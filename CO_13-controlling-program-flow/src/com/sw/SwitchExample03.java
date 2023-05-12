package com.sw;

public class SwitchExample03 {

    public static void main(String[] args) {
        Day today = Day.MON;

        switch(today){
            case SAT :
            case SUN:
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Weekdays");
                break;
        }
    }
}
