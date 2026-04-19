package com.ecom.user.addresses.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressStatus {
    ACTIVE(1L),
    PASSIVE(2L);

    private final Long code;
}
