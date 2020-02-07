package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "meals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meal_id")
    private Integer mealId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "meal_title")
    private String mealTitle;
    @Basic(optional = false)
    @NotNull
    @Column
    private Integer price;

//    @OneToMany(mappedBy = "meal")
//    private List<OrderMeals> orderMeals;
}
