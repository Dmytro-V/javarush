package com.javarush.task.task27.task2712.ad;


import java.util.ArrayList;


public class AdvertisementManager {
    
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        ArrayList<Object> advertisements = new ArrayList<>(storage.list());
        if (advertisements.isEmpty()) {
            throw new NoVideoAvailableException();
        }


    }

}
