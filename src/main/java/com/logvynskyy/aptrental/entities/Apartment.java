package com.logvynskyy.aptrental.entities;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;

public class Apartment {
    private String owner;
    private int id;
    private String name;
    private String description;
    private String keywordsInString;
    private HashSet<String> keywords = new HashSet<>();
    private MultipartFile[] files;

    public Apartment() {
        super();
    }

    public Apartment(int id, String name, String description, String keywordsInString, HashSet<String> keywords) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.keywordsInString = keywordsInString;
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

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

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
