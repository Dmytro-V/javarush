package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {

/*
    optimalVideoSet - список видео-роликов, отобранных для показа
    amount - сумма денег в копейках
    totalDuration - общая продолжительность показа отобранных рекламных роликов
*/

    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;
    private final EventType TYPE = EventType.SELECTED_VIDEOS;


    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public long getAmount() {
        return amount;
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
