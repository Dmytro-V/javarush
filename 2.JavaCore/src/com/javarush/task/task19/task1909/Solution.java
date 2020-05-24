package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            int in = readerFile.read();
            if (in == 46) {
                writerFile.write(33);
            } else
                writerFile.write(in);

        }

        readerFile.close();
        writerFile.close();

    }
}
