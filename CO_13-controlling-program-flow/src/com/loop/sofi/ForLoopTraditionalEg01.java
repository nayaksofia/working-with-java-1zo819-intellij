package com.loop.sofi;

public class ForLoopTraditionalEg01 {

    public static void main(String[] args) {

        float[] vals = {10.0f , 20.0f , 15.0f , 35.0f};
        float sum = 0.0f;
       for(int i=0; i<vals.length;i++){
           float val = vals[i];
           sum += val;
       }
        System.out.println("Sum Value = " + sum);
    }
}
