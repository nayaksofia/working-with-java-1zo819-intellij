package com.loop.sofi;

public class ForLoopEg01 {

    public static void main(String[] args) {
        int factorial = 1;
        for(int num = 5 ; num > 1; num--){
            factorial *=num;
            System.out.println(num + " | " + factorial);
        }
        System.out.println("Result: " + factorial);
    }
}
