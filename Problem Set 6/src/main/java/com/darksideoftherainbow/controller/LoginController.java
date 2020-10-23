package com.darksideoftherainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "logoutsuccess";
    }
}
