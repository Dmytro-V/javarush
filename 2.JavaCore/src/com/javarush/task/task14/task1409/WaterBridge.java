package com.javarush.task.task14.task1409;

public class WaterBridge implements Bridge{
    static int COUNT = 5;

    @Override
    public int getCarsCount() {
        return COUNT;
    }
}
