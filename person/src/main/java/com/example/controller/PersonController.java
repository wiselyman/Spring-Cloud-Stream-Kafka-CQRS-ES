package com.example.controller;

import com.example.command.CreatePersonCommand;
import com.example.domain.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by wangyunfei on 2017/6/5.
 */
@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody CreatePersonCommand personCommand){
        personCommand.setId(UUID.randomUUID().toString());
        Person p = personRepository.save(new Person(personCommand));
        return new ResponseEntity(p,HttpStatus.OK);
    }

}
