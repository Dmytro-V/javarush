package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int allSymbols = inputStream.available();
        int space = 0;

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == 32)
                space ++;
        }

        inputStream.close();
        float result = (float)space / allSymbols * 100;
        String formattedResult = new DecimalFormat("#0.00").format(result);
        System.out.println(formattedResult);
    }
}
