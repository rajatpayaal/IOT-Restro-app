# IoT Restro 🍽️

Our IoT-based restaurant application is designed to revolutionize the dining experience by merging the power of Internet of Things (IoT) with smart devices and seamless ordering systems. The app enhances customer convenience by offering automated device controls and a streamlined food ordering process, all from the comfort of your table. Whether you're adjusting the environment, placing an order, or exploring detailed recipes, this application allows diners to effortlessly interact with both the restaurant’s ambiance and its menu.
## Demo

### Demo APK

[Download APK](https://drive.google.com/file/d/1jyI5JuXql1VkLIgPSWT-HUXKi1gWDmW1/view?usp=drive_link)

### Demo Video

[Watch the Demo](https://youtu.be/IO75NGpGKMw?si=6unmfDdBrt1um_cg)

---

## Screenshots

<p>
   <img align="center" width="250" height="450" src="https://imgur.com/Ee5Qlkd.jpg"> ||
   <img align="center" width="250" height="450" src="https://imgur.com/rOX7Lto.jpg"> ||
   <img align="center" width="250" height="450" src="https://imgur.com/YzgrJvp.jpg"> ||
   <br></br>
   <img align="center" width="250" height="450" src="https://imgur.com/WqbEWrf.jpg"> ||
   <img align="center" width="250" height="450" src="https://imgur.com/uw9cwOY.jpg"> ||
   <img align="center" width="250" height="450" src="https://imgur.com/7fKz1an.jpg"> ||
</p>

---

## Key Features

1. **Light and Fan Control** 🌬️💡  
   Enjoy a comfortable dining experience with the ability to control the lighting and fan settings, ensuring an optimal atmosphere while dining.

2. **Effortless Ordering** 📝🍽️  
   Place orders seamlessly through the app, ensuring the kitchen receives real-time orders with full details for accuracy and speed.

3. **RESTful API for Food Management** 🍔  
   The back-end is powered by a RESTful API, ensuring efficient management of food data, including detailed descriptions, nutritional information, and availability.

4. **Interactive Recipe Experience** 🎥👨‍🍳  
   Learn about your dish's preparation with a YouTube video showing the recipe and a link to the detailed steps for food enthusiasts.

5. **Order Book & Detailed View** 📖  
   View your previous orders and access detailed recipes, including the ingredients and step-by-step preparation instructions.

6. **IoT Functionality - Fan On/Off** ⚡  
   Control the fan remotely to ensure your environment is always just right, enhancing comfort and convenience during your dining experience.

7. **Share Recipe to Self** 📲  
   Share your favorite recipes via the app to keep them for later or share them with friends and family.

---

## Technology Stack 🚀

This application is built using Java and C++ for IoT functionality, ensuring smooth interaction with devices and delivering a responsive and efficient user experience.

- **Java**: Used for building the Android application, enabling seamless communication between the app and the server for managing food data.
- **C++**: Powers the IoT functionality for controlling smart devices (light and fan control) in the restaurant environment.

---

## Run Locally

1. Clone the repository:
    ```bash
    git clone https://link-to-project
    ```

2. Navigate to the project directory and open it in Android Studio:
    ```bash
    cd project-directory
    ```

3. Install dependencies automatically based on the SDK version:
    ```bash
    // Android Studio will handle dependencies
    ```

4. Build and run the project in Android Studio.

---

## Installation Instructions 📦

1. Set the minimum SDK and target SDK in the `build.gradle` file:
    ```gradle
    minSdkVersion 23
    targetSdkVersion 32
    ```

2. Set version details:
    ```gradle
    versionCode 1
    versionName "1.0"
    ```

3. Add `gradle.properties` for configuration:
    ```properties
    android.enableJetifier=true
    android.useAndroidX=true
    org.gradle.jvmargs=-Xmx1536m
    ```

---

## API Reference - The Meal DB 🍔🍕

"The Meal DB" provides an extensive database of meals, recipes, and ingredients.

### Base URL

The base URL for accessing the API is:  
[https://www.themealdb.com/api/json/v1/1/](https://www.themealdb.com/api/json/v1/1/)

### Endpoints

1. **Get Random Meal**  
   Endpoint: `/random.php`  
   Retrieves a random meal with details.  
   Example Request:  
   ```http
   GET https://www.themealdb.com/api/json/v1/1/random.php

   
## 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## 👨‍💻 About the Developer

Developed and maintained by **Rajat Payaal**. I am passionate about building scalable and user-friendly applications. Connect with me on [GitHub](https://github.com/rajatpayaal) for more exciting projects and collaborations!
