package com.ecom.user.users.exception;

import com.ecom.user.common.exception.BaseException;

public class UserFoundWithEmailException extends BaseException {
    public UserFoundWithEmailException(){
        super(UsersErrorType.USER_EMAIL_EXIST.getCode().toString(),
                "An account already exists with this email!");
    }
}
