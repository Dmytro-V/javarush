package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readInt() throws IOException{
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
