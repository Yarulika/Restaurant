package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.entity.Role;
import com.sda.restaurant.exception.IncorrectPersonDetailsException;
import com.sda.restaurant.exception.PersonAlreadyExists;
import com.sda.restaurant.exception.PersonNotFoundException;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private OrderService orderService;

    // $ curl -v http://localhost:8080/restaurant/persons
    @GetMapping(path = "/restaurant/persons")
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping(path = "/restaurant/employees")
    public @ResponseBody Iterable<Person> getAllEmployees() {
        return personService.findPersonsByRoles("EMPLOYEE");
    }

    @GetMapping(path = "/restaurant/customers")
    public @ResponseBody Iterable<Person> getAllCustomers() {
        return personService.findPersonsByRoles("CUSTOMER");
    }

    // $ curl -v -X GET "http://localhost:8080/persons/aaa@a.com"
    @GetMapping(path = "/restaurant/persons/{email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email) {
        Optional<Person> person = personService.findByEmail(email);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/restaurant/persons/{personId}/orders")
    public Iterable<Order> getPersonsOrders(@PathVariable int personId) throws PersonNotFoundException {
        Optional<Person> person = personService.findById(personId);
        if (person.isPresent()) {
            return orderService.getOrdersForPerson(person.get());
        } else {
            throw new PersonNotFoundException("Person with id: " + personId + " not found.");
        }
    }

    @GetMapping(path = "/restaurant/persons/toptenbuyers")
    public @ResponseBody Iterable<Person> getTopTenBuyers() {
        return personService.getTopTenBuyers();
    }

    @PostMapping(path = "/restaurant/persons")
    public ResponseEntity<?> addPerson(@Valid @RequestBody Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            //TODO add IncorrectPersonDetailsException(& replace): but how to show what is exactly wrong
            //??? DONE BUT if it is ok like in IncorrectPersonDetailsException
            throw new IncorrectPersonDetailsException(bindingResult);
        }
        else {
            // new person's details looks ok, proceed with further checks
            if (personService.findByEmail(person.getEmail()).isPresent()) {
                throw new PersonAlreadyExists("Person with email: " + person.getEmail() + " already exists");
            } else
                return ResponseEntity.ok(personService.addNew(person));
        }
    }

    @PutMapping(path = "/restaurant/persons")
    public ResponseEntity<Person> updateAllPersonDetails(@RequestBody Person person) {
        try {
            personService.update(person);
            return new ResponseEntity<>((person), HttpStatus.OK);
        }
        catch (PersonNotFoundException ex){
            return new ResponseEntity<>((Person) null, HttpStatus.NOT_FOUND);
        }
    }

    //TODO: could use map and reflection or keep it like this [more advance]
    @PatchMapping(path = "/restaurant/persons/{personId}")   //update certain user field(s): firstName, lastName, email, address, username, password
    public Person updateSomePersonDetails(@RequestBody @NotEmpty Person newPerson, @NotNull @PathVariable int personId) {
        Optional<Person> person = personService.findById(personId);
        if (person.isEmpty()) {
            throw new PersonNotFoundException("Person with id: " + personId + " not found.");
        }
        Person updatingPerson = person.get();
        String fName = newPerson.getFirstName();
        if (fName != null ) updatingPerson.setFirstName(fName);

        String lName = newPerson.getLastName();
        if (lName != null ) updatingPerson.setLastName(lName);

        String email = newPerson.getEmail();
        if (email != null) updatingPerson.setEmail(email);

        String address = newPerson.getAddress();
        if (address != null) updatingPerson.setAddress(address);

        String username = newPerson.getUsername();
        if (username != null) updatingPerson.setUsername(username);

        String password = newPerson.getPassword();
        if (password != null) updatingPerson.setPassword(password);

        Set<Role> roles = newPerson.getRoles();
        if (roles != null) updatingPerson.setRoles(roles);

        return personService.update(updatingPerson);
    }

    @DeleteMapping(path = "/restaurant/persons/{personId}")
    public ResponseEntity<String> deletePersonById(@Valid @NotNull @PathVariable int personId) {
        try {
            personService.deleteById(personId);
            return new ResponseEntity<>("Person was deleted", HttpStatus.OK);
        }
        catch (PersonNotFoundException e)
        {
            return new ResponseEntity<>("Person was not found, id: " + personId, HttpStatus.NOT_FOUND);
        }
    }
}
