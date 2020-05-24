package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFileOne = args[0];
        String nameFileTwo = args[1];
        BufferedReader fileReader = new BufferedReader(new FileReader(nameFileOne));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(nameFileTwo));
        int point = 0;

        while (fileReader.ready()) {
            String[] line = fileReader.readLine().split(" ");
            for (int i = 0; i < line.length; i ++) {
                if (line[i].length() > 6) {
                    if (point != 0) fileWriter.write(",");
                    fileWriter.write(line[i]);
                    point ++;
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
