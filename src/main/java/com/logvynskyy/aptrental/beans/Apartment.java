package com.logvynskyy.aptrental.beans;

import java.util.HashSet;

public class Apartment {
//    private User owner;
    private String name;
    private String description;
    private String keywordsInString;
    private HashSet<String> keywords = new HashSet<>();

    public Apartment() {
        super();
    }

    public Apartment(String name, String description, String keywordsInString, HashSet<String> keywords) {
        this.name = name;
        this.description = description;
        this.keywordsInString = keywordsInString;
        this.keywords = keywords;
    }

    //    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }

    public String getName() {
        return name;
    }

    public void setName(String naming) {
        this.name = naming;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywordsInString() {
        return keywordsInString;
    }

    public void setKeywordsInString(String keywordsInString) {
        this.keywordsInString = keywordsInString;
    }

    public HashSet<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(HashSet<String> keywords) {
        this.keywords = keywords;
    }
}
