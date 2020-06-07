package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input name archive: ");
        String nameArchive = scanner.nextLine();

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(nameArchive));

        System.out.println("name of file for archive: ");
        String fileForArchive = scanner.nextLine();
        zipFileManager.createZip(Paths.get(fileForArchive));


        new ExitCommand().execute();

    }
}
