package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1},
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int result;

        int temp = 0;
        int rect = 0;

        for (int j = 0; j < a[0].length; j++) {
            if (a[0][j] == 1 && temp == 0) {
                rect ++;
                temp = 1;
            } else if (a[0][j] == 0)
                temp = 0;
        }

        temp = 0;
        for (int i = 1; i < a.length; i ++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && temp == 0 && a[i-1][j] == 0) {
                    rect ++;
                    temp = 1;
                } else if (a[i][j] == 0)
                    temp = 0;
            }
        }


        return rect;
    }
}
