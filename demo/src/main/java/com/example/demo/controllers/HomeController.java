package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        String name = principal.getName();
        return("<h1>Welcome Admin" + name + "</h1>");
    }

}
