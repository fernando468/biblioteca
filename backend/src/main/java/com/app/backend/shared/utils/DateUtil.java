package com.app.backend.shared.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {
    public static String formatToDDMMYYYY(LocalDate date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return formatter.format(date);
        }
        return "";
    }

    public static LocalDate formatToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        formatter = formatter.withLocale(Locale.US);
        return LocalDate.parse(date, formatter);
    }
}
