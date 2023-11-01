package com.example.yp_api_v3.Repositories;

import com.example.yp_api_v3.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByUsername(String username);
}