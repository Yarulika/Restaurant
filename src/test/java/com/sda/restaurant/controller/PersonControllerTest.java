package com.sda.restaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.entity.Role;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import com.sda.restaurant.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Test between controller and the HTTP layer
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = PersonController.class) //@WebMvcTest: fires up an application context that contains only the beans needed for testing a web controller
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc; // MockMvc instance to simulate HTTP requests

    @Autowired
    private ObjectMapper objectMapper; //to map to and from JSON

    @MockBean
    private PersonRepository personRepository;
//    @InjectMocks// mocks away the business logic
    private PersonService personService;

    @SpyBean
    private OrderService orderService;
    @SpyBean
    private UserServiceImpl userService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPersons() throws Exception {
        System.out.println("===TEST===TEST===TEST===");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, Role.RoleTitle.EMPLOYEE));
        Person testPerson1 = new Person(null, "test1", "testLn1", "test1@gmail.com", "Espoo", "testUsername1", "testPassword1", roles);
        Person testPerson2 = new Person(null, "test2", "testLn2", "test2@gmail.com", "Espoo", "testUsername2", "testPassword2", roles);
        List<Person> persons = new ArrayList<>();
        persons.add(testPerson1);
        persons.add(testPerson2);

        when(personRepository.findAll()).thenReturn(persons);

        // when
        ResultActions result = mockMvc
                .perform(
                        get("/restaurant/persons")
                            ).andDo(print());
        //then
        result
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.*").isArray())
                        .andExpect(jsonPath("$.*", hasSize(2)))
                        .andReturn();

    }

}
