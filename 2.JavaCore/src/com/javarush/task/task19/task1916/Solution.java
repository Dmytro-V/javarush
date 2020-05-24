package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader readerFile1 = new BufferedReader(new FileReader(file1));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(file2));

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        while (readerFile1.ready()) {
            list1.add(readerFile1.readLine());
        }
        while (readerFile2.ready()) {
            list2.add(readerFile2.readLine());
        }
        readerFile1.close();
        readerFile2.close();

        int i = 1;
        int j = 1;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i - 1).equals(list2.get(j - 1))) {
                lines.add(new LineItem(Type.SAME, list1.get(i - 1)));
                i++;
                j++;
            } else if (list1.get(i).equals(list2.get(j - 1))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i - 1)));
                i++;
            } else if (list1.get(i - 1).equals(list2.get(j))) {
                lines.add(new LineItem(Type.ADDED, list2.get(j - 1)));
                j++;
            } else
                break;
        }
        if (i < list1.size() && j == list2.size()) {
            if (list1.get(i-1).equals(list2.get(j-1))) {
                lines.add(new LineItem(Type.SAME, list1.get(i-1)));
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            } else if (list1.get(i).equals(list2.get(j-1))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i-1)));
                lines.add(new LineItem(Type.SAME, list1.get(i)));
            }
        }
        else if (i == list1.size() && j < list2.size()) {
            if (list1.get(i-1).equals(list2.get(j-1))) {
                lines.add(new LineItem(Type.SAME, list1.get(i-1)));
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
            } else if (list1.get(i-1).equals(list2.get(j))) {
                lines.add(new LineItem(Type.ADDED, list2.get(j-1)));
                lines.add(new LineItem(Type.SAME, list2.get(j)));
            }
        } else if (i == list1.size() && j == list2.size()) {
            if (list1.get(i-1).equals(list2.get(j-1)))
                lines.add(new LineItem(Type.SAME, list1.get(i-1)));
        }
/* проверка выводит в консоль
        for (int k = 0; k < lines.size(); k ++){
            System.out.println(lines.get(k).type + " " + lines.get(k).line);
        }
        
 */

    }



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
