package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100; //milliseconds
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();



    public static void main(String[] args) {


        List<Tablet> tablets = new ArrayList<>();

        Cook cook1 = new Cook("Ivanov");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Petrov");
        cook2.setQueue(orderQueue);


        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.setQueue(orderQueue);
        }

        Waiter waiter1 = new Waiter();

        cook1.addObserver(waiter1);
        cook2.addObserver(waiter1);

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);

        Thread threadCook1 = new Thread(cook1);
        Thread threadCook2 = new Thread(cook2);
        Thread thread = new Thread(randomOrderGeneratorTask);

        threadCook1.start();
        threadCook2.start();

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
