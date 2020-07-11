package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader;
    private static final String EXIT_WORD = "exit";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();

        writeMessage("menu:");
        writeMessage(Dish.allDishesToString());
        writeMessage("выбери блюдо:");
        String inputText = null;

        do {
            inputText = readString();
            for (Dish dish : Dish.values()) {
                if (inputText.equals(dish.name())) {
                    dishes.add(dish);
                }
            }
        } while (!inputText.equals(EXIT_WORD));

        return dishes;

    }
}
