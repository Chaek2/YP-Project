package com.example.yp.Models;

import java.util.Objects;

public class History {
    private int idHistory;
    private int book;
    private int client;

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
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
        History history = (History) o;
        return idHistory == history.idHistory && book == history.book && client == history.client;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistory, book, client);
    }
}
