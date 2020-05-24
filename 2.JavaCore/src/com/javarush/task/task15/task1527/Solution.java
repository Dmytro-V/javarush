package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        ArrayList<String> list = new ArrayList<>();
        int begin = url.indexOf('?');
        url = url.substring(begin +1);

        String[] parts = url.split(Pattern.quote("&"));

        for (int i = 0; i < parts.length; i++) {
            int end = parts[i].indexOf('=');
            if (end == -1)
                System.out.print(parts[i] + " ");
            else
                System.out.print(parts[i].substring(0, end) + " ");
        }
        System.out.println();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("obj")) {
                String objValue = parts[i].substring(parts[i].indexOf("=") + 1);
                try {
                    Double value = Double.parseDouble(objValue);
                    alert(value);
                }
                catch (NumberFormatException e) {
                    alert(objValue);
                }

            }
        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
