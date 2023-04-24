package com.inputoutput.stream.model;


import java.io.Serial;
import java.io.Serializable;

//User :: POJO Class implements Serializable Interface which has no methods
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 6238607686640066689L;

    //Step -1 : Declare field
    private String firstName;
    private int age;

    //Step-2 : Generate non-parameterized constructor
    public User() {

    }

    //Step-3 : Generate Parameterized Constructor

    public User(String name, int age) {
        this.firstName = name;
        this.age = age;
    }

    //Step-4 : Generate getter and setter

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
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
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
