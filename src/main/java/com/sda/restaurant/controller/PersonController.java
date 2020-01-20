package com.sda.restaurant.controller;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private OrderService orderService;

    // $ curl -v http://localhost:8080/persons
    @GetMapping // (path="/all")
    public @ResponseBody Iterable<Person> getAllPersons(){
        return personService.findAll();
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        //@RequestBody = json obj from request
        return personService.save(person);
    }

    @PutMapping
    public Person updateAllPersonDetails(@RequestBody Person person ){
        return personService.save(person);
    }

    @PatchMapping //update certain user field
    public Person updateSomePersonDetails(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping
    public void deletePerson(@RequestBody Person person){
        personService.delete(person);
    }

    // $ curl -v -X GET "http://localhost:8080/persons/aaa@a.com"
    @GetMapping(path = "/{email}")
    public Person getPersonByEmail(@PathVariable String email){
        Optional<Person> person = personService.findPersonByEmail(email);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }

    @GetMapping(path = "/{id}/orders")
    public Iterable<Order> getPersonsOrders(@PathVariable int id){
        return orderService.getOrdersForPerson(id);
    }

    @GetMapping(path = "/topten")
    public @ResponseBody Iterable<Person> getTopTenBuyers(){
        return personService.getTopTenBuyers(); //TODO
    }


    // $ curl -v -X POST "http://localhost:8080/persons/add?fName=one&lName=two&email=aaa@a.com"
    // @RequestParam means it is a parameter from the GET or POST request
//    @PostMapping(path="/add")
//    public String addPersonParamsWay(
//                    @RequestParam String fName,
//                    @RequestParam String lName,
//                    @RequestParam String email,
//                    @RequestParam String address,
//                    @RequestParam String username,
//                    @RequestParam String password) {
//        if (personService.ifPersonExistsByEmail(email)) {
//            return "exists";
//        }
//        else {
//            Person p = new Person();
//            p.setFirstName(fName);
//            p.setLastName(lName);
//            p.setEmail(email);
//            p.setAddress(address);
//            p.setUsername(username);
//            p.setPassword(password);
//            personService.save(p);
//            return "saved";
//        }
//    }
}
