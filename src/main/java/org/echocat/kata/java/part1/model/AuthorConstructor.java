package org.echocat.kata.java.part1.model;

import java.util.List;

public class AuthorConstructor implements EntityConstructor<Author> {

    @Override
    public Author apply(List<String> stringStream) {
        return new Author(stringStream.get(0), stringStream.get(1), stringStream.get(2));
    }
}
