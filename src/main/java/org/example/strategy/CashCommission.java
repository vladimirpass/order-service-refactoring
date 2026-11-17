package org.example.strategy;

import java.math.BigDecimal;

public class CashCommission implements CommissionStrategy {
    @Override
    public BigDecimal calculateCommission(BigDecimal amount) {
        return BigDecimal.ZERO;
    }
}
