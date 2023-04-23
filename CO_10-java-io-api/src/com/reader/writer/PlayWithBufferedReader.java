package com.reader.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PlayWithBufferedReader {


    public static void main(String[] args) {

        Path path = Path.of("CO_10-java-io-api/files/demo-file.txt");
        try(BufferedReader bufferedReader = Files.newBufferedReader(path);){

            //Stream API
            Stream<String> lines = bufferedReader.lines();
            lines.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
