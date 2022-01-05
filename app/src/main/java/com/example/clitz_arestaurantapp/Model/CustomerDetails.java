package com.example.clitz_arestaurantapp.Model;

public class CustomerDetails {

    private String Name;
    private String Number;
    private String Address;
    private String City;
    private String State;
    private String Pincode;

    public CustomerDetails(){

    }

    public CustomerDetails(String name,String number, String address, String city, String state, String pincode) {
        Name = name;
        Address = address;
        Number= number;
        City = city;
        State = state;
        Pincode = pincode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

}
