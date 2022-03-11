package org.echocat.kata.java.part1.model;

import java.util.List;

public class Book extends Publishable implements Printable{

   private final String description;

    public Book(String title, String isbn, List<Author> authors, String description) {
        super(title, isbn, authors);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title=" + super.getTitle()+
                ", isbn= "+ super.getIsbn()+
                ", authors="+ super.getAuthors().toString()+
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    @Override
    public <Book> void printEntity(List<Book> list) {
        list.forEach(System.out::println);
    }
}
