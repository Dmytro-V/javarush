package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        String[] arg = {"e:/result/1.txt", "e:/test.zip"};

        String fileName = args[0];
        String zipName = args[1];
        Path pathFile = Paths.get("new/", Paths.get(fileName).getFileName().toString());

        //read archive
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipName));

        Map<String, byte[]> entries = new LinkedHashMap<>();
        ZipEntry entry = zis.getNextEntry();
        while (entry != null) {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = zis.read(buffer)) > 0) {
                baos.write(buffer,0, length);
            }
            entries.put(entry.toString(), baos.toByteArray());
            baos.close();
            entry = zis.getNextEntry();
        }
        zis.close();

        //write new archive
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName));
        for (String key : entries.keySet()) {
            ZipEntry newEntry = new ZipEntry(key);
            if (newEntry.getName().equals(pathFile.toString())){
                continue;
            }
            zos.putNextEntry(new ZipEntry(key));
            zos.write(entries.get(key));
        }
        zos.putNextEntry(new ZipEntry(pathFile.toString()));

        //adding new file
        Files.copy(Paths.get(fileName), zos);

        zos.close();
    }
}
