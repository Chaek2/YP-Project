package com.example.yp_api_v3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Role", nullable = false)
    private int idRole;
    @Basic
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Client> clients = new ArrayList<>();

    public Role() {
    }

    public Role(String title) {
        this.title = title;
    }

    public Role(int idRole, String title, List<Client> clients) {
        this.idRole = idRole;
        this.title = title;
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
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
