package com.haerul.foodsapp.view.home;

import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
