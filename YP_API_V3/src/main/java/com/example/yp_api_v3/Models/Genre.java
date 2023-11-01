package com.example.yp_api_v3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Genre", nullable = false)
    private int idGenre;
    @Basic
    @Column(name = "Title", nullable = false, length = 50)
    private String title;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookgenre")
    private List<Book> bookgenre = new ArrayList<>();

    public Genre() {
    }

    public Genre(String title) {
        this.title = title;
    }

    public Genre(int idGenre, String title, List<Book> bookgenre) {
        this.idGenre = idGenre;
        this.title = title;
        this.bookgenre = bookgenre;
    }

    public List<Book> getBookgenre() {
        return bookgenre;
    }

    public void setBookgenre(List<Book> bookgenre) {
        this.bookgenre = bookgenre;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
