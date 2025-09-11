package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello new strange Spring-world";
    }
}
