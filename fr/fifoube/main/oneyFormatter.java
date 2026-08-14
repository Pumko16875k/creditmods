package fr.fifoube.main.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MoneyFormatter {

    private static final DecimalFormat FORMATTER;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setGroupingSeparator('.'); // Séparateur de milliers : point
        symbols.setDecimalSeparator(',');

        FORMATTER = new DecimalFormat("#,###", symbols);
    }

    public static String format(double amount) {
        return FORMATTER.format((long) amount);
    }

    public static String format(float amount) {
        return FORMATTER.format((long) amount);
    }

    public static String format(int amount) {
        return FORMATTER.format(amount);
    }
}
