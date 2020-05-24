package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        while (fileReader.ready()) {
            String[] words = fileReader.readLine().trim().split(" ");
            for (int i = 0; i < words.length; i ++) {
                if (!words[i].matches("\\D+")) {
                    fileWriter.write(words[i].trim() + " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
