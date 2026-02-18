package com.pedro.coupon.domain.model;

import com.pedro.coupon.domain.exception.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Coupon {

    private Long id;
    private final String code;
    private final String description;
    private final BigDecimal discountValue;
    private final LocalDate expirationDate;
    private final boolean published;
    private boolean deleted;

    private Coupon(Long id,
                   String code,
                   String description,
                   BigDecimal discountValue,
                   LocalDate expirationDate,
                   boolean published,
                   boolean deleted,
                   boolean validate) {

        this.id = id;
        this.code = sanitize(code);
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
        this.deleted = deleted;

        if (validate) {
            validate();
        }
    }

    public static Coupon create(String code,
                                String description,
                                BigDecimal discountValue,
                                LocalDate expirationDate,
                                boolean published) {

        return new Coupon(
                null,
                code,
                description,
                discountValue,
                expirationDate,
                published,
                false,
                true
        );
    }

    public static Coupon restore(Long id,
                                 String code,
                                 String description,
                                 BigDecimal discountValue,
                                 LocalDate expirationDate,
                                 boolean published,
                                 boolean deleted) {

        return new Coupon(
                id,
                code,
                description,
                discountValue,
                expirationDate,
                published,
                deleted,
                false
        );
    }

    private void validate() {
        validateCode();
        validateDiscount();
        validateExpirationDate();
        validateDescription();
    }

    private String sanitize(String code) {
        if (code == null) {
            throw new InvalidCouponCodeException();
        }
        return code.replaceAll("[^a-zA-Z0-9]", "");
    }

    private void validateCode() {
        if (this.code.length() != 6) {
            throw new InvalidCouponCodeException();
        }
    }

    private void validateDiscount() {
        if (discountValue == null ||
                discountValue.compareTo(BigDecimal.valueOf(0.5)) < 0) {
            throw new InvalidDiscountValueException();
        }
    }

    private void validateExpirationDate() {
        if (expirationDate == null ||
                expirationDate.isBefore(LocalDate.now())) {
            throw new ExpiredCouponException();
        }
    }

    public void delete() {
        if (this.deleted) {
            throw new CouponAlreadyDeletedException();
        }
        this.deleted = true;
    }

    private void validateDescription() {
        if (description == null || description.isBlank()) {
            throw new InvalidCouponDescriptionException();
        }
    }

    public boolean isDeleted() { return deleted; }
    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public BigDecimal getDiscountValue() { return discountValue; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public boolean isPublished() { return published; }
}
