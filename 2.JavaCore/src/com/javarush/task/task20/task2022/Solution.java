package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution one = new Solution("f:/1.txt");
        one.writeObject("One");

        FileOutputStream fos = new FileOutputStream("f:/2.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);

        out.writeObject(one);

        FileInputStream fis = new FileInputStream("f:/2.txt");
        ObjectInputStream in = new ObjectInputStream(fis);
        Solution two = (Solution)in.readObject();
        two.writeObject("two");
    }
}
