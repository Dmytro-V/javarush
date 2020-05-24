package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader readerFile = new FileReader(fileName1);
        FileWriter writerFile = new FileWriter(fileName2);

        while (readerFile.ready()) {
            int data = readerFile.read();
            int data2 = readerFile.read();
            writerFile.write(data2);
        }

        readerFile.close();
        writerFile.close();
    }
}
