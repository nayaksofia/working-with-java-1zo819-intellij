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

> Example : Aircraft State(is modeled by `field`) and Behavior(is modeled by `method`)  

> Objects should remain in control of how the outside world can use them .

**Benefits:**

- Modularity 
- Code re-use
- Information Hiding 

Class
--
> A `blueprint`. 

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

> Use `nouns` always.

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
> 1. Access modifier ----------------> Optional

> 2. Return Type

> 3. Name 

> 4. Parameter List ------------------> Optional 

> 5. Exception List ------------------> Optional 

> 6. Body 

````java
//Log aircraft remaining fuel to flight data recorder 
public void logFuelCapacity(String file) throws IOException {
     Path fileName = Path.of(file);
     String content = "Remaining fuel : " + this.remainingFuel;
     Files.writeString(fileName, content);
}

````

Return Type:
--
> Methods can return a value [String, Number etc.]

> Methods can return void(nothing)
**Example:01**
````java
String readFlightDataRecoder(String file){
    //Return a String value
}

void land(){

    //return nothing
        
}
        
````
> **Method Signature** : Combination of method name and parameter list
> i.e `logFuelCapacity(String file)`

Method Overloading ::
--
> A **class** can have `multiple methods` with the `same name` if their `parameter lists
 are different`.  The differentiation is made by the `number and type of arguments.`

**Example: Method Overloading**
````java
public double calulateRange(){
    //Assume current aircraft speed and fuel consumption
}

public double calculateRange(double speed){
    //Provide speed, calculate new fuel consumption and return result
}

public double calculaterange(int speed){

    //Provide speed as an integer 
}


````

Incorrect Method Overloading:
--
````java

public double calculaterange(double speed){
 //provide speed, calculate new fuel consumption and return result     
}

public double calculateRange(double desiredConsumption){

    //Provide consumption, calculate range a 
}

/*
   Note :: It shows compile time error : Same number of arguments, 
        same type => the compiler can not tell them apart
 */
````

Method Naming Convention::
--
> Can contain any legal identifier.

> Use camel case(getData(), calculateDistance())

> First word should be a `verb` : Because method by definition always doing sth or implementing some behaviour. 

Passing Information to a Method::
--

````java
void logFuelCapacity(String file , int remaingFuel){

    Path fileName = Path.of(file);
    String content = "Remaining fuel: " + remainingFuel;
    
    try{
        Files.writeString(fileName,content);
    }catch(IOException e){
     e.printStackTrace();    
    }
}
logFuelCapacity("fuel.log",13575);
````
**Notice:**
> This method has 2 parameters.

> Parameters have names

> They are used in method body.

> The values are passed into the method when we call it. 

Name must be unique ::
--
> We can not declare a `local variable` with the `same name as a method parameter`.

> We can not reuse the same name for multiple parameters. 

**These are not correct::**
````java
public void logFuelCapacity(String file, int remainingFuel){
    int remaingFuel = 1200; //Not correct
}

public void logFuelCapacity(String file, File file ){ //Not Correct 
    
}
````

Field Shadowing::
--
> A parameter can have the same name as the field of a class.

> In this case, the parameter is said to shadow the field. 

> Remove ambiguity by using the 'this' keyword.   

**Example :**
````java
class JetEngine{
    String model;
    
    JetEngine(String model){ 
        this.model = model;
    }
}
````

Arbitrary Number of Arguments:
---
> Construct called varargs

> Use it when you do not know how many arguments of a particular type will 
 be used

> A shorthand for using an array 

**Example::**

````java
public void printRoute(String... points){
    for(String point : points){
        System.out.println(point);
    }
}

printRoute("BUC","YVAN","HEARN");
printRoute("BUC","YVAN","HEARN","CDG");
````
Passing Parameters:
--
> Passing by value

> Passing by reference

Pass Primitive Types:[Pass by Value]
--
````java
private void swap(int a, int b){

    int aux = a; a = b; b=aux;
    
}
int a = 1; 
int b= 2;
swap(a,b); //Calling the method
System.out.println(a + " ," + b);

//Result is 1, 2 
````
> Primitive types are passed by value.

> A copy of that parameter value is made in memory.

> The `caller and callee` have independent variables with `same value`.

> Changes inside the method do not affect the outer variables. 


Pass by Reference Types:[Pass by Reference]
--
````java
class Coordinate {
 double x;
 double y;
}

void offset(Coordinate c){

    c.x +=0.1;
    c.y +=0.1;
}

Coordinate c = new Coordinate(0.0, 0.0); //instantiate object of class Coordinate
offset(c);
````
> Reference data types are passed to methods by value.

> A copy of the memory location is passed into the method.

> Changes to the state of the object are persisted. 

You use the words "parameter" and "argument". Is there a difference ?
--
No, 
>**Parameters** : are variables defined in the `method declaration`

>**Arguments** : are actual values that are passes into the methods. 

**Parameter Vs. Argument**
````java
/*
   Here, a and b are parameters, a variable defined in the 
   method declaration.
 */

private void swap(int a, int b){ //parameters 
 
    int aux =a; a=b; b=aux;
    
}

//1 and 2 are arguments, they are the value passed into the method
// When method is called , parameters are assigned.         
swap(1,2); // arguments

````

The "this" keyword::
--

> `this` is the reference to the current object.

When to use "this"::
--
> Access instance field

> Call a constructor

**Example-1 :: Access Instance Field / Avoid Shadowing**
--
````java

class JetEngine {
    private int thrust;
    
    JetEngine(int thrust){
        this.thrust = thrust; //access the field 
    }
}

````

**Example-2 :: Explicit Constructor Call**
--

````java
import java.util.UUID;

class JetEngine {
 private String id;
 private String model;

 public JetEngine() {
  this.id = UUID.randomUUID().toString();
 }
 
 public JetEngine(String model){
     this(); // calling the above non-parameterised constructor 
     this.model = model;
 }
}
````
Demo::
--
> Implement state and behavior

> Model the target label . Implement commands.  

Summary::
--
> Declare and use variables in Java 

> Declare and use methods

> Method Overloading

> Passing arguments to methods

> Understand the 'this' keyword

# MO-4 : Understanding Static Fields, Methods and Classes

Static Fields:
--
> A **static** modifier means that sth is directly related to the class itself,
> not to an instance of the class.

The "static" Modifier:
--
> Static fields/Class variables

> Static methods/ Class methods

> Static initialization blocks

> Static(nested) classes

Static Fields/ Class Variables::
--
> Fields that are associated with the class. 

> Every instance of a class shares a class variables.

> Every instance of the class share class variable if accessible.  

**Example :**
````java
class JetEngine {
    String serialNumber; //Instance Variable
     public  static  int currentMode1Nb; //Static field/class variable
     
     JetEngine(){
         currentMode1Nb++;
         this.serialNumber = String.format("%08d",currentMode1Nb);
     }
}

JetEngine je1 = new JetEngine();
JetEngine je2 = new JetEngine();

System.out.println(je1.serialNumber);  //Instance field
System.out.println(je1.serialNumber); //Instance field

//Output :: 00000001 00000002

System.out.println(JetEngine.currentMode1Nb); //class name followed by the class variable name. 
````
> Use the "static" modifier.

> They are shared by all instances, so you can not access them using "this".

> Static fields can use access modifiers to limit access to their value. 

> Each constructor call increases the currentMode1Nb class variable 

> From the outside the class, you can access the static field using
 `class name, followed by the class variable name.` 

> In other way we can access `static fields`i.e using **Static Import** . Here is the example.

Accessing Static Fields :: Use Static Import 
--
**JetEngine.class**
````java

package pluralsight.oop;

public class JetEngine {
    public String serialNumber; //Instance field
    public static int currentMode1Nb; //Static field
 
   public JetEngine(){
       currentMode1Nb++;
       this.serialNumber = String.format("%08d",currentMode1Nb);
   }
}

````
**Main.java**
````java

//import pluralsight.oop.JetEngine;
//Use Static Import to access static field 
import static pluralsight.oop.JetEngine.current1Nb;

public  class  Main{
    public static void main(String[] args){
     //System.out.println(JetEngine.current1Nb); // Without use of static import
     System.out.println(current1Nb); //Here we use only static variable name; as we alrady import it. 
    }
}
````

Constants:
--

````java
public class Constant {
    public  static final int SPEED_OF_SOUND =343; //meters per sec
}

int halfSpeedOfSound = Constant.SPEED_OF_SOUND/2;
````

> You can add the `final` modifier to a static field and effectively make it conastant.

> Once a value is assigned , the field can not be assigned another value

> Constants are named using upper case and words are separared by _ (Underscore).

Static Methods/ Class Methods:
--
> Methods that can be invoked on the class , without the need to create instances of the class. 

**Static Method Example**
> Use the "static" modifier to create a static method.

> Static Method can not use `instance field`.

> Static method can not use `instance field`. 

> Static methods can use `static fields`.

> Static methods can have access modifiers.

> Usually used for utility methods.
 
*Example-1**
````java
package pluralsight.oop;

public class FuelCalculator {
    static final int AVG_LITERS_PER_SEC = 4; //Static Field 
    
 //static methods 
    public static int calculateNeed(int durationMin){ 
        int durationInSec = durationMin * 60;
        return AVG_LITERS_PER_SEC * durationInSec;
    }
}

````
> How do we invoke static method ???

Calling Static Methods :: 
--
> Type-1: Use Class Name Followed By Method Name 

> Type-2: Use Static Import with Class Name followed by method name; then you called 
> directly that method. 

**FuelCalculator.java**

````java
package pluralsight.oop;

public class FuelCalculator {
 static final int AVG_LITERS_PER_SEC = 4; //Static Field 

 //static methods 
 public static int calculateNeed(int durationMin){
     
  int durationInSec = durationMin * 60;
  return AVG_LITERS_PER_SEC * durationInSec;
  
 }
 
}

````

**Main.java**
````java
//import  pluralsight.oop.FuelCalculator;  //Type-1
import static pluralsight.oop.FuelCalculator.calculateNeed; //Type-2: use static import with class name followed by method name

public class Main{
    public static void main(String[] args){
        int twoHourFlight = 120;
        //int quantity = FuelCalculator.calculateNeed(twoHourFlight);  //When we do not use static import, we call the method with classname followed by method name 
       int quantity = calculateNeed(twoHourFlight);
         System.out.println(quantity);
    }
}

````

Static Methods Used as Utility Methods:
--
> Math.max(10,20);

> Math.sqrt(16.0);

> Character.toUpperCase('a');

> String.format("%08d",23);

> System.exit(0);

````java
public class Utils{
    public static int sum(int a, in b){ }
    public  static  void  log(String msg){}
    public static  int calculateFuel(){}
    
}

````
### Don't Create God Utility Classes

> Each utility class should have a very specific purpose

> The Single Responsibility Principle applies to these classes as well 

# Static Initialization Block

> Code block enclosed in braces and preceded by the 'static' keyword. 

> Used to initialize class variables

> They can only access class variables and methods directly. 

> A class can have multiple static blocks; they will be executed in order. 


**Example**

````java
public class JetEngine{
    public String serialNumber; //instance variable
    public static int currentMode1Nb; // static variable
    
    static {
        currentMode1Nb = 10 ;
    }
}

````

# Instance Vs. Class/Static 

| Instance Methods                                          | Class Methods                                                                                       |
|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Can access instance variables and other instance methods. | Can access class variables and other class methods                                                  |
| Can access class variables and class methods              | Can not access instance variables or methods directly, they must use an object reference to do this. |


# Static Nested Classes

````java
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class FlightDataRecorder {
    private List<Entry> entries = new ArrayList<>();

    private void log(String msg) {
        entries.add(new Entry(LocalDateTime.now(),msg));
    }
    
    private static class Entry{  //static class ; A full fledged class , but we do not want to expose it
        private LocalDateTime dateTime;
        private String log;
        
        //Parameterised Constructor
        private Entry(LocalDateTime dateTime, String log){  
            this.dateTime = dateTime;
            this.log = log;
        }
    }

}


````

Static Nested Class:
--
> A top-level class that has been nested in another to-level class for convenience. 

> A `static nested class` interacts with the instance members of its outer class just
> like any other class.

````java

import java.time.LocalDateTime;

public class FlightDataRecorder {
 public static class Entry {
  private LocaleDateTime dateTime;
  private string log;

  public Entry(LocalDateTime dateTime, String log) {
   this.dateTime = dateTime;
   this.log = log;
  }
 }
}

// Can also be exposed at package or public level; To instantiate it, you need to use the outer class name

 FlightDataRecorder.Entry e = new FlightDataRecorder.Entry(LocalDateTime.now(),"msg");

````
# Demo : Demonstrating Static Fields and Methods 

 - Creating Helper Methods

# MO-5 : Using Encapsulation and Inheritance 

> Understand access modifiers and how to use them effectively

> Encapsulation

> Implement inheritance

> Abstract classes

> Demo:: Using encapsulation and inheritance to model airspace routes

### Access Modifiers : 

> Specify if a given class or its members(fields and methods) can be accessed by other classes. 

**Two Levels Of Access Control**
>1.  **Top level(class level)** : This modifier control access to the class as whole. 

>2. **Member level** :: This modifier control access to the field or methods.

Class level Modifiers:
---
>1. **package-private(default)** :: A class is visible only to classes in the same package.

> 2. **public** :: A class is visible by the whole world 

**Member Access Modifiers:**
--
> Control access to a class fields and methods. 

> **Public** : a member is visible to all the classes everywhere

> **Protected** : a member is visible within its own package or by a subclass 
> of its class in any other package 

>**Package-private(no modifier)** :: a member is visible only within its own package

>**Private :** a member is visible only inside its own class 

**Example**

````java
import java.util.UUID;

public class FlightDataRecorder {
 private String id;
 protected List<Entry> entries = new ArrayList<>();

 public FlightDataRecorder() {
  this.id = UUID.randomUUID().toString();
 }
 
 public void log(String msg) {
     entries.add(new Entry(LocalDatetime.now(), msg));
 }
 public String getId(){
     return this.id;
 }
}
````

**Access Level Table** [Oracle Certified]


|             | Class | Package | Subclass | World |      
|-------------|-------|---------|----------|-------|
| public      | Y     | Y       | Y        | Y     |        
| protected   | Y     | Y       | Y        | N     | 
| no modifier | Y     | Y       | N        | N     |
| private     | Y     | N       | N        | N     |  

Encapsulation:
--
> Grouping data with the methods that operate on that data within a class.

Purpose of Encapsulation :
--
> Hide information : from the external world

> Hide internal workings 

**Example**
````java
public class Aircraft {
    public int altitude;
    public int speed;
}
a.altitude = 0 ;
a.speed = 0 ;

````
> **Do not Expose State** : It can be exploited to use objects in ways that they 
> were not meant to be used. 

> So we wanted to use `encapsulation` to minimize errors from misuse.

Do not expose more than necessary.
--
> Use the most restrictive access level that is suitable for your use case. 

> Only expose the minimum functionality and data needed.

> It is not a good practice to use public fields.



````java
public class Aircraft {
    private int altitude , speed;
    public void land(){
        //Gradually decrease speed and altitude safely 
    }
}
a.land(); //internal details are hidden , you only have access to public API
        
````
> It is best to use `getter and setter`.

Getter/Setters:
--

````java
public class JetEngine {
    private int altitude;
    
    //We can read the field using getter
 public int getAltitude(){
     return altitude; 
 }
 
 // We can set value using setter
 public void setAltitude(int altitude){
     if(altitude < 0 || altitude > 300  ){
       throw new IllegalArgumentException();  
     }
     this.altitude = altitude;
 }
 
}
````
Inheritance:
--
> Define new classes based on existing classes.

> A class can acquire the features and behaviors of another class and build upon them. 

> In Java a class can extend a single class. Java has not multiple inheritance.

> If a class does not explicitly extend another class ,then it implicitly extends Object. 

Basic Methods in Object Class
--
> toString()

> getClass()

> hashCode()

> equals()

> clone()

**Inheritance Example : Share Non-Private Members**
````java
public class Aircraft{
    
    private String modelId;
    
    protected inr altitude,speed;
    
    public void land(){}
 
   public void takeoff(){}
}
````

````java
public class Airplane extends Aircraft {
     //Can access all non-private members
     // from the base superclass
 
    //Add another specific field
    private String wakeTurbulence;
}
````
Subclass: 
--
> The inherited fields can be used directly.

> the inherited methods can be used directly. 

> You can create new instance fields in the subclass that do not exist in the 
> super class.

> You can create new instance methods in the subclass that do not exists in the 
> superclass. 

> You can `override` existing instance methods. 

> You can invoke the constructor of the superclass by using the `"super" keyword`. 

Method Overriding
--
>The ability of a subclass to modify an existing method. 
>The overriding method has the `same name, number and type of parameters and return type`. 

> We can apply method overriding that can only be accessible i.e `public method.`

> We can not apply method overriding to `private method`. 

**Example Of Method Overriding**
````java
//Super class/Base Class
public class Aircraft {
    public void land() {
     System.out.println("Aircraft landing");
    }
}

//Sub Class /Child Class
public class Helicopter extends Aircraft{
    @Override 
    public void land(){
      System.out.println("Helicopter landing");
    }
}

//Main method

public class Main {
 public static void main(String[] args) {
  Aircraft a = new Aircraft();
  Aircraft h = new Helicopter();

  a.land(); // Output => Aircraft landing
  h.land(); // Output => Helicopter landing 
  
 }
}
````
Overriding is a form of Polymorphism:
--
> Same concept; various implementations :: Polymorphism 

> The version of a method that gets executed is determined at runtime, by the object that is used to invoke it. 

> We can not override `final method` and `private access modifier` method . 

**Example:: Prevent Method Overriding --> Use the "final" modifier**

````java
//Super class
public class Aircraft {
 public final void land() {
  System.out.println("Aircraft landing");
 }
}


//Subclass
public class Helicopter extends Aircraft {
 //can not override final method
 //It shows compilation error

 @Override
 public void land(){
  System.out.println("Halicaptor landing");
 }
}

````

The "super" Keyword:
--
> Access superclass members

> Call superclass constructors

````java

//Super class
public class Aircraft {
    
 public void land() {
  System.out.println("Aircraft landing");
 }
}


//Subclass
public class Helicopter extends Aircraft {
 //can not override final method
 //It shows compilation error

 @Override
 public void land(){
     super.land(); //Calling the method of super class 
     System.out.println("Halicaptor landing");
 }
}

````

> `this` : Operate on the current class 

> `super` : Operates on the super class 

Call Superclass Constructors::
---

````java
//Super Class
public class Aircraft {
    
    private String model; //instance field
    
 //Parameterised constructor
    public Aircraft(String model){
        this.model = model;
    }
}

//Sub-Class
public class Airplane extends Aircraft {
    private String wakeTurbulence; //instance field
    
    //Constructor
    public Airplane(String model, String wakeTurbulence){
        
        super(model); //call base constructor
        this.wakeTurbulence = wakeTurbulence;
        
    }
}
````

Prevent Inheritance :: Use the "final" Modifier on the Class
--
````java
//Super class
public final class Aircraft{
    public void land() {
     System.out.println("Aircraft landing");
    }
}

//Sub Class; But here we can not extend final class 
public class Helicopter extends Aircraft{
    
}

````
> What if I do not want anyone to mess with my class via inheritance?

> Ans : you use `final keyword` on  the entire class . 

Abstract Classes and Methods: 
---

Abstract Class:
--
> A class that can not be instantiated. It is meant to be extended 
> and used as a baseline by more concrete classes. 

> An abstract class can also contains `Abstract Method`.

> We want `high level of abstraction`. 

> We want abstract class act as a `Blueprint for other classes.`

Abstract Method:
--
> A method that is declared without any implementation. i.e the method without body. 

> A subclass is responsible for overriding it.

Class Hierarchies:
---
> From the **Example of Aircraft** we say that, it would be very unrealistic to expect the
same landing procedure for all subclasses

> However, they need to implement this action , but in their own way.

> An abstract class can be used to define a skeleton, or baseline.

> We abstract, but we leave freedom to subclasses to come with their own behavior in a consistent way. 

Abstract Class:
--
**Example**

````java
public abstract class Aircraft {
 private int altitude;  //instance field 

 //Too complex to be abstracted
 public abstract void land(); //abstract method without body 

 //instance method 
 public int getAltitude() {
  return this.altitude;
 }
}

 //Aircraft a = new Aircraft(); //Abstract class can not be instantiated
//For that we need to extend it. 

//**Extending Abstract Classes**

public class Helicopter extends Aircraft {
    @Override
 public void land(){
        //Complex logic that handles
       // helicaptor landing
    }
}

public class Glider extends Aircraft{
    @Override
  public void land(){
     //Complex logic that handles
     //glider landing
    }
}


// Main Class
public class Main{
 public static void main(String[] args) {
  
     Aircraft h = new Helicopter();
     h.land();
     int alt1 = h.getAltitude();
     
     Aircraft g = new Glider();
     g.land();
     int alt = g.getAltitude();
 }
}

````

> A concrete class / simple class `can not contain abstarct method.`


When to use Abstract Classes:
--
> When we required to create a template for future classes,but let them provide the actual implementation.

> Share some functionality with future subclasses

> Implement Template Method design pattern 

**Example : Template Method-Design the Skeleton of an Algorithm 

````java
public abstract class Aircraft {    //This is an abstract class
    
    // Remember: A final method that can not be overidden in the subclasses; 

   //this is a concrete final method; which can not be overriden
 
    public final void takeoff(){  // It's not an abstract method. It has a body.
        this.checkSystems();
        this.getClearance();
        this.implementCustomActions();
    }
    
    // A subclass needs to implement all these abstract methods
 
    protected abstract void checkSystems();
    protected abstract void getClearance();
    protected abstract void implementCustomActions();
}

````
Abstract Classes:
--
> **Must be declared using the "abstract" keyword**

> **Can contain abstract and non-abstract methods**

> **Can have constructors**

> **Can not be instantiated. For that we need to extend the abstract class.** 

# Demo: Using encapsulation and inheritance to model the display of airspace routes

Summary
--
> Access modifiers can help us to hide away implementation  details and protect our
> classes from misuse.

> Inheritance is a great way to share functionality in a group of related classes 

>  We can use method overriding to give a more specific implementation than the
> one defined in a base class.

> We can prevent inheritance and overriding by using the "final" keyword.

> Abstract can not be instantiated.

> Abstract classes can be used as a template by other classes. 

# Understanding Interfaces and Polymorphism

> An interface is a contract that you define for the classes that implement it. 

**Interface :**
--
> A **reference type** that can contain `method signatures`, `default methods`, `static methods`, `nested types and constant`.

**Interface Restrictions**
--
> They can not be instantiated

> An interface can not contain a constructor.

> Usually, interface methods do not have a body

> Default and static methods have been introduced in recent versions of Java for
compatibility reasons

> A class can implement `one or more interfaces`. 

Why Use Interfaces ?

> Abstraction : To achieve abstraction.  Hide away implementation details and only expose the public API 


> "Mimic" Multiple Inheritance :: A class can implement multiple interfaces.

Declaring and Implementing an Interface:
--

````java
//Declaring an Interface
interface Engine { 
    //public , static, final by default
 int MIN_OPERATING_TEMPERATURE = -50;
 void start();

 void stop();
}

// Access it by using interface name followed by constant name 
int minTemp = Engine.MIN_OPERATING_TEMPERATURE


//Implementing an Interface
public class TurboProp implements Engine {
 @Override
 public void start() {
  //engine start logic
 }
 

 @Override
 public void stop(){
     //engine stop logic 
 }
}
````

> Interface methods are by default `abstract` and `public`.

> When a class implements them they must be public. 

> We can add the "public" access modifier to interface methods. 

> In Java, interfaces can also contain constants. 

> Fields defined in interfaces are public, static and final by default. 

Default and Static Methods
--

Evolving Interfaces:
--
````java
//Interface:: Engine
interface Engine {

 void start();
 void stop();

}
````
````java
public class TurboProp implements Engine { 
    
    @Override
     public void start(){}
   
     @Override
     public void stop(){}
 
}
````
> At some point, in future , add a method `heathCheck()` in an interface `Engine`.
And it shows error showing as follows: 

````java
interface Engine{
    void start();
    void stop();
    void healthCheck();  //new add at last
}

````

````java
public class TurboProp implements Engine {
 //Error, this class will not compile
 //because it must override healthCheck()

 @Override
 public void start() {

 }

 @Override
 public void stop(){ 
     
 }
}

````
**Remember**
> Changing interfaces can break classes that implement them .

Default Method:
--
> A method defined in an interface that has an implementation. 
They allow interfaces to evolve but do not force changes to classes that
implement those interfaces. 

**Example of Default Method**
````java
interface Engine{
    void start();
    
    void stop();
    
    default String healthCheck(){
        //logic goes here
     return "Ok";
    }
}
````


````java

public class TurboProp implements Engine {
    
 @Override
 public void start() {
 }

 @Override
 public  void stop(){
     
 }
 @Override
 public String healthCheck(){ }
 
 Engine e = new TurboProp();
 e.healthCheck();
 
}

````

Properties of Default Methods:
--

> Declared with the `default` keyword at the beginning of the `method signature`. 

> Must provide an implementation

> They are implicitly public

> Can be overridden by classes that implement the interface

Static Methods in Interfaces:
--
> A method that "belongs" to the interface.

> You can declare a full-fledged method as static and 
> use the interface name to call it.

**Example**
````java
interface Engine{
    int MIN_TEMP = -50;
    
    void start();
    void stop();
    
    static boolean canStart(int outsideTemp){
        return outsideTemp > MIN_TEMP;
    }
}
````

````java
//Use Interface name, followed by static method
booolean canStart = Engine.canStart(-30);

/*Remember :
    A static interface method is linked to the interface,not 
    to class that implement it.
    
    i.e 
    boolean canStart = TurboProp.canStart(-30) // Error    
        
 */
````

> Defining a static method in an interface is the same as defining it 
> in a class.

**Why use them?**
> If you want a palceholder to store static methods , then you really do not need a 
> concrete class for this. 

 

Functional Interfaces:
--
> An interface that contains a single abstract method . 
> It is an interface that exposes one single responsibility. 

**Example** 
````java
@FunctionalInterface
public interface EventHandler{
    void handle();  //a single method 
}
````

> Starting with Java-8, we can use a `lambda expression` to implement a functional interface.

**Implementing Functional Interfaces with Lambda Expressions**

````java
EventHandler onStart =()-> {
    System.out.println("Program Started");
        };

onStart.handle();
        
````

Widely Used Functional Interfaces:

> Predicate<T>

> Function<T>

> Runnable

> Comparable<T>

````java
List<String> manufacturers = List.of("Boeing", "Airbus", "Embraer");

//Print manufacturers that start with A

Predicate<String> startWithA = (String val)-> {
    return val.startsWith("A");
};

manufacturers.stream()
        .filter(startWithA)
        .forEach(System.out :: println);
````

Properties of Functional Interfaces:
--
> Can have a single abstract method, but multiple default or static
> methods

> We can use @FunctionalInterface to make sure the interface
> does not have more than one abstract method

> We can implement functional interfaces with lambdas , no need for creating concrete classes.

# Polymorphism 

> The ability of an abstraction **to make many forms** at `runtime`

Method Overriding:
--
 
**Inheritance**
Override behavior from the superclass, to create more specialized 
implementations. 

**Interfaces**
Classes that implement the interface must override the intent defined in the 
interface. 

//Depending on model, each radar uses different formats

````java
public interface RadarInterface {
    List<RadarTarget> readData();
}

````

Implementing Interfaces:
---
**Many Forms for Same Intent**
````java
public class BinaryRadar implements radarInterface{
    @Override
 public List<RadarTarget> readData(){
        //read binary data and extract targets
    }
}
````

````java
public class XmlRadar implements RadarInterface {
    @Override
    public List<RadarTarget> readData(){
        //parse xml and extract radar targets
    }
}

````

````java
//Combine data from multiple radars
List<RadarInterface> radars = List.of(
        new XmlRadar(),
        new BinaryRadar()
        );
List<RadarTarget> combinedData = new ArrayList<>();
radars.forEach(r-> combinedData.addAll(r.readData()));


````

Runtime Behavior:
--

> We are using a common reference variable type.

> At runtime, the behavior that gets triggered is determined by the 
actual object type(the object we create)

Benefits of Polymorphism
--
> Change behavior of an application at runtime even without recompiling your code.

> Reduces coupling because we can depend on abstractions, not concrete types

> We can use a single variable type to store many types. 

Interfaces vs. Abstract Classes
--
**When should I use ?**

| Use abstract classes                                              | Use interfaces                  |
|-------------------------------------------------------------------|---------------------------------|
| When you want to offer some base <br/>functionality to subclasses | Highest level of abstraction    |
| Provide a template for future classes                             | Highest level of loose coupling |
| Create abstract members that are not public                       | Implement more interfaces.      |
|                                                                   |                                 |

Demo:
--
> Using interfaces and polymorphism to implement airspace sectors


Summary:
--
> Interfaces are a reference type that usually holds only abstract
methods.

> We can think about interfaces like a public contract that each class must respect.

> Default methods allow interfaces to evolve without breaking existing code.

> Functional interfaces are interfaces with a single abstract method.
> They can be implemented using lambada expressions.

> Interfaces are great for implementing polymorphism.The intent they define can take many forms at runtime based on the objects 
> that were created from them. 

# MO-7 Defining Enumeration and Nested Classes

**Enum Types**
--
> Enum type is a `data type` that enables a variable to hold only `certain predefined values`.
> They should be used every time you need to represent a fixed set of 
> constant values. 

**Define Enum**
````java 
public enum FlightRules{
    INSTRUMENT_FLIGHT_RULES,
    VISUAL_FLIGHT_RULES,
    SPECIAL_FLIGHT_RULES
}

````
**Use Enum**

````java
int calculateMinSeparation(FlightRules fr){
  
    switch(fr) {
        case VISUAL_FLIGHT_RULES:
            return 20;  //Nm
        
        case INSTRUMENT_FLIGHT_RULES:
            return 10;  //Nm
        
        case SPECIAL_FLIGHT_RULES:
            return 15;  //Nm
        default:
             return -1;
        }
    
}
````

> `Enums in Java are more powerful` than enums in other language. 

> The enum declaration defines a special class called enum type

> An enum type can have a body which can include fields and methods. 

> THe compiler also adds some special static methods like values() or valueOf()

> An enum type can have properties assigned to each constant value.

> An enum type can have a constructor, which can be used to assign properties to enum constants. 

````java
public enum FlightRules {
    //Constants must be defined first; assign separation as property on constants
 
 INSTRUMENT_FLIGHT_RULES(10),
 VISUAL_FLIGHT_RULES(20),
 SPECIAL_FLIGHT_RULES(15);
 
 
 private int minSeparation;  //Property assigned to constant
 
 //Constructor must be private or package private
 FlightRules(int minSeparation){
     this.minSeparation = minSeparation;
 }
 
 //Method in enum
 public int getMinSeparation(){
     return minSeparation;
 }
}

````
> An Enum Type is a type of class having some restrictions. 

Use Enum Methods
--
````java
public int calculate(FlightRules fr){

    return fr.getMinSeparation();
}

calculate(FlightRules.INSTRUMENT_FLIGHT_RULES);  //Output:20 

````
Enum Type Restrictions:
--
> The constants must be declared at the top of the enum body; Everything else 
> will be declared after them.

> The constructor of the enum type must be private or package private; It automatically 
> creates the constants defined in the enum body.

> You can not claa the enum type constructor directly. 

Demo: Using enums to model an aircraft wake turbulence category
--

# Inner Classes

Nested Class
--
In Java, we can define a class within another class; Such a class is called 
a nested class.

There are two types of Nested Classes:
1. Static Nested Classes
   A Static nested class was associated with another class. 
2. Inner Classes (Non-static Nested Classes)
  An inner class is a class associated with an instance of its outer class.

Inner Class Characteristics:
--
> It has direct access to the outer class object's fields and methods.

> Because it is associated with an instance of the enclosing class , it can not 
> contain any static members.

> To instantiate an inner class, you must first instantiate the object  of  the outer class.
> Then you can create an inner class object using outer class object.

````java
public class Aircraft {
    
    //Declare fields 
    private final int altitudeF1;
    private final boolean isRvsmCapable;
    
    public int getSeparationFeet(){
        //Logic goes here
     
       //check altitude and RVSM capability to determine separation
    }
}

````
**(OR)**

**Private Inner Class**
````java
public class Aircraft{ //Outer Class
    private final int altitudeF1;
    private final boolean isRvsmCapable;
    
    private class VerticalSeparation { //Inner Class 
        
        private int separationInFeet; //field declaration
        
        VerticalSeparation(){ //non-parameterised constructor
            if(altitudeF1 >= 290 && altitudeF1 <= 410 && isRvsmCapable) {
                separationInFeet = 1000;
            } else {
              separationInFeet = 2000;  
            }
            
            public int getSeparationInFeet(){
                return separationInFeet;
         }
        }
        
        //generate getter method
        public int getSeparationFeet(){
            VerticalSeparation vsep = new verticlaSeparation();
            return vsep.getSeparationFeet();
        }
    }
}

````
Instantiating Inner Classes:
--
> An instance of the inner class can only exist within an instance of the outer class.

> 

````java
//Make the inner class access modifier ---> public , Then do the following  

//Define an instance of the outer class
Aircraft a = new Aircraft(300, true);

//Using the outer class instance create a new inner class instance
Aircraft.VerticalSeparation vsep = a.new VerticalSeparation();

System.out.println(vsep.getSeparationInFeet());

````
Special Types of Inner Classes :

> Local Classes

> Anonymous Classes

Local Classes:
--
> A class that is defined within a block of code , usually within a method.

**Where Can You Define a local Class ?**
> In a method 

> In a for loop 

> In an if clause or any block of code

````java
public class Aircraft {

    //Declare private fields
    private final int altitudeF1;
    private final boolean isRvsmCapable;

    public int getSeparation() {   //A method

        class VerticalSeparation {   //No access modifier , Inside the method we create the inner class i.e local class

            private int seapartionInFeet; // Declare field inside local class or inner class 

            VerticlaSeparation() {  //constructor 
                if (altitudeF1 >= 290 && altitudeF1 <= 410 && isRvsmCapable) {
                    seapartionInFeet = `1000 ';
                         else{
                        separationInFeet = 2000;
                    }
                }

                public in getSeparationInFeet() { //generate getter 
                    return separationInFeet;
                }
                
                //Must be instantiated in same block
                VerticalSeparation vsep = new VerticalSeparation();
                return vsep.getSeparationInFeet();

            }
        }
    }

}
````
**Access Members of Outer Class**
--
> A local class can access all the members of its enclosing class

> In addition to that a local class can access the local variables defined in the same scope;
> But these variables need to be final or effectively final 

> Local classes can access the method parameters if they are defined within a method.

**Accessing Local Fields**
--
**A Local Class Can Access Final or Effectively Final Local Variables**
Demo::
````java
public class Conventions{
    
    public int fromFeetToFL(){  //Method 
           //final int valueInFeet = 100; //Final local variable
            int valueInFeet = 100; //Effectively final 
         // valueInFeet = 200;  //Not final or effectively final anymore
        
        class FeetToFL{ //Inner Class or Local Class ; do not have access modifier 
            
            public int get(){
                return valueInFeet/100; //Can access final local variable 
            }
            //Instantiate object of locla class 
            FeetToFL convertor = new FeetToFL();
            return converter.get();
            
        }
    }
    
    
}
````
Local Class Restrictions:
--
> They ca not contain any static members , except constants(final static fields of primitive types or String)

> You can not declare interfaces in a block , just classes 

> They can not be instantiated from outside the block they were defined in . 

> They do not have access modifiers since they are defined within a block and used with in the same block. 

Anonymous Classes:
---

> Simplified local class; A great way to declare and instantiated a class at the same time . 

> Anonymous classes are treated  as **Expressions**
````java
//The interface can have many members as possible
public interface UnitConverter{
    int convert();
}

````
````java
public void someMethod(){
    int feet = 2000 ; // Final or effectively final

     UnitConverter feetToF1 = new UnitConvertor(){
         @Override
        public int convert(){
                return feet/100;
        }
     };
     System.out.println(feelToF1.convert());
     
     
     UnitConverter feetToMeters = new UnitConvertor(){
         @Override
         public int convert(){
             return (int) (feet*0.3048);
        }
     }
     
     //You can add extra methods
        private void log(){
         System.out.println(" Converting " + feet + "to FL");
        }
     
}

````

Anonymous Class Expression:
--
> The new operator ; followed by the name of the interface/base class that needs to be implemented or extended 

> Parantheses that contains arguments to a constructor

> Inside the body we actually define the whole class. 
````java

UnitConvertor feetToFl = new InitConverter(){  //Directly instantiate and declare interface/class at the same time
    
    @Override
  public int convert(){
    
        return feet/100;
    }
};

````
> An anonymous class expression is almost like invoking a constructor , except you need
> to define a class i na block of code. 

Access Members of Outer Class
--
> An anonymous class can access all the instance members of its enclosing class

> In addition to that an anonymous class can access the local variables definedin the same scope ; but these variables 
> need to be final or effectively final

> Anonymous classes can access the method parameters if they are defined within a method

Anonymous Class Restrictions:
--
> They can not contains any static members, except constants final static fields of primitive types or String)

> You can not declare constructor in them .

> But, you can add extra methods. 

What you can declare in an Anonymous Class?
--

> You can declare :
 - Methods
 - Fields
 - Local Classes
 - Instance initializer 

> If you want to define a class with only one method, then even anonymous classes are a bit too complicated.

Lambada Expressions:
--
> A way to represent a functional interface using an expression; it is treated as 
> a function by the compiler. 

Lambda Expression Vs. Anonymous Class

**Filtering a Collection of Objects**
````java
public class Aircraft{
    
    //Declare fields
    private final String callSign;
    private final int altitudeF1;
    private final boolean isRvsmCapable;
    
    //Getter and setters
}

````
````java
List<Aircraft> aircraft = List.of(
        new Aircraft("OS731", 100 , true),
        new Aircraft("ROT123", 120, true),
        new Aircraft("BA087",140, false),
        new Aircraft("AF567",250,true),
        new Aircraft("LUF676",360,false)
        );
print(aircraft); //print specific aircraft


````
Define Functional Interface :
--
````java
@FunctionalInterface
public interface AircraftFilter{
    boolean check(Aircraft a);
}

````
**Using an Anonymous Class**
````java
private void print(List<Aircraft> aircraft){
//Anonymous class => lots of boilerplate;
//What if we nned to change the filters or provide them as a method param?

AircraftFilter lowAltitudeFilter = new AircraftFillter() {
    
    @Override
  public boolean check(Aircraft a){
    return a.getAltitudeF1() <150;
    }
} ;

aircraft.forEach(a-> {
    if(lowAltitudeFilter.check(a)){
        System.out.println(a.getCallsign());
        }
        });
}

````
**Using a lambda Expression**
````java
private void print(List<Aircraft> aircraft, AircraftFilter filter){

    aircraft.forEach(a->{
        if(filter.check(a)){
            System.out.println(a.getCallsign());
        }
        });
}

//Provide filter implementation using lambdas

print(aircraft,(a->a.getAltitudeF1() <150));
print(aircraft,(a-> a.getAltitudeF1() > 290 && a.getAltitudeF1() < 410 && a.isRvsmCapable()));



````

Syntax of a Lambda Expression:
--
> A comma separated list of input parameters .

> The arrow token -> 

> A body which can be a single expression or a method block 
````java
print(aircraft, (a -> a.getAltitudeF1() < 150));
print(aircraft, (a -> { return a.getAltitudeF1() <150 ; 
}));

````
> **Lambda expressions** can capture `final or effectively final local variables of the enclosing scope`. 

**Course::** Using Lambda Expressions in java Code by Jose Paumard. 

**Summary:**
--
>**Enum type** is great for storing fixed sets of constants.

>**Enum type** is powerful in Java; you can add methods , fields and constructors. 

> Java inner classes can access the instance members of its enclosing class while still being a reusable class itself.

> Local classes are defined within a block of code

> Anonymous classes allow us to declare and instantiate a class at the same time based on an 
> interface or superclass

> Lambda expressions implement a single unit of behavior that can be passed to other code. 

**Source::** https://github.com/dangeabunea/pluralsight-java11-object-oriented-approach 