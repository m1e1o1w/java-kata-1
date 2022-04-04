package org.echocat.kata.java.part1.reader;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Reader {
    public static Stream<String> readFile(String fileName) {
        try {
            URI uri = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(fileName)).toURI();
            return Files.lines(Path.of(uri)).skip(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
