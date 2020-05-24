package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        PrintStream console = System.out;
        System.setOut(printStream);
        testString.printSomething();
        String text = byteArrayOutputStream.toString();
        String[] symbols = text.split(" ");

        int answer = 0;
        int numberOne = Integer.parseInt(symbols[0]);
        int numberTwo = Integer.parseInt(symbols[2]);
        if (symbols[1].equals("+"))
            answer = numberOne + numberTwo;
        else if (symbols[1].equals("-"))
            answer = numberOne - numberTwo;
        else if (symbols[1].equals("*"))
            answer = numberOne * numberTwo;


        String result = byteArrayOutputStream.toString() + answer;

        System.setOut(console);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

