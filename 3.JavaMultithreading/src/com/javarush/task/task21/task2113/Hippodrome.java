package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses){
            horse.print();
        }

        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0;
        int indexWinner = 0;
        for (int i = 0; i < horses.size(); i ++) {
            if (maxDistance < horses.get(i).getDistance()) {
                maxDistance = horses.get(i).getDistance();
                indexWinner = i;
            }
        }

        return horses.get(indexWinner);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horseOne = new Horse("horse1", 3, 0);
        Horse horseTwo = new Horse("horse2", 3, 0);
        Horse horseThree = new Horse("horse3", 3, 0);
        List<Horse> horse = new ArrayList<>();
        horse.add(horseOne);
        horse.add(horseTwo);
        horse.add(horseThree);

        game = new Hippodrome(horse);

        game.run();
        game.printWinner();
    }
}
