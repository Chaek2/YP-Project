package com.example.yp_api_v3.Controllers;

import com.example.yp_api_v3.Models.Book;
import com.example.yp_api_v3.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    private BookRepository repos;

    @GetMapping
    List FindAll(){
        return (List) repos.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity FindById(@PathVariable int id){
        Optional<Book> book = repos.findById(id);
        if(book.isPresent()) {
            return ResponseEntity.ok().body(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity save(@RequestBody Book book) {
        repos.save(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity put(@RequestBody Book book) {
        Optional<Book> bookcurrect = repos.findById(book.getIdBook());
        if(bookcurrect.isPresent()) {
            repos.save(book);
            return ResponseEntity.ok().body(repos.findById(book.getIdBook()).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    ResponseEntity Delete(@RequestParam int id){
        Optional<Book> book = repos.findById(id);
        if(book.isPresent()) {
            repos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
