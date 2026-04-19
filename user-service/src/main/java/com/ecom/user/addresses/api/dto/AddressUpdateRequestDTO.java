package com.ecom.user.addresses.api.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateRequestDTO {

    private UUID userId;

    @Size(min = 3, max = 512, message = "Address can not be larger than 512 characters!")
    private String address;

    private String status;

    // Ignore leading and trailing whitespace when address is provided.
    @JsonSetter
    public void setAddress(String address) {
        this.address = address != null ? address.trim() : null;
    }
}

