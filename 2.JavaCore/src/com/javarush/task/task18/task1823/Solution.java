package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile;
        while (true) {
            nameFile = reader.readLine();
            if (nameFile.equals("exit"))
                break;
            ReadThread readThread = new ReadThread(nameFile);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.nameFile = fileName;
        }
        String nameFile;

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(nameFile);
                HashMap<Integer,Integer> map = new HashMap<>();
                int maxCount = 0;
                int byteMax = 0; // byte с максимальным повторением

                while (fileInputStream.available() > 0) {
                    int readByte = fileInputStream.read();
                    int count;
                    if (map.containsKey(readByte)) {
                        count = map.get(readByte) + 1;
                        map.put(readByte, count);
                        if (count > maxCount) {
                            maxCount = count;
                            byteMax = readByte;
                        }
                    } else {
                        map.put(readByte, 1);
                        if (maxCount == 0) {
                            maxCount = 1;
                            byteMax = readByte;
                        }
                    }
                }
                fileInputStream.close();
                synchronized (resultMap) {
                    resultMap.put(nameFile, byteMax);
                }

            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }

        }


    }
}
