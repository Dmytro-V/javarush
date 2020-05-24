package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append(fileReader.readLine());
            stringBuilder.append(" ");
        }
        fileReader.close();

        String[] arr = stringBuilder.toString().split(" ");

        for(int i= 0; i < arr.length; i++) {
            System.out.println(arr[i] + " " + arr[i].length());

        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                StringBuilder word = new StringBuilder(arr[j]);
                if (word.reverse().toString().equals(arr[i])) {
                    Pair pair = new Pair();
                    pair.first = arr[i];
                    pair.second = arr[j];
                    result.add(pair);
                }
            }
        }

        for (int i = 0; i < result.size() - 1; i++) {
            for(int j = i + 1; j < result.size();) {
                if (result.get(i).equals(result.get(j))) {
                    result.remove(j);

                } else
                    j++;
            }
        }

        System.out.println("end");
        System.out.println(result);
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
