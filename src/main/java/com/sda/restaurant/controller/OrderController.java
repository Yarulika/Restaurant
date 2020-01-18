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
    @Autowired
    private PersonService personService;

    // $ curl -v http://localhost:8080/orders
    @GetMapping
    public @ResponseBody
    Iterable<Order> getAllOrders(){
        return orderService.findAll();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return orderService.save(order);
    }


//    @PostMapping(path = "/add")
//    public @ResponseBody String addOrder(
//            @RequestParam Integer personId,
//            @RequestParam Date date,
//            @RequestParam Integer cost) {
//
//        Person p = personService.findByIdOrNull(personId);
//        Order o = new Order();
//        o.setPerson(p);
//        o.setDate(date);
//        o.setCost(cost);
//        orderService.save(o);
//        return "saved";
//    }
}
