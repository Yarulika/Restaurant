package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // $ curl -v http://localhost:8080/orders
    @GetMapping
    public @ResponseBody Iterable<Order> getAllOrders(){
        return orderService.findAll();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping(path = "/today")
    public @ResponseBody Iterable<Order> getTodaysOrders(){
        return orderService.findForToday();
    }
}
