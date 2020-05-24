package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileNameIn));
        StringBuilder builder = new StringBuilder();
        while (readerFile.ready())
            builder.append((char)(readerFile.read()));

        String textFile = builder.toString();
        String[] words = textFile.split(" ");
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileNameOut));

        for (int i = 0; i < words.length; i ++) {
            try {
                int number = Integer.parseInt(words[i]);
                writerFile.write(number + " ");
            } catch (NumberFormatException e) {

            }
        }

        readerFile.close();
        writerFile.close();
    }
}
