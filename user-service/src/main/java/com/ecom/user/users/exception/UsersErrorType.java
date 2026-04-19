package com.ecom.user.users.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsersErrorType {

    USER_NOT_FOUND(1L),
    INVALID_USER_TYPE(2L),
    USER_EMAIL_EXIST(3L);

    private final Long code;
}
