package com.example.clitz_arestaurantapp.Model;

public class User {

    private String Name;
    private String Password;
    private String Email;


    public User() {

    }

    public User(String name, String password) {
        Name = name;
        Password = password;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public  void setEmail(String email) {
        Email = email;
    }

}
