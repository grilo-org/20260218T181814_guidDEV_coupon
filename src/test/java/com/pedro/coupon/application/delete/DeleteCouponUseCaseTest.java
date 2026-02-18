package com.pedro.coupon.application.delete;

import com.pedro.coupon.domain.exception.CouponNotFoundException;
import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DeleteCouponUseCaseTest {

    private final CouponRepository repository = mock(CouponRepository.class);
    private final DeleteCouponUseCase useCase = new DeleteCouponUseCase(repository);

    @Test
    void shouldDeleteCoupon() {
        Coupon coupon = Coupon.create(
                "ABC123", "Test", BigDecimal.TEN,
                LocalDate.now().plusDays(1), true);

        when(repository.findById(1L)).thenReturn(Optional.of(coupon));

        useCase.execute(1L);

        assertTrue(coupon.isDeleted());
        verify(repository).save(coupon);
    }

    @Test
    void shouldThrowWhenNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CouponNotFoundException.class,
                () -> useCase.execute(1L));
    }
}
