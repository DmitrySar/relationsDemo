package com.example.relationsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/jsondemo")
    public String jsonDemo() {
        return "jsondemo";
    }
}
