package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tegBegin = "<" + args[0];
        String tegEnd = "</" + args[0] + ">";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);

        StringBuilder textReader = new StringBuilder();

        while (fileReader.ready()) {
            char symbol = (char)fileReader.read();
            textReader.append(symbol);
        }
        String line = textReader.toString().replaceAll("\\n", "").replaceAll("\\r", "");

        fileReader.close();

        int begin = 0;
        int start = 0;
        int end = 0;
        int startEnd = 0;
        TreeMap<Integer, String> map = new TreeMap<>();

        while (begin != -1) {
            begin = line.indexOf(tegBegin, start);
            if (begin != -1) {
                map.put(begin, "start");
                start = begin + 1;
            }
        }
        while (end != -1) {
            end = line.indexOf(tegEnd, startEnd);
            if (end != -1) {
                map.put(end, "end");
                startEnd = end + 1;
            }
        }
/*          line  - all text from file
            map  - index   start and stop of tegs
            list  - list of index
            result  - index begin of tag ,  tag

 */
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(map.keySet().toArray(new Integer[0])));
        TreeMap<Integer, String> result = new TreeMap<>();
        int i =0;
        while ( list.size() > 0 && i < list.size() - 1) {
            String value = map.get(list.get(i));
            String nextValue = map.get(list.get(i+1));
            if (value.equals("start") && nextValue.equals("end")) {
                String text = line.substring(list.get(i), list.get(i+1) + tegEnd.length());
                result.put(list.get(i), text);
                list.remove(i+1);
                list.remove(i);
                i = 0;
            } else i ++;
        }

        for (Map.Entry<Integer, String> entry : result.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
