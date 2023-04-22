package com.arraycollection;


import java.util.*;
import java.util.stream.Collectors;

public class ListMain {
    public static void main(String... args) {  //This type of main method is also correct

        //Demo-1: Intro To ArrayList; Different Ways To ArrayList Declarations

        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList(100);
        ArrayList arrayList2 = new ArrayList(arrayList1);

        ArrayList<String> colors = new ArrayList<String>();

        List arrayList3 = new ArrayList();
        Collection arrayList4 = new ArrayList();

        // ArrayList arrayList5 = new Collection<>();  //----> This shows error, because Collection is in higher Order i.e interface

        // Demo-2 : Using the ArrayList

       /*
         Note : ArrayList can Add Elements using it's add() methods
        */

        colors.add("red");
        colors.add("yellow");
        colors.add("blue");
        colors.add(1,"orange");

        //For Loop Type-1 : To retrieve elements at the index position of our List
        for (int i=0; i<colors.size();i++){
            System.out.println(colors.get(i));
            /*
             Note: We use get() method to retrieve elements at the index position on our lists.
             */
        }

        //For Loop Type-2 : To retrieve elements at the index position of our List
        for (String color: colors){
            System.out.println(color);
        }

        //For Loop Type-3 : To retrieve elements on the index position of our List

        colors.forEach(color -> System.out.println(color));

        /*
         To Remove the Element
         */
        colors.remove("orange");
        colors.remove(0);

        colors.forEach(color -> System.out.println(color)); //Iterate i.e for loop

        for (int i=0; i<colors.size();i++){
            colors.remove(i);
        }
        System.out.println(colors);

        // for(String color : colors){
        //    colors.remove(color);
        // }

        /*
            Note :: Therefore it is not best practice to use remove() method inside the for loop.
         */

        // Demo-3 : Array to ArrayList and Back

        Object[] colorObjArray = colors.toArray(); //Returns All Of the Color Back As A Basic of Object Types
        String[] colorArray = colors.toArray(new String[0]);

        String[] shapes = new String[] {"square","circle","triangle"};
        List shapeList = Arrays.asList(shapes);
        System.out.println(shapeList);
        System.out.println(shapeList.getClass().getName());
        System.out.println(colors.getClass().getName());

        // Another way to create ArrayList

        List shapeList1 = List.of(shapes); //can't be change at all

        // shapeList1.add("rectangle");


         /*
             Note: Arrays are outer class and ArrayList are the Inner Class.
          */

        List<String> shapeList2 = new ArrayList<>();
        for(String shape : shapes){
            shapeList2.add(shape);
        }
        System.out.println(shapeList2);

        Object[] shapes2 = shapeList2.toArray();

        // Demo : The LinkedList

        /*   Note ::
                LinkedList is a type of Link from one element to element similar to a chain.
                LinkedList data collection implements List Interface same as ArrayList;
                But also, it implements Queue Interface.
                The List Sec. of the LinkedList is very similar to the ArrayList and perform all of the same
                function.
         */

        LinkedList<String> orders = new LinkedList<>();
        orders.add("Order-1");
        orders.add("Order-2");
        orders.add("Order-3");
        System.out.println(orders);
        orders.addFirst("Order-4");
        orders.addLast("Order-5");
        System.out.println(orders);
        orders.removeFirst();  //Queue functionality
        orders.removeLast();
        System.out.println(orders);

        // Demo : The Sorting Lists

      /* Notes:: To Remember
        - Collections and Collection both are different.
        - Collections having s is a Helper Class for Collection Interface.
        - Collection is a parent interface for all our collection types.
        - Both are inside the java.util.*; package .
        - Collections.sort() : Helper class to sort the list of elements
        - Sorting Algorithm : Comparable and Comparator
       */

        List numberList = new ArrayList();
        numberList.add(10);
        numberList.add(20);
        numberList.add(2);
        numberList.add(21);
        numberList.add(9);
        numberList.add(6);
        numberList.add(3);
        numberList.add(16);

        System.out.println("Before Sorting :: " + numberList);
        Collections.sort(numberList); //Collections is the Helper Class. It is not the Collection, which is parent interface.
        System.out.println("After Sorting :: " + numberList);

        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Everest", 8848));
        mountains.add(new Mountain("Matterhorn", 4478));
        mountains.add(new Mountain("K2",8611));

        Collections.sort(mountains);
        System.out.println(mountains.stream()
                .map(Mountain::getName)
                .collect(Collectors.toList()));

        // Uses of Comparator

        Comparator<Mountain> mountainComparator = new Comparator<Mountain>() {
            @Override
            public int compare(Mountain o1, Mountain o2) {
                return o2.getHeight()-o1.getHeight();
            }
        };

        Collections.sort(mountains,mountainComparator);
        System.out.println(mountains.stream()
                .map(Mountain::getName)
                .collect(Collectors.toList()));

        //Lambda Expression
        Comparator<Mountain>  mountainComparator1 = (m1, m2) ->
                m2.getHeight() - m1.getHeight();


    }
}
