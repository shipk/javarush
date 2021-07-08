package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        //System.out.println(new Solution(4));
        Solution savedObject = new Solution(4);
        Solution loadedObject;
        try (FileOutputStream fileStream = new FileOutputStream("c:/tmp/2014.txt");
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
             FileInputStream fileInputStream = new FileInputStream("c:/tmp/2014.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
             )
        {
            objectStream.writeObject(savedObject);
            loadedObject = (Solution) objectInputStream.readObject();
            if (savedObject.string.equals(loadedObject.string)) {
                System.out.println("equals");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
