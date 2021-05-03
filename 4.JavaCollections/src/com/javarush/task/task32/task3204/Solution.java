package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Stream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        boolean isAllow = false;
        byte[] array = new byte[8];
        do {

            for (int i = 0; i < 8; i++) {
                array[i] = getRandomByte();
            }

            boolean digit = false;
            boolean letterUp = false;
            boolean letterLow = false;

            for (byte b : array) {
                if (b >= 48 && b <= 57) {
                    digit = true;
                } else if (b >= 65 && b <= 90) {
                    letterUp = true;
                } else if (b >= 97 && b <= 122) {
                    letterLow = true;
                }
            }
            isAllow = digit && letterLow && letterUp;
        } while (!isAllow);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(array);
        } catch (IOException e) {

        }

        return baos;
    }

    private static byte getRandomByte() {
        //48 ... 57
        //65 ...90
        //97 ...122

        Random random = new Random();
        byte number = 0;
        int select = random.nextInt(3);
        switch (select) {
            case 0:
                number = (byte)(random.nextInt(10) + 48);
                break;
            case 1:
                number = (byte)(random.nextInt(26) + 65);
                break;
            case 2:
                number = (byte)(random.nextInt(26) + 97);
                break;
        }
        return number;
    }
}