package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;       //count of play
    private int duration;  //seconds

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getAmountPerMSecond() {
        int amountPerSecond = (int)(1000 * getAmountPerOneDisplaying() / getDuration());
        return amountPerSecond;

    }

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    @Override
    public String toString() {
        return name + " is displaying... " + getAmountPerOneDisplaying() + ", " + getAmountPerMSecond();
    }
}
