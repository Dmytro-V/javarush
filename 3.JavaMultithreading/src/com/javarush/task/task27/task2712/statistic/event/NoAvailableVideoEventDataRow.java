package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow {

    //totalDuration - время приготовления заказа в секундах
    private int totalDuration;
    private Date currentDate;
    private final EventType TYPE = EventType.NO_AVAILABLE_VIDEO;



    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
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
        return totalDuration;
    }
}
