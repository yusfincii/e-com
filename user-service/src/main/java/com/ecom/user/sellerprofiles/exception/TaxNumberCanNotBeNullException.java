package com.ecom.user.sellerprofiles.exception;

import com.ecom.user.common.exception.BaseException;

public class TaxNumberCanNotBeNullException extends BaseException {
    public TaxNumberCanNotBeNullException(){
        super(SellerProfilesErrorType.TAX_NUMBER_NULL_ERROR.getCode().toString(),
                "Tax number can not be blank or null!");
    }
}
