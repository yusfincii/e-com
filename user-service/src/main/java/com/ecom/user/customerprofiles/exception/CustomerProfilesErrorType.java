package com.ecom.user.customerprofiles.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerProfilesErrorType {

    REQUIRED_FIELDS_MUST_BE_FILL_ERROR(40L),
    INVALID_GENDER_ERROR(41L);

    private final Long code;
}
