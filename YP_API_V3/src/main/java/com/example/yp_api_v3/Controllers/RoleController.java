package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.Role;
import com.example.yp_api_v3.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    private RoleRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<Role> role = repos.findById(id);
        if(role.isPresent()) {
            return ResponseEntity.ok().body(role.get());
        } else {
            return ResponseEntity.status(418).build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody Role role) {
        repos.save(role);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody Role role) {
        Optional<Role> rolecurrect = repos.findById(role.getIdRole());
        if(rolecurrect.isPresent()) {
            repos.save(role);
            return ResponseEntity.ok().body(repos.findById(role.getIdRole()).get());
        } else {
            return ResponseEntity.status(418).build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<Role> role = repos.findById(id);
        if(role.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(418).build();
        }
    }
}
