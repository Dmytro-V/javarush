package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = readerName.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile, true));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        while (true) {
            text = reader.readLine();
            if (text.equals("exit")) {
                bufferedWriter.write(text);
                break;
            }
            bufferedWriter.write(text + "\r\n");
        }
        readerName.close();
        bufferedWriter.close();
        reader.close();

    }
}
