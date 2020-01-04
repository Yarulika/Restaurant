package com.sda.restaurant.dao;

import com.sda.restaurant.model.OrderMeals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMealsRepository extends JpaRepository<OrderMeals, Integer> {
}
