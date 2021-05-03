package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {


        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        byte[] readingBytes = new byte[text.length()];
        raf.seek(number);
        raf.read(readingBytes, 0, text.length());

        String readingText = new String(readingBytes);

        raf.seek(raf.length());
        if (text.equals(readingText)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }


    }
}
