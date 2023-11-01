package com.example.yp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Book {

    private int idBook;

    private String title;

    private String image;

    private String summary;

    private String txt;

    private String author;

    private Date yearOfPublication;

    public Book() {
    }

    public Book(String title, String image, String summary, String txt, String author, Date yearOfPublication) {
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.txt = txt;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Book(int idBook, String title, String image, String summary, String txt, String author, Date yearOfPublication) {
        this.idBook = idBook;
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.txt = txt;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}