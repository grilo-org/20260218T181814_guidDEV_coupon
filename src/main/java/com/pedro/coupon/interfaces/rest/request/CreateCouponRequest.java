package com.pedro.coupon.interfaces.rest.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateCouponRequest {

    private String code;
    private String description;
    private BigDecimal discountValue;
    private LocalDate expirationDate;
    private boolean published;

    public String getCode() { return code; }
    public String getDescription() { return description; }
    public BigDecimal getDiscountValue() { return discountValue; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public boolean isPublished() { return published; }
}
