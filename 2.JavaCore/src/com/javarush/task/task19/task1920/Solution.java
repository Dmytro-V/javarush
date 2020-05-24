package com.javarush.task.task19.task1920;

/* 
Самый богатый
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
        Double maxValue = 0.0;


        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            String key = line[0];
            Double value = Double.parseDouble(line[1]);
            double newValue;

            if (map.containsKey(key)) {
                newValue = map.get(key) + value;
                map.put(key, newValue);
                if (newValue > maxValue) maxValue = newValue;
            } else {
                map.put(key, value);
                if (value > maxValue) maxValue = value;
            }

        }
        reader.close();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue().equals(maxValue))
                System.out.println(pair.getKey());

        }
    }
}
