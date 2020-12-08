package com.group7.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class employee {

    @GetMapping("/employee")
    String Employee(){
        return "Employee";
    }
}
