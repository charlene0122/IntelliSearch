package com.search.intellisearch.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
