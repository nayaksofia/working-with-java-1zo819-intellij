package com.loop.sofi;

public class ForLoopTraditionalEg03 {

    public static void main(String[] args) {

        int[] left = {5, 3, 7};
        int[] right = {12 , 9 , 8};

        for(int i=0 , j=right.length-1; i<left.length; i++,j--){
            int result = left[i] + right[j];
            System.out.println("result = " + result);
        }
    }
}
