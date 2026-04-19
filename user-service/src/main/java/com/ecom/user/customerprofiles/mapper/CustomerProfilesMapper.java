package com.ecom.user.customerprofiles.mapper;

import com.ecom.user.customerprofiles.enumeration.Gender;
import com.ecom.user.customerprofiles.exception.InvalidGenderException;
import com.ecom.user.customerprofiles.persistence.entity.CustomerProfiles;
import com.ecom.user.users.api.dto.UsersRequestDTO;
import com.ecom.user.users.api.dto.UsersResponseDTO;
import org.mapstruct.*;

import java.util.Arrays;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerProfilesMapper {

    @Mapping(source = "gender", target = "gender", qualifiedByName = "stringToGender")
    CustomerProfiles toEntity(UsersRequestDTO requestDTO);

    @Mapping(target = "userId", ignore = true)
    void enrichUserResponseFromCustomerProfile(CustomerProfiles customerProfiles,
                                               @MappingTarget UsersResponseDTO responseDTO);

    @Named("stringToGender")
    default Gender stringToGender(String gender) {
        if (gender == null) {
            return null;
        }

        return Arrays.stream(Gender.values())
                .filter(item -> item.name().equalsIgnoreCase(gender.trim()))
                .findFirst()
                .orElseThrow(InvalidGenderException::new);
    }
}
