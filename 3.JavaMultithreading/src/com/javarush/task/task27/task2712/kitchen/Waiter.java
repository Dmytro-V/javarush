package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;


import java.util.concurrent.LinkedBlockingQueue;

public class Waiter implements Runnable {

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }



    @Override
    public void run() {
        Order order = null;
        try {
            while (true) {
                    order = queue.poll();
                    if (order != null) {
                        ConsoleHelper.writeMessage(order + " was cooked");
                    }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {

        }
    }
}
