package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileNameIn));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileNameOut));

        while (readerFile.ready()) {
            String line = readerFile.readLine().replaceAll("\\p{Punct}", "");
            writerFile.write(line);

        }

        readerFile.close();
        writerFile.close();
    }
}
