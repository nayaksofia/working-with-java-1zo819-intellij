package com.manipulating.file;

import java.io.FileWriter;
import java.io.IOException;

//Creating File Using FileWriter Class
public class PlayWithFiles {

    public static void main(String[] args) throws IOException {
        try{
            FileWriter file = new FileWriter("CO_10-java-io-api/files/demo-file.txt");
            file.write("This is the content that will be written to the file. \n" +
                    "Happy to create it :)");
            file.close();
            System.out.println("\n File Created Successfully.\n File Name :: demo-file ");
        }catch (IOException e){
            System.out.println("\nAn error occurred while creating the file " + e.getMessage());
        }


    }
}
