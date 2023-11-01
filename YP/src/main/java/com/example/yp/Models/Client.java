package com.example.yp.Models;


import java.util.ArrayList;
import java.util.List;

public class Client {

    private int idClient;

    private String username;

    private String password;

    private Role role;
    private boolean active;

    public Client() {
    }

    public Client(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Client(int idClient, String username, String password, Role role) {
        this.idClient = idClient;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean isActive() {
        return true;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}