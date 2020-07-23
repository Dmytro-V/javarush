package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {    //minutes
        int durationOrder = 0;
        for (Dish dish : dishes) {
            durationOrder += dish.getDuration();
        }
        return durationOrder;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }


    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes + " of " + tablet;
        }

    }
}
