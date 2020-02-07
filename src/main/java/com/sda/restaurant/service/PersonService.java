package com.sda.restaurant.service;

import com.sda.restaurant.dao.PersonRepository;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.exception.PersonAlreadyExists;
import com.sda.restaurant.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person addNew(@Valid @NotEmpty Person person) {
        if (person.getPersonId() != null) {
            if (findById(person.getPersonId()).isPresent()) {
                throw new PersonAlreadyExists("Person with id: " + person.getPersonId() + " already exists.");
            }
        }
        String encode = passwordEncoder.encode(person.getPassword());
        person.setPassword(encode);
        return personRepository.save(person);
    }

    public Person update(@Valid @NotEmpty Person person) {
        if (findById(person.getPersonId()).isPresent()) {
            String encode = passwordEncoder.encode(person.getPassword());
            person.setPassword(encode);
            return personRepository.save(person);
        } else {
            throw new PersonNotFoundException(("Person with id: " + person.getPersonId() + " not found."));
        }
    }

    public void deleteById(@Valid @NotNull int personId) {
        Optional<Person> person = findById(personId);
        if (person.isEmpty()) {
            throw new PersonNotFoundException("Person with id: " + personId + " not found.");
        } else {
            personRepository.delete(person.get());
        }
    }

    public Optional<Person> findById(@NotNull Integer id) {
        return personRepository.findById(id);
    }

    public Optional<Person> findByEmail(@NotBlank String email) {
        return findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst();
    }

    public boolean ifPersonExistsByEmail(@NotBlank String email) {
        Optional<Person> personsByEmail = findAll().stream().filter(e -> e.getEmail().equals(email)).findFirst();
        return personsByEmail.isPresent();
    }

    public List<Person> findAll() {
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    public List<Person> findPersonsByRoles(@NotBlank String role) {
        return personRepository.findByRolesRoleTitle(role);
    }

    public List<Person> getTopTenBuyers() {
        return personRepository.getTenTopBuyers();
    }
}
