package model;

import java.time.LocalDate;
public abstract class Person {
    private int id;
    private String name;
    private String email;
    LocalDate birthday;

    public Person(int id, String name, String email, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return birthday;
    }

    public void setDate(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Birthday: " + birthday + ", Email: " + email;
    }
}

