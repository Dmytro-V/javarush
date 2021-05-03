package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<>();
        Queue<File> queueFolders = new LinkedList<>();

        File file = new File(root);
        if (file.isFile()) {
            files.add(file.toString());
            return files;
        }
        queueFolders.add(file);

        while (!queueFolders.isEmpty()) {
            File folder = queueFolders.poll();
            File[] filesFromFolder = folder.listFiles();
            for (File fileFromFolder : filesFromFolder) {
                if (fileFromFolder.isFile()) {
                    files.add(fileFromFolder.toString());
                } else {
                    queueFolders.add(fileFromFolder);
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        try {
            List<String> list = getFileTree("f:/test");
            for (String s : list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
