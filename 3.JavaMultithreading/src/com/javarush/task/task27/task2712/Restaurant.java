package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        tablet1.createOrder();
        tablet1.createOrder();
        tablet1.createOrder();
        tablet1.createOrder();

        Cook cook = new Cook("Amigo");
        tablet1.addObserver(cook);
    }
}
