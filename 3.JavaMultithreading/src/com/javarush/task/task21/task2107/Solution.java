package com.javarush.task.task21.task2107;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Solution solution = new Solution();

        User hubert = new User(172, "Hubert");
        solution.users.put("Hubert", hubert);

        User zapp = new User(41, "Zapp");
        solution.users.put("Zapp", zapp);

        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public Solution clone() throws CloneNotSupportedException {
        Solution sol = (Solution) super.clone();
        sol.users = new LinkedHashMap();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User user = (User) entry.getValue().clone();
            sol.users.put(entry.getKey(), user);
        }
        return sol;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            User user = (User) super.clone();
            return user;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }


        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

    }
}
