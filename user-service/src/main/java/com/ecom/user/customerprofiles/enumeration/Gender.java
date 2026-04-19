package com.ecom.user.customerprofiles.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE(1L),
    FEMALE(2L);

    private final Long code;

    public static List<String> getNames(){
        return Arrays.stream(Gender.values())
                .map(Gender::name)
                .toList();
    }
}
