package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.PublicKey;

public interface PersonRespository  extends JpaRepository<Person, Integer> {


    @Query("select p from Person p where p.id = ?1")
    Person findById(int id);
}
