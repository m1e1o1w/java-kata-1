package org.echocat.kata.java.part1.model;

import java.util.List;

public class Publication {
    private final String title;
    private final String isbn;
    private final List<String> authors;

    public Publication(String title, String isbn, List<String> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
