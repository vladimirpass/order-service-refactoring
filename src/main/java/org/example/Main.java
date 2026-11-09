package org.example;

import org.example.model.CustomerType;
import org.example.model.Order;
import org.example.model.PaymentType;
import org.example.service.OrderService;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class Main {
    private static final String ORDER_ID_1 = "1";
    private static final BigDecimal ORDER_AMOUNT_1 = new BigDecimal("1000.0");
    private static final String ORDER_ID_2 = "2";
    private static final BigDecimal ORDER_AMOUNT_2 = new BigDecimal("20.0");

    // Форматтер с точкой (Locale.US), чтобы совпадало с чеком
    private static final DecimalFormat MONEY_FORMAT =
            new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US));

    public static void main(String[] args) {
        OrderService service = new OrderService();

        Order order1 = new Order(ORDER_ID_1, CustomerType.VIP, PaymentType.CARD, List.of("Laptop", "Mouse"), ORDER_AMOUNT_1);
        Order order2 = new Order(ORDER_ID_2, CustomerType.REGULAR, PaymentType.CASH, List.of("Book"), ORDER_AMOUNT_2);

        BigDecimal finalAmount1 = service.processOrder(order1);
        BigDecimal finalAmount2 = service.processOrder(order2);

        System.out.println("Final amount 1: " + MONEY_FORMAT.format(finalAmount1));
        System.out.println("Final amount 2: " + MONEY_FORMAT.format(finalAmount2));
    }
}