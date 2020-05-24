package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end"))
                break;
            int lastIndex = fileName.lastIndexOf(".part") + 5;
            int numOfPart = Integer.parseInt(fileName.substring(lastIndex));
            map.put(numOfPart , fileName);
        }

        int lastIndex = map.get(1).lastIndexOf(".part");
        String resultFileName = map.get(1).substring(0, lastIndex);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFileName, true));
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            String nameFilePart = entry.getValue();
            BufferedReader fileReader = new BufferedReader(new FileReader(nameFilePart));
            int i;
            while ((i = fileReader.read()) != -1) {
                writer.write(i);
            }
            fileReader.close();
        }
        writer.close();

    }
}
