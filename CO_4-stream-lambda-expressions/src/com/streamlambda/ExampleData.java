package com.streamlambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ExampleData {

    public static List<Product> getProducts(){
        return Arrays.asList(
                new Product(Category.FOOD,"Orange",new BigDecimal("1.65")),
                new Product(Category.FOOD,"Potato",new BigDecimal("2.65")),
                new Product(Category.FOOD,"GarudaCheese",new BigDecimal("6.65")),
                new Product(Category.UTENSILS,"Plates",new BigDecimal("12.65")),
                new Product(Category.CLEANING,"Detergent",new BigDecimal("3.78")),
                new Product(Category.OFFICE,"Pencils",new BigDecimal("3.65")),
                new Product(Category.FOOD,"Rice",new BigDecimal("5.65")),
                new Product(Category.CLEANING,"Scourer",new BigDecimal("2.29")),
                new Product(Category.FOOD,"Milk",new BigDecimal("1.39")),
                new Product(Category.OFFICE,"Notebook",new BigDecimal("4.99"))


        );
    }

}
