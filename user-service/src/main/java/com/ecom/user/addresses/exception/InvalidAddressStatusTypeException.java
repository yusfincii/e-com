package com.ecom.user.addresses.exception;

import com.ecom.user.common.exception.BaseException;

public class InvalidAddressStatusTypeException extends BaseException {
    public InvalidAddressStatusTypeException(){
        super(AddressErrorType.ADDRESS_NOT_FOUND.getCode().toString(),
                "Address status not found!");
    }
}
