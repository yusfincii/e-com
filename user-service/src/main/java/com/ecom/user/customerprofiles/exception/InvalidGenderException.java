package com.ecom.user.customerprofiles.exception;

import com.ecom.user.common.exception.BaseException;

public class InvalidGenderException extends BaseException {
    public InvalidGenderException(){
        super(CustomerProfilesErrorType.INVALID_GENDER_ERROR.getCode().toString(),
                "Gender is invalid!");
    }
}
