package com.javarush.task.task20.task2023;

/* 
Делаем правильный вывод
*/

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] s) {
        Solution sol = new Solution();
        sol.test();
        //A a = new C();
        //a.method2();
    }

    public static class A {
        public void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            System.out.println("A class, method2");
            method1();
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2();
            System.out.println("B class, method1");
        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");
            super.method1();
        }
    }


    public void test() {
        Set c = new HashSet();
        print(c);
    }

    public void print(Collection c) {
        System.out.println("Collection");
    }

    public void print(Set s) {
        System.out.println("Set");
    }

    public void print(HashSet hs) {
        System.out.println("HashSet");
    }
}
