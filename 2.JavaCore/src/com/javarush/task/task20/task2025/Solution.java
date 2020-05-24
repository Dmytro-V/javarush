package com.javarush.task.task20.task2025;

import javafx.collections.transformation.SortedList;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        if (N >= Long.MAX_VALUE || N <= 0L) return null;

            ArrayList<Long> listLong = new ArrayList<>();
            int digit = Long.toString(N).length(); //разряд числа от 1 до 19

            //матрица возведения в степень
            Long[][] matrix = new Long[10][digit + 1];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < digit + 1; j++) {
                    matrix[i][j] = (long) Math.pow((double) i, (double) j);
                }
            }

            //числа Армстронга 1 разряда
            for (int i = 1; i <= 9; i++) {
                listLong.add((long) i);
            }

            Long value = 100L;
            while (value <= N) {
                char[] charValue = value.toString().toCharArray();
                Integer[] intValue = new Integer[charValue.length];
                for (int i = 0; i < charValue.length; i++) {
                    intValue[i] = charValue[i] - '0';
                }

                boolean condition = true;
                int prev = intValue[0];
                for (int i = 1; i < intValue.length; i++) {
                    if (intValue[i] != 0) {
                        if (prev > intValue[i])
                            condition = false;
                    }
                }

                // проверка числа Армстрронга int[] intValue
                if (condition) {
                    Long numArm = (long) 0;
                    int exp = intValue.length;
                    for (int i = 0; i < intValue.length; i++) {
                        numArm = numArm + matrix[intValue[i]][exp];
                    }

                    char[] charArm = numArm.toString().toCharArray();
                    ArrayList<Integer> listArm = new ArrayList<>();
                    for (int i = 0; i < charArm.length; i++) {
                        listArm.add(charArm[i] - '0');
                    }
                    Collections.sort(listArm);

                    List<Integer> listValue = Arrays.asList(intValue);
                    Collections.sort(listValue);

                    boolean isArm = true;
                    if (listValue.size() == listArm.size()) {
                        for (int i = 0; i < listValue.size(); i++) {
                            if (listValue.get(i) != listArm.get(i))
                                isArm = false;
                        }
                    } else
                        isArm = false;

                    if (isArm)
                        listLong.add(numArm);
                }

                value++;
            }

            //коррекция списка listLong
            Set<Long> set = new HashSet<>(listLong);
            listLong.clear();
            for (Long key : set) {
                if (key < N)
                    listLong.add(key);
            }
            Collections.sort(listLong);

            result = new long[listLong.size()];
            for (int i = 0; i < listLong.size(); i++) {
                result[i] = listLong.get(i);
            }


        return result;
    }


    public static void main(String[] args) {
        Date dateBegin = new Date();

        long[] result = getNumbers(-3L);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        Date dateEnd = new Date();
        long msDelay = dateEnd.getTime() - dateBegin.getTime(); //вычисляем разницу
        System.out.println("Time is: " + msDelay + " in ms");
    }
}
