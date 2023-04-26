package com.streamlambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
  Demo :: Method References
 */
public class LambdasExample07 {

    interface ProductFactory{
        Product create(Category category,String name, BigDecimal price);
    }
    static boolean isExpensive(Product product){

        return product.getPrice().compareTo(new BigDecimal("5.00")) >=0 ;
    }
    public static void main(String[] args) {

       // List<Product> products = ExampleData.getProducts();
        List<Product> products = new ArrayList<>(ExampleData.getProducts());

   //Four Types Of Method References
        products.removeIf(LambdasExample07:: isExpensive); //Method Reference : Type-1
        products.forEach(System.out:: println); //Method Reference : Type-2
        products.stream().map(Product:: getName).forEach(System.out::println); //Method Reference : Type-3

        ProductFactory factory = Product::new;
        Product blueberries = factory.create(Category.FOOD,"Blueberries",new BigDecimal("6.95")); //Method Reference : Type-4
    }
}

/*
  Four Types Of Method References::
  --------------------------------------
  ClassName :: methodName     ----> Static Method
  objectRef :: methodName     ----> Instance method of a specific object
  ClassName :: methodName     ----> Instance method not of a specific object
  ClassName :: new            ----> Constructor
 */

/*
 Q:: Why UnsupportedOperationException ?
 ------------------------------------------------
 Ans:: The exception is thrown at line 23, which is products.removeIf(LambdasExample07::isExpensive);.
  The removeIf() method is called on the products list and it is trying to remove elements using a lambda
  expression, which is LambdasExample07::isExpensive.

  The reason for the exception is that the List returned by ExampleData.getProducts() is an
  unmodifiable list. This means that the removeIf() method cannot modify the list and therefore
  throws an UnsupportedOperationException.

  Q. How to fix this?
  Ans. To fix this, you need to create a new list and add all the products
  from ExampleData.getProducts() to the new list, like this:

  List<Product> products = new ArrayList<>(ExampleData.getProducts());

  This will create a new 'ArrayList' containing all the products from `ExampleData.getProducts()`
  and  the `removeIf()` method can be safely used on this new list.
 */