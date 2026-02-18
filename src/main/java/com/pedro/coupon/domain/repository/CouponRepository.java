package com.pedro.coupon.domain.repository;

import com.pedro.coupon.domain.model.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {

    Coupon save(Coupon coupon);

    Optional<Coupon> findById(Long id);

    List<Coupon> findAllActive();
}
