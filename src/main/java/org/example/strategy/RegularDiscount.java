package org.example.strategy;

import java.math.BigDecimal;

public class RegularDiscount implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(BigDecimal amount) {
        return BigDecimal.ZERO;
    }
}