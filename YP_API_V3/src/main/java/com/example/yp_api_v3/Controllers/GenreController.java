package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.Genre;
import com.example.yp_api_v3.Repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/genre")
public class GenreController {
    @Autowired
    private GenreRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<Genre> genre = repos.findById(id);
        if(genre.isPresent()) {
            return ResponseEntity.ok().body(genre.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody Genre genre) {
        repos.save(genre);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody Genre genre) {
        Optional<Genre> genrecurrect = repos.findById(genre.getIdGenre());
        if(genrecurrect.isPresent()) {
            repos.save(genre);
            return ResponseEntity.ok().body(repos.findById(genre.getIdGenre()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<Genre> genre = repos.findById(id);
        if(genre.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
