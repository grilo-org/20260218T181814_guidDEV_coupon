package com.pedro.coupon.application.delete;

import com.pedro.coupon.domain.exception.CouponNotFoundException;
import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCouponUseCase {

    private final CouponRepository repository;

    public DeleteCouponUseCase(CouponRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {

        Coupon coupon = repository.findById(id)
                .orElseThrow(CouponNotFoundException::new);

        coupon.delete();

        repository.save(coupon);
    }
}
