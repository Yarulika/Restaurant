//package com.sda.restaurant.controller;
//
//import java.nio.charset.Charset;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//
//import com.sda.restaurant.dao.PersonRepository;
//import com.sda.restaurant.entity.Person;
//import com.sda.restaurant.service.OrderService;
//import com.sda.restaurant.service.PersonService;
//import org.hamcrest.core.Is;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.ContentResultMatchers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
////@WebMvcTest(PersonController.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest
//@AutoConfigureMockMvc
//public class PersonControllerTest {
//
//    @MockBean
//    private PersonRepository personRepository;
//
//    @MockBean
//    PersonService personService;
//
//    @MockBean
//    OrderService orderService;
//
//    @Autowired
//    PersonController personController;
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void whenPostRequestToPersonsAndValidUser_thenCorrectResponse() throws Exception {
//
//        given(personService.addNew(null)).willReturn(new Person());
//
//        String person = "{\"firstName\": \"bob\", \"lastName\": \"cook\", \"email\" : \"bob@domain.com\", \"address\": \"espoo\", \"username\":\"autotest\", \"password\":\"autotest\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/persons").content(person).contentType(MediaType.APPLICATION_JSON))
//                //.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("AAA"));
////                .contentType(MediaType.APPLICATION_JSON_UTF8))
////
////                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
//    }
//
////            "firstName": "t",
////            "lastName": "test25",
////            "email": "lhhga.dh@hhfmg",
////            "address": "espoo",
////            "username": "user25",
////            "password": "pass25",
//
//}