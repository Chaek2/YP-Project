package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.Liked;
import com.example.yp_api_v3.Repositories.LikedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/liked")
public class LikedController {
    @Autowired
    private LikedRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<Liked> liked = repos.findById(id);
        if(liked.isPresent()) {
            return ResponseEntity.ok().body(liked.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody Liked liked) {
        repos.save(liked);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody Liked liked) {
        Optional<Liked> likedcurrect = repos.findById(liked.getIdLiked());
        if(likedcurrect.isPresent()) {
            repos.save(liked);
            return ResponseEntity.ok().body(repos.findById(liked.getIdLiked()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<Liked> liked = repos.findById(id);
        if(liked.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
