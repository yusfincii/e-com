package com.ecom.user.customerprofiles.exception;

import com.ecom.user.common.exception.BaseException;

public class RequiredFieldsMustBeFillForCustomerProfileException extends BaseException {
    public RequiredFieldsMustBeFillForCustomerProfileException(){
        super(CustomerProfilesErrorType.REQUIRED_FIELDS_MUST_BE_FILL_ERROR.getCode().toString(),
                "Fields related with customer profile must be filled!");
    }
}
