package com.pedro.coupon.application.create;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateCouponCommand(
        String code,
        String description,
        BigDecimal discountValue,
        LocalDate expirationDate,
        boolean published
) {}
