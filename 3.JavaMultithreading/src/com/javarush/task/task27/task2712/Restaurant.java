package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100; //milliseconds


    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Tablet tablet2 = new Tablet(2);
        Tablet tablet3 = new Tablet(3);
        Tablet tablet4 = new Tablet(4);

        Cook cook1 = new Cook("Ivanov");
        Cook cook2 = new Cook("Petrov");

        Waiter waiter1 = new Waiter();

        tablet1.addObserver(cook1);
        tablet2.addObserver(cook1);
        tablet3.addObserver(cook2);
        tablet4.addObserver(cook2);
        cook1.addObserver(waiter1);
        cook2.addObserver(waiter1);


        DirectorTablet directorTablet = new DirectorTablet();

//        StatisticManager.getInstance().input();


        tablet1.createTestOrder();
        tablet2.createTestOrder();
        tablet3.createTestOrder();
        tablet4.createTestOrder();

        System.out.println("***********************");

        directorTablet.printActiveVideoSet();
        System.out.println("--------------------");
        directorTablet.printArchivedVideoSet();
        System.out.println("--------------------");

        directorTablet.printAdvertisementProfit();
        System.out.println("--------------------");

        directorTablet.printCookWorkloading();

    }
}
