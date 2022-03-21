package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.*;
import org.echocat.kata.java.part1.parcer.Parcer;
import org.echocat.kata.java.part1.reader.Reader;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    private static final String filePath = "C:\\Users\\Barba\\java-kata-1\\src\\main\\resources\\org\\echocat\\kata\\java\\part1\\data\\";

    private final Database database = new Database();

    public MainApp() {
        database.setAuthorList(readAuthors());
        database.setPublishableList(readPublications());
    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        Database database = mainApp.getDatabase();
        List<Publication> publications = database.getPublishableList();

        publications.forEach(System.out::println);
        mainApp.findPublishableByIsbn("3214-5698-7412", publications).forEach(System.out::println);
        mainApp.findPublishableByEmail("null-lieblich@echocat.org", publications).forEach(System.out::println);

    }

    private List<Publication> findPublishableByIsbn(String isbn, List<Publication> publications) {
        return FilerEntities.findPublishableBy(isbn, publications);
    }

    private List<Publication> findPublishableByEmail(String email, List<Publication> publications) {
        return FilerEntities.findPublishableByEmail(email, publications);
    }

    private List<Author> readAuthors() {
        return readEntities("authors.csv", new AuthorConstructor(), Collectors.toList());
    }

    private List<Publication> readPublications() {
        return Stream.concat(streamBooks(), streamMagazines()).collect(Collectors.toList());
    }

    private Stream<Book> streamBooks() {
        return streamEntity("books.csv", new BookConstructor());
    }

    private Stream<Magazine> streamMagazines() {
        return streamEntity("magazines.csv", new MagazineConstructor());
    }

    public <E, C> C readEntities(String fileName, EntityConstructor<E> constructor, Collector<E, ?, C> collector) {
        return streamEntity(fileName, constructor).collect(collector);
    }

    public <E> Stream<E> streamEntity(String fileName, EntityConstructor<E> constructor) {
        return Reader.readFile(filePath + fileName)
                .map(Parcer::parseLine)
                .map(constructor);
    }

    public Database getDatabase() {
        return database;
    }
}


