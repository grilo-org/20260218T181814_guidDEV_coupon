package com.pedro.coupon.domain.exception;

public class InvalidDiscountValueException extends RuntimeException {
    public InvalidDiscountValueException() {
        super("Invalid discount value.");
    }
}
