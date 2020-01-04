package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "meals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meal_id")
    private Integer mealId;
    @Column(name = "meal_title")
    private String mealTitle;
    @Column
    private Integer price;

    //OrderMeals
    @OneToMany(mappedBy = "meal")
    private List<OrderMeals> orderMeals;
}
