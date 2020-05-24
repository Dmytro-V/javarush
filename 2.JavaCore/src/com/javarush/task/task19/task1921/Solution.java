package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            String name = line[0];
            int last = line.length;
            int day = Integer.parseInt(line[last - 3]);
            int month = Integer.parseInt(line[last - 2]);
            int year = Integer.parseInt(line[last -1]);

            for (int i = 1; i < line.length - 3; i ++) {
                name = name + " " + line[i];
            }
            Date date = new Date(year - 1900, month - 1, day);
            Person person = new Person(name, date);
            PEOPLE.add(person);

        }
        reader.close();

    }
}
