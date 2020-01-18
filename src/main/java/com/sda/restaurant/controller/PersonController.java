package com.sda.restaurant.controller;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    // $ curl -v http://localhost:8080/persons/all
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllPersons(){
        return personService.findAll();
    }

    // $ curl -v -X POST "http://localhost:8080/persons/add?fName=one&lName=two&email=aaa@a.com"
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    @PostMapping(path="/add")
    public @ResponseBody String addPerson(
                    @RequestParam String fName,
                    @RequestParam String lName,
                    @RequestParam String email,
                    @RequestParam String address,
                    @RequestParam String username,
                    @RequestParam String password) {
        // TODO: check if person exists (by email)
        // if (true) { return "exists"; }
        Person p = new Person();
        p.setFirstName(fName);
        p.setLastName(lName);
        p.setEmail(email);
        p.setAddress(address);
        p.setUsername(username);
        p.setPassword(password);
        personService.save(p);
        return "Saved";
    }

}
