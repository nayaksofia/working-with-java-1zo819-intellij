package com.complex.loop;

public class NestedForEachLoopEg01 {

    public static void main(String[] args) {

        //Initialise two-dimensional array
        int[][] multi ={{100, 105, 110},
                        {200, 205, 210},
                        {300, 305, 310}};

        // Enhanced for-loop
        for(int[] simple: multi){
            for(int value : simple){
                System.out.println("Value = " + value);
            }
        }
    }



}
