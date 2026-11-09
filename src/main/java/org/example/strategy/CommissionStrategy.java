package org.example.strategy;

import java.math.BigDecimal;

public interface CommissionStrategy {
    BigDecimal calculateCommission(BigDecimal amount);
}
