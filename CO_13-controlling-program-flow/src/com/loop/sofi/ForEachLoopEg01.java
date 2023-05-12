package com.loop.sofi;

//Demo :: ForEach Loop
public class ForEachLoopEg01 {

    public static void main(String[] args) {

        float[] vals = {10.0f, 20.0f, 15.0f};
        float sum = 0.0f;

        for(float val : vals){
            sum +=val;
        }
        System.out.println("Sum = " + sum);
    }
}
