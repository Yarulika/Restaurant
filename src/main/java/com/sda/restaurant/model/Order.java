package com.sda.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "orders")
public class Order {
    @Column(name = "order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    //Person: many orders may belong to one person
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column
    private Date date;
    @Column
    private int cost;
}
