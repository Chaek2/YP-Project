package com.example.yp_api_v3.Models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Liked {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Liked", nullable = false)
    private int idLiked;
    @Basic
    @Column(name = "Book", nullable = false)
    private int book;
    @Basic
    @Column(name = "Client", nullable = false)
    private int client;

    public int getIdLiked() {
        return idLiked;
    }

    public void setIdLiked(int idLiked) {
        this.idLiked = idLiked;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liked liked = (Liked) o;
        return idLiked == liked.idLiked && book == liked.book && client == liked.client;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLiked, book, client);
    }
}
