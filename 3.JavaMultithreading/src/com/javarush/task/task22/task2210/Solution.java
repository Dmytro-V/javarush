package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> result = new ArrayList<>();
        while (tokenizer.hasMoreTokens())
        {
            result.add(tokenizer.nextToken());
        }
        String[] arr = result.toArray(new String[result.size()]);

        return arr;
    }
}
