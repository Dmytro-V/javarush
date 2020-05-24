package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();

        FileInputStream inputStreamFile1 = new FileInputStream(nameFile1);
        int i;
        ArrayList<Integer> list = new ArrayList<>();
        while ((i = inputStreamFile1.read()) != -1) {
            list.add(i);
        }
        inputStreamFile1.close();

        FileInputStream inputStreamFile2 = new FileInputStream(nameFile2);
        FileOutputStream outputStreamFile1 = new FileOutputStream(nameFile1);
        while ((i = inputStreamFile2.read()) != -1) {
            outputStreamFile1.write(i);
        }
        for (int j = 0; j < list.size(); j ++) {
            outputStreamFile1.write(list.get(j));
        }
        inputStreamFile2.close();
        outputStreamFile1.close();
    }
}
