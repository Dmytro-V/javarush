package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<>();
        int i;
        while ((i = fileInputStream.read()) != -1) {
            //if (i != 10 && i != 32 && i != 12) {
                if (map.containsKey((char) i)) {
                    map.put((char) i, map.get((char) i) + 1);
                } else
                    map.put((char) i, 1);


        }
        fileInputStream.close();
        for (Map.Entry<Character, Integer> entrySet: map.entrySet() ) {

            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
    }
}
