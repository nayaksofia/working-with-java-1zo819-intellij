package com.inputoutput.stream;

import com.inputoutput.stream.model.User; //Import the POJO Class :: User

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlayWithObjectStream {

    public static void main(String[] args) {

        //Instantiate different  objects Using the POJO Class
        User u1 = new User("Paul", 23);
        User u2 = new User("Ambit",25);

        //Write :: If we wanted to write it in ObjectOutPutStream() or ByteArrayOutputStream()

        try(FileOutputStream fos = new FileOutputStream("CO_10-java-io-api/files/users.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);){
           oos.writeObject(u1);
           oos.writeObject(u2);
        }catch(IOException e){
           e.printStackTrace();
        }

    }
}
