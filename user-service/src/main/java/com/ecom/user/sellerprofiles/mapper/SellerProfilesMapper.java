package com.ecom.user.sellerprofiles.mapper;

import com.ecom.user.sellerprofiles.persistence.entity.SellerProfiles;
import com.ecom.user.users.api.dto.UsersRequestDTO;
import com.ecom.user.users.api.dto.UsersResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SellerProfilesMapper {

    SellerProfiles toEntity(UsersRequestDTO usersRequestDTO);

    @Mapping(target = "userId", ignore = true)
    void enrichUserResponseFromSellerProfile(SellerProfiles sellerProfiles, @MappingTarget UsersResponseDTO responseDTO);
}
