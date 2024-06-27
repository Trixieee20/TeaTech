package com.TeaTech.co.TeaTech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String address;
    private String contactnumber;
    private int age;

    User(){}
    
    public User(String name, String address, String contactnumber, int age) {
        this.name = name;
        this.address = address;
        this.contactnumber = contactnumber;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactnumber;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

}
