package com.ecom.user.users.exception;

import com.ecom.user.common.exception.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(){
        super(UsersErrorType.USER_NOT_FOUND.getCode().toString(),
                "User with given id not found!");
    }
}
