package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.parcer.Parcer;

import java.io.File;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BookConstructor implements BiFunction<List<String>, List<Author>, Book> {

    @Override
    public Book apply(List<String> strings, List<Author> authors) {
        return new Book(
                strings.get(0),
                strings.get(1),
                FilerEntities.findAuthorsBy(Parcer.parseLine(strings.get(2),","), authors),
                strings.get(3));
    }
}
