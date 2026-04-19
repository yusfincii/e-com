package com.ecom.user.users.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum UserType {

    ADMIN(1L, 1L),
    CUSTOMER(2L, 2L),
    SELLER(3L, 3L);

    private final Long id;
    private final Long code;

    public static List<String> getNames(){
        return Arrays.stream(UserType.values())
                .map(UserType::name)
                .toList();
    }
}
