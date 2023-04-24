package com.inputoutput.stream.model;


import java.io.Serializable;

//User :: POJO Class implements Serializable Interface which has no methods
public class User implements Serializable {

    //Step -1 : Declare field
    private String name;
    private int age;

    //Step-2 : Generate non-parameterized constructor
    public User() {

    }

    //Step-3 : Generate Parameterized Constructor

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Step-4 : Generate getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Step-5 : Generate get toString() method

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
