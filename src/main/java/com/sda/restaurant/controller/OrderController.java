package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/restaurant/orders")
    public @ResponseBody Iterable<Order> getAllOrders(){
        return orderService.findAll();
    }

    @GetMapping(path = "/restaurant/orders/today")
    public @ResponseBody Iterable<Order> getTodaysOrders(){
        return orderService.findForToday();
    }

    @PostMapping(path = "/restaurant/orders")
    public Order addOrder(@Valid @RequestBody Order order){
        return orderService.save(order);
    }
}
