package com.example.yp.Models;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private int idTag;
    private String title;

    public Tag() {
    }

    public Tag(String title) {
        this.title = title;
    }

    public Tag(int idTag, String title) {
        this.idTag = idTag;
        this.title = title;
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
