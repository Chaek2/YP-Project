package com.example.yp.Models;


public class Role {
    private int idRole;
    private String title;

    public Role() {
    }

    public Role(String title) {
        this.title = title;
    }

    public Role(int idRole, String title) {
        this.idRole = idRole;
        this.title = title;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
