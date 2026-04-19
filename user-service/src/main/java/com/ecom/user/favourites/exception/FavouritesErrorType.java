package com.ecom.user.favourites.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FavouritesErrorType {

    FAVOURITE_NOT_FOUND(1L);

    private final Long code;
}
