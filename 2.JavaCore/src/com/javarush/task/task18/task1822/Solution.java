package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith(args[0] + " "))
                System.out.println(line);
        }
        bufferedReader.close();

    }
}
