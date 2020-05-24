package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int hundred = number / 100;
        int decades = (number - hundred * 100) / 10;
        int units = (number - hundred * 100 - decades * 10);
        int i = hundred + decades + units;
        return i;
    }
}