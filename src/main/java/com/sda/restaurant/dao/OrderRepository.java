package com.sda.restaurant.dao;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> getOrdersByDateBetween(long dayStartSec, long dayEndSec);

    List<Order> getOrdersByPerson(Person person);
}
