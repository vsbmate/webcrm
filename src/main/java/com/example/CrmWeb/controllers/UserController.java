package com.example.CrmWeb.controllers;


import com.example.CrmWeb.models.UserAdmin;
import com.example.CrmWeb.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(UserAdmin userAdmin, Model model){
        if(!userService.createUser(userAdmin)){
            model.addAttribute("errorMessage", "Пользователь с eMail: " + userAdmin.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/login";
    }
}
