package org.example.printer;

import org.example.model.Order;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Logger;

public class ReceiptPrinter {
    private static final Logger LOGGER = Logger.getLogger(ReceiptPrinter.class.getName());

    // Форматтер для денег (точка вместо запятой)
    private static final DecimalFormat MONEY_FORMAT =
            new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US));

    public static void print(Order order, BigDecimal discount, BigDecimal commission, BigDecimal finalAmount) {
        String receipt = String.format(
                "\n=== RECEIPT ===\n" +
                        "Order ID: %s\n" +
                        "Items: %s\n" +
                        "Base amount: %s\n" +
                        "Discount: -%s\n" +
                        "Commission: +%s\n" +
                        "Final amount: %s\n" +
                        "================",
                order.getId(),
                order.getItems(),
                MONEY_FORMAT.format(order.getAmount()),
                MONEY_FORMAT.format(discount),
                MONEY_FORMAT.format(commission),
                MONEY_FORMAT.format(finalAmount)
        );

        LOGGER.info(receipt);
    }
}
