package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person addNew(Person person){ return personRepository.save(person); }

    public void delete(Person person) { personRepository.delete(person); }

    public Person update( Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    public Optional<Person> findByEmail(String email){
        return findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst();
    }

    public List<Person> findAll(){ return personRepository.findAll(); }

    public boolean ifPersonExistsByEmail(String email){
        Optional<Person> personsByEmail = findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst();
        return personsByEmail.isPresent();
    }

    public List<Person> findPersonsByRoles(String role){
        return personRepository.findByRolesRoleTitle(role);
    }

    public List<Person> getTopTenBuyers(){
        return personRepository.getTenTopBuyers();
    }
}
