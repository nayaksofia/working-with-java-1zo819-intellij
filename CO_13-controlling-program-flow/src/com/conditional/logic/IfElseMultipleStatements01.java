package com.conditional.logic;

import java.util.Scanner;

public class IfElseMultipleStatements01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Value-1 :: ");
        int value1 = scanner.nextInt();

        System.out.println("Enter Value-2 :: ");
        int value2 = scanner.nextInt();

        int diff = 0; // initialise

        if(value1>value2){
            diff = value1 - value2;
            System.out.println("Value 1 is bigger than Value 2 , diff = " + diff);
        }
        else {
            diff= value2 - value1;
            System.out.println("Value 1 is not bigger than Value 2, diff = " + diff);

        }
    }
}
