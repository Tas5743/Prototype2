package com.darksideoftherainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/about")
    public String aboutUs() {
        return "about";
    }

    @GetMapping("/careers")
    public String careers() {
        return "careers";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
