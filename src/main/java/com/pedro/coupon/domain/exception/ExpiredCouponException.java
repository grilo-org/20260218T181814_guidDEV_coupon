package com.pedro.coupon.domain.exception;

public class ExpiredCouponException extends RuntimeException {
    public ExpiredCouponException() {
        super("Expired coupon.");
    }
}
