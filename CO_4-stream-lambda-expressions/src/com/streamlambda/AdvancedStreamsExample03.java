package com.streamlambda;


import java.util.ArrayList;
import java.util.List;

// Difference between reduce() and collect()
public class AdvancedStreamsExample03 {

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();

        List<String> productNames1 = products.stream().reduce(
                new ArrayList<>(),
                (list,product)-> {
                    ArrayList<String> newList = new ArrayList<>(list);
                    newList.add(product.getName());
                    return newList;
                },

                (list1,list2)->{
                    ArrayList<String> newList = new ArrayList<>(list1);
                    newList.addAll(list2);
                    return newList;
                }
        );

        List<String>productName2 = products.stream().collect(
                ArrayList::new,
                (list, product) -> list.add(product.getName()),
                ArrayList::addAll
        );

    }

}
