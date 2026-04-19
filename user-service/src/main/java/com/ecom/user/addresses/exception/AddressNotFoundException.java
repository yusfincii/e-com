package com.ecom.user.addresses.exception;

import com.ecom.user.common.exception.BaseException;

public class AddressNotFoundException extends BaseException {
    public AddressNotFoundException(){
        super(AddressErrorType.ADDRESS_NOT_FOUND.getCode().toString(),
                "Address not found!");
    }
}
