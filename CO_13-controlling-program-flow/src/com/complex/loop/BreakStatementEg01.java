package com.complex.loop;

public class BreakStatementEg01 {

    public static void main(String[] args) {
        int sum = 0;
        int iVal = 1;
        while(iVal<10){
            sum += iVal;
            System.out.println("iVal = " +iVal + "  Sum = " + sum);
            if(sum>5){
                break;
            }
            iVal++;
        }
    }
}
