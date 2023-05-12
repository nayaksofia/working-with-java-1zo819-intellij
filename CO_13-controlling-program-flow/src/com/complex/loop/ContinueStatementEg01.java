package com.complex.loop;

//Demo : We get odd value :)
public class ContinueStatementEg01 {

    public static void main(String[] args) {

        int iVal = 0;
        while(iVal<10){
            iVal++;
            if(iVal%2==0){
                continue;
            }
            System.out.println("iVal = " +iVal);
        }
    }
}
