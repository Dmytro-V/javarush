package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        String nameFile3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(nameFile1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(nameFile2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(nameFile3);

        int half = inputStream.available() / 2;

        while (inputStream.available() > half)
            fileOutputStream1.write(inputStream.read());
        while (inputStream.available() > 0)
            fileOutputStream2.write(inputStream.read());
        inputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
