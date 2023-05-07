# Working with Streams- The Basics

What is a Stream ?
--
> Ans. The purpose of stream is to process sequence of elements by executing different kinds of operations on the elements.

For Example-1: 

````java
 /* You hava a stream of products.
   - You want to filter out the products FOOD
   - Then you want to convert each product to just it's name.
   - Then you want to print the products name.       
  */

 products.stream()
         .filter(product->product.getCategory() == Category.FOOD)
         .map(Product::getName)
         .forEach(System.out::println);
````   
>This is the `chain of methods call`. 
And this chain of methods call is known as `the stream pipeline`.

> The Stream is an `Object` that implements interface `java.util.stream` 

> `interface java.util.stream.Stream`  :: Package

There are two kinds of operations in the pipeline.

> 1. `Intermediate Operation` :: Intermediate operations are the operations in the middle; such as .filter() and .map()

> 2. `Terminal Operations` :: Terminal operations are the very last operations in the pipeline such as .forEach() 

`Important To Know` :
--
> Stream processing is `lazy`. This means the stream does not produce elements and does not
> perform any intermediate operations unless there is a terminal operation attached to it that
> consumes these elements.

# Difference between Streams and Collections
| Stream                              | Collections                       |
|-------------------------------------|-----------------------------------|
| Does not store elements.            | Stores elements in data structure |
| Lazy evaluation [ stream.sorted() ] | Eager evaluation [list.sort()]    |
| Functional Programming              | Imperative Programming            |
| Does not modify its source          | Do modify the collection          |
| Iterating consumes the stream       | Can be iterated multiple times    |
| May be infinite                     | Never infinite                    |
|                                     |                                   |

# Internal vs. External Iteration


External Iteration: Iteration Over Collections
---------
In external iteration, how the iteration is done ,not control by the collection itself, but
it depends on the programmer, who write the for-loop. 

External iteration is a `low level of abstraction`, because we have to provide
a lot of details. 
````java
for(int i=0; i<products.size(),i++){
    Product p = products.get(i);
    System.out.println(product);
}
````

Internal Iteration: Iteration Over Stream
---
When you iterate over a stream, you do not write a for-loop. Instead, you call a terminal operation such as `forEach`
Passing in a function that you want to apply to each of the elements. This is `internal operation`.
Because, you leave the control of the operation to the stream itself.

In Internal operation, you do not need to care about details. 
It provides the `Higher-level of abstraction` , also provides `optimization`.

Later, you will see how internal operation helps to use `Parallel Stream` very easy.
````java
 products.stream()
        .forEach(System.out :: println);
````

> Searching in Streams::

Find a particular element:
---
````java
filter(...)
findFirst()  (or) findAny()

````
Check if elements exist:
----
````java
anyMatch()
allMatch()
noneMatch()

````
Short-circuiting
---
Some of the search operations are short-circuiting; that means they will stop
and return an answer as soon as possible.

For Example:
> findFirst() and findAny() will stop iterating through the stream as soon as
> they find the element.Likewise, anyMatch() stop matching as soon as it find it's element.

Not short-circuiting:
---
>allMatch() and noneMatch() are not short-circuiting. 

Summary:-
--
> Stream Concepts
 - Stream pipeline
 - Intermediate and Terminal Operations

> Difference between `streams` and `collections`

 - Imperative vs functional programming
 - External vs internal iteration
> Working with streams
 - map and flatMap
 - Searching in streams
 - Collecting streams



# MO-4 : Working with Streams in Depth 

1. Generating and Building Streams:
2. Reducing Streams in Details
3. Collecting Streams in Detail

  

Collecting Streams:
--
> Collection = Mutable reduction

> A collection operation reduces a stream into a mutable result container.

Collection and Reduction
--

````
<R> R collect(Supplier<R> supplier, BiConsumer <R, ? super T> accumulator, biConsumer<R,R> combiner)

//Collection is for Mutable reduction
````

````
<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) 

//Reduction is for Immutable Reduction 
````

Working with Collectors
--

Stream ---> Accumulator,
            Supplier,
            Combiner,
            Finisher ----> Result


<R, A> R collect(Collector<? super T, A, R> collector)

>Collectors contains factory methods:

 - toList()
 - toSet()
 - toMap()
 - ........


Grouping Stream Elements
--

Partitioning Stream Elements
--

Parallel Streams:
--
To get a Parallel Stream instead of calling `stream()` in a collection , you do call `parallelStream()` 


````
//Sequential Stream
List<String> names = products.stream()
          .filter(product->product.getCategory() == Category.FOOD)
          .map(Product::getName) //Method Reference
          .collect(Collectors.toList());


//Parallel Stream
List<String> names = products.parallelStream()
          .filter(product->product.getCategory() == Category.FOOD)
          .map(Product::getName) //Method Reference
          .collect(Collectors.toList());
          
//External Iteration

for(int i=0; i < products.size() ; i++) {

   Product p = products.get(i);
   System.out.println(product);
   
}

//Internal Iteration
products.parallelStream()
        .forEach(System.out::println);


//Grouping-By in Streams
Map<Category, List<Product>> productsByCategory = 
     products.stream().collect(
     Collectors.groupingBy(Product::getCategory));
     

//Grouping-By in Parallel Streams :: Unorder collector
Map<Category, List<Product>> productsByCategory = 
     products.parallelStream().collect(
     Collectors.groupingByConcurrent(Product::getCategory));
 
````

Specialized Streams
--

> IntStream

> LongStream

> DoubleStream

Summary:
--
> Working with Lambda Expressions
- A lambda expression is an anonymous method.
- A lambda expression implements functional interface
- A functional interface has a single abstract method.

> Method References
 - Use a method reference `instead of a lambda expression`.
 - A method reference implements a `functional interface`.
 - Refers to a `static` or `non-static method` or a `constructor`.

Functional Interface
````
@FunctionalInterface
interface ProductFilter{
   boolean test(Product product);
}
````
----
> Lambda Expression

> Functional Intrface 

> Method Reference

> Streams

> Stream Operations

> Reduction and Collection

> Collectors

> Grouping and Partitioning

> Parallel Streams