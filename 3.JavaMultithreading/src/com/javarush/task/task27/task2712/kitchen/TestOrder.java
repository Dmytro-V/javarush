package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int numberOfDishes = random.nextInt(5) + 1;
        this.dishes = new ArrayList<>();
        for (int i = 0; i < numberOfDishes; i++) {
            int index = random.nextInt(Dish.values().length);
            dishes.add(Dish.values()[index]);
        }
    }
}
