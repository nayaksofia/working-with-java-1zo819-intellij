package com.reader.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlayWithBufferedWriter {

    public static void main(String[] args) {

        Path path = Path.of("CO_10-java-io-api/files/words.txt");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path);){
            bufferedWriter.write("\n Writing to a buffered writer.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
