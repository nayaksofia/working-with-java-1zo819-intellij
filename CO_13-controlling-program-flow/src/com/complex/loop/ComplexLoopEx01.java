package com.complex.loop;

public class ComplexLoopEx01 {
    public static void main(String[] args) {
        int evenCount = 0 ;
        for(int i = 10 ; i > 0 ; i--){
           System.out.print(i);
              if (i % 2 == 0) {
                 System.out.println(" is even");
                     evenCount ++;

              }else
                  System.out.println(" is odd");

        }

        System.out.println("evenCount : " + evenCount);
    }
}
