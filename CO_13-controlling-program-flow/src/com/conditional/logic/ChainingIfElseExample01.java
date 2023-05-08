package com.conditional.logic;

import java.util.Scanner;

public class ChainingIfElseExample01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the age of the person: ");
        int age = scanner.nextInt(); //Read the input from the user

        if(age>70){
            System.out.println("Senior Adult");
        } else if (age>17) {
            System.out.println("Adult");
        } else if (age>6) {
            System.out.println("Child");
        } else {
            System.out.println("Baby");
        }

    }
}
