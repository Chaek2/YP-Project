package com.example.yp.Controllers;

import com.example.yp.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class AdminController {
    Server server = new Server();

    @GetMapping("/TG")
    String TG_get(Model model){
        model.addAttribute("tag",server.GetAll(TABLE.tag));
        model.addAttribute("gen",server.GetAll(TABLE.genre));
        return "TG";
    }
    @PostMapping("/TG")
    String TG_post(@RequestParam String column,Model model){
        List<Tag> tagList = (List<Tag>) server.GetAll(TABLE.tag);
        List<Genre> genreList = (List<Genre>) server.GetAll(TABLE.genre);
        switch (column){
            case "id":
                Collections.sort(genreList, Comparator.comparing(Genre::getIdGenre));
                Collections.sort(tagList, Comparator.comparing(Tag::getIdTag));
                break;
            case "title":
                Collections.sort(genreList, Comparator.comparing(Genre::getTitle));
                Collections.sort(tagList, Comparator.comparing(Tag::getTitle));
                break;
        }
        model.addAttribute("tag",tagList);
        model.addAttribute("gen",genreList);
        return "TG";
    }

    @PostMapping("/TAG/DEL")
    String TAG_DEL_post(@RequestParam int id) throws IOException, InterruptedException {
        int complite = server.Delete(TABLE.tag,id);
        return "redirect:/TG";
    }
    @PostMapping("/TAG/ADD")
    String TAG_ADD_post(@RequestParam String title) throws IOException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(title);
        int complite = server.Post(TABLE.tag,arrayList);
        return "redirect:/TG";
    }

    @PostMapping("/GEN/DEL")
    String GEN_DEL_post(@RequestParam int id) throws IOException, InterruptedException {
        int complite = server.Delete(TABLE.genre,id);
        return "redirect:/TG";
    }
    @PostMapping("/GEN/ADD")
    String GEN_ADD_post(@RequestParam String title) throws IOException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(title);
        int complite = server.Post(TABLE.genre,arrayList);
        return "redirect:/TG";
    }

    @GetMapping("/book/new")
    String book_new_get(@CookieValue int id) {
        if (id>0) {
            return "booknew";
        }
        return "auth";
    }
    @PostMapping("/book/new")
    String book_new_post(@CookieValue int id, @ModelAttribute Book book) throws IOException, InterruptedException {
        if (id>0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(book.getTitle());
            arrayList.add(book.getImage());
            arrayList.add(book.getSummary());
            arrayList.add(book.getTxt());
            arrayList.add(book.getAuthor());
            arrayList.add(book.getYearOfPublication());
            int complite = server.Post(TABLE.book,arrayList);
            System.out.println(complite);
            return "redirect:/menu";
        }
        return "auth";
    }


}
