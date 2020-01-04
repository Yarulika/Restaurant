package com.sda.restaurant.dao;

import com.sda.restaurant.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
