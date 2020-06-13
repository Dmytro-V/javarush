package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {


    @Override
    public void execute() throws Exception {

        try {
            ConsoleHelper.writeMessage("распаковка архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("введите директорию куда будем распаковывать:");
            Path outputPath = Paths.get(ConsoleHelper.readString());

            zipFileManager.extractAll(outputPath);

            ConsoleHelper.writeMessage("Архив распакован.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }

    }
}
