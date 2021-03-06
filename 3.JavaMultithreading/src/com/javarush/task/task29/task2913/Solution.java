package com.javarush.task.task29.task2913;

import java.util.Random;
import java.util.StringJoiner;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder(String.valueOf(a));

        while (a != b) {
            if (a < b) {
                sb.append(" " + ++a);
            } else {
                sb.append(" " + --a);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}