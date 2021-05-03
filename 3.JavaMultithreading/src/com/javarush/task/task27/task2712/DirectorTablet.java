package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {

        StatisticManager statisticManager = StatisticManager.getInstance();

        Map<LocalDate, Long> profit = statisticManager.getAdvertisementProfitPerDays();
        ArrayList<LocalDate> dates = new ArrayList<>(profit.keySet());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0;
        for (LocalDate date : dates) {
            total += profit.get(date);
            double amount = profit.get(date) / 100.0;
            ConsoleHelper.writeMessage(df.format(date) + " - " + String.format("%.2f", amount));
        }
        double totalAmount = total / 100.0;
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalAmount));

    }

    public void printCookWorkloading() {

        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<LocalDate, Map<String, Integer>> timeCookPerDay = statisticManager.getTimeCookPerDay();
        ArrayList<LocalDate> dates = new ArrayList<>(timeCookPerDay.keySet());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);

        for (LocalDate date : dates) {
            ConsoleHelper.writeMessage(df.format(date));
            Map<String, Integer> mapOfCook = timeCookPerDay.get(date);
            for (String cookName : mapOfCook.keySet()) {
                int cookingTimeSecond = mapOfCook.get(cookName);
                BigDecimal cookingTimeMinut = BigDecimal.valueOf(cookingTimeSecond / 60.0).setScale(0, RoundingMode.UP);

                ConsoleHelper.writeMessage(cookName + " - " + cookingTimeMinut + " min");
            }
        }
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        Set<Advertisement> activeVideoSet = manager.getActiveVideoSet();
        for (Advertisement advertisement : activeVideoSet) {
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        Set<Advertisement> archivedVideoSet = manager.getArchivedVideoSet();
        for (Advertisement advertisement : archivedVideoSet) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }

}
