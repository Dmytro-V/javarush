package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("lastName1", "firstName1");
        map.put("lastName2", "firstName2");
        map.put("lastName3", "firstName3");
        map.put("lastName4", "firstName4");
        map.put("lastName5", "firstName1");

        map.put("lastName6", "firstName6");
        map.put("lastName7", "firstName7");
        map.put("lastName8", "firstName8");
        map.put("lastName9", "firstName9");
        map.put("lastName1", "firstName10");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
