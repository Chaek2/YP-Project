package com.example.yp_api_v3.Models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Book_Genre", schema = "dbo", catalog = "SYEL_YP")
public class BookGenre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Book_Genre", nullable = false)
    private int idBookGenre;
    @Basic
    @Column(name = "Book", nullable = false)
    private int book;
    @Basic
    @Column(name = "Genre", nullable = false)
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
