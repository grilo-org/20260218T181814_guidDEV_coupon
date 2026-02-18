package com.pedro.coupon.infrastructure.persistence.repository;

import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import com.pedro.coupon.infrastructure.persistence.entity.CouponJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository jpaRepository;

    public CouponRepositoryImpl(CouponJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Coupon save(Coupon coupon) {

        CouponJpaEntity entity = toEntity(coupon);

        CouponJpaEntity saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Coupon> findAllActive() {
        return jpaRepository.findByDeletedFalse()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private CouponJpaEntity toEntity(Coupon coupon) {
        return new CouponJpaEntity(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDescription(),
                coupon.getDiscountValue(),
                coupon.getExpirationDate(),
                coupon.isPublished(),
                coupon.isDeleted()
        );
    }

    private Coupon toDomain(CouponJpaEntity entity) {

        return Coupon.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getDiscountValue(),
                entity.getExpirationDate(),
                entity.isPublished(),
                entity.isDeleted()
        );
    }

}
