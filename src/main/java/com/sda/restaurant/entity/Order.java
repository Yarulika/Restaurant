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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Basic(optional = false)
    @NotNull
    @Column // = unix seconds, UTC time zone
    private Long date;
    @Basic(optional = false)
    @NotNull
    @Column
    private int cost;

//    @OneToMany(mappedBy = "order")
//    private List<OrderMeals> orderMeals;

}
