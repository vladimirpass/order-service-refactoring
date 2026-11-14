package org.example.strategy;

import java.math.BigDecimal;

public class TransferCommission implements CommissionStrategy {
    private static final BigDecimal COMMISSION_RATE = new BigDecimal("0.01");

    @Override
    public BigDecimal calculateCommission(BigDecimal amount) {
        return amount.multiply(COMMISSION_RATE);
    }
}