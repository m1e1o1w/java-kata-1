package org.echocat.kata.java.part1.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilerEntities {
    public static List<Author> findAuthorsBy(List<String> emails, List<Author> authors) {
        return emails.stream()
                .flatMap(authorEmail -> authors.stream().filter(it -> it.getEmail().equals(authorEmail)))
                .collect(Collectors.toList()
                );
    }

    public static List<Publishable> findPublishableBy(String isbn, List<Publishable> publishables) {
        return publishables.stream().filter(it -> it.getIsbn().equals(isbn))
                .collect(Collectors.toList()
                );
    }

    public static List<Publishable> findPublishableByEmail(String email, List<Publishable> publishables) {
        Optional<Author> authors = publishables
                .stream().flatMap(it -> it.getAuthors().stream())
                .filter(a -> a.getEmail().equals(email)).findFirst();
        return publishables.stream()
                .filter(it -> it.getAuthors().contains(authors.get()))
                .collect(Collectors.toList()
                );
    }
}
