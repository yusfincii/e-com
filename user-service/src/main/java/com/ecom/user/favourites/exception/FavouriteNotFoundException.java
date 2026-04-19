package com.ecom.user.favourites.exception;

import com.ecom.user.common.exception.BaseException;

public class FavouriteNotFoundException extends BaseException {
    public FavouriteNotFoundException(){
        super(FavouritesErrorType.FAVOURITE_NOT_FOUND.getCode().toString(),
                "Favourite not found with given ids!");
    }
}
