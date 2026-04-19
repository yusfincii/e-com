package com.ecom.user.sellerprofiles.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SellerProfilesErrorType {
    TAX_NUMBER_NULL_ERROR(20L);

    private final Long code;
}
