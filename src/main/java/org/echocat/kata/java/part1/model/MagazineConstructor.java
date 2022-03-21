package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.parcer.Parcer;

import java.util.List;

public class MagazineConstructor implements EntityConstructor<Magazine> {

    @Override
    public Magazine apply(List<String> strings) {
        return new Magazine(
                strings.get(0),
                strings.get(1),
                Parcer.parseLine(strings.get(2), ","),
                Parcer.parseDate(strings.get(3))
        );
    }
}
