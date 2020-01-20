package com.sda.restaurant.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Basic(optional = false)
    private Integer orderMealsId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    //Meal: many OrderMeals(order details) may belong to one meal
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    private Integer quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min=0, max = 10000)
    @Column(name = "unit_price")
    private Integer unitPrice;
}
