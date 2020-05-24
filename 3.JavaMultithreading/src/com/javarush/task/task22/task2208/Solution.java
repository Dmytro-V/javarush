package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        int next = 0;
        for ( Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (next !=0 )
                    result.append(" and ");
                result.append(pair.getKey() + " = '" + pair.getValue() + "'" );
                next++;
            }
        }

        return result.toString();
    }
}
