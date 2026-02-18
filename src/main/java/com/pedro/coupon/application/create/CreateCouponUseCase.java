package com.pedro.coupon.application.create;

import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CreateCouponUseCase {

    private final CouponRepository repository;

    public CreateCouponUseCase(CouponRepository repository) {
        this.repository = repository;
    }

    public Coupon execute(String code,
                          String description, BigDecimal discountValue,
                          LocalDate expirationDate, boolean published) {

        Coupon coupon = Coupon.create(
                code,
                description,
                discountValue,
                expirationDate,
                published
        );

        return repository.save(coupon);
    }
}
