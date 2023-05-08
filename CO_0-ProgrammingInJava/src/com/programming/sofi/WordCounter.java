package com.programming.sofi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 Demo: Count the words from the paragraph given by the user.
 */
public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get the list of words to count
        System.out.println("Enter Words (Separate by space) :: ");
        String wordString= scanner.nextLine(); // To Read Words From The User
        String[] words = wordString.split(" "); //Split each word based on space and store it in an array

        //Get the paragraph to search
        System.out.println("Write The Paragraph :: ");
        String paragraph = scanner.nextLine(); //To Read From The User
        /*
         Split the paragraph into words using regular expressions.
         Then, exclude the punctuation marks.
         */
        String[] paragraphWords = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
        Map<String,Integer> wordCounts = new HashMap<>();

        /*
        Notes:
          We use Map<> to count how many times each word appears in the paragraph.
          In Map<>, keys are unique and values will be duplicate.
          The Map<String, Integer> specifically is a map where the keys are of type String,
          representing the words,and the values are of type Integer,
          representing the count of each word.
         */

        //Algorithm To Count Word
        for( String word : words){
            int count=0; //Initialise count
            for(String paraWord : paragraphWords){
                if(word.equalsIgnoreCase(paraWord)){
                    count++;
                }
            }
            wordCounts.put(word,count); //Used to store the count of each word in the wordCounts map
        }

        //Print the result
        System.out.println("Words counts: ");
        for (String word : words) {
            int count1 = wordCounts.get(word);  //get() method to retrieve the corresponding counts from the wordCounts map.
            System.out.println(word + " : " + count1);
        }
    }
}

/*
 Remember ::
 ------
 String[] paragraphWords = paragraph.split(""); has been modified to String[] paragraphWords = paragraph.split(" ");

 This is because the original line was splitting the paragraph into individual characters, not words.
 By changing the delimiter from an empty string to a space, the paragraph is correctly split into individual words.


 "\s+" is a regular expression pattern that matches one or more whitespace characters.
 It can be used with the split() method to split a string into an array of words separated by whitespace.


[^a-zA-Z0-9\s] is a regular expression that matches any character that is not a letter (a-z or A-Z), not a digit (0-9), and not a whitespace character (\s).
In other words, it matches any character that is not a part of a word or a space.
This regular expression is often used to remove punctuation marks or other special characters from a string
or to split a string into words by removing non-word characters.
 */
