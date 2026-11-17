package org.example.strategy;


import java.math.BigDecimal;

public class CardCommission implements CommissionStrategy {
    private static final BigDecimal COMMISSION_RATE = new BigDecimal("0.02");

    @Override
    public BigDecimal calculateCommission(BigDecimal amount) {
        return amount.multiply(COMMISSION_RATE);
    }
}
