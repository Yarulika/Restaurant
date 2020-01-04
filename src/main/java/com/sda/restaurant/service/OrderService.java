package com.sda.restaurant.service;

import com.sda.restaurant.dao.OrderRepository;
import com.sda.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order){ return orderRepository.save(order); }

    public void delete(Order order) { orderRepository.delete(order); }

    public void update(Order order) { save(order); }

    public Order findById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> findAll(){ return orderRepository.findAll(); }
}
