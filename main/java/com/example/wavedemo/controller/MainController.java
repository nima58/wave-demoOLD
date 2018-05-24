package com.example.wavedemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello from ClearOn controller ...";
    }
}
