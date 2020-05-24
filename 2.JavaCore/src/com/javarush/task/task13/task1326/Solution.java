package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(nameFile);
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(fileInputStream));

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String s = readerFile.readLine();
            if (s == null)
                break;
            int i = Integer.parseInt(s);
            list.add(i);
        }
        readerFile.close();
        fileInputStream.close();

        Collections.sort(list);
        for (int j = 0; j < list.size(); j ++) {
           if ((list.get(j) % 2) == 0)
                System.out.println(list.get(j));
        }



    }
}
