package com.mentos74.drugsapp.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontPageController {

    @GetMapping("/about")
    public String about() {
        return "/front_page/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/front_page/contact";
    }

    @GetMapping("/help")
    public String help() {
        return "/front_page/help";
    }

    @GetMapping("/services")
    public String services() {
        return "/front_page/services";
    }


}
