package com.loop.sofi;

public class DoWhileLoopEg01 {
    public static void main(String[] args) {
        int iVal = 80;
        do{
            System.out.println(iVal + " * 2 = ");
            iVal *=2;
            System.out.println(iVal);
        }while (iVal < 60);
    }
}
