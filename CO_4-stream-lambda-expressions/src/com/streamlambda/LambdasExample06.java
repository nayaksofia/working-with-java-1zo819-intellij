package com.streamlambda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LambdasExample06 {
    public static void main(String[] args) throws IOException {
        List<Product> products = ExampleData.getProducts();

        /* // Type-1 :: Use of simple for loop
         try(FileWriter writer = new FileWriter("CO_4-stream-lambda-expressions/files/products.txt");){
         for(Product product : products){
             writer.write(product.toString() + "\n");
         }
       }catch (IOException e){
           System.err.println("An exception occurred: " +e.getMessage());
       }

         */

      //Type-2 :: Use of lambda expression by calling forEach()

        try(FileWriter writer = new FileWriter("CO_4-stream-lambda-expressions/files/products.txt");){
          products.forEach(product -> {
              try{
                  writer.write(product.toString() + "\n");
              }catch(IOException e){
                  throw new RuntimeException();
              }
          });
        }catch(IOException | RuntimeException e){
            System.err.println("An exception occurred: " + e.getMessage());
        }
    }
}

/*
 To Remember ::
  Sometimes simple for-loop is better to use then calling forEach() using lambda Expression.
 */