package com.example.nikestore;

public class User {
    private String name,surname;
    public User()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return surname;
    }

    public void setLast_name(String last_name) {
        this.surname = last_name;
    }

    public User(String name, String last_name) {
        this.name = name;
        this.surname = last_name;
    }
}
