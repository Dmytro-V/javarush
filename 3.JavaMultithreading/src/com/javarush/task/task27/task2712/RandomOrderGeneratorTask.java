package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private final int ORDER_CREATING_INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int orderCreatingInterval) {
        this.tablets = tablets;
        ORDER_CREATING_INTERVAL = orderCreatingInterval;
    }

    @Override
    public void run() {

        while (true) {
            int size = tablets.size();
            int random = (int) (Math.random() * 100) / size;
            Tablet tablet = tablets.get(random);

            tablet.createOrder();
            try {
                Thread.sleep(ORDER_CREATING_INTERVAL);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
