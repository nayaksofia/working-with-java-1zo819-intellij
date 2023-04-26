package com.streamlambda;

import java.math.BigDecimal;
import java.util.List;

/*
 TODO :: Go through the product list and print the products that are less than some upper limit.
 */
public class LambadasExample02 {

    static  void printProducts(List<Product> products, BigDecimal priceLimit){
        for (Product product : products){
            if(product.getPrice().compareTo(priceLimit)< 0){
                System.out.println(product);
            }
        }
    }
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        printProducts(products, priceLimit);
    }
}
