package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){ return personRepository.save(person); }

    public void delete(Person person) { personRepository.delete(person); }

    public void update( Person person) {
        save(person);
    }

    public Person findByIdOrNull(Integer id) {      // findById
        return personRepository.findById(id).orElse(null);
//        Explanation: //before using optional - check if exists
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

    // TODO
//    public Person findByEmail(String email){
//        List<Person> personsList = findAll();
//        System.out.println(personsList.get(0).getEmail().toString());
//        return null;
//    }

}
