package com.pedro.coupon.domain.exception;

public class InvalidCouponDescriptionException extends RuntimeException{
    public InvalidCouponDescriptionException() {
        super("Coupon description is required.");
    }
}
