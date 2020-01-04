package com.sda.restaurant.controller;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called personRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PersonRepository personRepository;

    // $ curl -v -X POST "http://localhost:8080/demo/add?email=aa&name=aaa"
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPerson(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person p = new Person();
        p.setFirstName(name);
        p.setLastName("Yarulika");
        p.setEmail(email);
        p.setAddress("Espoo");
        p.setUsername("marit");
        p.setPassword("root");
        personRepository.save(p);
        return "Saved";
    }

    // $ curl -v http://localhost:8080/demo/all
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllPersons() {
        // This returns a JSON or XML with the persons
        return personRepository.findAll();
    }
}
