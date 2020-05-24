package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] lists = new ArrayList[2];
        lists[0] =new ArrayList<String>();
        lists[1] =new ArrayList<String>();

        lists[0].add("one");
        lists[0].add("two");
        lists[0].add("three");

        lists[1].add("1");
        lists[1].add("2");
        lists[1].add("3");

        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}