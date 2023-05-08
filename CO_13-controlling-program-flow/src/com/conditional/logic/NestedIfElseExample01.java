package com.conditional.logic;

import java.util.Scanner;

public class NestedIfElseExample01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students :: ");
        int students = scanner.nextInt();

        System.out.println("Enter the number of available rooms :: ");
        int rooms = scanner.nextInt();


        if(students > 0 ){
            if(rooms>0){
                float SR = (float) students/rooms;
                System.out.println("Students per room :: " + SR);
            }
        }else
            System.out.println("There is no students. ");
    }
}
