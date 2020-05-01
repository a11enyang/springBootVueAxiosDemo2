package com.example.demo.controller.person;


import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class MainController {

    @Autowired
    public PersonService personService;

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }
}
