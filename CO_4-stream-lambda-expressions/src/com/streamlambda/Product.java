package com.streamlambda;

import java.math.BigDecimal;
import java.util.Objects;

//POJO Class :: Product
public class Product {

    private final Category category;
    private final String name;
    private final BigDecimal price;

    //Generate Parameterised Constructor


    public Product(Category category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    //Generate Getter
    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //toString() Method
    @Override
    public String toString(){
        return String.format("%-10s %-16s $ %6.2f",category,name,price);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(category, product.category) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);


    }
}
