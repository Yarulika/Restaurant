package com.sda.restaurant.dao;

import com.sda.restaurant.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personRepository
//@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {     //JpaRepository<Person, Integer>

}
