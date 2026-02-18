package com.pedro.coupon.domain.exception;

public class InvalidCouponCodeException extends RuntimeException {
    public InvalidCouponCodeException() {
        super("Invalid coupon code.");
    }
}
