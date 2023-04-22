package com.arraycollection;

//Demo :: Defining a Generic Class

/*
 Notes :
  <> ---> Known as Dimond Syntax. Used to represent Generic Type.
  When we are not sure what type of objects we are going to use, at that scenario we use Generic type.
  Here we use <T> in Widget Class.

  Generic Naming Convention:
  ----------------------------
  E -> Element (Used Extensively By The Java Collections Framework)
  K -> Key
  T -> Type
  V -> value
  S, U, V and so on -> Second , third , and fourth types

  > Map is a stand-alone interface.
  > Map has two generic type <K, V>

  - How generics works in methods ?
 */

public class Widget<T> {

    public static void main(String... args) {

        //Declare and instantiate our new Generic Class object
        Widget<String> widget = new Widget<>(); // Widget declaration
        widget.setType("Hello");

        //Few more valid declaration
        Widget widget1 = new Widget<>(); //It consider as Object Type and Valid one.
        Widget widget2 = new Widget();

        String [] strings = new String[] {"Hi", "There"}; //New Primitive String Array
        System.out.println(Widget.firstArrayElement(strings));
    }

    private T type;

    //Generate Getter and Setter.
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    //Demo :: Defining a Generic Method

    public static <T> T firstArrayElement(T[] t){
        //if there is a first Element return it
        if(t.length > 0){
            return t[0];
        }

        //otherwise return null
        return null;
    }


}
