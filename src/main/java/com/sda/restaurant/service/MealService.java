package com.sda.restaurant.service;

import com.sda.restaurant.dao.MealRepository;
import com.sda.restaurant.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    public MealRepository mealRepository;

    public Meal save(Meal meal) {return mealRepository.save(meal); }

    public void delete(Meal meal ) { mealRepository.delete(meal); }

    public void update(Meal meal ) { save(meal); }

    public Meal findById(Integer mealId) {
        return mealRepository.findById(mealId).orElse(null);
    }

    public List<Meal> findAll(){ return mealRepository.findAll(); }

}
