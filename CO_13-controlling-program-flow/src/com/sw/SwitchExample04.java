package com.sw;

public class SwitchExample04 {

    public static void main(String[] args) {
        int iVal = 11;
        final byte evenValue = 0;

        switch (iVal%2){

            case evenValue:
                System.out.println("Even");
                break;
            case evenValue + 1:
                System.out.println("Odd");
                break;
        }
    }
}
