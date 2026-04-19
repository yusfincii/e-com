package com.ecom.user.users.mapper;

import com.ecom.user.users.api.dto.UsersRequestDTO;
import com.ecom.user.users.api.dto.UsersResponseDTO;
import com.ecom.user.users.api.dto.UsersUpdateRequestDTO;
import com.ecom.user.users.enumeration.UserType;
import com.ecom.user.users.persistence.Users;
import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsersMapper {

    @Mapping(source = "id", target = "userId")
    UsersResponseDTO toResponseDTO(Users users);

    @Mapping(source = "email", target = "email", qualifiedByName = "trimEmail")
    @Mapping(source = "userType", target = "userType", qualifiedByName = "stringToUserType")
    @Mapping(source = "password", target = "password", qualifiedByName = "encodePassword")
    Users toEntity(UsersRequestDTO dto, @Context PasswordEncoder encoder);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "email", target = "email", qualifiedByName = "trimEmail")
    @Mapping(source = "userType", target = "userType", qualifiedByName = "stringToUserType")
    @Mapping(source = "password", target = "password", qualifiedByName = "encodePassword")
    void updateEntityFromDto(UsersUpdateRequestDTO dto, @MappingTarget Users entity, @Context PasswordEncoder encoder);

    List<UsersResponseDTO> toResponseDTOList(List<Users> usersList);


    @Named("stringToUserType")
    default UserType stringToUserType(String type) {
        if (type == null) {
            return null;
        }

        return Arrays.stream(UserType.values())
                .filter(userType -> userType.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);
    }

    @Named("trimEmail")
    default String trimEmail(String email) {
        return email == null ? null : email.trim();
    }

    @Named("encodePassword")
    default String encodePassword(String password, @Context PasswordEncoder encoder) {
        return password == null ? null : encoder.encode(password);
    }
}
