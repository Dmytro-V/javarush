package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        switch (args[0]) {
            case ("-c"):
                String inputName = args[1];

                Sex inputSex = null;
                if (args[2].equals("м"))
                    inputSex = Sex.MALE;
                else if (args[2].equals("ж"))
                    inputSex = Sex.FEMALE;

                SimpleDateFormat inputDataFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date inputDate = inputDataFormat.parse(args[3]);

                if (inputSex == Sex.MALE)
                    allPeople.add(Person.createMale(args[1], inputDate));
                else if (inputSex == Sex.FEMALE)
                    allPeople.add(Person.createFemale(args[1], inputDate));
                System.out.println(allPeople.size() - 1);
                break;
            case ("-u"):
                int inputId = Integer.parseInt(args[1]);

                inputName = args[2];

                inputSex = null;
                if (args[3].equals("м"))
                    inputSex = Sex.MALE;
                else if (args[3].equals("ж"))
                    inputSex = Sex.FEMALE;

                inputDataFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                inputDate = inputDataFormat.parse(args[4]);

                allPeople.get(inputId).setName(inputName);
                allPeople.get(inputId).setSex(inputSex);
                allPeople.get(inputId).setBirthDate(inputDate);
                break;
            case ("-d"):
                inputId = Integer.parseInt(args[1]);
                allPeople.get(inputId).setName(null);
                allPeople.get(inputId).setSex(null);
                allPeople.get(inputId).setBirthDate(null);
                break;
            case("-i"):
                inputId = Integer.parseInt(args[1]);
                System.out.print(allPeople.get(inputId).getName());

                if (allPeople.get(inputId).getSex() == Sex.MALE)
                    System.out.print(" " + "м");
                else if (allPeople.get(inputId).getSex() == Sex.FEMALE)
                    System.out.print(" " + "ж");
                SimpleDateFormat outputData = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                System.out.print(" " + outputData.format(allPeople.get(inputId).getBirthDate()));
        }


    }
}
