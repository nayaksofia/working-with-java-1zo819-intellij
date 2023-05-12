package com.sw;

import java.util.Scanner;

public class IfElseOperationEg01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operations symbol from here [+,-,*,/] :: " );
        String operation = scanner.nextLine();

        System.out.println("Enter Value 1 :: ");
        int val1 = scanner.nextInt();

        System.out.println("Enter Value 2 :: ");
        int val2 = scanner.nextInt();

        int result = 0;

        if (operation.equals("+")) {

            result = val1 + val2;
            System.out.println("Addition: " + result);

        } else if (operation.equals("-")) {

            result = val1 - val2;
            System.out.println("Subtraction: " + result);

        }else if(operation.equals("*")) {

            result = val1 * val2;
            System.out.println("Multiplication : " + result);

        }else
            System.out.println("Invalid Operation");

    }

}






