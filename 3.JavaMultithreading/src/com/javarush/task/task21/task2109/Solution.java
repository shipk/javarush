package com.javarush.task.task21.task2109;

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

        public A clone() throws CloneNotSupportedException {
            return (A) super.clone();
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

        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public C clone() throws CloneNotSupportedException {
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1,2);
        A newA = a.clone();

        B b = new B(1,2, "b_name");
        //B newB = b.clone();

        C c = new C(1,2,"cc");
        C newC = c.clone();

    }
}
