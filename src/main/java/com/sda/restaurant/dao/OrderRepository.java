package com.sda.restaurant.dao;

import com.sda.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    //TODO: use query by name
    @Query(value = "SELECT * FROM orders WHERE orders.date BETWEEN ?1 AND ?2",
                nativeQuery = true)
    List<Order> getForToday(long dayStartSec, long dayEndSec);

    //TODO: use query by name
    @Query(value = "SELECT * FROM orders WHERE person_id = ?1",
                nativeQuery = true)
    List<Order> getForPerson(int id);

}
