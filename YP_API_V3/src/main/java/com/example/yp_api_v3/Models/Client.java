package com.example.yp_api_v3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Client", nullable = false)
    private int idClient;
    @Basic
    @Column(name = "Login", nullable = false, length = 30)
    private String username;
    @Basic
    @Column(name = "Password", nullable = false, length = 30)
    private String password;

    @ManyToOne
    @JoinColumn(name="Role")
    private Role role;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Liked",
            joinColumns = @JoinColumn(name = "Client", referencedColumnName = "ID_Client"),
            inverseJoinColumns = @JoinColumn(name = "Book", referencedColumnName = "ID_Book"))
    private List<Book> liked = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "History",
            joinColumns = @JoinColumn(name = "Client", referencedColumnName = "ID_Client"),
            inverseJoinColumns = @JoinColumn(name = "Book", referencedColumnName = "ID_Book"))
    private List<Book> history = new ArrayList<>();

    public Client() {
    }

    public Client(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Client(int idClient, String username, String password, Role role, List<Book> liked, List<Book> history) {
        this.idClient = idClient;
        this.username = username;
        this.password = password;
        this.role = role;
        this.liked = liked;
        this.history = history;
    }

    public List<Book> getLiked() {
        return liked;
    }

    public void setLiked(List<Book> liked) {
        this.liked = liked;
    }

    public List<Book> getHistory() {
        return history;
    }

    public void setHistory(List<Book> history) {
        this.history = history;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
