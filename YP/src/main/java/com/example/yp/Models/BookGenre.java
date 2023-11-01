package com.example.yp.Models;


import java.util.Objects;

public class BookGenre {

    private int idBookGenre;

    private int book;

    private int genre;

    public int getIdBookGenre() {
        return idBookGenre;
    }

    public void setIdBookGenre(int idBookGenre) {
        this.idBookGenre = idBookGenre;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenre bookGenre = (BookGenre) o;
        return idBookGenre == bookGenre.idBookGenre && book == bookGenre.book && genre == bookGenre.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBookGenre, book, genre);
    }
}
