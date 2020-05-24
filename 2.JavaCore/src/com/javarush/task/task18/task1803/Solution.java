package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        FileInputStream inputStream = new FileInputStream(nameFile);
        HashMap<Integer, Integer> map =new HashMap<>();
        int max = 1;

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (map.containsKey(data)) {
                int value = map.get(data);
                map.put(data, value + 1);
                if ((value + 1) > max )
                    max = value + 1;
            } else
                map.put(data, 1);
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == max)
                System.out.print(pair.getKey() + " ");
        }

        inputStream.close();
        reader.close();
    }
}
