package com.sda.restaurant.service;

import com.sda.restaurant.model.Person;
import com.sda.restaurant.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

//    public List<Person> getPersons(){
//        return personRepository.findAll();
//    }

//HW finish entites, service layer
//  implement in service methods:
//
//    create
//    delete
//    update
//    getById
//    list all
}
