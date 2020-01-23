package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Person;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @Autowired
    private PersonService personService;

    // $ curl -v http://localhost:8080/employees
    @GetMapping
    public @ResponseBody
    Iterable<Person> getAllEmployees(){
        return personService.findPersonsByRoles("employee");
    }
}
