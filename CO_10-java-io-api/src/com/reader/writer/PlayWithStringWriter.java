package com.reader.writer;

import java.io.IOException;
import java.io.StringWriter;

public class PlayWithStringWriter {
    public static void main(String[] args) {
        try(StringWriter stringWriter = new StringWriter();){

            stringWriter.write("\n Hello Universe!!!!\n");

            stringWriter.flush();
            StringBuffer buffer = stringWriter.getBuffer();
            String string = stringWriter.toString();
            System.out.println("string = " + string);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

/*
 String Class is immutable.
 */