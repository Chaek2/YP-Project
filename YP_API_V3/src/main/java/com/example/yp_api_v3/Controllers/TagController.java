package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.Tag;
import com.example.yp_api_v3.Repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tag")
public class TagController {

    @Autowired
    private TagRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<Tag> tag = repos.findById(id);
        if(tag.isPresent()) {
            return ResponseEntity.ok().body(tag.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    Tag save(@RequestBody Tag tag) {
        return repos.save(tag);
    }

    @PutMapping
    ResponseEntity put(@RequestBody Tag tag) {
        Optional<Tag> clientcurrect = repos.findById(tag.getIdTag());
        if(clientcurrect.isPresent()) {
            repos.save(tag);
            return ResponseEntity.ok().body(repos.findById(tag.getIdTag()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<Tag> tag = repos.findById(id);
        if(tag.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
