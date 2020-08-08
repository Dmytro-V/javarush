package com.javarush.task.task30.task3013;

/* 
Набираем код Ӏ Java Multithreading: 10 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код

        number = ((number>>1)  |
        (number>>2)  |
        (number>>3)  |
        (number>>4)  |
        (number>>5)  |
        (number>>6)  |
        (number>>7)  |
        (number>>8)  |
        (number>>9)  |
        (number>>10)  |
        (number>>11)  |
        (number>>12)  |
        (number>>13)  |
        (number>>14)  |
        (number>>15)  |
        (number>>16)  |
        (number>>17)  |
        (number>>18)  |
        (number>>19)  |
        (number>>20)  |
        (number>>21)  |
        (number>>22)  |
        (number>>23)  |
        (number>>24)  |
        (number>>25)  |
        (number>>26)  |
        (number>>27)  |
        (number>>28)  |
        (number>>29)  |
        (number>>30)  |
        (number>>31)  |
        (number>>32))  ;

        return (~(number>>1))&number;





    }
}