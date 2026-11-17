package org.example.factory;

import org.example.model.PaymentType;
import org.example.strategy.CardCommission;
import org.example.strategy.CashCommission;
import org.example.strategy.CommissionStrategy;
import org.example.strategy.TransferCommission;

public class CommissionFactory {
    public static CommissionStrategy getStrategy(PaymentType paymentType) {
        return switch (paymentType) {
            case CARD -> new CardCommission();
            case CASH -> new CashCommission();
            case TRANSFER -> new TransferCommission();
        };
    }
}
