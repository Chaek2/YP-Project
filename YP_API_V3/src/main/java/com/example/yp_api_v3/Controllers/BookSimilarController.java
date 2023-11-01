package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.BookSimilar;
import com.example.yp_api_v3.Repositories.BookSimilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/booksimilar")
public class BookSimilarController {
    @Autowired
    private BookSimilarRepository repos;

    @GetMapping
    List FindAll() {
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id) {
        Optional<BookSimilar> bookSimilar = repos.findById(id);
        if (bookSimilar.isPresent()) {
            return ResponseEntity.ok().body(bookSimilar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody BookSimilar bookSimilar) {
        repos.save(bookSimilar);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody BookSimilar bookSimilar) {
        Optional<BookSimilar> bookSimilarcurrect = repos.findById(bookSimilar.getIdBookSimilar());
        if (bookSimilarcurrect.isPresent()) {
            repos.save(bookSimilar);
            return ResponseEntity.ok().body(repos.findById(bookSimilar.getIdBookSimilar()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id) {
        Optional<BookSimilar> bookSimilar = repos.findById(id);
        if (bookSimilar.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
