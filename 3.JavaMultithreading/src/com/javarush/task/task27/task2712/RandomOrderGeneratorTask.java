package com.javarush.task.task27.task2712;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private final int interval; //milliseconds

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {

        while (true) {
            int size = tablets.size();

            ThreadLocalRandom random = ThreadLocalRandom.current();
            Tablet tablet = tablets.get(random.nextInt(size));

            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
