package com.pedro.coupon.application.create;

import com.pedro.coupon.domain.model.Coupon;
import com.pedro.coupon.domain.repository.CouponRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateCouponUseCaseTest {

    private final CouponRepository repository = mock(CouponRepository.class);
    private final CreateCouponUseCase useCase = new CreateCouponUseCase(repository);

    @Test
    void shouldCreateCoupon() {
        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        Coupon coupon = useCase.execute(
                "ABC123",
                "Test",
                BigDecimal.TEN,
                LocalDate.now().plusDays(1),
                true
        );

        assertNotNull(coupon);
        verify(repository).save(any());
    }
}

