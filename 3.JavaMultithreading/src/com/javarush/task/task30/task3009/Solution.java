package com.javarush.task.task30.task3009;

/* 
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        Integer numberDec = null;

        for (int i = 2; i <= 36; i++) {
            try {
                numberDec = Integer.parseInt(number);
                String numberNewSystem = Integer.toString(numberDec, i).toUpperCase();
                String revNumber = new StringBuilder(numberNewSystem).reverse().toString();
                if (numberNewSystem.equals(revNumber)) {
                    set.add(i);
                }
            } catch (NumberFormatException e) {
            }

        }


        return set;
    }
}