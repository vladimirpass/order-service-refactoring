package org.example.strategy;

import java.math.BigDecimal;

public class PremiumDiscount implements DiscountStrategy {
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.10");

    @Override
    public BigDecimal calculateDiscount(BigDecimal amount) {
        return amount.multiply(DISCOUNT_RATE);
    }
}
