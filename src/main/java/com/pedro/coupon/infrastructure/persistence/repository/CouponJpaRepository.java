package com.pedro.coupon.infrastructure.persistence.repository;

import com.pedro.coupon.infrastructure.persistence.entity.CouponJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponJpaRepository extends JpaRepository<CouponJpaEntity, Long> {
    List<CouponJpaEntity> findByDeletedFalse();
}
