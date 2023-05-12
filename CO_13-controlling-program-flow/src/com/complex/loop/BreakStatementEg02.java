package com.complex.loop;

public class BreakStatementEg02 {
    public static void main(String[] args) {

        int iValStart = 1;

        while(iValStart < 4){
            System.out.println("----------------------------------------");
            System.out.println("iValStart = " + iValStart);
            System.out.println("----------------------------------------");
            int sum=0, iVal = iValStart;
            while (iVal < 10 ){
                sum += iVal;
                System.out.println("iVal = " + iVal + " sum = " + sum);
                if(sum > 5){
                    break;
                }
                iVal ++;
            }
            iValStart ++;
        }
    }
}
