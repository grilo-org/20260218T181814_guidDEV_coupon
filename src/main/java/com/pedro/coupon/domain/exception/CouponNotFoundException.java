package com.pedro.coupon.domain.exception;

public class CouponNotFoundException extends RuntimeException{
    public CouponNotFoundException() {
        super("Coupon not found");
    }
}
