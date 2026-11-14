package org.example.service;

import org.example.factory.CommissionFactory;
import org.example.factory.DiscountFactory;
import org.example.model.Order;
import org.example.printer.ReceiptPrinter;
import org.example.strategy.CommissionStrategy;
import org.example.strategy.DiscountStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();

    public BigDecimal processOrder(Order order) {
        // Вызываем выделенный метод валидации
        validateOrder(order);

        // расчёт скидки и комиссии
        DiscountStrategy discountStrategy = DiscountFactory.getStrategy(order.getCustomerType());
        BigDecimal discount = discountStrategy.calculateDiscount(order.getAmount());

        CommissionStrategy commissionStrategy = CommissionFactory.getStrategy(order.getPaymentType());
        BigDecimal commission = commissionStrategy.calculateCommission(order.getAmount());

        // итоговая сумма
        BigDecimal finalAmount = order.getAmount()
                .subtract(discount)
                .add(commission);

        //  формирование чека
        ReceiptPrinter.print(order, discount, commission, finalAmount);

        //  "сохранение" заказа
        orders.add(order);

        return finalAmount;
    }

    // Выделенный метод валидации
    private void validateOrder(Order order) {
        if (order.getAmount() == null || order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Order amount must be positive");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new RuntimeException("Order must contain at least one item");
        }
    }
}