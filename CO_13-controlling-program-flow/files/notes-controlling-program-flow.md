
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

