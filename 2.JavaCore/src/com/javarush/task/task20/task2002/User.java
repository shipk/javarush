package com.javarush.task.task20.task2002;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import static java.util.Date.*;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return this.name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isMale != user.isMale) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        return country == user.country;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isMale ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public void save(PrintWriter writer) {
        if (firstName != null) {
            writer.println("yes");
            writer.println(firstName);
        } else {
            writer.println("no");
        }

        if (lastName != null) {
            writer.println("yes");
            writer.println(lastName);
        } else {
            writer.println("no");
        }

        if (birthDate != null) {
            writer.println("yes");
            writer.println(birthDate.getTime());
        } else {
            writer.println("no");
        }

        writer.println(isMale? "Male" : "Female");

        if (country != null) {
            writer.println("yes");
            writer.println(country);
        } else {
            writer.println("no");
        }
    }

    public void load(BufferedReader reader) throws Exception {
        //implement this method - реализуйте этот метод
        String flag;

        flag = reader.readLine();
        if (flag.equals("yes")) {
            this.firstName = reader.readLine();
        } else
            this.firstName = null;

        flag = reader.readLine();
        if (flag.equals("yes")) {
            this.lastName = reader.readLine();
        } else
            this.lastName = null;

        flag = reader.readLine();
        if (flag.equals("yes")) {
            this.birthDate = new Date(Long.parseLong(reader.readLine()));
        } else
            this.birthDate = null;

        String sex = reader.readLine();
        this.isMale = false;
        if (sex.equals("Male")) {
            this.isMale = true;
        }

        flag = reader.readLine();
        if (flag.equals("yes")) {
            this.country = Country.valueOf(reader.readLine());
        } else
            this.country = null;
    }
}
