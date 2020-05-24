package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{
    static int eggs = 10;
   @Override
    public int getCountOfEggsPerMonth() {
        return eggs;
    }
    @Override
    public String getDescription() {
        return(super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + eggs + " яиц в месяц.");
    }
}
