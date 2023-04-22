package com.reader.writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PlayWithReader {
    public static void main(String[] args) {
        try{
            Reader reader = new FileReader("CO_10-java-io-api/files/demo-file.txt");

            char[] buf = new char[16];
            int read = reader.read(buf);
            StringBuilder sb = new StringBuilder();
            //StringBuilder helps to store characters when we do not know how many characters are there.

           while(read>0){

               sb.append(buf,0,read);
               read = reader.read(buf);

           }
            System.out.println("sb = \n" + sb);
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

