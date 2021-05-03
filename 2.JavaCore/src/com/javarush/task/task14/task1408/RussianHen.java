package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{
    static int eggs = 30;

    @Override
    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    @Override
    public String getDescription() {
        return(super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + eggs + " яиц в месяц.");
    }
}
