package com.arraycollection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {
    public static void main(String... args) {

        //Four different ways of declaration
        HashMap countries = new HashMap();  //Type-1 : Declared without generic types
        HashMap<Integer, String> countries1 = new HashMap<>(); //Type-2 : Declared with generic types : Integer(First type is the Key) and String(Second Type is the Value)

        Map languages = new HashMap(); //Type-3 : Use Map Interface i.e the Parent Interface to hold variable
        Map<String, String> languages1 = new HashMap<>(); //Type-4: Map Interface to hold variable using Generic Types

        //To Add We Use Here put() method.
        countries1.put(840, "USA"); //First Parameter is the Key . Second Parameter is the value.
        countries1.put(484, "MEX");
        countries1.put(124, "CAN");

        System.out.println(countries1);

        //To retrieve value we use get() method and provide the key value there .

        System.out.println(countries1.get(840));

        //To remove we use remove method
        countries1.remove(840);
        System.out.println(countries1);

        //Key values are unique. Can't be duplicated. Which is exactly the definition of a Set.But values can be duplicated.

        countries1.keySet(); //keySet() :: This returns all of the keys in your Map
        System.out.println(countries1.keySet().toString()); //To printout the keySets


        /*
          Q. What happens if we put same key values twice in a map ?
          Ans. It will overwrite the second value in the same key.
         */

        countries1.put(124, "CAN");
        countries1.put(124, "ABC");
        System.out.println(countries1);

        countries1.values(); //values can be duplicated by using different key.


        countries1.containsKey(840); //Shows output :: True or False
        countries1.containsValue("USA"); //Shows output :: True or False

        countries1.put(-1, null);
        countries1.put(null, null);

        //*****************************Tree Map***************************************************

        TreeMap<Integer, String> planets = new TreeMap<>(); //Key as Integer and Value as a String
        Map<String, String> englishSpanish = new TreeMap<>();

        planets.put(3, "Earth");
        planets.put(2, "Venus");
        planets.put(4, "Mars");

        //Autoboxing- Primitive <-> Wrapper Class
        planets.put(Integer.valueOf(3), "Earth");

        englishSpanish.put("dog", "perro");
        englishSpanish.put("cat", "gato");
        englishSpanish.put("fish", "pez");

        System.out.println("");

        //Returns all the keys
        System.out.println(planets.keySet().toString()); //In TreeMap Returns in sorted order
        System.out.println(englishSpanish.keySet().toString()); //In TreeMap Returns in sorted order

        planets.put(20, null); //Value should be null
        //planets.put(null,null); //Key should not be null in TreeMap. It shows exception :: NullPointerException

    }
}
