package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.entity.Role;
import com.sda.restaurant.exception.PersonDetailsFoundException;
import com.sda.restaurant.exception.PersonNotFoundException;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private OrderService orderService;

    // $ curl -v http://localhost:8080/persons
    @GetMapping
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personService.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person, BindingResult bindingResult) throws PersonDetailsFoundException {
        if (bindingResult.hasErrors()){
            throw new PersonDetailsFoundException("Incorrect person details"); //TODO add IncorrectPersonDetailsException (and replace here)
        }
        else {
            // new person's details looks ok, proceed with further checks
            if (person.getPersonId() != null) {
                if (personService.findById(person.getPersonId()).isPresent()) {
                    throw new PersonDetailsFoundException("Person with id: " + person.getPersonId() + " already exists");
                }
            }
            if (personService.findByEmail(person.getEmail()).isPresent()) {
                throw new PersonDetailsFoundException("Person with email: " + person.getEmail() + " already exists");
            } else
                return ResponseEntity.ok(personService.addNew(person));
        }
    }

    @PutMapping
    public ResponseEntity<Person> updateAllPersonDetails(@RequestBody Person person) {
        if (personService.findById(person.getPersonId()).isPresent()) {
            return ResponseEntity.ok(personService.addNew(person));
        } else
//            ? if it is ok TODO ->
            return new ResponseEntity<>((Person) null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(path = "/{personId}")   //update certain user field(s): firstName, lastName, email, address, username, password
    public Person updateSomePersonDetails(@RequestBody Person newPerson, @PathVariable int personId) throws PersonNotFoundException {
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

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@RequestBody Person person) {
        if (personService.findById(person.getPersonId()).isEmpty()) {
            return new ResponseEntity<>("Person was not found, id: " + person.getPersonId(), HttpStatus.NOT_FOUND);
        } else {
            personService.delete(person);
            return new ResponseEntity<>("Person was deleted", HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable int id) {
        Optional<Person> person = personService.findById(id);
        if (person.isPresent()) {
            personService.delete(person.get());
            return new ResponseEntity<>("Person was deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person was not found, id: " + id, HttpStatus.NOT_FOUND);
        }
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

    @GetMapping(path = "/{personId}/orders")
    public Iterable<Order> getPersonsOrders(@PathVariable int personId) throws PersonNotFoundException {
        Optional<Person> person = personService.findById(personId);
        if (person.isPresent()) {
            return orderService.getOrdersForPerson(personId);
        } else {
            throw new PersonNotFoundException("Person with id: " + personId + " not found.");
        }
    }

    @GetMapping(path = "/toptenbuyers")
    public @ResponseBody Iterable<Person> getTopTenBuyers() {
        return personService.getTopTenBuyers();
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public void handlePersonNotFoundException(PersonNotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(PersonDetailsFoundException.class)
    public void handleEmailFoundException(PersonDetailsFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

}
