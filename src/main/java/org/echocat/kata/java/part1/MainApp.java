package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.*;
import org.echocat.kata.java.part1.parcer.Parcer;
import org.echocat.kata.java.part1.reader.Reader;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    private static final String filePath = "C:\\Users\\Barba\\java-kata-1\\src\\main\\resources\\org\\echocat\\kata\\java\\part1\\data\\";

    public static void main(String[] args) {

        Stream<String> authorStream = Reader.readFile(filePath + "authors.csv");
        Stream<String> bookStream = Reader.readFile(filePath + "books.csv");
        Stream<String> magazineStream = Reader.readFile(filePath + "magazines.csv");

        List<Author> authors = authorStream
                .map(Parcer::parseLine)
                .map(stringStream -> new AuthorConstructor().apply(stringStream))
                .collect(Collectors.toList());
        System.out.println(authors);

        List<Publishable> books = bookStream
                .map(Parcer::parseLine)
                .map(line -> new BookConstructor().apply(line, authors))
                .collect(Collectors.toList());


        List<Publishable> magazines = magazineStream
                .map(Parcer::parseLine)
                .map(line -> new MagazineConstructor().apply(line, authors))
                .collect(Collectors.toList());

        List<Publishable> publishables = new ArrayList<>();
        publishables.addAll(books);
        publishables.addAll(magazines);

        System.out.println("All Books and magazines");
        publishables.forEach(System.out::println);

        System.out.println("By isbn: 4545-8558-3232");
        FilerEntities.findPublishableBy("4545-8558-3232", publishables)
                .forEach(System.out::println);

        System.out.println("Sorted books and magazines");
        // TODO: publishables.stream().sorted().forEach(System.out::println);

        System.out.println("By author: null-lieblich@echocat.org");
        FilerEntities.findPublishableByEmail("null-lieblich@echocat.org", publishables)
               .forEach(System.out::println);

    }
}

