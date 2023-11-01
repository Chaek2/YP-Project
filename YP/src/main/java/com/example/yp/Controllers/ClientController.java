package com.example.yp.Controllers;

import com.example.yp.Models.Client;
import com.example.yp.Models.Role;
import com.example.yp.Models.TABLE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ClientController {
    Server server = new Server();
    @PostMapping("/profile")
    String profile_post(@RequestParam int idClient,
                        @RequestParam String username,
                        @RequestParam String password,
                        @RequestParam int idrole
    ) throws IOException, InterruptedException {
        Role role = (Role) server.GetByID(TABLE.role,idrole);
        ArrayList arrayList = new ArrayList();
        arrayList.add(idrole);
        arrayList.add(role.getTitle());
        arrayList.add(username);
        arrayList.add(password);
        arrayList.add(idClient);
        int complite = server.Put(TABLE.client,arrayList);
        return "redirect:/profile";
    }
}
