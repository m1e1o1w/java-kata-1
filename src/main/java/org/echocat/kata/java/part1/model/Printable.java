package org.echocat.kata.java.part1.model;

import java.util.List;

public interface Printable {
    public <E> void printEntity(List<E> list);
}
