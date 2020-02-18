package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    private Person person1, person2;

    @Before
    public void setUp() {
        Person person1 = new Person(null, "person1", "ln1", "p1@gmail.com", "Espo", "p1username", "pass1", null);
        Person person2 = new Person(null, "person2", "ln2", "p2@gmail.com", "Espo", "p2username", "pass2", null);
    }

    @Test
    public void getPersons(){
        when(personRepository.findAll()).thenReturn(Stream.of(person1,person2).collect(Collectors.toList()));
        assertEquals(2, personService.findAll().size());
    }

    @Test
    public void whenValidEmail_thenPersonFound() {
        Person person1 = new Person(null, "person1", "ln1", "p1@gmail.com", "Espo", "p1username", "pass1", null);
        String email = "p1@gmail.com";

        when(personRepository.findByEmail(email)).thenReturn(person1);
        assertEquals(person1.getEmail(), personRepository.findByEmail(email).getEmail());
    }

}
