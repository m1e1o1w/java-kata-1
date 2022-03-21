package org.echocat.kata.java.part1.model;

import java.util.List;

public class Database {
    public List<Publication> getPublishableList() {
        return publishableList;
    }

    public void setPublishableList(List<Publication> publishableList) {
        this.publishableList = publishableList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    private List<Publication> publishableList;
    private List<Author> authorList;


    public Database() {
    }


}
