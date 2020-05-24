package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        char[] stringChar = string.toCharArray();

        for (int i = 0; i <= string.length(); i++) {
            if (i == 0 || stringChar[i - 1] == ' ')
                stringChar[i] = Character.toUpperCase(stringChar[i]);
        }
        System.out.println(new String(stringChar));
    }
}
