package com.sda.restaurant.service;

import com.sda.restaurant.dao.MealRepository;
import com.sda.restaurant.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class MealService {

    @Autowired
    public MealRepository mealRepository;

    public Meal save(@Valid @NotEmpty Meal meal) {return mealRepository.save(meal); }

    public void delete(@Valid @NotEmpty Meal meal ) { mealRepository.delete(meal); }

    public void update(@Valid @NotEmpty Meal meal ) { save(meal); }

    public Meal findById(@NotNull Integer mealId) {
        return mealRepository.findById(mealId).orElse(null);
    }

    public List<Meal> findAll(){ return mealRepository.findAll(); }

}
