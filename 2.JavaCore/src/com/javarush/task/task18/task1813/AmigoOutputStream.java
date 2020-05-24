package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream content;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream stream) throws FileNotFoundException {
        super(fileName);
        content = stream;
    }

    @Override
    public void write(int i) throws IOException {
        content.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        content.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        content.write(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {
        content.flush();
        String s = "JavaRush © All rights reserved.";
        content.write(s.getBytes());
        content.close();
    }

    @Override
    public void flush() throws IOException {
        content.flush();
    }
}
