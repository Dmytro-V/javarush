package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
            String result = null;
            if (string == null)
                throw new TooShortStringException();

        int begin = string.indexOf(" ");
            if (begin == -1)
                throw new TooShortStringException();

            int j = begin;
            for (int i = 0; i < 3; i++) {
                j = string.indexOf(" ", j + 1);
                if (j == - 1)
                    break;
            }
            if (j == -1)
                throw new TooShortStringException();
            if ((j = string.indexOf(" ",j + 1)) != -1)
                result = string.substring(begin + 1, j);
            else
                result = string.substring(begin + 1);

        return result;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
