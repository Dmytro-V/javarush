package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private boolean sex;
        private int age;
        private int weight;
        private int height;

        public Human(String firstName, String lastName, boolean sex, int age, int weight, int height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, boolean sex, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String lastName, int weight, int height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.weight = weight;
            this.height = height;
        }

        public Human(String firstName, String lastName, int age, int weight, int height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(String firstName, String lastName, boolean sex, int weight, int height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(boolean sex, int age, int weight, int height) {
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(boolean sex, int weight, int height) {
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(int age, int weight, int height) {
            this.age = age;
            this.weight = weight;
            this.height = height;
        }
    }
}
