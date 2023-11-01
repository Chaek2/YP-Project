package com.example.yp_api_v3.Models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Book_Tag", schema = "dbo", catalog = "SYEL_YP")
public class BookTag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Book_Tag", nullable = false)
    private int idBookTag;
    @Basic
    @Column(name = "Book", nullable = false)
    private int book;
    @Basic
    @Column(name = "Tag", nullable = false)
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
