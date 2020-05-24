package com.javarush.task.task16.task1632;

import com.sun.java.swing.plaf.windows.WindowsDesktopPaneUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FifthThread());
    }

    public static void main(String[] args) {
    }

    public static class FirstThread extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
    public static class SecondThread extends Thread {
        @Override
        public void run() {
            try {
               Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class ThirdThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {

            }
        }
    }
    public static class FourthThread extends Thread implements Message {
        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e){

            }
        }

        @Override
        public void showWarning() {
            if (this.isAlive())
                this.interrupt();
        }
    }
    public static class FifthThread extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer> list = new ArrayList<>();
            String text;
            int result = 0;
            try {
                while (true) {
                    text = reader.readLine();
                    if (text.equals("N"))
                        break;
                    list.add(Integer.parseInt(text));
                }
                for (int i = 0; i < list.size(); i++) {
                    result += list.get(i);
                }
                System.out.println(result);
            } catch (IOException e) {

            }
        }
    }
}