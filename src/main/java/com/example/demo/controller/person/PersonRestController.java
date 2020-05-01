package com.example.demo.controller.person;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonRestController {

    @Autowired
    public PersonService personService;

    /**
     * 查询所有person
     * @return
     */
    @GetMapping("/persons")
    public List<Person> list() {
        return personService.findAll();
    }

    /**
     * 保存一个person
     * @param p
     * @return
     */
    @PostMapping("/persons")
    public Person saveOne(@RequestBody Person p) {
        return personService.saveOne(p);
    }

    /**
     * 根据id删除一个person
     * @param id
     */
    @DeleteMapping("/persons/{id}")
    public void deleteById(@PathVariable int id) {
        personService.deleteById(id);
    }
}
