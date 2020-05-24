package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(isDateOdd("january 5 2014"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Date dateEnd = dateFormat.parse(date);

        Date dateBegin = new Date();
        dateBegin.setHours(0);
        dateBegin.setMinutes(0);
        dateBegin.setSeconds(0);
        dateBegin.setDate(0);
        dateBegin.setMonth(0);
        dateBegin.setYear(dateEnd.getYear());

        long distance = dateEnd.getTime() - dateBegin.getTime();
        long days = distance / (24 * 60 * 60 * 1000);

        if (days == 0 || days % 2 == 0)
            return true;
        else
            return false;
    }
}
