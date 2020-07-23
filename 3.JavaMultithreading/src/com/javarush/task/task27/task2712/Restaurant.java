package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100; //milliseconds


    public static void main(String[] args) {


        List<Tablet> tablets = new ArrayList<>();


        Cook cook1 = new Cook("Ivanov");
        Cook cook2 = new Cook("Petrov");

        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.addObserver(cook1);
            tablet.addObserver(cook2);
        }

        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(cook1);
        statisticManager.register(cook2);

        Waiter waiter1 = new Waiter();


        cook1.addObserver(waiter1);
        cook2.addObserver(waiter1);

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);

        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();

/*

        DirectorTablet directorTablet = new DirectorTablet();

        System.out.println("***********************");
        directorTablet.printActiveVideoSet();
        System.out.println("--------------------");
        directorTablet.printArchivedVideoSet();
        System.out.println("--------------------");
        directorTablet.printAdvertisementProfit();
        System.out.println("--------------------");
        directorTablet.printCookWorkloading();*/

    }
}
