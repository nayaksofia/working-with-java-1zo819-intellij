package com.reader.writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//Another way to close the Reader
public class ReaderClose {
    public static void main(String[] args) {
        try( Reader reader = new FileReader("CO_10-java-io-api/files/demo-file.txt");){

            char[] buf = new char[16];
            int read = reader.read(buf);
            StringBuilder sb = new StringBuilder();

            while(read>0){

                sb.append(buf,0,read);
                read = reader.read(buf);

            }
            System.out.println("sb = \n" + sb);
            // reader.close(); :: Not required to use close method here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
