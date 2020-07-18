package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;


public class AdvertisementManager {
    
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    private List<List<Advertisement>> approachLists = new ArrayList<>();
    private int maxDurationList = 0;


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                advertisements.add(advertisement);
            }
        }

        if (advertisements.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        makeAllSets(advertisements);

        if (approachLists.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Collections.sort(approachLists, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> list1, List<Advertisement> list2) {

                int comparator1 = (int)(getTotalAmount(list2) - getTotalAmount(list1));
                if (comparator1 != 0) return comparator1;

                int comparator2 = getDurationList(list2) - getDurationList(list1);
                if (comparator2 != 0) return comparator2;

                int comparator3 = list1.size() - list2.size();
                return comparator3;
            }
        });

        List<Advertisement> listForPlaying = approachLists.get(0);

        Collections.sort(listForPlaying, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement ad1, Advertisement ad2) {
                int comparator1 = (int)(ad2.getAmountPerOneDisplaying() - ad1.getAmountPerOneDisplaying());
                if (comparator1 != 0) return comparator1;

                int comparator2 = ad1.getAmountPerMSecond() - ad2.getAmountPerMSecond();
                return comparator2;
            }
        });

        EventDataRow event = new VideoSelectedEventDataRow(listForPlaying, getTotalAmount(listForPlaying), getDurationList(listForPlaying));
        StatisticManager.getInstance().register(event);

        for (Advertisement advertisement : listForPlaying) {
            System.out.println(advertisement);
            advertisement.revalidate();
        }

    }


    private void makeAllSets(List<Advertisement> list) {
        int durationList = getDurationList(list);
        if (durationList > 0 && durationList <= timeSeconds) {
            if (durationList >= maxDurationList) {
                approachLists.add(list);
                maxDurationList = durationList;
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Advertisement> newList = new ArrayList<>(list);
            newList.remove(i);
            makeAllSets(newList);
        }
    }

    private int getDurationList(List<Advertisement> list) {
        int totalDuration = 0;
        for (Advertisement advertisement : list) {
            totalDuration += advertisement.getDuration();
        }
        return totalDuration;
    }

    private long getTotalAmount(List<Advertisement> list) {
        int totalAmount = 0;
        for (Advertisement advertisement : list) {
            totalAmount += advertisement.getAmountPerOneDisplaying();
        }
        return totalAmount;
    }


}
