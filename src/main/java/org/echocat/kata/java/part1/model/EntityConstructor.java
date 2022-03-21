package org.echocat.kata.java.part1.model;

import java.util.List;
import java.util.function.Function;

public interface EntityConstructor<E> extends Function<List<String>, E> {
}
