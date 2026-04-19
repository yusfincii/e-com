package com.ecom.user.addresses.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressErrorType {

    ADDRESS_NOT_FOUND(700L);

    private final Long code;
}
