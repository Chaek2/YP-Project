package com.example.yp.Models;

import java.util.Objects;

public class Liked {
    private int idLiked;
    private int book;
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
