package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge{
    static int COUNT = 10;

    @Override
    public int getCarsCount() {
        return COUNT;
    }
}
