package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigInteger result, value;

        if (n < 0)
            result = BigInteger.valueOf(0);
        else if (n == 0)
            result = BigInteger.valueOf(1);
        else {
            result = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) {
                value = BigInteger.valueOf(i);
                result = result.multiply(value);
            }
        }

        return "" + result;
    }
}
