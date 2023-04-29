package com.streamlambda;

import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        List<String> foodProductNames = products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .map(Product::getName) //transform by name
                .collect(Collectors.toList());
        System.out.println(foodProductNames);

        String categories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .map(Category::name)
                .collect(Collectors.joining(";"));
        System.out.println(categories);
    }
}
