package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana;
        int length = array.length;
        Arrays.sort(array);
        if (length % 2 == 0) {
            mediana = (array[length / 2] + array[length / 2 - 1]) / 2;
        } else {
            mediana = array[array.length / 2];
        }
        Comparator<Integer> comp = Comparator.comparingInt(t -> Math.abs(mediana - t));

        Arrays.sort(array, comp);

        return array;
    }
}
