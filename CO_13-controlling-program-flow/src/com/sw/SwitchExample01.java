package com.sw;

import java.util.Scanner;

public class SwitchExample01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any sign among these[-,+,*,$] :: ");
        String sign = scanner.nextLine();


        switch (sign){

            case "+":
                System.out.println("Positive");
                break;
            case "-":
                System.out.println("Negative");
                break;
            case "*":
                System.out.println("Star");
                break;
            case "$":
                System.out.println("Dollar");
                break;
            default:
                System.out.println("Sign not recognized");
                break;
        }

        System.out.println("Keep Working..........");
    }
}
