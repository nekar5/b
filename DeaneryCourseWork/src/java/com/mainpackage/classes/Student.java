package com.mainpackage.classes;

public class Student {
    private String name;
    private String surname;
    private double rating; 

    public Student(String name, String surname, double rating) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
