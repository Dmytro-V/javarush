package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private String name;
    private boolean busy;

    public boolean isBusy() {
        return busy;
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

        ConsoleHelper.writeMessage( "Start cooking - " + order +
                        ", cooking time " + ((Order)order).getTotalCookingTime() +
                        "min");

        int timeCooking = order.getTotalCookingTime() * 10; // min * 10
        Thread.sleep(timeCooking);

        setChanged();
        notifyObservers(order);

        EventDataRow event = new CookedOrderEventDataRow(order.getTablet().toString(),
                this.toString(),
                ((Order) order).getTotalCookingTime() * 60,
                ((Order) order).getDishes());
        StatisticManager.getInstance().register(event);
        this.busy = false;
    }

}
