package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private OrderService orderService;

    // $ curl -v http://localhost:8080/persons
    @GetMapping
    public @ResponseBody
    Iterable<Person> getAllPersons() {
        return personService.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        if (person.getPersonId() != null) {
            if (personService.findById(person.getPersonId()).isPresent()) {
                return ResponseEntity.badRequest().build();  //TODO ("ID s already occupied")
            }
        }
        if (personService.findByEmail(person.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();  //TODO ("email is already occupied")
        } else
            return ResponseEntity.ok(personService.addNew(person));
    }

    @PutMapping //path = "/{id TODO Validate: person.getPersonId() != null
    public ResponseEntity<Person> updateAllPersonDetails(@RequestBody Person person) {
        if (personService.findById(person.getPersonId()).isEmpty()) {
            return ResponseEntity.ok(personService.addNew(person));
        }
        else
            return ResponseEntity.badRequest().build();
    }

    @PatchMapping //update certain user field
    public Person updateSomePersonDetails(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping //TODO Validate: person.getPersonId() != null
    public void deletePerson(@RequestBody Person person) {
//        if (personService.findById(person.getPersonId()).isEmpty()) {
//            return;
//        }
        // ????????????????????? what is it better return ?

        personService.delete(person);
    }

    // $ curl -v -X GET "http://localhost:8080/persons/aaa@a.com"
    @GetMapping(path = "/{email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email) {
        Optional<Person> person = personService.findByEmail(email);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/{id}/orders")
    public Iterable<Order> getPersonsOrders(@PathVariable int id) {
        return orderService.getOrdersForPerson(id);
    }

    @GetMapping(path = "/topten")
    public @ResponseBody
    Iterable<Person> getTopTenBuyers() {
        return personService.getTopTenBuyers(); //TODO
    }
}
