package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        if (!properties.isEmpty()) {
            for (Map.Entry<String, String> pair : properties.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                prop.setProperty(key, value);
            }
            prop.save(outputStream, "prop");
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        Set<String> listKeys = prop.stringPropertyNames();

        for (String key : listKeys) {
            properties.put(key, prop.getProperty(key));
        }


    }

    public static void main(String[] args) throws Exception {
 
    }
}
