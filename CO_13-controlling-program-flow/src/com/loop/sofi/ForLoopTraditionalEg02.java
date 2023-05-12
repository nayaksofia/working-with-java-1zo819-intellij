package com.loop.sofi;

public class ForLoopTraditionalEg02 {

    public static void main(String[] args) {

        int[] left = {5, 3, 7};
        int[] right = {12, 9, 8};

        for (int i = 0; i < left.length ; i++){
            int result = left[i] + right[i] ;
            System.out.println("Result = " + result);
        }
    }
}

