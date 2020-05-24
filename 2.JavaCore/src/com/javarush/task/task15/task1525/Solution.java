package com.javarush.task.task15.task1525;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileInputStream file = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            while (true) {
                String s = (reader.readLine());

                if (s == null)
                    break;
                lines.add(s);


            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        System.out.println(lines);

    }
}
