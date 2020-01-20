package com.sda.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Column(name = "order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    //Person: many orders may belong to one person
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column // = unix seconds, UTC time zone
    private Long date;
    @Column
    private int cost;

    //order_meals
    @OneToMany(mappedBy = "order")
    private List<OrderMeals> orderMeals;

}
