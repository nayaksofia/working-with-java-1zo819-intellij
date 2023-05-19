# The Java Object-Oriented Approach
**Dan Geabunea**

## MO-02 Introduction to OOP: Classes and Objects 

> Our brains naturally see the world as an organized collection of various objects.

OOP
--
> **OOP** is a `programming paradigm` that organizes software around `objects`.
> In most cases , this is the most natural and pragmatic way of modelling the
> real world.  

> Course overview ::
 - Fundamental concepts of OOP
 - Abstraction, Encapsulation , Inheritance , Polymorphism 
 - Static members and classes 
 - Enumeration and nested classes

In the end of lecture we do learn; how to use OOP effectively to solve real 
business problems. 

> Configuring the Development Environment 
 - Java 11 SDK
 - Maven(3.6)
 - Intellij

> Github:: https://github.com/dangeabunea/pluralsight-java11-object-oriented-approach

Object 
--
> A software construct that models real world concepts.

> Objects should remain in control of how the outside world can use them .

**Benefits:**

- Modularity 
- Code re-use
- Information Hiding 

Class
--
> A `class` is a prototype from which objects can be created / instantiated. It contains all properties and
> methods that are common to all objects of that type.

**Example Of Class**
````java
//JetEngine.java

public class JetEngine extends Engine implements PropulsionSystem{
    //fields(state)
    String model;
    int fanSpeed;
    int maxFanSpeed;
    int thrust;
    
    
    //methods (behavior)
    void start(){}
    void stop(){}
}

````

Class Anatomy:
--
> 1. Class access modifier

> 2. Class Keyword

> 3. Class Name 

> 4. Superclass and/or interfaces 

> 5. Fields

> 6. Methods

> **Class** is are like `blueprint`. But they are kind useless, if you do not instantiate
 object from it. 

Understanding Constructors:
--
**Constructor:**
> A special method used to initialize objects from a class .  

**Constructor Properties**

> Constructors are like methods except they use the name of the class
 and have no return type. 

> A default, no-argument constructor is available even if you do not declare any.

> You can declare multiple overloaded constructors.

> They have access modifiers

**Default Constructor || Instantiate a Class :**

````java
//JetEngine.java

public class JetEngine{
    //fields(state)
    String model;
    int fanSpeed;
    int maxFanSpeed;
    int thrust;
    
    
    //methods (behavior)
    void start(){}
    void stop(){}
}

JetEngine trent = new JetEngine(); //Instantiate the class, No argument constructor
trent.start();

````

**Explicit Constructor**
````java
//JetEngine.java

public class JetEngine{
    //fields(state)
    String model;
    int fanSpeed;
    int maxFanSpeed;
    int thrust;
    
    //No argument constructor
    JetEngine(){
        
    }
    
  // Constructor taking model name as an argument    
  JetEngine(String model){
      this.model = model ;
  }
  
}

JetEngine trent = new JetEngine(); //Won't work . To work this we need to declare 
//no argument constructor in the POJO class


````

> Constructors can be overloaded and reused by other constructors. 

**Overloaded Constructor**

````java
class JetEngine {
    String model;
    int maxFanSpeed;
    
    //Parameterised constructor
    JetEngine(String model) {
        this.model = model;
    }
    
    JetEngine(String model , int maxFanSpeed){
        this(model); //needs to be the first line , Calling the constructor
        this.maxFanSpeed = maxFanSpeed;
        
    }
}

JetEngine trent = new JetEngine("Trent 800", 60000);
````

**Overloaded Constructors : Order of Execution**

````java
class JetEngine{
    
    //No argument constructor
    JetEngine(){
     System.out.println("no arg");
    }
    
    JetEngine(String model){
        this(); // Calling above non-argument constructor
        System.out.println("model");
    }
    
    JetEngine(String model, int maxFanSpeed){
        this(model); //Calling the above single argument constructor
        System.out.println("model, maxFanSpeed");
    }
}

JetEngine trent = new JetEngine("Trent 800", 6000); // Create JetEngine


/* OutPut :: 

        no arg
        model 
        model , maxFanSpeed
        
 */
````

**Private Constructors**
 > Constructor may have access modifier. 

````java

class  JetEngine{
    
    int maxFanSpeed;
    
    private  JetEngine(String model){
        this.model = model ;
    }
    
    JetEngine(String model, int maxFanSpeed){
        this(model); //needs to be the first line; argument of above constructor pass
        this.maxFanSpeed = maxFanSpeed;
    }
}
//Instantiate JetEngine

JetEngine trent = new JetEngine(" Trent 800", 60000);
````

> Overloaded constructors act like overloaded methods. 
> The compiler differentiates them by the number of arguments and their type.

**Overloaded constructor** :: Need to have different signatures; Otherwise it shows compile time errors. 

**Example**:
````java

class  JetEngine{
    
    int maxFanSpeed;
    int maxTrust;
    
    //Not valid; shows compile time error; because these constructors have 
    //same number of arguments and  same data type, and compiler get confused.  
    
    JetEngine(int maxFanSpeed){
        this.maxFanSpeed;
    }
    
    JetEngine(int maxTrust){
        this.maxTrust;
    }
    
    
}
````

**Initializer Block:**
--
> Code that is executed whenever an instance is created . 
> It has no data type, no associated name and is placed outside  any method.


**Initializer Type**
--
>**Static :** Used for initializing static fields.

>**Non-Static :** Used for initializing instance fields.

**Instance Initializer:**
--

````java

class JetEngine {
    String model;
    int maxThrust;

    {
        this.model = " ";
        System.out.println("Initializer Called");
    }
    
    JetEngine(int maxFanSpeed) {
        this.maxFanSpeed = maxFanSpeed;
    }
    
    JetEngine trent800 = new JetEngine(60000);
}
````

Instantiating Objects:
--
````java

JetEngine trent800 = new JetEngine("Trent 800", 6000);
Aircraft boeing = new Aircraft("Boeing 737");

````

1. Declaration : Associate a variable name with the object type
2. Instantiation : the 'new' keyword creates a new object 
3. Initialization : call to constructor 

** 1. Declaring a variable to refer to an Object**
````
JetEngine trent800;
````

- This notifies the compiler that you will use the variable called 
`trent 800` to refer to data who has the `JetEngine` type. 
- The value will be determined after instantiation.
- Simply declaring a reference variable does not create aan object. 

**2. Instantiating an Object**

````
JetEngine trent800 = new JetEngine("Trent 800", 6000);
````

- The `new` operator allocates memory for the 'JetEngine' object and returns
a reference to that memory location. 
- Then , it invokes the constructor. 

**Initializing an Object :**

````
JetEngine(String model, int maxFanSpeed){

this.model = model;
this.maxFanSpeed = maxFanSpeed;
}

````
- The constructor takes care of object initialization. 

**Multiple References to the Same Object**

````
JetEngine trent800 = new JetEngine("Trent 800", 6000);
JetEngine anotherTrent = trent800;

````

Destroying Objects:
--

**Garbage Collection:**
> Process that finds and deletes unused objects from the memory heap. 

> This process is completely automatic. 

> **Automatic ::** Memory is freed up automatically. 

> **Customizable ::** GC parameters are highly customizable

> **Nondeterministic ::** You have little control on the process. 

Basic GC Process:
--
> **Mark** :: identify which objects are in use and which are not.

> **Delete** :: remove unreferenced objects to free memory

> **Compact** :: optional step, compact remaining referenced objects

Organizing Classes with Packages:
--

**Package::**
> A namespace that organizes a group of related classes or interfaces. 

> You can think about packages as folders on your computer. 

> Packages help us easier to read and understand. 

**Packages Naming Conventions :**

> Packages names are written in lower case.

> Companies usually use their reverse domain name as a prefix (com.pluralsight.videocourse)

> Packages in the Java API start with java or javax 

**Example::**
````java
package com.aircraftfactory.logistics;

// Use import key word followed by class name or  package name to import here . 
import java.time.LocalDateTime; // importing other class
import  com.aircraftfactory.shipping; //importing other package

public  class Planner {
    //Code goes here 
}
````

Demo :: Defining and Instantiating Classes 
---
- Define a class to model a flight plan
- Add overloaded constructor
- Understand constructor execution order

> Demo is done in another directory : Use Maven

> Path: C:\Users\nayak\Desktop\SOFIA\CodingJourney\workspace-projects-intellij\workspace-1zo819-java-projects

> In POJO Class we have 
- fields 
- constructors
- behaviours i.e methods

Summary:
--
> OOP is a paradigm that organizes software around objects. 
> Most times it is the most efficient way of modelling complex business needs.

> Classes are a blueprint, from which multiple objects can be 
> instantiated.

> Constructors are a special method that allows us to initialize objects.
> A class can have many constructors. Ans the constructors called one another using `this` keyword.

> We can also initialise fields using instance initializer. 

> Packages are namespaces that organize code based on its purpose or responsibility.

> Objects are destroyed automatically, by a process called `garbage collection`. 

# MO-3: Modelling State And Behavior

> **Variable::** Container/piece of memory that stores data value


````

String message = "Hello";

````
> Variable Definition ::
> --

- Data type
- Name
- Value

**Variable Data Type**
--
> Primitive

 - int
 - boolean
 - double

> Reference

 - String
 - objects
 - arrays

**Variable Categories**
--
> Instance variable

> Class variable

> Local variable

> Parameters 

Instance Variable::
--
````java
class JetEngine {
 
  String model; // instance variable
  int maxTrust; // instance variable
  private fanSpeed; //instance variable
  
}
JetEngine engine1 = new JetEngine("Trent 800", 60000);
JetEngine engine2 = new JetEngine("GM", 60000);
````
> Objects store their individual state in non-static fields. 

> These fields are also called instance variables because they are unique to every instance of class.

> They can have access modifier. 


````java

class  JetEngine {
    
    String model; //instance variable
    int maxThrust; //instance variable
 
    void changeThrust(int value){
        
        if(value > this.maxThrust) {
            
        }
    }
}

````
> Instance variables are used only within their declaring class, usually by instance methods `Getter and Setter`. 

Class Variables
--
````java

class JetEngine {
 
    String model; //instance variable
    static int nbInstances = 0;  //class variable
    static  final int MAX_THEORETICAL_SPEED = 990 ; //constant class variable 
 
}
int enginesCreated = JetEngine.nbInstances;

````
> Fields defined with the `static` modifier.

> Class variable are unique to the class, rather than the instance. 
> One copy of the class variable, regardless of how many instances we create. 

> Static variable use the `name of the class ` followed by the `variable name`.

> We can also add the 'final' modifier to indicate that `the value of the field will not change`. 

**Both Instance variable and class variables can also be called `fields`.**
--

Local Variables:
--

````java

//Method land
void land(){
    
    boolean isLandingGearDeployed = this.systems.landingGear.status; //local variable
   
    if(!isLandingGearDeployed){
        this.systems.displayAlert("Enable Landing Gear");
    }
}
````

> Methods store their state in local variables, `defined in the body of the method`.

> Only visible to the methods that declare them .

Parameters:
--
````java

void moveFlaps(double degrees){

    //implementation
        
}

aircraft.moveFlaps(25.9);
````
> Parameters are variables declared in the signature of methods.

> Their value is provided by the calling code. 

Variable Naming Conventions:
----------

> Case sensitive (maxSpeed is not equal to maxspeed)

> Must start with a letter , $ or _

> The rest of the characters can be letters, digits, $ or _

> If the name is made up of more words use camel case (currentThrust)

> Use nouns always.

**Always try to give your `variable meaningful names` that can be easily
understood by other humans.**

Methods:
--

> A block of code that runs when it is invoked. 

**Example:**

````java

class Aircraft{
    //method
    void land(){
        
        if(this.systems.landingGear.deployed){
            this.systems.alerts.show("Drop landing gear");
        }
        
        //Implementation details
    }
}

//Method is executed when called
Aircraft a = new Aircraft(); //Instantiate object a of class Aircraft
a.land();


````

Method Declaration:: [Six Parts]
--



