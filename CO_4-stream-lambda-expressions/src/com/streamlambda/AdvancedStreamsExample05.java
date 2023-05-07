package com.streamlambda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Demo:: Grouping Stream Elements
public class AdvancedStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory)); //Using Method Reference > Product::getCategory

        Map<Category, List<String>> productNamesByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName,Collectors.toList())));

    //Challenge ! Can you explain exactly how this works ?
        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getPrice,Collectors.reducing(BigDecimal.ZERO,BigDecimal::add))));

    }
}
