package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {

    private final static StatisticManager statisticManager = new StatisticManager();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        return statisticManager;
    }

    public void register(EventDataRow data) {

    }

}
