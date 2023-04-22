package com.arraycollection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
    public static void main(String... args) {
        Set<Integer> primeNumber1 = new HashSet<>();
        Set<Integer> primeNumber2 = new TreeSet<>();

        primeNumber1.add(71);
        primeNumber1.add(61);
        primeNumber1.add(51);
        primeNumber1.add(41);
        primeNumber1.add(31);
        primeNumber1.add(1);


        primeNumber2.add(71);
        primeNumber2.add(61);
        primeNumber2.add(51);
        primeNumber2.add(41);
        primeNumber2.add(31);
        primeNumber2.add(1);

        System.out.println("HashSet ::");
        primeNumber1.forEach(System.out :: println);
        System.out.println("");
        System.out.println("TreeSet :: ");
        primeNumber2.forEach(System.out :: println);

        /* Notes: Difference between HashSet and TreeSet
           > TreeSet order the elements as they are added to the Set. But HashSet do not.
         */

        System.out.println(primeNumber1.add(5));
        System.out.println(primeNumber1.add(5));

        primeNumber1.remove(5);
        System.out.println(primeNumber1.isEmpty());
        System.out.println(primeNumber1.size());
    }

}
