package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(nameFile1);
        FileOutputStream outputStream = new FileOutputStream(nameFile2);

        while (inputStream.available() > 0)
            list.add(inputStream.read());

        for (int i = list.size() - 1; i >= 0; i--)
            outputStream.write(list.get(i));

        inputStream.close();
        outputStream.close();


    }
}
