package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/*
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom thread = ThreadLocalRandom.current();
        return thread.nextInt(from, to);
    }

    public static double getRandomDouble() {
        ThreadLocalRandom thread = ThreadLocalRandom.current();
        return thread.nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        ThreadLocalRandom thread = ThreadLocalRandom.current();
        return thread.nextLong(n);
    }

    public static void main(String[] args) {
    }
}
