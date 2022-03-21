package org.echocat.kata.java.part1.model;

import java.util.List;

public interface Printable {
    <E> void printEntity(List<E> list);
}
