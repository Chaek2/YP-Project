package com.example.yp_api_v3.Models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Book_Similar", schema = "dbo", catalog = "SYEL1")
public class BookSimilar {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Book_Similar", nullable = false)
    private int idBookSimilar;
    @Basic
    @Column(name = "Book", nullable = false)
    private int book;
    @Basic
    @Column(name = "Similar", nullable = false)
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
