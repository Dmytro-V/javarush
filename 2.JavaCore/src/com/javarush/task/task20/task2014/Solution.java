package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        String fileName = "f:/1.txt";

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputObjectStream = new ObjectOutputStream(outputStream);

            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream inputObjectStream = new ObjectInputStream(inputStream);

            Solution savedObject = new Solution(5);
            outputObjectStream.writeObject(savedObject);

            Solution loadedObject = new Solution(8);
            loadedObject = (Solution)inputObjectStream.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));

        } catch (Exception e) {

        }

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
