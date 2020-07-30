package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String text = args[0].toUpperCase();

            for (int i = 2; i <= 36; i++) {

                try {
                    BigInteger result = new BigInteger(text, i);
                    System.out.println(i);
                    return;

                } catch (Exception e) {
                }
            }
        } catch (Exception e) {

        }
        System.out.println("incorrect");
    }
}