package com.complex.loop;

public class ReturnStatementEg01 {
    public static void main(String[] args) {
        System.out.println("Before Method Call");
        methodWithLoops();
        System.out.println("After Method Call");
    }

    private static void methodWithLoops() {
        for(int iValStart = 1; iValStart < 4 ; iValStart++){
            System.out.println("iValStart = " + iValStart);
            for(int iVal = iValStart; iVal <10 ; iVal++){
                System.out.println("iVal = " + iVal);
                if (iVal==3)
                    return; // Exist current method . And also terminate all loops
            }
        }
    }
}
