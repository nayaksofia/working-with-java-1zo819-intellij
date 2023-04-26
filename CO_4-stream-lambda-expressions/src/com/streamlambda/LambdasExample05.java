package com.streamlambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LambdasExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        BigDecimal priceLimit = new BigDecimal("5.00");

        List<Product> cheapProducts = new ArrayList<>();
        //Apply lambda expression here
        products.parallelStream().forEach(product -> {
            if(product.getPrice().compareTo(priceLimit)<0){
                cheapProducts.add(product);
            }
        });

        //Avoid side-effect in lambda expressions
        cheapProducts.forEach(System.out::println);
    }
}
