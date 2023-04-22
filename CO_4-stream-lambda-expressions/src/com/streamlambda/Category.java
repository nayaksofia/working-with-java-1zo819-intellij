package com.streamlambda;

public enum Category {
    FOOD,
    UTENSILS,
    CLEANING,
    OFFICE
}


/* Notes::
 enum :: [Source:: w3schools.com ]
  -> An enum is a special "class" that represents a group of constants(unchangeable variables, like final variables)
  -> To create an enum , use enum keyword (instead of class or interface)
  -> In enum, separate the constants with comma. Note that they should be in uppercase letters.

  Difference between Enums and Classes ::
  -> An enum can, just like a class, have attributes and methods. The only difference is that enum constants are
    public, static and final. (Unchangeable- Can not be overridden) .

  -> An enum can not be used to create objects, and it can not extend other classes(But it can implement interfaces).

  Why and when to use enum ?
  -> Use enum when you have values that you know are not going to change, like month days,colors etc..
 */
