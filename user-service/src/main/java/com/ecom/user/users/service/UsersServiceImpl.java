package com.ecom.user.users.service;

import com.ecom.user.customerprofiles.enumeration.Gender;
import com.ecom.user.customerprofiles.exception.InvalidGenderException;
import com.ecom.user.customerprofiles.exception.RequiredFieldsMustBeFillForCustomerProfileException;
import com.ecom.user.customerprofiles.mapper.CustomerProfilesMapper;
import com.ecom.user.customerprofiles.persistence.entity.CustomerProfiles;
import com.ecom.user.customerprofiles.persistence.repository.CustomerProfilesRepository;
import com.ecom.user.sellerprofiles.exception.TaxNumberCanNotBeNullException;
import com.ecom.user.sellerprofiles.mapper.SellerProfilesMapper;
import com.ecom.user.sellerprofiles.persistence.entity.SellerProfiles;
import com.ecom.user.sellerprofiles.persistence.repository.SellerProfilesRepository;
import com.ecom.user.users.api.dto.UsersRequestDTO;
import com.ecom.user.users.api.dto.UsersResponseDTO;
import com.ecom.user.users.api.dto.UsersUpdateRequestDTO;
import com.ecom.user.users.enumeration.UserType;
import com.ecom.user.users.exception.InvalidUserTypeException;
import com.ecom.user.users.exception.UserFoundWithEmailException;
import com.ecom.user.users.exception.UserNotFoundException;
import com.ecom.user.users.mapper.UsersMapper;
import com.ecom.user.users.persistence.Users;
import com.ecom.user.users.persistence.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repository;
    private final UsersMapper mapper;
    private final PasswordEncoder encoder;
    private final UsersRepository usersRepository;
    private final SellerProfilesMapper sellerProfilesMapper;
    private final SellerProfilesRepository sellerProfilesRepository;
    private final CustomerProfilesMapper customerProfilesMapper;
    private final CustomerProfilesRepository customerProfilesRepository;

    @Override
    public List<UsersResponseDTO> getAllUsers() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    @Override
    public UsersResponseDTO getUserById(UUID id) {
        return mapper.toResponseDTO(repository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    // Fields checks according to the business logic
    private void userCreateControls(UsersRequestDTO usersDTO){
        // user type check
        if(!UserType.getNames().contains(usersDTO.getUserType().trim().toUpperCase())){
            throw new InvalidUserTypeException();
        }

        // exist e-mail check
        if(repository.existsByEmail(usersDTO.getEmail().trim())){
            throw new UserFoundWithEmailException();
        }

        // --- seller profile checks ---
        if(usersDTO.getUserType().equals(UserType.SELLER.toString())){
            if (usersDTO.getTaxNumber() == null){
                throw new TaxNumberCanNotBeNullException();
            }
        }

        // --- customer profile checks ---
        if(usersDTO.getUserType().equals(UserType.CUSTOMER.toString())){
            if (usersDTO.getBirthDate() == null || usersDTO.getPhoneNumber() == null ||
                    usersDTO.getGender() == null ){
                throw new RequiredFieldsMustBeFillForCustomerProfileException();
            }
            if(!Gender.getNames().contains(usersDTO.getGender().trim().toUpperCase())){
                throw new InvalidGenderException();
            }
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UsersResponseDTO createUser(UsersRequestDTO usersDTO, UUID createdBy) {
        userCreateControls(usersDTO);
        Users created = mapper.toEntity(usersDTO, encoder);
        created.setCreateTime(LocalDateTime.now());
        created.setCreatedBy(createdBy);
        Users saved = repository.save(created);
        // response dto initialization
        UsersResponseDTO responseDTO = mapper.toResponseDTO(saved);

        if(usersDTO.getUserType().equalsIgnoreCase(UserType.SELLER.toString())){
            SellerProfiles sellerProfiles = sellerProfilesMapper.toEntity(usersDTO);
            sellerProfiles.setUserId(saved.getId());
            sellerProfiles.setCreatedBy(createdBy);
            sellerProfiles.setCreateTime(LocalDateTime.now());
            sellerProfilesRepository.save(sellerProfiles);

            // enrich response dto with seller profiles fields
            sellerProfilesMapper.enrichUserResponseFromSellerProfile(sellerProfiles, responseDTO);
        } else if (usersDTO.getUserType().equalsIgnoreCase(UserType.CUSTOMER.toString())) {
            CustomerProfiles customerProfiles = customerProfilesMapper.toEntity(usersDTO);
            customerProfiles.setUserId(saved.getId());
            customerProfiles.setCreatedBy(createdBy);
            customerProfiles.setCreateTime(LocalDateTime.now());
            customerProfilesRepository.save(customerProfiles);
            // enrich response dto with customer profiles fields
            customerProfilesMapper.enrichUserResponseFromCustomerProfile(customerProfiles, responseDTO);
        }

        return responseDTO;
    }

    // Fields checks according to the business logic and existing user
    private void userUpdateControls(UsersUpdateRequestDTO usersDTO, Users entity){
        // Validate only provided user type for partial update requests
        if(usersDTO.getUserType() != null &&
                !UserType.getNames().contains(usersDTO.getUserType().trim().toUpperCase())){
            throw new InvalidUserTypeException();
        }

        // Check e-mail uniqueness only when e-mail is provided and changed
        if(usersDTO.getEmail() != null &&
                !entity.getEmail().equals(usersDTO.getEmail().trim())){
            if(repository.existsByEmail(usersDTO.getEmail().trim())){
                throw new UserFoundWithEmailException();
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UsersResponseDTO updateUser(UUID id, UsersUpdateRequestDTO usersDTO, UUID updatedBy) {
        Users updated = repository.findById(id).orElseThrow(UserNotFoundException::new);
        userUpdateControls(usersDTO, updated);
        mapper.updateEntityFromDto(usersDTO, updated, encoder);
        updated.setUpdateTime(LocalDateTime.now());
        updated.setUpdatedBy(updatedBy);
        return mapper.toResponseDTO(repository.save(updated));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(UUID id, UUID userId) {
        Users user = repository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setIsDeleted(true);
        user.setUpdateTime(LocalDateTime.now());
        user.setUpdatedBy(userId);
        repository.save(user);
    }

    @Override
    public Boolean isExistUserById(UUID id) {
        if(id == null){
            return false;
        }
        return usersRepository.existsById(id);
    }
}
