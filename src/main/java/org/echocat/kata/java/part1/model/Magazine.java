package org.echocat.kata.java.part1.model;

import java.time.LocalDate;
import java.util.List;

public class Magazine extends Publishable {
    private final LocalDate publishedAt;

    public Magazine(String title, String isbn, List<Author> authors, LocalDate publishedAt) {
        super(title, isbn, authors);
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title=" + super.getTitle() +
                ", isbn= " + super.getIsbn() +
                ", authors=" + super.getAuthors().toString() +
                ", publishedAt=" + publishedAt +
                '}';
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }
}
