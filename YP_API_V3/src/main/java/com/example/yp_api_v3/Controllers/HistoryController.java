package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.History;
import com.example.yp_api_v3.Repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/history")
public class HistoryController {
    @Autowired
    private HistoryRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<History> history = repos.findById(id);
        if(history.isPresent()) {
            return ResponseEntity.ok().body(history.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody History history) {
        repos.save(history);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody History history) {
        Optional<History> bookcurrect = repos.findById(history.getIdHistory());
        if(bookcurrect.isPresent()) {
            repos.save(history);
            return ResponseEntity.ok().body(repos.findById(history.getIdHistory()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<History> history = repos.findById(id);
        if(history.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
