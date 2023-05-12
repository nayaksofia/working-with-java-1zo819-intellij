package com.loop.sofi;

public class WhileLoopEg01 {

    public static void main(String[] args) {

        int someValue = 1;
        int factorial = 1;

        while(someValue > 1){
            factorial *= someValue;
            someValue--;
        }
        System.out.println("Factorial = " + factorial);

    }
}
