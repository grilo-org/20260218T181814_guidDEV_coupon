package com.pedro.coupon.application.get;

import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import org.springframework.stereotype.Service;


@Service
public class FindCouponByIdUseCaseImpl implements FindCouponByIdUseCase {

    private final CouponRepository couponRepository;

    public FindCouponByIdUseCaseImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon execute(Long id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found with id " + id));
    }
}