package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        try {
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                int idInput = Integer.parseInt(args[1]);
                ArrayList<String> list = new ArrayList<>();

                while (fileReader.ready()) {
                    String line = fileReader.readLine();
                    int idFile = Integer.parseInt(line.substring(0, 8).trim());
                    if (idFile == idInput) {
                        if (args[0].equals("-u")) {
                            String updateProduct = String.format("%-8s%-30s%-8s%-4s", idFile, args[2], args[3], args[4]);
                            list.add(updateProduct);
                        } else if (args[0].equals("-d")) { }
                    } else {
                        list.add(line);
                    }
                }
            fileReader.close();

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));

                for (int i = 0; i < list.size(); i ++) {
                    fileWriter.write(list.get(i));
                    fileWriter.newLine();
                }

                fileWriter.close();


        } catch (Exception e) {

        }

    }
}
