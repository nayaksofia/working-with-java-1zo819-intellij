package com.streamlambda;

import java.util.List;
import java.util.Comparator;

public class LambadasExample01 {

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();

        //Type-2 :: Using lambda expression
        products.sort((o1,o2)-> o1.getPrice().compareTo(o2.getPrice()));

        for(Product product : products){
            System.out.println(product);
        }

    }
}

/*
 Note:
         //Type-1 : Sorting - Normal Method
          products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
 */