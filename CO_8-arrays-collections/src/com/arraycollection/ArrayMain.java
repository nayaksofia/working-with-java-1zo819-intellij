package com.arraycollection;

import java.util.Arrays;

public class ArrayMain {

    public static void main(String[] args) {

        int[] ids = new int[10];
        System.out.println(ids[0]);

        String[] instruments = new String[3];
        System.out.println(instruments[0]);

        String[] instruments1 = new String[] { "guitar", "drums", "boss"};
        System.out.println(instruments1[0]);

        /*
         - Array can be declared in varieties of way.
         Examples ::
         */

        int [] ids2;
        int []ids3;
        int ids4[];
        int ids5 [];

         /*
          - You can declared array in multiple variable names .
          Example ::
          */
        int[] ids6 , ids7 , ids8;

        // Demo-1 : Accessing and Iterating Arrays

        //Length of the Array :: How big is it ?
        System.out.println(instruments1.length);

        //For Loop Type-1 :
        for (int i = 0; i < ids.length; i++){

            ids[i] = i * i;
            System.out.println(ids[i]);
        }

        /* Note On For Loop Type-1:
          If we use <= ,it shows ArrayIndexOutOfBoundsException .
          So we only use <

         */

        //For Loop Type-2

        for(String instrument: instruments1){
            System.out.println(instrument);
        }

        /* Note For For Loop Type-2
          - Advantage of For Loop Type-2 is , you do not have to worry about the ArrayIndexOutOfBoundsException
          - Disadvantage of For Loop Type-2 is, you can't assign value to this array.
         */

        /* Demo-2:  Sorting Arrays */
        Arrays.sort(instruments1);
        System.out.println(Arrays.toString(instruments1));

        /* Demo-3 : Searching Arrays */
        int[] fibArray = new int[] {0, 1, 5, 2, 3, 1, 8, 13 };
        Arrays.sort(fibArray);
        System.out.println(Arrays.binarySearch(fibArray, 3));

        System.out.println(Arrays.toString(args));

        // Two Dimensional Array
        int[][] multiArray = new int[3][3]; // Type-1 : Two Dimensional Array
        int[][] multiArray2 = new int[3][10]; // Type-2 : Two Dimensional Array
        int[][][] multiArray3 = new int[2][2][3];//Type-3 : Three Dimensional Array

        String[][] multiArray4 = new String[3][10]; //Type-1 String Type Two Dimensional Array
        String[][] westCostCitiesGrouped = new String[][]{
                {"LA","SanFrancisco","SanDiego"},
                {"Seattle","Tacoma"},
                {"Portland"},
        };  // Type-2 : String Type Two Dimensional Array

        //For Loop Example-1 : For Two Dimensional Array
        for(int i=0; i<westCostCitiesGrouped.length;i++){
            for(int ii=0; ii <westCostCitiesGrouped[i].length;ii++){
                System.out.println(westCostCitiesGrouped[i][ii]);
            }
        }

        //Replace For Loop Example-1 ; As Following
        for(String[] row : westCostCitiesGrouped){
            for(String city : row){
                System.out.println(city);
            }
        }

        System.out.println(Arrays.toString(westCostCitiesGrouped));

    }
}
