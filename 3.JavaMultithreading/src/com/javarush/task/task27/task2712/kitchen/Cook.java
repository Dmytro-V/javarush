package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {

        ConsoleHelper.writeMessage( "Start cooking - " + order +
                        ", cooking time " + ((Order)order).getTotalCookingTime() +
                        "min");
        setChanged();
        notifyObservers(order);

        EventDataRow event = new CookedOrderEventDataRow(order.getTablet().toString(),
                this.toString(),
                ((Order) order).getTotalCookingTime() * 60,
                ((Order) order).getDishes());
        StatisticManager.getInstance().register(event);
    }

}
