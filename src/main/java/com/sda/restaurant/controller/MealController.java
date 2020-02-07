package com.sda.restaurant.controller;

import com.sda.restaurant.entity.Meal;
import com.sda.restaurant.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MealController {
    @Autowired
    MealService mealService;

    @GetMapping(path = "/restaurant/meals")
    public @ResponseBody Iterable<Meal> getAllMeal(){
        return mealService.findAll();
    }

    @PostMapping(path = "/restaurant/meals")
    public Meal addMeal(@Valid @RequestBody Meal meal){
        return mealService.save(meal);
    }

}
