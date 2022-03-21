package org.echocat.kata.java.part1.model;

import java.util.List;
import java.util.stream.Collectors;

public class FilerEntities {

    public static List<Publication> findPublishableBy(String isbn, List<Publication> publishables) {
        return publishables.stream().filter(it -> it.getIsbn().equals(isbn))
                .collect(Collectors.toList()
                );
    }

    public static List<Publication> findPublishableByEmail(String email, List<Publication> publishables) {
        return publishables
                .stream()
                .filter(publication -> publication.getAuthors().contains(email))
                .collect(Collectors.toList());
    }
}
