package com.example.yp.Models;

import java.util.Objects;


public class BookTag {

    private int idBookTag;

    private int book;

    private int tag;

    public int getIdBookTag() {
        return idBookTag;
    }

    public void setIdBookTag(int idBookTag) {
        this.idBookTag = idBookTag;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookTag bookTag = (BookTag) o;
        return idBookTag == bookTag.idBookTag && book == bookTag.book && tag == bookTag.tag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBookTag, book, tag);
    }
}
