package com.conditional.logic;

import java.util.Scanner;

public class IfElseExample01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Value-1 :: ");
        int value1 = scanner.nextInt();

        System.out.println("Enter Value-2 :: ");
        int value2 = scanner.nextInt();

        if(value1>value2)
            System.out.println("Value 1 is bigger \n ");
        else
            System.out.println("Value 1 is not bigger \n");
        System.out.println("Keep working.....");


    }
}
/*
 Notice :
  Here notice that an if statement conditionally executes a single statement.
  If it executes a single statement than there is no use of bracket{}
  And Else clause executes a statement when condition is false.
 */