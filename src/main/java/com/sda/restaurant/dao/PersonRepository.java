package com.sda.restaurant.dao;

import com.sda.restaurant.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personRepository
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {     //JpaRepository<Person, Integer>

}
