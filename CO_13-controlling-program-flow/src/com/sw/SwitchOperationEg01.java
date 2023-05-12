package com.sw;

import java.util.Scanner;

public class SwitchOperationEg01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any sign among these[-,+,*,$] :: ");
        String operation = scanner.nextLine();

        System.out.println("Enter Value 1 :: ");
        int val1 = scanner.nextInt();

        System.out.println("Enter Value 2 :: ");
        int val2 = scanner.nextInt();

         int result = 0;

        switch(operation){

            case "+":
                result = val1 + val2;
                System.out.println("Addition : " + result);
                break;
            case "-":
                result = val1 - val2;
                System.out.println("Subtraction : " + result);
                break;

            default:
                System.out.println("Invalid Operation");
                break;
        }
        System.out.println("Keep Working.......");
    }
}
