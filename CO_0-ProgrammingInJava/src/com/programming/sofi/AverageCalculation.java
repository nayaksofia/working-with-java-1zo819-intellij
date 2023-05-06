package com.programming.sofi;

import java.util.Scanner;

//Demo :: Calculate the average of numbers entered by the user .
public class AverageCalculation {
    public static void main(String[] args) {

        /*
         1. Instantiate scanner Object Using Scanner Class :: To get input from the user
         2. Use try-catch resources : to close Scanner Object
         3. Then store the size of the array in variable n
         4. Create an array numbers of size n using for loop
         5. Calculate the average of number by dividing with n i.e the size of array
         6. Finally, take printout.
         How to calculate average ?
         Average = Total Arrays Of Numbers / length of numbers
        */

        try(Scanner scanner = new Scanner(System.in)){
            int n;
            System.out.println("Enter the size of the array :: ");
            n = scanner.nextInt(); //To Read from the user

            int[] numbers = new int[n]; //Initialise Numbers
            int sum = 0;
            double average;

            System.out.println("Enter " + n + " numbers :");

            //Create an array using for loop entered by user
            for(int i=0; i<n ; i++){
                numbers[i] = scanner.nextInt(); //Read
                sum += numbers[i];
            }

            average = (double) sum/n; //Casting

            System.out.println("The average is :: " +average);

        }

    }
}
