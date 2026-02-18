package com.pedro.coupon.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "coupons")
public class CouponJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String description;
    private BigDecimal discountValue;
    private LocalDate expirationDate;
    private boolean published;
    private boolean deleted;

    public CouponJpaEntity() {
    }

    public CouponJpaEntity(Long id,
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

    public void setId(Long id) { this.id = id; }

    public void setCode(String code) { this.code = code; }

    public void setDescription(String description) { this.description = description; }

    public void setDiscountValue(BigDecimal discountValue) { this.discountValue = discountValue; }

    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    public void setPublished(boolean published) { this.published = published; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}
