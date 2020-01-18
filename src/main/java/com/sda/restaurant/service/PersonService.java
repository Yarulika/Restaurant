package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.dao.RoleRepository;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Person save(Person person){ return personRepository.save(person); }

    public Person saveWithRole(Person person, String role){
        //TODO saveWithRole
//        Person p = personRepository.save(person);
//        Role r = new Role();
//        r.
//        p.setRoles(new HashSet<role>);

        return personRepository.save(person);
    }

    public void delete(Person person) { personRepository.delete(person); }

    public Person update( Person person) {
        return personRepository.save(person);
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

    public boolean ifPersonExistsByEmail(String email){
        Optional<Person> personsByEmail = findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst();
        return personsByEmail.isPresent();
    }

    public Optional<Person> findPersonByEmail(String email){
        return findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst();
    }

    public List<Person> findPersonsByRoles(String role){
        return personRepository.findByRolesRoleTitle(role);
    }

}
