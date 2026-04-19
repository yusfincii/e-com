package com.ecom.user.addresses.service;

import com.ecom.user.addresses.api.dto.AddressRequestDTO;
import com.ecom.user.addresses.api.dto.AddressResponseDTO;
import com.ecom.user.addresses.api.dto.AddressUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    AddressResponseDTO getAddressById(UUID addressId);

    List<AddressResponseDTO> getAddressByUserId(UUID userId);

    AddressResponseDTO createAddress(AddressRequestDTO createDTO, UUID createdBy);

    AddressResponseDTO updateAddress(UUID addressId, AddressUpdateRequestDTO updateDTO, UUID updatedBy);

    void deleteAddress(UUID addressId, UUID deletedBy);

}
