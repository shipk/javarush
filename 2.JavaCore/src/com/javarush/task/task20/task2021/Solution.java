package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }
        private void writeObject(ObjectOutputStream os) throws IOException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
