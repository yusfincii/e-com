package com.ecom.user.users.service;

import com.ecom.user.users.api.dto.UsersRequestDTO;
import com.ecom.user.users.api.dto.UsersResponseDTO;
import com.ecom.user.users.api.dto.UsersUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface UsersService {

    List<UsersResponseDTO> getAllUsers();

    UsersResponseDTO getUserById(UUID id);

    UsersResponseDTO createUser(UsersRequestDTO usersDTO, UUID createdBy);

    UsersResponseDTO updateUser(UUID id, UsersUpdateRequestDTO usersDTO, UUID updatedBy);

    void deleteUser(UUID id, UUID deletedBy);

    Boolean isExistUserById(UUID id);

}
