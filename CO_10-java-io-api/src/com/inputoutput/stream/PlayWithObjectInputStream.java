package com.inputoutput.stream;

import com.inputoutput.stream.model.User;

import java.io.*;

public class PlayWithObjectInputStream {

    public static void main(String[] args) {

        //Read :: To Read the content we use ObjectInputStream() or BytesInputStream()
        try(FileInputStream fis = new FileInputStream("CO_10-java-io-api/files/users.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);){

            Object o1  = ois.readObject();
            Object o2  =  ois.readObject();

            System.out.println("Paul = " + o1);
            System.out.println("Ambit = " + o2);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
