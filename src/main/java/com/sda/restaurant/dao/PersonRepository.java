package com.sda.restaurant.dao;

import com.sda.restaurant.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personRepository
//@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {     //JpaRepository<Person, Integer>

//    List<Person> findByName(String firstName);
//    List<Person> findAll();
}
