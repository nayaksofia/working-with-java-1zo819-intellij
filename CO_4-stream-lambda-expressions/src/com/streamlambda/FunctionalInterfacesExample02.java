package com.streamlambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionalInterfacesExample02 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products){
            productsByCategory.computeIfAbsent(product.getCategory(),c -> new ArrayList<>()).add(product);
        }

        productsByCategory.forEach(((category, ps) ->{
            System.out.println("Category: " + category);
            ps.forEach(product -> System.out.println("-" + product.getName()));
        } ));
    }
}
