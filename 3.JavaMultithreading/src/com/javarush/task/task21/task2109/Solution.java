package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }


    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();

        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }


        @Override
        protected Object clone() throws CloneNotSupportedException {
            C clone = new C(this.getI(), this.getJ(), this.getName());
            return clone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof C)) return false;
            C c = (C) o;
            return this.getI() == c.getI() && this.getJ() == c.getJ() && this.getName().equals(c.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ(), getName());
        }



    }

    public static void main(String[] args) {

    }
}
