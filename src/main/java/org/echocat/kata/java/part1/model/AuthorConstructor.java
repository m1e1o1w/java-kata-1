package org.echocat.kata.java.part1.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AuthorConstructor implements Function<List<String>, Author> {

    @Override
    public Author apply(List<String> stringStream) {
        return new Author(stringStream.get(0), stringStream.get(1), stringStream.get(2));
    }
}
