package com.iot.iotrestaurantapp.view.home;

import com.iot.iotrestaurantapp.model.Categories;
import com.iot.iotrestaurantapp.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
