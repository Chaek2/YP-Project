package com.example.yp.Models;

import java.util.Objects;


public class BookSimilar {

    private int idBookSimilar;

    private int book;

    private int similar;

    public int getIdBookSimilar() {
        return idBookSimilar;
    }

    public void setIdBookSimilar(int idBookSimilar) {
        this.idBookSimilar = idBookSimilar;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getSimilar() {
        return similar;
    }

    public void setSimilar(int similar) {
        this.similar = similar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookSimilar that = (BookSimilar) o;
        return idBookSimilar == that.idBookSimilar && book == that.book && similar == that.similar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBookSimilar, book, similar);
    }
}
