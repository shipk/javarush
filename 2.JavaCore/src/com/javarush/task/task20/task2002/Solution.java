package com.javarush.task.task20.task2002;

import javax.jws.soap.SOAPBinding;
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
            //File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("c:/tmp/2002.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Ivanov");
            user1.setMale(true);
            user1.setBirthDate(new Date(100, 1, 1));
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            user1 = new User();
            user1.setFirstName("Petra");
            user1.setLastName("Petrova");
            user1.setMale(false);
            user1.setBirthDate(new Date(101, 11, 11));
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

            if (javaRush.equals(loadedObject)) {
                System.out.println("Objects are equal");
            } else {
                System.out.println("Objects are not equal");
            }

        } catch (IOException e) {
            e.printStackTrace();
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
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            for (User user : users) {
                user.save(writer);
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                User user = new User();
                user.load(reader);
                users.add(user);
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
