package com.pedro.coupon.interfaces.rest.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponResponse {

    private final Long id;
    private final String code;
    private final String description;
    private final BigDecimal discountValue;
    private final LocalDate expirationDate;
    private final boolean published;
    private final boolean deleted;

    public CouponResponse(Long id,
                          String code,
                          String description,
                          BigDecimal discountValue,
                          LocalDate expirationDate,
                          boolean published,
                          boolean deleted) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
        this.deleted = deleted;
    }

    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public BigDecimal getDiscountValue() { return discountValue; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public boolean isPublished() { return published; }
    public boolean isDeleted() { return deleted; }
}
