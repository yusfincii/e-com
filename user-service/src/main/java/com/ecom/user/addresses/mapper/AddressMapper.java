package com.ecom.user.addresses.mapper;

import com.ecom.user.addresses.api.dto.AddressRequestDTO;
import com.ecom.user.addresses.api.dto.AddressResponseDTO;
import com.ecom.user.addresses.api.dto.AddressUpdateRequestDTO;
import com.ecom.user.addresses.enumeration.AddressStatus;
import com.ecom.user.addresses.exception.InvalidAddressStatusTypeException;
import com.ecom.user.addresses.persistence.entity.Address;
import org.mapstruct.*;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressResponseDTO toResponseDTO(Address address);

    List<AddressResponseDTO> toResponseDTOList(List<Address> address);

    @Mapping(source = "address", target = "address", qualifiedByName = "trimAddress")
    @Mapping(source = "status", target = "status", qualifiedByName = "stringToAddressStatus")
    Address toAddress(AddressRequestDTO addressRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "address", target = "address", qualifiedByName = "trimAddress")
    @Mapping(source = "status", target = "status", qualifiedByName = "stringToAddressStatus")
    void updateEntityFromDto(AddressUpdateRequestDTO dto, @MappingTarget Address entity);

    @Named("stringToAddressStatus")
    default AddressStatus stringToAddressStatus(String status){
        if (status == null) {
            return null;
        }

        return Arrays.stream(AddressStatus.values())
                .filter(addressStatus -> addressStatus.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(InvalidAddressStatusTypeException::new);
    }

    @Named("trimAddress")
    default String trimAddress(String address) {
        return address == null ? null : address.trim();
    }
}
