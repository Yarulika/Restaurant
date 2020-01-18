package com.sda.restaurant.dao;

import com.sda.restaurant.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {     //JpaRepository<Person, Integer>
//    1) query by names: findByRoles || findByRolesRoleTitle
    List<Person> findByRolesRoleTitle(String role);

//    2) native sql query
//    @Query(value="select * from .. like in db", nativeQuery = true)
//    List<Person> getAll();

}
