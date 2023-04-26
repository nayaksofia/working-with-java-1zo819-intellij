package com.streamlambda;

import java.math.BigDecimal;
import java.util.List;

/*
 TODO :: Go through the product list and print the products that are less than some upper limit.
       - Introducing Lambda Expression .
 */
public class LambadasExample03 {

    //Add an Interface i.e a functional interface having accept method
    interface ProductFilter{
        boolean accept(Product product);
    }
    static  void printProducts(List<Product> products, ProductFilter filter){
        for (Product product : products){
            if(filter.accept(product)){
                System.out.println(product);
            }
        }
    }
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

       //Local Variable : priceLimit
       BigDecimal priceLimit = new BigDecimal("5.00");

       /*
         - Capturing local variable priceLimit here in lambda expression.

         Things To Remember::
         -------------------
         - Captured local variables must be final or effectively final .
        */
       ProductFilter filter = product -> product.getPrice().compareTo(priceLimit)<0;

        printProducts(products, filter);
    }
}
