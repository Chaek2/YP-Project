package com.example.yp_api_v3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tag")
public class Tag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Tag", nullable = false)
    private int idTag;
    @Basic
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @JsonIgnore
    @ManyToMany(mappedBy = "booktag")
    private List<Book> booktag = new ArrayList<>();

    public Tag() {
    }

    public Tag(String title) {
        this.title = title;
    }

    public Tag(int idTag, String title, List<Book> booktag) {
        this.idTag = idTag;
        this.title = title;
        this.booktag = booktag;
    }

    public List<Book> getBooktag() {
        return booktag;
    }

    public void setBooktag(List<Book> booktag) {
        this.booktag = booktag;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
