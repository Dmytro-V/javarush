package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(nameFile);

        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            builder.append((char)(fileReader.read()));
        }
        String textFile = builder.toString();
        String[] words = textFile.split("\\W");

        int count = 0;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals("world"))
                count ++;
        }
        System.out.println(count);

        fileReader.close();
    }
}
