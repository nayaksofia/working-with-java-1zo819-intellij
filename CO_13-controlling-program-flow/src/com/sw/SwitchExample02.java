package com.sw;

import java.util.Scanner;

public class SwitchExample02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any value from [one,two,three,four,five] :: ");
        String valueName = scanner.nextLine();
        int total = 10;

        switch (valueName){

            case "one":
                total +=1;
                break;
            case "two":
                total =+2;
                break;
            case "three":
                total +=3;
                break;
            case "four":
                total +=4;
                break;
            case "five":
                total +=5;
                break;
            default:
                System.out.println("Value can not be recognized. \n Enter the value again.");
        }

        System.out.println("Total = " + total);


    }
}
