package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import com.sda.restaurant.service.OrderService;
import com.sda.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PersonService personService;

    // $ curl -v http://localhost:8080/orders/all
    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Order> getAllOrders(){
        return orderService.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addOrder(
            @RequestParam Integer personId,
            @RequestParam Date date,
            @RequestParam Integer cost) {

        Person p = personService.findByIdOrNull(personId);
        Order o = new Order();
        o.setPerson(p);
        o.setDate(date);
        o.setCost(cost);
        orderService.save(o);
        return "saved";
    }
}
