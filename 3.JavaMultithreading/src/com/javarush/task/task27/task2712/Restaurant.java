package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Cook cook = new Cook("Amigo");
        Waiter waiter = new Waiter();

        tablet1.addObserver(cook);
        cook.addObserver(waiter);

        DirectorTablet directorTablet = new DirectorTablet();

        tablet1.createOrder();
        tablet1.createOrder();
        tablet1.createOrder();
        tablet1.createOrder();

        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();

    }
}
