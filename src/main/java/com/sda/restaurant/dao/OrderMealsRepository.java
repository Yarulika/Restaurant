package com.sda.restaurant.dao;

import com.sda.restaurant.entity.OrderMeals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMealsRepository extends JpaRepository<OrderMeals, Integer> {
}
