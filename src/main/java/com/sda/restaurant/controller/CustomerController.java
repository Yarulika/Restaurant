package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Person;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Autowired
    private PersonService personService;

    // $ curl -v http://localhost:8080/customers
    @GetMapping
    public @ResponseBody Iterable<Person> getAllCustomers(){
        return personService.findPersonsByRoles("customer");
    }
}
