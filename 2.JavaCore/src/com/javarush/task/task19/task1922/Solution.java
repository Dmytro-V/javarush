package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String fileLine = fileReader.readLine();
            String[] lineWords = fileLine.split(" ");
            int equals = 0;
            for (int i = 0; i < lineWords.length; i ++) {
                for (int j = 0; j < words.size(); j ++) {
                    if (lineWords[i].equals(words.get(j)))
                        equals ++;
                }
            }
            if (equals == 2) System.out.println(fileLine);

        }
        fileReader.close();
    }
}
