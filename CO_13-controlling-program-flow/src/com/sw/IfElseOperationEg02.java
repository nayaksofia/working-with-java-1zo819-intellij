package com.sw;

// Demo :: String comparison operation
import java.util.Scanner;


public class IfElseOperationEg02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your grade to get a message [grade = A, B , C, D, E ] :: ");
        String grade = scanner.nextLine();

        if(grade.equalsIgnoreCase("A"))
            System.out.println("Great Work");
        else if (grade.equalsIgnoreCase("B") || grade.equalsIgnoreCase("C") || grade.equalsIgnoreCase("D"))
            System.out.println("You Passed !!!");
        else
            System.out.println("Try again next time ");

    }
}

/*
 Note ::
 - In Java we should use the `equals()` method to compare two strings.
 - The equals() method compares the actual contents of the two strings,
  instead of comparing their memory references like the `==` operator does .
 */