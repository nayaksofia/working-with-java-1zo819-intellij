package com.console;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


//Relearn and ReRun . I can not understand console.
public class PlayWithConsole {

    public static void main(String[] args) {

        Console console = System.console();

        PrintWriter writer = console.writer();
        writer.println("What is your name ?");

        String name = console.readLine();
        writer.printf("Hello " + name);

        writer.printf("What is your password %s?", name);

        char[] chars = console.readPassword();
        String password = new String(chars);
        writer.printf("%s is an easy password to guess !", password);
        writer.printf("What are your favourite color %s? ", name);
        String colors = console.readLine();

       // Reader reader = console.reader();
        // PrintWriter writer1= console.writer();

        List<String> providedColors =
                                              new Scanner(colors)
                                              .useDelimiter("")
                                              .tokens()
                                              .collect(Collectors.toList());
        writer.println(providedColors);


    }

}
