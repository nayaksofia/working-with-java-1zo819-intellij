package com.reader.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class PlayWithWriter {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("CO_10-java-io-api/files/words.txt");){
          writer.write("Hello World !!!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

/*
  Writer is an abstract class extended by three subclasses like FileWriter etc.
 */