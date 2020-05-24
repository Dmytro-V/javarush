package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    static int eggs = 20;

    @Override
    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    @Override
    public String getDescription() {
        return(super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + eggs + " яиц в месяц.");
    }
}
