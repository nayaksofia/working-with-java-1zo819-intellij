package com.complex.loop;

import java.util.Scanner;

public class ComplexLoopEx02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the iVal value :: ");
        int iVal = scanner.nextInt();
        if (iVal < 5)
            /*
              Here do...while() loop is consider as one statement inside if--else .
              That's why no colony bracket{} are required.
             */
            do
                System.out.println("iVal = " + iVal++);
            while(iVal<5);
        else
            System.out.println("iVal is not less than 5");
    }
}
