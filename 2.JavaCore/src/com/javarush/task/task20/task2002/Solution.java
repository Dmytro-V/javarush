package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("f:/1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User userOne = new User();
            User userTwo = new User();

            userOne.setFirstName("Ivan");
            userOne.setLastName("Ivanov");
            userOne.setBirthDate(new Date(90, 10, 10));
            userOne.setMale(true);
            userOne.setCountry(User.Country.valueOf("UKRAINE"));
            userTwo.setFirstName("John");
            userTwo.setLastName("Smith");
            userTwo.setBirthDate(new Date(110, 02, 05));
            userTwo.setMale(true);
            userTwo.setCountry(User.Country.valueOf("OTHER"));

            javaRush.users.add(userOne);
            javaRush.users.add(userTwo);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject))
                System.out.println(true);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (users.isEmpty()) {
                writer.write("empty");
            } else {
                writer.write("users");
                writer.newLine();
                for (User user : users) {
                    writer.write(user.getFirstName() + " "
                    + user.getLastName() + " "
                    + user.getBirthDate().getTime() + " "
                    + user.isMale() + " "
                    + user.getCountry().getDisplayName());
                    writer.newLine();
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsers = reader.readLine();
            if (isUsers.equals("users")) {
                while (reader.ready()) {
                    String[] line = reader.readLine().split(" ");

                    User user = new User();
                        user.setFirstName(line[0]);
                        user.setLastName(line[1]);
                        user.setBirthDate(new Date(new Long(line[2])));
                        user.setMale(new Boolean(line[3]));
                        user.setCountry(User.Country.valueOf(line[4].toUpperCase()));
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
