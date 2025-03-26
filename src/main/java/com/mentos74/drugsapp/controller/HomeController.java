package com.mentos74.drugsapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        System.out.println("kadieu");
        return "home/home";
    }
}
