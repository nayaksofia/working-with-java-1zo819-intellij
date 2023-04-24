package com.inputoutput.stream;

import java.io.*;

public class PlayWithInputStream {

    public static void main(String[] args) throws FileNotFoundException {

        byte[] header = {0xC,0xB,0xA,0xF,0xE,0xA,0xB,0xE};


        try(OutputStream os = new FileOutputStream("CO_10-java-io-api/files/data.bin");){
            os.write(header);
        }catch(IOException e){
            e.printStackTrace();
        }

        try(InputStream is = new FileInputStream("CO_10-java-io-api/files/data.bin");){

            byte[] allBytes = is.readAllBytes();
            for(byte allByte : allBytes){
                System.out.printf("0x%x ",allByte);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
