package org.echocat.kata.java.part1.parcer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

public class Parcer {
    private static final Locale LOCALE = Locale.GERMAN;

    private static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
            .withLocale(LOCALE);

    public static List<String> parseLine(String line, String regex) {
        return List.of(line.split(regex));
    }

    public static List<String> parseLine(String line) {
        return List.of(line.split(";"));
    }

    public static LocalDate parseDate(String line) {
        return LocalDate.parse(line, DATE_FORMATTER);
    }
}
