package com.javarush.task.task22.task2212;

import java.sql.SQLOutput;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;


        if (telNumber.matches("(\\+\\d{2})?(\\(\\d{3}\\)|\\d{3})\\d{3}-?\\d{2}-?\\d{2}")) {
            return true;
            }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("+123456789012 - " + checkTelNumber("+123456789012"));
        System.out.println("+38(050)1234567 - " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - " + checkTelNumber("(0)501234567"));

    }
}
