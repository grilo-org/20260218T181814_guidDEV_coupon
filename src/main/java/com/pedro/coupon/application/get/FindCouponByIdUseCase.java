package com.pedro.coupon.application.get;

import com.pedro.coupon.domain.model.Coupon;

public interface FindCouponByIdUseCase {
    Coupon execute(Long id);
}

