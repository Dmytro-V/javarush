package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            String key = line[0];
            Double value = Double.parseDouble(line[1]);
            Double newValue;

            if (map.containsKey(key)) {
                newValue = map.get(key) + value;
                map.put(key, newValue);
            } else
                map.put(key, value);

        }
        reader.close();

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());

        }

    }
}
