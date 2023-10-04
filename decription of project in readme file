
# Iot Restro 

### Aims to transform traditional dining experiences into seamless, tech-savvy encounters. By incorporating automated devices and robust computer software, we've created a system that not only streamlines restaurant operations but also enhances customer satisfaction.

**Key IoT Features:**

1. **Light and Fan Control**: Say goodbye to uncomfortable drafts and dining in harsh lighting. Our system empowers diners to effortlessly adjust lighting and fan settings according to their preferences, ensuring a comfortable and inviting atmosphere.

2. **Effortless Ordering**: Simplify the food ordering process with a few taps on your device. Orders are seamlessly transmitted to the kitchen, enhancing efficiency and accuracy.

3. **RESTful API for Food Management**: Behind the scenes, we utilize a powerful RESTful API to manage food data efficiently. This means an extensive menu with detailed descriptions, nutritional information, and real-time availability status, ensuring you make informed choices.

4. **Interactive Recipe Experience**: Explore the culinary world with a click. When you order a dish, you can instantly access a YouTube video showcasing its preparation. Delve into the chef's technique, ingredients, and inspiration. For the curious foodie, we provide links to online recipes for further exploration.

 # Screenshorts
<p>
   <img align="center" width="250" height="450" src="https://imgur.com/Ee5Qlkd.jpg"> ||
<img align="center" width="250" height="450" src="https://imgur.com/rOX7Lto.jpg"> ||
<img align="center" width="250" height="450" src="https://imgur.com/YzgrJvp.jpg"> ||
  <br></br>
<img align="center" width="250" height="450" src="https://imgur.com/WqbEWrf.jpg"> ||
<img align="center" width="250" height="450" src="https://imgur.com/uw9cwOY.jpg"> ||
<img align="center" width="250" height="450" src="https://imgur.com/7fKz1an.jpg"> ||

</p>


   

- ### Application is designed to make dining out a hassle-free and enjoyable experience. With wireless connectivity and user-friendly interfaces, we've simplified the entire process. Whether it's adjusting your dining environment, placing orders, or discovering the secrets behind your favorite dishes, we put the power in your hands. Welcome to a dining experience where technology meets simplicity and where your comfort and satisfaction are our top priorities.



## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  run in android studio
```

Install dependencies

```bash
  Automatic dependencies on the bases of SDK version 
```


## Installation


```bash
  minSdk 23
        targetSdk 32
        versionCode 1
        versionName "1.0"

        and  set  :  gradle.properties
        android.enableJetifier=true
android.useAndroidX=true
org.gradle.jvmargs=-Xmx1536m
```
    

# Project API 

---

## The Meal DB API Reference

## Overview

"The Meal DB" is a comprehensive food and meal database that provides extensive information about meals, recipes, ingredients, and more. This API allows developers to access and retrieve data related to meals, ingredients, and categories.

## Base URL

The base URL for "The Meal DB" API is [https://www.themealdb.com/api/json/v1/1/](https://www.themealdb.com/api/json/v1/1/).

## Endpoints

### 1. Get Random Meal

- **Endpoint**: `/random.php`
- **Description**: Retrieve a random meal along with its details.
- **Example Request**:
  ```http
  GET https://www.themealdb.com/api/json/v1/1/random.php
  ```
- **Example Response**:
  ```json
  {
    "meals": [
      {
        "idMeal": "52768",
        "strMeal": "Spaghetti Carbonara",
        "strCategory": "Pasta",
        "strArea": "Italian",
        "strInstructions": "..."
        // Other meal details
      }
    ]
  }
  ```

### 2. Search Meals by Name

- **Endpoint**: `/search.php`
- **Description**: Search for meals by their name.
- **Parameters**:
  - `s` (required): The name or keyword to search for.
- **Example Request**:
  ```http
  GET https://www.themealdb.com/api/json/v1/1/search.php?s=chicken
  ```
- **Example Response**:
  ```json
  {
    "meals": [
      {
        "idMeal": "52772",
        "strMeal": "Chicken Alfredo Primavera",
        "strCategory": "Chicken",
        "strArea": "American",
        "strInstructions": "..."
        // Other meal details
      },
      {
        "idMeal": "52773",
        "strMeal": "Chicken Basquaise",
        "strCategory": "Chicken",
        "strArea": "French",
        "strInstructions": "..."
        // Other meal details
      }
      // More meals...
    ]
  }
  ```

### 3. Lookup Meal by ID

- **Endpoint**: `/lookup.php`
- **Description**: Retrieve a meal by its unique ID.
- **Parameters**:
  - `i` (required): The ID of the meal to retrieve.
- **Example Request**:
  ```http
  GET https://www.themealdb.com/api/json/v1/1/lookup.php?i=52768
  ```
- **Example Response**:
  ```json
  {
    "meals": [
      {
        "idMeal": "52768",
        "strMeal": "Spaghetti Carbonara",
        "strCategory": "Pasta",
        "strArea": "Italian",
        "strInstructions": "..."
        // Other meal details
      }
    ]
  }
  ```

### 4. List Meal Categories

- **Endpoint**: `/list.php`
- **Description**: Retrieve a list of meal categories.
- **Example Request**:
  ```http
  GET https://www.themealdb.com/api/json/v1/1/list.php?c=list
  ```
- **Example Response**:
  ```json
  {
    "meals": [
      {
        "strCategory": "Beef"
      },
      {
        "strCategory": "Chicken"
      },
      {
        "strCategory": "Dessert"
      }
      // More categories...
    ]
  }
  ```

## Rate Limit

"The Meal DB" API does not specify a rate limit in the public documentation. However, it's essential to make API requests responsibly to avoid overloading the server with too many requests in a short time.

Please note that this API reference provides a simplified overview of "The Meal DB" API's capabilities. For more endpoints and details, refer to the official documentation on [The Meal DB website](https://www.themealdb.com/api.php).

---

## Installation


```bash
  minSdk 23
        targetSdk 32
        versionCode 1
        versionName "1.0"
```
    
