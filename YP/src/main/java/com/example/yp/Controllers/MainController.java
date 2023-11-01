package com.example.yp.Controllers;

import com.example.yp.Models.*;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    Server server = new Server();

    @GetMapping("/")
    String main_auth_get(){
        return "auth";
    }
    @GetMapping("/auth")
    String auth_get(){
        return "auth";
    }
    @GetMapping("/reg")
    String reg_get(){
        return "reg";
    }

    @PostMapping("/auth")
    String auth_post(@RequestParam String username,
                     @RequestParam String password,
                     HttpServletResponse response){
        Client client = server.GetByUsername(username);
        if(client != null) {
            if (client.getPassword().equals(password)) {
                Cookie cookie = new Cookie("id", String.valueOf(client.getIdClient()));
                response.addCookie(cookie);
                return "redirect:/menu";
            }
        }
        Cookie cookie = new Cookie("id", "0");
        response.addCookie(cookie);
        return "auth";
    }

    @PostMapping("/reg")
    String reg_post(@RequestParam String username,
                     @RequestParam String password,
                     HttpServletResponse response) throws IOException, InterruptedException {
        @Nullable Client client = server.GetByUsername(username);
        if(client == null) {
            ArrayList arrayList = new ArrayList();
            Role role = (Role) server.GetByID(TABLE.role,3);
            arrayList.add(role.getIdRole());
            arrayList.add(role.getTitle());
            arrayList.add(username);
            arrayList.add(password);
            int complite = server.Post(TABLE.client,arrayList);
            return "redirect:/auth";
        }
        Cookie cookie = new Cookie("id", "0");
        response.addCookie(cookie);
        return "reg";
    }

    @GetMapping("/menu")
    String menu_get(@CookieValue int id,Model model){
        if (id>0){
            model.addAttribute("id",id);
            Client client = (Client) server.GetByID(TABLE.client,id);
            model.addAttribute("role",client.getRole().getIdRole());
            return "menu";
        }
        return "auth";
    }

    @GetMapping("/profile")
    String profile_get(@CookieValue int id,
                       Model model){
        if (id>0){
            Client client = (Client) server.GetByID(TABLE.client,id);
            model.addAttribute("client",client);
            return "profile";
        }
        return "auth";
    }

    @GetMapping("/book/all")
    String book_all_get(@CookieValue int id,Model model){
        if (id>0) {
            model.addAttribute("book", server.GetAll(TABLE.book));
            return "bookall";
        }
        return "auth";
    }

    @GetMapping("/book/info")
    String book_info_get(@CookieValue int id,@RequestParam int idbook,Model model) throws IOException, InterruptedException {
        if (id>0) {
            boolean find = false;
            List<History> historyList = (List<History>) server.GetAll(TABLE.history);
            for(History item: historyList){
                if(item.getBook() == idbook && item.getClient() == id) find = true;
            }
            if(find){
                ArrayList arrayList = new ArrayList();
                arrayList.add(idbook);
                arrayList.add(id);
                int complite = server.Post(TABLE.history,arrayList);
            }
            model.addAttribute("book", server.GetByID(TABLE.book,idbook));
            return "bookinfo";
        }
        return "auth";
    }

    @GetMapping("/logout")
    String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("id", "0");
        response.addCookie(cookie);
        return "redirect:/auth";
    }
}
