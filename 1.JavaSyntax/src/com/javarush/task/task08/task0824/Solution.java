package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFatherFather = new Human("grandFatherFather", true, 80);
        Human grandFatherMother = new Human("grandFatherMother", true, 75);
        Human grandMotherFather = new Human("grandMotherFather", false, 80);
        Human grandMotherMother = new Human("grandMotherMother", false, 75);
        Human father = new Human("Father", true, 60);
        Human mother = new Human("Mother", false, 55);
        Human child1 = new Human("child1", true, 20);
        Human child2 = new Human("child2", false, 15);
        Human child3 = new Human("child3", false, 10);

        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(child1);
        children1.add(child2);
        children1.add(child3);

        father.children.addAll(children1);
        mother.children.addAll(children1);

        grandFatherFather.children.add(father);
        grandMotherFather.children.add(father);
        grandFatherMother.children.add(mother);
        grandMotherMother.children.add(mother);

        System.out.println(grandFatherFather);
        System.out.println(grandFatherMother);
        System.out.println(grandMotherFather);
        System.out.println(grandMotherMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }



    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
