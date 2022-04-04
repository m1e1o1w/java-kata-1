package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.*;
import org.echocat.kata.java.part1.parcer.Parcer;
import org.echocat.kata.java.part1.reader.Reader;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    private final Database database = new Database();
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public MainApp() throws Exception {
        Future<List<Author>> authors = executorService.submit(this::readAuthors);
        Future<List<Publication>> publications = executorService.submit(this::readPublications);
        database.setAuthorList(authors.get());
        database.setPublishableList(publications.get());
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        MainApp mainApp = new MainApp();
        Database database = mainApp.getDatabase();

        List<Publication> publications = database.getPublishableList();

        publications.forEach(System.out::println);
        mainApp.findPublishableByIsbn("3214-5698-7412", publications).forEach(System.out::println);
        mainApp.findPublishableByEmail("null-lieblich@echocat.org", publications).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("It took: " + ((end - start) / 1000.0) + "seconds");
        mainApp.executorService.shutdown();
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

    private List<Publication> readPublications() throws ExecutionException, InterruptedException {
        Future<Stream<Book>> books = executorService.submit(this::streamBooks);
        Future<Stream<Magazine>> magazines = executorService.submit(this::streamMagazines);
        return Stream.concat(books.get(), magazines.get()).collect(Collectors.toList());
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
        return Reader.readFile(fileName)
                .map(Parcer::parseLine)
                .map(constructor);
    }

    public Database getDatabase() {
        return database;
    }
}


