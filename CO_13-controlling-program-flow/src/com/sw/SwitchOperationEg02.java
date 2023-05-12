package com.sw;

import java.util.Scanner;

public class SwitchOperationEg02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your grade to get a message :) : ");
        String grade = scanner.nextLine();

        switch (grade){
            case "A":
                System.out.println("Great work");
                break;
            case "B":
            case "C":
            case "D":
                System.out.println("You Passed!!!");
                break;
            default:
                System.out.println("Try again next time :) ");
        }
    }
}
