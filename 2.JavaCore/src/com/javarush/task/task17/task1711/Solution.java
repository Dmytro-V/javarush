package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case ("-c"):

                for (int i = 1; i < args.length; i += 3) {
                    String inputName = args[i];

                    Sex inputSex = null;
                    if (args[i + 1].equals("м"))
                        inputSex = Sex.MALE;
                    else if (args[i + 1].equals("ж"))
                        inputSex = Sex.FEMALE;

                    SimpleDateFormat inputDataFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date inputDate = inputDataFormat.parse(args[i + 2]);

                    synchronized (allPeople) {
                        if (inputSex == Sex.MALE)
                            allPeople.add(Person.createMale(inputName, inputDate));
                        else if (inputSex == Sex.FEMALE)
                            allPeople.add(Person.createFemale(inputName, inputDate));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;

            case ("-u"):
                for (int i = 1; i < args.length; i += 4) {
                    int inputId = Integer.parseInt(args[i]);

                    String inputName = args[i + 1];

                    Sex inputSex = null;
                    if (args[i + 2].equals("м"))
                        inputSex = Sex.MALE;
                    else if (args[i + 2].equals("ж"))
                        inputSex = Sex.FEMALE;

                    SimpleDateFormat inputDataFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date inputDate = inputDataFormat.parse(args[i + 3]);

                    synchronized (allPeople) {
                        allPeople.get(inputId).setName(inputName);
                        allPeople.get(inputId).setSex(inputSex);
                        allPeople.get(inputId).setBirthDate(inputDate);
                    }
                }
                break;

            case ("-d"):
                for (int i = 1; i < args.length; i ++) {
                    int inputId = Integer.parseInt(args[i]);

                    synchronized (allPeople) {
                        allPeople.get(inputId).setName(null);
                        allPeople.get(inputId).setSex(null);
                        allPeople.get(inputId).setBirthDate(null);
                    }
                }
                break;

            case("-i"):

                for (int i = 1; i < args.length; i++) {
                    int inputId = Integer.parseInt(args[i]);

                    synchronized (allPeople) {
                        System.out.print(allPeople.get(inputId).getName());

                        if (allPeople.get(inputId).getSex() == Sex.MALE)
                            System.out.print(" " + "м");
                        else if (allPeople.get(inputId).getSex() == Sex.FEMALE)
                            System.out.print(" " + "ж");
                        SimpleDateFormat outputData = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                        System.out.println(" " + outputData.format(allPeople.get(inputId).getBirthDate()));
                    }
                }
        }
    }
}
