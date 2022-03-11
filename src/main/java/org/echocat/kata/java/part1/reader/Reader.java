package org.echocat.kata.java.part1.reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class Reader {
    public static Stream<String> readFile(String fileName) {
        try {
            return Files.lines(Path.of(fileName)).skip(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
