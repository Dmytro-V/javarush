package com.javarush.task.task27.task2712.ad;


import java.util.*;

public class StatisticAdvertisementManager {

    private static final StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage =  AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return statisticAdvertisementManager;
    }

    public Set<Advertisement> getActiveVideoSet() {
        Set<Advertisement> activeVideoSet = new TreeSet<>((ad1, ad2) -> ad1.getName().compareToIgnoreCase(ad2.getName()));
        List<Advertisement> list = advertisementStorage.list();
        for (Advertisement advertisement : list) {
            if (advertisement.getHits() > 0) {
                activeVideoSet.add(advertisement);
            }
        }

        return activeVideoSet;
    }

    public Set<Advertisement> getArchivedVideoSet() {
        Set<Advertisement> archivedVideoSet = new TreeSet<>((ad1, ad2) -> ad1.getName().compareToIgnoreCase(ad2.getName()));
        List<Advertisement> list = advertisementStorage.list();
        for (Advertisement advertisement : list) {
            if (advertisement.getHits() == 0) {
                archivedVideoSet.add(advertisement);
            }
        }
        return archivedVideoSet;

    }
}
