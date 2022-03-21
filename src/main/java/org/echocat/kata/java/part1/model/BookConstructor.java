package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.parcer.Parcer;

import java.util.List;

public class BookConstructor implements EntityConstructor<Book> {

    @Override
    public Book apply(List<String> strings) {
        return new Book(
                strings.get(0),
                strings.get(1),
                Parcer.parseLine(strings.get(2), ","),
                strings.get(3));
    }
}
