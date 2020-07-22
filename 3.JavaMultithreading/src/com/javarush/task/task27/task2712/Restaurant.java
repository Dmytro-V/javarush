package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
//        Tablet tablet1 = new Tablet(1);
//        Tablet tablet2 = new Tablet(2);
//
//        Cook cook1 = new Cook("Ivanov");
//        Cook cook2 = new Cook("Petrov");
//
//        Waiter waiter1 = new Waiter();
//
//        tablet1.addObserver(cook1);
//        cook1.addObserver(waiter1);
//
//        tablet2.addObserver(cook2);
//        cook2.addObserver(waiter1);

        DirectorTablet directorTablet = new DirectorTablet();
//        StatisticManager.getInstance().input();

//
//        tablet1.createOrder();
//        tablet2.createOrder();
//        tablet1.createOrder();
//        tablet2.createOrder();

        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();

    }
}
