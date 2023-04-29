package com.streamlambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Demo:  How to obtain streams from source i.e a Collections and Arrays ?
 */
public class BasicStreamsExample02 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Stream<Product> stream1 = products.stream();

        String[] array = new String[]{"one","two","three"};
        Stream<String> stream2 = Arrays.stream(array);

        Stream<String> stream3 = Stream.of("one", "two" ,"three");

        Stream<String> stream4 = Stream.ofNullable("four");

        Stream<?> stream5 = Stream.empty();

        //Start is inclusive , end is exclusive
        IntStream dice = new Random().ints(1,7);

        try(BufferedReader in = new BufferedReader(new FileReader("README.md", StandardCharsets.UTF_8))){
            in.lines().forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
