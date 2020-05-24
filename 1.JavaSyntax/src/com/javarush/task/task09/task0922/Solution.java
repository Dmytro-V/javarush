package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d");
        Date date = dateFormat.parse(reader.readLine());

        SimpleDateFormat dateFormatOutput = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

        System.out.println(dateFormatOutput.format(date).toUpperCase());

    }
}
