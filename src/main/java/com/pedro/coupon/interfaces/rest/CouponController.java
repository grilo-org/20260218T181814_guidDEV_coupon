package com.pedro.coupon.interfaces.rest;

import com.pedro.coupon.application.create.CreateCouponUseCase;
import com.pedro.coupon.application.delete.DeleteCouponUseCase;
import com.pedro.coupon.application.get.FindAllCouponsUseCase;
import com.pedro.coupon.application.get.FindCouponByIdUseCase;
import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.interfaces.rest.request.CreateCouponRequest;
import com.pedro.coupon.interfaces.rest.response.CouponResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CreateCouponUseCase createUseCase;
    private final DeleteCouponUseCase deleteUseCase;
    private final FindAllCouponsUseCase findAllUseCase;
    private final FindCouponByIdUseCase findByIdUseCase;

    public CouponController(CreateCouponUseCase createUseCase,
                            DeleteCouponUseCase deleteUseCase,
                            FindAllCouponsUseCase findAllUseCase,
                            FindCouponByIdUseCase findByIdUseCase) {
        this.createUseCase = createUseCase;
        this.deleteUseCase = deleteUseCase;
        this.findAllUseCase = findAllUseCase;
        this.findByIdUseCase = findByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> create(@RequestBody CreateCouponRequest request) {

        Coupon coupon = createUseCase.execute(
                request.getCode(),
                request.getDescription(),
                request.getDiscountValue(),
                request.getExpirationDate(),
                request.isPublished()
        );

        return ResponseEntity.ok(toResponse(coupon));
    }

    @GetMapping
    public ResponseEntity<List<CouponResponse>> findAll() {

        List<CouponResponse> response = findAllUseCase.execute()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponResponse> findById(@PathVariable Long id) {

        Coupon coupon = findByIdUseCase.execute(id);

        return ResponseEntity.ok(toResponse(coupon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        deleteUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }

    private CouponResponse toResponse(Coupon coupon) {
        return new CouponResponse(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDescription(),
                coupon.getDiscountValue(),
                coupon.getExpirationDate(),
                coupon.isPublished(),
                coupon.isDeleted()
        );
    }

}


