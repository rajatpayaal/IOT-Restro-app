package com.iot.iotrestaurantapp.view.detail;

import com.iot.iotrestaurantapp.model.Meals;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meals.Meal meal);
    void onErrorLoading(String message);
}
