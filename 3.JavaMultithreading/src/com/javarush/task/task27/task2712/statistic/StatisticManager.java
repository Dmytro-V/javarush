package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.time.LocalDate;
import java.util.*;

public class StatisticManager {

    private final static StatisticManager statisticManager = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        return statisticManager;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    public Map<LocalDate, Long> getAdvertisementProfitPerDays() {
        Map<LocalDate, Long> profitPerDays = new TreeMap<>(Comparator.reverseOrder());
        List<EventDataRow> events = statisticStorage.getListEvents(EventType.SELECTED_VIDEOS);

        for (EventDataRow event : events) {
            VideoSelectedEventDataRow videoSelectedEvent = (VideoSelectedEventDataRow) event;
            Date date = videoSelectedEvent.getDate();
            LocalDate dateEvent = new java.sql.Date(date.getTime()).toLocalDate();

            long amount = videoSelectedEvent.getAmount();

            profitPerDays.merge(dateEvent, amount, Long::sum);
        }
        return profitPerDays;
    }

    public Map<LocalDate, Map<String, Integer>> getTimeCookPerDay() {
        List<EventDataRow> events = statisticStorage.getListEvents(EventType.COOKED_ORDER);

        Map<LocalDate, Map<String, Integer>> resultMap = new TreeMap<>(Comparator.reverseOrder());

        for (EventDataRow event : events) {
            CookedOrderEventDataRow cookedEvent = (CookedOrderEventDataRow)event;
            String cookName = cookedEvent.getCookName();

            Date date = cookedEvent.getDate();
            LocalDate dateEvent = new java.sql.Date(date.getTime()).toLocalDate();

            int cookingTimeSecond = cookedEvent.getTime();

            if (!resultMap.containsKey(dateEvent)) {
                Map<String, Integer> mapOfCook = new TreeMap<>();
                mapOfCook.put(cookName, cookingTimeSecond);
                resultMap.put(dateEvent, mapOfCook);
            } else {
                Map<String, Integer> mapOfCook = resultMap.get(dateEvent);
                mapOfCook.merge(cookName, cookingTimeSecond, Integer::sum);
            }
        }
        return resultMap;
    }

/*    public void input(){
        statisticStorage.inputData();
    }*/

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            EventType type = data.getType();
            storage.get(type).add(data);
        }

/*
        public void inputData() {
            List<Dish> dishes = new ArrayList<>();
            dishes.add(Dish.Fish);
            dishes.add(Dish.Water);
            dishes.add(Dish.Soup);
            dishes.add(Dish.Fish);

            CookedOrderEventDataRow event1 = new CookedOrderEventDataRow("tabletOne","Ivanov",180,dishes);
            CookedOrderEventDataRow event6 = new CookedOrderEventDataRow("tabletOne","Ivanov",181,dishes);
            CookedOrderEventDataRow event2 = new CookedOrderEventDataRow("tabletOne","Petrov",180,dishes);
            CookedOrderEventDataRow event3 = new CookedOrderEventDataRow("tabletOne","Ivanov",180,dishes);
            CookedOrderEventDataRow event4 = new CookedOrderEventDataRow("tabletOne","Ivanov",180,dishes);
            CookedOrderEventDataRow event5 = new CookedOrderEventDataRow("tabletOne","Petrov",181,dishes);
            event1.setCurrentDate(new Date("12-Jul-2020"));
            event6.setCurrentDate(new Date("12-Jul-2020"));
            event2.setCurrentDate(new Date("12-Jul-2020"));
            event3.setCurrentDate(new Date("13-Jul-2020"));
            event4.setCurrentDate(new Date("14-Jul-2020"));
            event5.setCurrentDate(new Date("14-Jul-2020"));

            put(event1);
            put(event2);
            put(event3);
            put(event4);
            put(event5);
            put(event6);
        }
*/

        private List<EventDataRow> getListEvents(EventType eventType) {
            return storage.get(eventType);
        }
    }

}
