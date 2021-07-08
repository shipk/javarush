package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            A a = (A) objectStream.readObject();
            return a;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (ClassCastException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public class A implements Serializable{
    }

    public class B extends A implements Externalizable {
        public B() {
            System.out.println("inside B");
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(1);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            int i = in.readInt();
        }
    }

    public static void main(String[] args) {

    }
}
