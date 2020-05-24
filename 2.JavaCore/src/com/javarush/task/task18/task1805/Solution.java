package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        FileInputStream inputStream = new FileInputStream(nameFile);
        TreeSet<Integer> set = new TreeSet<>();

        while (inputStream.available() > 0) {
            set.add(inputStream.read());
        }
        for (Integer i : set) {
            System.out.print(i + " ");
        }

        inputStream.close();
        reader.close();
    }
}
