package com.sda.restaurant.model;

import lombok.*;
import javax.persistence.*;

@Entity(name = "order_meals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderMeals {
    @Column(name = "order_meals_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderMealsId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    //Meal: many OrderMeals(order details) may belong to one meal
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    private Integer quantity;
    @Column(name = "unit_price")
    private Integer unitPrice;
}
