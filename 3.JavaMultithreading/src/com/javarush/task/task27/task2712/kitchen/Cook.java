package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;
    private LinkedBlockingQueue<Order> queueCookedOrder;


    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void setQueueCookedOrder(LinkedBlockingQueue<Order> queueCookedOrder) {
        this.queueCookedOrder = queueCookedOrder;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) throws InterruptedException {

        this.busy = true;

        ConsoleHelper.writeMessage( "Start cooking - " + order + " by " + this.name +
                        ", cooking time " + ((Order)order).getTotalCookingTime() +
                        "min");

        int timeCooking = order.getTotalCookingTime() * 10; // min * 10
        Thread.sleep(timeCooking);

        queueCookedOrder.add(order);

        EventDataRow event = new CookedOrderEventDataRow(order.getTablet().toString(),
                this.toString(),
                ((Order) order).getTotalCookingTime() * 60,
                ((Order) order).getDishes());
        StatisticManager.getInstance().register(event);
        this.busy = false;
    }

    @Override
    public void run() {
        Order order = null;
        try {
            while (true) {
                if (!this.isBusy()) {
                    order = queue.poll();
                    if (order != null) {
                        this.startCookingOrder(order);
                    }
                }

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {

        }
    }
}
