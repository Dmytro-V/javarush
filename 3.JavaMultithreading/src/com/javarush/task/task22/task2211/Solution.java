package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(args[0]));
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(args[1]));
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        byte[] byteList = new byte[is.available()];
        is.read(byteList);
        String s = new String(byteList, windows1251);
        os.write(s.getBytes(utf8));
        is.close();
        os.close();
    }
}
