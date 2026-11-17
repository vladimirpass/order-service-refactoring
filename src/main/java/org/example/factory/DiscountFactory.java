package org.example.factory;

import org.example.model.CustomerType;
import org.example.strategy.DiscountStrategy;
import org.example.strategy.PremiumDiscount;
import org.example.strategy.RegularDiscount;
import org.example.strategy.VipDiscount;

public class DiscountFactory {
    public static DiscountStrategy getStrategy(CustomerType customerType) {
        return switch (customerType) {
            case REGULAR -> new RegularDiscount();
            case VIP -> new VipDiscount();
            case PREMIUM -> new PremiumDiscount();
        };
    }
}