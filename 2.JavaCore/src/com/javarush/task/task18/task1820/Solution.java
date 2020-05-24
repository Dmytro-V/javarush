package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();

        FileInputStream inputStreamFile1 = new FileInputStream(nameFile1);
        FileOutputStream outputStreamFile2 = new FileOutputStream(nameFile2);

        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = inputStreamFile1.read()) != -1) {
            stringBuilder.append((char)i);
        }

        String input = stringBuilder.toString();
        String[] listInput = input.split(" ");

        ArrayList<Integer> listInt = new ArrayList<>();
        for (int j = 0; j < listInput.length; j ++) {
            listInt.add(Math.round(Float.parseFloat(listInput[j])));
        }
        for (int j = 0; j < listInt.size(); j ++) {

            outputStreamFile2.write((listInt.get(j) + " ").getBytes());
        }



        inputStreamFile1.close();
        outputStreamFile2.close();
    }
}
