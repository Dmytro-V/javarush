package com.javarush.task.task22.task2209;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(nameFile));
        StringBuilder words = new StringBuilder();
        while (readerFile.ready()) {
            words.append(readerFile.readLine() + " ");
        }
        readerFile.close();
        String text = words.toString();
        if (text.charAt(0) == '\uFEFF') {
            text = text.substring(1);
        }

        String[] arrOfWords = text.split(" ");


        //...
        StringBuilder result = getLine(arrOfWords);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<StringBuilder> result = new ArrayList<>();
        if (words.length == 0)
            return new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            list = new ArrayList<>(Arrays.asList(words));
            result.add(new StringBuilder());

//          Collections.sort(list);
            String word = list.get(i);
            list.remove(i);
            result.get(i).append(word + " ");
            int size;

            while ((size = list.size()) > 0) {
                for (int j = 0; j < list.size(); j++) {
                    String end = word.substring(word.length() - 1);
                    String begin = list.get(j).substring(0, 1);
                    if (end.equalsIgnoreCase(begin)) {
                        result.get(i).append(list.get(j)+ " ");
                        word = list.get(j);
                        list.remove(j);
                        break;
                    }
                }
                if (list.size() == size)
                    break;
            }
            if (size == 0)
                break;
        }

        int maxLength = 0;
        int maxRes = 0;
        for (int i = 0; i < result.size(); i++) {
            if (maxLength < result.get(i).length()) {
                maxLength = result.get(i).length();
                maxRes = i;
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (result.get(maxRes).indexOf(words[i]) == -1)
            result.get(maxRes).append(words[i] + " ");
        }
        result.get(maxRes).deleteCharAt(result.get(maxRes).length() - 1);
        return result.get(maxRes);
    }
}
