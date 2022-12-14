package models;

import java.io.Serializable;

public class Profile implements Serializable {

    // serialization field
    public static final long serialVersionUID = 1L;

    // instance fields
    private String userName, firstName, lastName, country, email, gsm, imagePath;
    private int age;

    // constructor
    public Profile(String userName, String firstName, String lastName, String country, String email, String gsm, int age, String imagePath) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.gsm = gsm;
        this.age = age;
        this.imagePath = imagePath;
    }

    // setters and getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
