package com.streamlambda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
  Demo:: To calculate total price of product per categories. Result will be Map()
 */
public class AdvancedStreamsExample04 {
    public static void main(String[] args) {
        List <Product> products = ExampleData.getProducts();

        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,  //Key mapper function, Using Method Reference
                        Product::getPrice,    //Value mapper function, Using Method Reference
                        BigDecimal::add ));   //Merge Function,Using Method Reference
        System.out.println(totalPerCategory);  //Take a printout

    }
}
