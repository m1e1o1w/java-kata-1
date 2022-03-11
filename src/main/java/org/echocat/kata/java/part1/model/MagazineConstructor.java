package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.parcer.Parcer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.BiFunction;

public class MagazineConstructor implements BiFunction<List<String>, List<Author>,Magazine> {
    @Override
    public Magazine apply(List<String> strings, List<Author> authors) {
        return new Magazine(
                strings.get(0),
                strings.get(1),
                FilerEntities.findAuthorsBy(
                        Parcer.parseLine(strings.get(2)), authors),
                Parcer.parseDate(strings.get(3))
        );
    }
}
