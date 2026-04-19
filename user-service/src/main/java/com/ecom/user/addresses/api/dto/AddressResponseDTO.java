package com.ecom.user.addresses.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressResponseDTO {

    private UUID id;

    private UUID userId;

    private String address;

    private String status;
}
