package org.echocat.kata.java.part1.model;

import java.util.List;

public class Publishable {
   private final String title;
  private final String isbn;
  private final List<Author> authors;

    public Publishable(String title, String isbn, List<Author> authors) {
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

    public List<Author> getAuthors() {
        return authors;
    }
}
