package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

//        String[] args = {"f:/test", "f:/result/1.txt"};

        File path = new File(args[0]);

        File resultFileAbsolutePath = new File(args[1]);
        File destination = new File(resultFileAbsolutePath.getParent() + "/" + "allFilesContent.txt");
        try {
            FileOutputStream fos = new FileOutputStream(destination);
            fos.close();
        } catch (FileNotFoundException e) {

        }

//        if (!FileUtils.isExist(destination)) {
//            File pathOfDirectory = new File(resultFileAbsolutePath.getParent());
//            pathOfDirectory.mkdir();
//            resultFileAbsolutePath.createNewFile();
//
//        }
        FileUtils.renameFile(resultFileAbsolutePath, destination);


        FileOutputStream fos = new FileOutputStream(destination);

            List<File> listFiles = getFiles(path);
            Collections.sort(listFiles, Comparator.comparing(File::getName));
            int i = 0;
            for (int j = 0; j < listFiles.size(); j++) {
                if (i > 0) {
                }
                File file = listFiles.get(j);
                int length = (int)file.length();
                if ( length <= 50) {
                    FileInputStream fis = new FileInputStream(file);
                    while (fis.available() > 0) {
                        fos.write(fis.read());

                    }
                    fos.write("\n".getBytes());

                    i++;
                    fis.close();
                    fos.flush();
                }
            }
        fos.close();


    }

    private static List<File> getFiles(File path) {
        File[] list = path.listFiles();
        List<File> files = new ArrayList<>();

        for (File file : list) {
            if (file.isFile()) {
                files.add(file);
            } else {
                files.addAll(getFiles(file));
            }
        }
        return files;
    }
}
