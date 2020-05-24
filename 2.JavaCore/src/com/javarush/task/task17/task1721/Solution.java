package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader readerFile1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader readerFile2 = new BufferedReader(new FileReader(fileName2));

            while (true) {
                String line = readerFile1.readLine();
                if (line == null)
                    break;
                allLines.add(line);
            }
            while (true) {
                String line = readerFile2.readLine();
                if (line  == null)
                    break;
                forRemoveLines.add(line);
            }
            reader.close();
            readerFile1.close();
            readerFile2.close();

        } catch (IOException e) {

        }
        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {

        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }




    }
}
