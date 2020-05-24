package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        String nameFile3 = reader.readLine();

        FileOutputStream outputStream1 = new FileOutputStream(nameFile1);
        FileInputStream inputStreamFile2 = new FileInputStream(nameFile2);
        int i;
        while ((i = inputStreamFile2.read()) != -1) {
            outputStream1.write(i);
        }
        inputStreamFile2.close();
        outputStream1.close();

        FileInputStream inputStreamFile3 = new FileInputStream(nameFile3);
        FileOutputStream outputStream2 = new FileOutputStream(nameFile1, true);
        while ((i = inputStreamFile3.read()) != -1) {
            outputStream2.write(i);
        }
        inputStreamFile3.close();
        outputStream2.close();
    }
}
