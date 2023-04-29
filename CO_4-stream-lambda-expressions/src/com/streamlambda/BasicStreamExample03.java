package com.streamlambda;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


//Demo :: Few Operations In Stream Like Filtering and Transforming
public class BasicStreamExample03 {

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();

        //Filtering Element
        products.stream()
                .filter(product -> product.getCategory() == Category.FOOD) //Intermediate Operation
                .forEach(System.out::println);  //Terminal Operation

        //Map method :: Transforming each element into stream.
        products.stream()
                .map(product -> String.format("The price of %s is $ %.2f",product.getName(),product.getPrice()))
                .forEach(System.out::println); //Terminal Operation



        //Demo :: flatMap() Method
        Pattern spaces = Pattern.compile("\\s+");
        products.stream()
                .flatMap(product -> spaces.splitAsStream(product.getName()))
                .forEach(System.out::println);

        Stream<String> stream = products.stream()
                .flatMap(product -> spaces.splitAsStream(product.getName()));

        /*
          Important To Remember:
          --------------------------
          1. map() --> Perform one to one transformation that means, for each input element there is one output element.
          2. flatmap()----> Perform one to many transformation that means, for each input element there is more than one
          output elements i.e. stream of values (or) no output element.

         */

    }

}
