package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String resultFileName = args[0];
        File resultFile = new File(resultFileName);

        List<String> inputFiles = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            inputFiles.add(args[i]);
        }

        Collections.sort(inputFiles);

        List<FileInputStream> streams = new ArrayList<>();

        for (String inputFile : inputFiles) {
            FileInputStream zipFile = new FileInputStream(inputFile);
            streams.add(zipFile);
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(streams));
        ZipInputStream zip = new ZipInputStream(sequenceInputStream);

        FileOutputStream fos = new FileOutputStream(resultFile);


        ZipEntry entry = zip.getNextEntry();

        while (entry != null) {
            byte[] buffer = new byte[8 * 1024];
            int len;
            while ((len = zip.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            entry = zip.getNextEntry();
        }

        fos.close();
        zip.close();
        for (FileInputStream stream : streams) {
            stream.close();
        }
    }
}
