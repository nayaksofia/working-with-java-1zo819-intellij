package com.arraycollection;

public class Mountain implements Comparable<Mountain>{
    //Field Declaration
    private String name;
    private int height;

    //Generate Constructor

    public Mountain(String n, int h) {
        this.name = n;
        this.height = h;
    }

    //compareTo(T o) is present in Comparable Interface.
    @Override
    public int compareTo(Mountain o) {
        return this.height-o.height;
    }

    //Generate getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
