package com.pedro.coupon.domain.model;

import com.pedro.coupon.domain.exception.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void shouldCreateValidCoupon() {
        Coupon coupon = Coupon.create(
                "ABC123",
                "Black Friday",
                BigDecimal.TEN,
                LocalDate.now().plusDays(1),
                true
        );

        assertEquals("ABC123", coupon.getCode());
        assertFalse(coupon.isDeleted());
    }

    @Test
    void shouldSanitizeCode() {
        Coupon coupon = Coupon.create(
                "A@B#C1!23",
                "Test",
                BigDecimal.TEN,
                LocalDate.now().plusDays(1),
                true
        );

        assertEquals("ABC123", coupon.getCode());
    }

    @Test
    void shouldThrowWhenCodeInvalid() {
        assertThrows(InvalidCouponCodeException.class, () ->
                Coupon.create("ABC", "Test", BigDecimal.TEN,
                        LocalDate.now().plusDays(1), true));
    }

    @Test
    void shouldThrowWhenDescriptionNull() {
        assertThrows(InvalidCouponDescriptionException.class, () ->
                Coupon.create("ABC123", null, BigDecimal.TEN,
                        LocalDate.now().plusDays(1), true));
    }

    @Test
    void shouldThrowWhenDiscountInvalid() {
        assertThrows(InvalidDiscountValueException.class, () ->
                Coupon.create("ABC123", "Test",
                        BigDecimal.valueOf(0.1),
                        LocalDate.now().plusDays(1), true));
    }

    @Test
    void shouldThrowWhenExpiredDate() {
        assertThrows(ExpiredCouponException.class, () ->
                Coupon.create("ABC123", "Test",
                        BigDecimal.TEN,
                        LocalDate.now().minusDays(1), true));
    }

    @Test
    void shouldDeleteCoupon() {
        Coupon coupon = Coupon.create(
                "ABC123", "Test", BigDecimal.TEN,
                LocalDate.now().plusDays(1), true);

        coupon.delete();

        assertTrue(coupon.isDeleted());
    }

    @Test
    void shouldNotDeleteTwice() {
        Coupon coupon = Coupon.create(
                "ABC123", "Test", BigDecimal.TEN,
                LocalDate.now().plusDays(1), true);

        coupon.delete();

        assertThrows(CouponAlreadyDeletedException.class, coupon::delete);
    }
}

