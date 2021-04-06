package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";

    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }


    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}


