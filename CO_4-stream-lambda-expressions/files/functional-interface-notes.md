# Understanding Functional Interface

> A functional interface is an interface with `single abstract method`.

> In addition to the single abstract method, it may have `default` and `static` methods.

````java
@FunctionalInterface  //Using it is not required
interface Comparator<T> {
    int compare(T o1, T o2);

    default Comparator<T> reversed() {...}
    static  <...> naturalOrder() {...}
    
    boolean equals(Object obj);
}
````

````java
Example-1 : 
---------------
interface Comparator<T> {
   int compare(T o1, T o2);
}

Example-2 :
------------
interface Runnable{
   void run();
}

Example-3:
-----------------
interface FileFilter{
 boolean accept(File f);
}

Example-4:
-------------
interface ActionListener {
  void actionPerformed(ActionEvent e);
}
````
> The `@FunctionalInterface` Annotation :: Expresses that an 
> interface is intended to be used as a functional interface. 

````
@FunctionalInterface
interface ProductFilter{
 boolean test(Product product);
}
````
Common Standard Functional Interface[CSFI]
----
````
//CSFI-1 :One Input and One Output
interface Function<T, R> {
 R apply(T value);
}

//CSFT-2 : One Input and Zero Output
interface Consumer<T> {
  void accept(T value);
}

//CSFT-3 : Zero input and One Output ; Generate values 
interface Supplier<T> {
 T get();
}

//CSFT-4 : One Input and returns Boolean Output/value
interface Predicate<T>{
 boolean test(T value);
}

//CSFT-5 : Input and Output are of same type
interface UnaryOperator<T>{
 T apply(T value);
}

//Two inputs and One Output
interface BiFunction<T,U,R> {
 R apply(T v1, U v1);
 }
 
//Two inputs and No Outputs
interface BiConsumer<T, U> {
  void accept(T v1, U v2);
}

//Two inputs and return Boolean
interface BiPredicate<T, U> {
  boolean test(T v1, U v2); 
}

//Two inputs and outputs, all are of same types
interface BinaryOperator<T> {
 T apply(T v1, T v2);
 }
````
Functional Composition
---
- Functional composition is a combining function into a new function.

- And, we can do this in different ways as follows :
> Function `andThen` Function

> Function `compose` Function

> Predicate `and` Predicate
 

Specialized Standard Functional Interfaces
---
> XFunction<R>

>XToYFunction

>ToXFunction<T>

>ToXBiFunction<T, U>

>XUnaryOperator

>XPredicate

>XConsumer

>ObjXConsumer<T>

>XSupplier

>XBinaryOperator 



X, Y = Int, Long, Double  

Extra: BooleanSupplier