
# MO-1 : Conditional Logic

### Course :: Getting Started With Programming In Java

if-else
--
> An `if` statement conditionally executes a single statement.

> Else clause executes a statement when condition is false


> Else clause is optional 

**Syntax :**

````
if( condition )
   true-statement ;
else
   false-statement;
````
Block statement:
--
 - Allows you to group multiple statements together
 - Creates a compound statement
 - Enclose statements within brackets {}

````
   statement-1;
   statement-2;
      .
      .
      .
   statement-N;
````
Chaining if-else:
--
- Evaluate multiple conditions
- Evaluated in order top-to-bottom
- First to test true is executed

````
if(condition-1)
  true-statement-1;
else if(condition-2)
  true-statement-2;
        .
        .
        .
        .
else if(condition-N)
  true-statement-N;
else
  false-statement;

````
Nested If:
--
- One if within another 
- Be sure else matches with correct if

Logical Operators:
--
- Combines two values, variables or expressions
- produce a single true or false result

**And operator**

- && 
- True if both sides are true

**Or operator**

- ||
- True if at least one side is true

Valid Conditions:
--
> Must always be boolean

> A variable, value , or expression that resolves to true or false. 

````
int iVal = 1;

//This will not compile
if(iVal)  
 System.out.println("Let's code.");  

//This will also not compile
if(iVal = 1)
 System.out.println("Let's code."); 

//This will complie
if(iVal==1)
 System.out.println("Let's code!!!");
 
````

# MO-2 Switch Statement 

**Tutor Name :: [Jim Wilson]**

Switch statement:
--
- Test value against multiple matches
- Transfer control based on match 
````
switch(test-value){
  case match-1:
     statements
     break; // break keyword exist the switch statement
  .
  .
  .
  .
  case match-N:
     statements
     break;
  default:
     statements
}
````
The Effect of Break on Switch Flow:
--
> Branch Control Flow:

> Branch Ordering: 

> Switch Supported Types
 
 Switch Supported Types:
 --
> All integral types except long
 - char, byte , short , int 
> Supported integral type wrappers
 - Character, Byte , Short , Integer 
> String

> enum Values 

Switch Supported Values:
--
> Switch test value
 - Any expression that returns a value.

> Branch case value
 - Any constant expression 
 - Value must be resolvable at compile time 

 Choosing Between Switch and if-else
--

> if-else
- Extremely flexible
- Can handle most-any condition

> Switch
 - It is restrictive in nature
 - Test must be based on exact value match
 - Type and value requirements 
 - Often allows intent to be more clearly expressed than if-else


Understanding when to avoid switch
--


Summary
--
> Switch statement
- Test value against multiple matches
- Transfer control based on match

> When match found
 - Start running code in that branch
 - Continue executing following code until switch exited
> Break
 - Immediately exists switch 
 - Often used at the end of each branch 

# MO-4 Looping 

> Common aspects of loops

> While loop

> Do-while loop

> For loop

> For-each loop

Loops
--
> **Def** : Repeatedly execute some code as long as provided condition is true.

> **While Loop** : Basic looping

> **Do-while loop** : Looping with deferred condition check

> **For-loop** : Looping with simplified notation for common use case

Some characteristics that common to all loops:
--
> Loop body
 - Code contained within a loop
 - By default just a single statement 
 - Use block to include multiple statements

> Loop iteration
 - A single pass through the code contained within a loop 

While Loop:
--

> Condition checked at loop start 

> Loop body may never run 

````
while(condition)
  statement;
````

Do-While Loop:
--
> Condition checked at loop end

> Loop body always runs at least once 

**Syntax:**
````
do 
  statement;
while(condition);
````
**Remember:**
> `While loop` check the condition at the beginning while `do-while loop` check the condition at the end.

For Loop:
--
> Condition checked at loop start

> Loop body may never run.

> Simplified notation for loop control values 

````
for(initialize; condition ; update)
statement;

````
> Examples of While Loop and For Loop ; where both perform
same operation:

WhileLoop.java
````
int i = 1;

while(i<100){
   System.out.println(i);
   i *= 2;
}

````

ForLoop.java

````
for(int i =1; i<100 ; i*=2)
  System.out.println(i);
````
For Loop Control Variable::
--
> Loop control variable, we can not use it outside the Loop.

For-each Loop::
--

> Simplifies iterating over a collection of items.

> Executes loop body once for each member
 - Handles getting collection length
 - Handles accessing each item 

> Types supported 
 - Arrays
 - Any type that implements Iterable
 - Most collection classes

For-each Loop Limitation :
--

**Be aware of limitations:**
> For-each loop is designed for iterating sequentially through a single 
 collection of items. 
> 

# MO-5 : Complex Looping and Branching

Nesting Loops and if-else:
--
> Nesting :
  - Placing one construct within another
> Nesting is commonly used
 - if-else within if-else
 - Loop within if-else
 - if-else within loop
 - Loop within loop

Nesting For Loops:
--

**Nested Loop:**
> One loop contains another loop

> The outer loop contains the inner loop 

**For each iteration of the outer loop :**
 - Inner loop runs from start to finish .

Branching:
--

> Branching : Alter standard code flow

> The continue statement :
  - Skips remainder of current loop iteration

> The break statement:
  - Terminates innermost switch or loop

Loops and the Return Statement
---
> The return statement 
 - Exits current method
 - Terminates all switches or loops within that method

Infinite Loops:
--

> Infinite Loop :
 - A loop that will repeatedly execute without ever terminating 

> Sometimes created intentionally
 - Generally rely on some external event to terminate the loop

> Commonly created inadvertently
 - Loop processing never causes the control condition to become false


Other Courses:
--
> Working with Classes and Interfaces in Java.