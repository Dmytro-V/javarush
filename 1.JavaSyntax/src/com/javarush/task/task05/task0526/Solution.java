package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man manIvan = new Man("Ivan", 30, "Polska");
        Man manVasya = new Man("Vasya", 40, "Gdansk");
        Woman womanMasha = new Woman("Masha", 25, "polska");
        Woman womanDasha = new Woman ("Dasha", 30, "Gdansk");

        System.out.println( manIvan.name + " " + manIvan.age + " " + manIvan.address);
        System.out.println( manVasya.name + " " + manVasya.age + " " + manVasya.address);
        System.out.println( womanMasha.name + " " + womanMasha.age + " " + womanMasha.address);
        System.out.println( womanDasha.name + " " + womanDasha.age + " " + womanDasha.address);
    }

    //напишите тут ваш код
    public static class Man {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
