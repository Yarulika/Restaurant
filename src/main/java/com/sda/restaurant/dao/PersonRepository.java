package com.sda.restaurant.dao;

import com.sda.restaurant.entity.Person;
import com.sda.restaurant.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByRolesRoleTitle(Role.RoleTitle role);

    @Query(value=
            "SELECT persons.* FROM persons " +
            "JOIN (SELECT orders.person_id AS id, SUM(orders.cost) AS cost_sum FROM orders "+
            "GROUP BY orders.person_id "+
            ") AS sum_tb ON persons.person_id = sum_tb.id "+
            "ORDER BY cost_sum DESC "+
            "LIMIT 10; "
        , nativeQuery = true)
    List<Person> getTenTopBuyers();

    Person findByUsername(String username);
    Person findByEmail(String email);
}
