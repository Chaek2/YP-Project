package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.Client;
import com.example.yp_api_v3.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<Client> client = repos.findById(id);
        if(client.isPresent()) {
            return ResponseEntity.ok().body(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody Client client) {
//        Client newclient = new Client(client.getRole(), client.getUsername(), client.getPassword());
        repos.save(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody Client client) {
        Optional<Client> clientcurrect = repos.findById(client.getIdClient());
        if(clientcurrect.isPresent()) {
            repos.save(client);
            return ResponseEntity.ok().body(repos.findById(client.getIdClient()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<Client> client = repos.findById(id);
        if(client.isPresent()) {
            if(client.get().getRole().getIdRole() == 1){
                return ResponseEntity.noContent().build();
            }
            else {
                repos.deleteById(id);
                return ResponseEntity.ok().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
