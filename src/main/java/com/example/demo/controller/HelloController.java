package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/twitter")
public class HelloController {

    @PostMapping("/post")
    public Object post(@RequestParam String id, @RequestParam String name) {
        Map<String, Object> person = new HashMap<>();
        person.put("name", name);
        person.put("id",id);
        return person;
    }
}
