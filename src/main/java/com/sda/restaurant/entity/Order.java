package com.sda.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;

    //Person: many orders may belong to one person
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Basic(optional = false)
    @NotNull
    @Column // = unix seconds, UTC time zone
    private Long date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 1000)
    @Column
    private int cost;

    //order_meals
    @OneToMany(mappedBy = "order")
    private List<OrderMeals> orderMeals;

}
