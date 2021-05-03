package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    static int eggs = 25;

    @Override
    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    @Override
    public String getDescription() {
        return(super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + eggs + " яиц в месяц.");
    }
}
