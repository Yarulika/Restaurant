package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class PersonServiceTest {

//    @Autowired
//    private PersonRepository personRepository;
//
//    @Test
//    void basicTest() {
//        given(personRepository.findById(1)).willReturn(Optional.empty());
//
//    PersonService personService = new PersonService();
//    personService.findById(1);
//
//    }
}