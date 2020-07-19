package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow {

/*
    tabletName - имя планшета
    cookName - имя повара
    cookingTimeSeconds - время приготовления заказа в секундах
    cookingDishs - список блюд для приготовления
*/


    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;
    private Date currentDate;
    private final EventType TYPE = EventType.COOKED_ORDER;


    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();

    }

    @Override
    public EventType getType() {
        return TYPE;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }
}
