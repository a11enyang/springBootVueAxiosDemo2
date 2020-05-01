package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    public PersonRespository personRespository;

    /**
     * 通过id查找person
     * @param id
     * @return
     */
    public Person findById(int id) {
        return personRespository.findById(id);
    }

    /**
     * 查找所有的person
     * @return
     */
    public List<Person> findAll() {
        return personRespository.findAll();
    }

    /**
     * 保存一个person
     * @param p
     * @return
     */
    public Person saveOne(Person p) {
        return personRespository.save(p);
    }

    /**
     * 根据id删除person
     * @param id
     */
    public void deleteById(int id) {
        personRespository.deleteById(id);
    }
}
