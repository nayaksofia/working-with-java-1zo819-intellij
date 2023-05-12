package com.complex.loop;

// Demo : Nested For Loop to iterate over the two-dimensional array and prints it's contents
public class NestedForLoopEg01 {

    public static void main(String[] args) {

        //Initialise Two Dimensional Array
        int[][]  multi= {{100, 105 , 110},
                {200 , 205, 225},
                {300 , 305, 335}};

        for(int i=0; i <multi.length ; i++){
            for(int j = 0; j< multi[i].length; j++){
                System.out.println(multi[i][j]);
            }
        }
    }
}
