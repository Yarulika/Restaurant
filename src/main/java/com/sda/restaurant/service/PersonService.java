package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){ return personRepository.save(person); }

    public void delete(Person person) { personRepository.delete(person); }

    public void update( Person person) {
        save(person);
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElse(null);
//        Explanation:
//        Optional<Person> optionalPerson = personRepository.findById(id);
//        if (optionalPerson.isPresent()) {
//            optionalPerson.get();
//        }else{
//            return null;
//        }
//        return optionalPerson.orElse(null);
//        return personRepository.findById(id);
    }

    public List<Person> findAll(){ return personRepository.findAll(); }

//  implement in service methods:
//    create
//    delete
//    update
//    getById
//    list all
}
