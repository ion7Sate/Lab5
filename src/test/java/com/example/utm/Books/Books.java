package com.example.utm.Books;

public class Books {
    private int id;
    private  String title;
    private String author;
    private int nrPages;

    public Books(int id, String title, String author, int nrPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.nrPages = nrPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNrPages() {
        return nrPages;
    }

    public void setNrPages(int nrPages) {
        this.nrPages = nrPages;
    }
}
