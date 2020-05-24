package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try {
            if (args[0].equals("-c")) {
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                int id = 0;
                int idMax = id;
                while (fileReader.ready()) {
                    id = Integer.parseInt(fileReader.readLine().substring(0, 8).trim());
                    if (id > idMax)
                        idMax = id;
                }
                idMax++;
                String newId = String.format("%-8s", idMax);
                String productName = String.format("%-30s", args[1]);
                String price = String.format("%-8s", args[2]);
                String quantity = String.format("%-4s", args[3]);
                String newProduct = String.format("%-8s%-30s%-8s%-4s", idMax, args[1], args[2], args[3]);

                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

                fileWriter.newLine();
                fileWriter.write(newProduct);

                fileReader.close();
                fileWriter.close();

            }
        } catch (Exception e) {

        }


    }
}
