package com.javarush.task.task31.task3113;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution {

    private static int countFolders;
    private static int countFiles;
    private static long totalSize;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathString = reader.readLine();

        Path path = Paths.get(pathString);

        if (!Files.isDirectory(path)) {
            System.out.println(pathString + " - не папка");
            return;
        }

        Files.walkFileTree(path, new SimpleFileVisitor(){
            @Override
            public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory()) {
                    countFolders++;
                }

                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
                countFiles++;
                totalSize += attrs.size();
                return super.visitFile(file, attrs);
            }
        });

        System.out.println("Всего папок - " + (countFolders - 1));
        System.out.println("Всего файлов  - " + countFiles);
        System.out.println("Общий размер - " + totalSize);

    }
}
