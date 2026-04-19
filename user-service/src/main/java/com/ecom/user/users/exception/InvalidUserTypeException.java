package com.ecom.user.users.exception;

import com.ecom.user.common.exception.BaseException;

public class InvalidUserTypeException extends BaseException {
    public InvalidUserTypeException(){
        super(UsersErrorType.INVALID_USER_TYPE.getCode().toString(),
                "Given user type is not valid!");
    }
}
