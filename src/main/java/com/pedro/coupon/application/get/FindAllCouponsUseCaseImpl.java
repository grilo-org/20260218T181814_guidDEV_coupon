package com.pedro.coupon.application.get;

import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCouponsUseCaseImpl implements FindAllCouponsUseCase {

    private final CouponRepository repository;

    public FindAllCouponsUseCaseImpl(CouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Coupon> execute() {
        return repository.findAllActive();
    }
}