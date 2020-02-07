package com.sda.restaurant.service;

import com.sda.restaurant.dao.OrderRepository;
import com.sda.restaurant.entity.Order;
import com.sda.restaurant.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(@Valid @NotEmpty Order order){ return orderRepository.save(order); }

    public void delete(@Valid @NotEmpty Order order) { orderRepository.delete(order); }

    public void update(@Valid @NotEmpty Order order) { save(order); }

    public Order findById(@NotNull Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> findAll(){ return orderRepository.findAll(); }

    public Iterable<Order> findForToday() {
        long nowSec = Instant.now().getEpochSecond();
        long nowDays = nowSec/(60*60*24);
        long dayStartSec = nowDays * 60*60*24;
        long dayEndSec = ((nowDays+1) * 60*60*24) - 1;
        // today: from dayStartSec to dayEndSec
        return orderRepository.getOrdersByDateBetween(dayStartSec, dayEndSec);
    }

    public Iterable<Order> getOrdersForPerson(@NotNull Person person){
         return orderRepository.getOrdersByPerson(person);
    }

}
