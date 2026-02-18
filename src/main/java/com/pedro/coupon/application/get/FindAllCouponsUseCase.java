package com.pedro.coupon.application.get;

import com.pedro.coupon.domain.model.Coupon;
import java.util.List;

public interface FindAllCouponsUseCase {
    List<Coupon> execute();
}

