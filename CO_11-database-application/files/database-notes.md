###### Date :: 26th April 2023
Lec-11 ::Database Application With JDBC in Java SE Application :
-------------------------------------
Prerequisites::
--------------
> Java Syntax

> IntelliJ Idea
-----------------------------------
Sec-1 :: Introduction to Relational Database and SQL
---------------------------------------------------------

### Broad Categories Of Database:

1. SQL (or Relational)
2. No SQL (Data is not modeled using relationships)

What is a relational database ?
------------------------------------
- Data is organized into tables
- Tables have rows and columns
- Tables are related through keys

> Data is accessed in the relational database through SQL. [Structured Query Language]

> CRUD Operation:
> ------------------
> 1. Create : Insert new data into the table; Creating data.
> 2. Read : Read data from the table
> 3. Update : Update data from the table
> 4. Delete  : Delete data from the table

Examples of Reading Data
-----
**[SQL Commands]:**
-------------------
````
SELECT TicketsSold FROM Gigs <--------- Simple Read

SELECT id, name From Venues WHERE name LIKE '%arena%' <---------Filters

SELECT * FROM gigs JOIN venues ON venues.id = gigs.venueid WHERE
venues.name LIKE '%arena%'                  <--------------------- Joins

SELECT COUNT(*) from Gigs where TicketsSold < 30 <-----------SQL Functions

INSERT INTO                                   <------Insert into
venues(name, capacity)                   <--------Table and columns to add
values('The Arena',100);           <----------Values to insert



UPDATE venues              <---------Update Table 
SET capacity=30           <----------Columns to update
WHERE id=4                <----------Value to change to


UPDATE venues             <-----Be Aware Of It
SET capacity=30


DELETE FROM           <--------DELETE from 
venues                <--------table
WHERE Id=5            <----------filter

DELETE FROM 
venues                <--------Be Aware About It 
````

> Database :: mySQL | mySQLWorkbench with Docker 

Summary MO-1:: 
--
> Relational database holds related data in tables.

> Basic CRUD Operation [Create, Read, Update, Delete]

# Sec-2 : Introduction To JDBC 

### Topics-To-Cover :

> JDBC Interfaces

> JDBC Driver Manager

> JDBC Driver

> JDBC URL

> Initial Connection to database

### JDBC Interface

> When you write an application using JDBC you need to connect
> with the database to get the data. 

> When you connect to the database
> you need sth called :  JDBC Driver.

`Driver Interface` :: These driver;the java classes either 
supply by JDBC Vendor or may be through Opensource .  
Driver are specific to a given database.It may be , for example: 
mysql driver or oracle driver or sqlserver driver. However, if
we use the driver we do not use that class explicitly.
We will use an Interface. In this case we used `driver interface`. 

`Connection`: Similarly we use driver to make connection to the database.
We use `JDBC Connection Interface`.

`PreparedStatement` : It is an interface. We called it as a  `parameterised statement`. 

`CallableStatement` : 

`ResultSet`: 

See how we get connection in a moment?
--
>PreparedStatement ps = conn.prepareStatement("SELECT....");

Execute a query and get a ResultSet :
---
>ResultSet rs = ps.executeQuery();

Use the ResultSet
------
>while(rs.next()){....}

> All of this is coded against the interfaces , not against the implementations. 


Getting the Connection:
--
> To get a connection need to use the `DriverManager`.
> The URL identifies the database to connect to and is database specific.


````
String url = "...";
Connection conn = DriverManager.getConnection(url);
````
# JDBC Driver

JDBC Classes :
--
>The DriverManager loads the driver.

>Driver provides implementations of the JDBC interfaces.

>These classes know how to talk to this specific database. 

Loading the Driver
--
> DriverManager.getConnection("jdbc:mysql://localhost:3306/loboticket");

Driver code : Contains the JDBC Classes
---
> com.mysql.cj.jdbc.ConnectionImpl implements Connection{ }


Implementation Classes:
--
| JDBC Interfaces   | JDBC Implementation   |
|-------------------|-----------------------|
| Driver            | DriverImpl            |
| Connection        | ConnectionImpl        |
| PreparedStatement | PreparedStatementImpl |
| CallableStatement | CallableStatementImpl |
| ResultSet         | ResultSetImpl         |
-------------------------------------------------

Summary: MO-2
---
> All code is in IntelliJ Idea

> Gradle script to manage the code

> Use 'Flyway' to set up the database

> A Ticket database 


 # Loading The Driver::
 
> Demo::

> IDE :: IntelliJ IDE

````java
//File Name: Application.java
//------------------------------------

import java.sql.*;
import java.time.LocalDate;

public class Application {

  static String url = "jdbc:mysql://localhost:3306/loboticket";
  static String userName = "loboticket";
  static String password = "p4ssw0rd";

  public static void main(String[] args) throws SQLException {

    //Get Connection
    try (Connection conn = DriverManager.getConnection(url, userName, password)) {
      System.out.println(conn);
    }
  }

// Now `Build` the above code. Then Run It. 
}
````
Next : Work With Docker-MySQL Workbench
----
> Step-1: Open : Docker

> Step-2: Click on `sofia-mysql`(Port :3306)

> Step-3: Hover on the `sofia-mysql`. Right side you get `CLI`.

> Step-4: Click on `CLI`

> Step-5: Write the command `mysql -u root -p`

> Step-6 : Then Enter Password: `root`

> Step-7 : Now Open MySQl Workbench 

> Step-8 : Write Command To Work MySQL WorkBench

> Step-9 : Create Schema -- $ CREATE DATABASE loboticket;

> Step-10 : Use That Schema -- $ USE loboticket;

> Step-11 : Create Table -- $ CREATE TABLE Venues(....);

> Step-12 : Insert Data InTo The Table as follows data::

````roomsql
 /*File Name: 1_initial_tables.sql*/

create table Venues
(
Id           Int PRIMARY KEY   AUTO_INCREMENT,
Name         varchar(100)      not null,
Capacity     Int               not null
);

create table Acts
(
Id           Int PRIMARY KEY    AUTO_INCREMENT,
Name         TEXT               not null,
RecordLable  TEXT               null
);

create table Gigs
(
 Id           Int PRIMARY KEY     AUTO_INCREMENT,
 VenueId      Int                 not null,
 ActId        Int                 not null,
 TicketsSold  Int                 not null,
 Price        decimal(4,2)        not null,
 Date         Date                not null,
 
 FOREIGN KEY(VenueId) REFERENCES Venues(Id),
 FOREIGN KEY(ActId)   REFERENCES Acts(Id)

);

````

### Note that ::
 
> The database schema must exist to allow the migrations to run.


# MO-4 : Connecting to Database

- JDBC URL
- Initial Connection To Database

Getting the Connection:
--
> To get a connection need to use the `DriverManager`.

> The `URL` identifies the database to connect to and is database specific.

````JDBC 
String url = "jdbc:mysql://localhost:3306/loboticket";
Connection conn = DriverManager.getConnection(url);
````
Parts of JDBC URL:
----

> jdbc :: [protocol] Always start with `jdbc`.

> mysql ::[subprotocol] Vendor/product name

> localhost:3306/loboticket :: [Subname] Database specific connection string


Example JDBC URLS
---
> jdbc:postgresql://localhost/loboticket

> jdbc:mysql://localhost:3306/loboticket

> jdbc:oracle:thin:@123.123.123.123:5321:loboticket

> jdbc:derby:loboticket 

 Closing Connection:
---
#### Database Connections:

- These are native resources. 

- Must be closed by the application after use 

- Use `try with resources` to close connection. This will also
  close the statement and the result set. Use try-finally block ;

````java
// File Name :: Application.java
//-------------------

import java.sql.*;
import java.time.LocalDate;

public class Application {
  static String url = "jdbc:mysql://localhost:3306/loboticket";
  static String userName = "loboticket";
  static String password = "p4ssw0rd";

  public static void main(String[] args) throws SQLException {
    try (Connection conn = DriverManager.getConnection(url, userName, password);
         PreparedStatement stmt = conn.prepareStatement("select * from Acts")) {
      var results = stmt.executeQuery();

      while (results.next()) { //Iterate over the results
        System.out.println(results.getString("Name"));
      }
    }
  }
}


````
Running the Code In Command Line
---
> java -cp . :mysql-connector-java-8.0.23.jar  com.app.Application

> dot(.) :: Represent class path 

Output
--
> com.mysql.cj.jdbc.ConnectionImpl@2ea41516

Notice that; it prints the driver specific class name 

# MO-5 : Using PreparedStatements

### Topics to cover:

> Using a `PreparedStatement` to read and write to the database 

> Using parameters in a PreparedStatement 

> Using the `ExecuteQuery` and `Executemethods` 

Different `Statement` Interfaces
---

> Statement : 

- PreparedStatement : Use parameterized query
- CallableStatement  : Call storeProcedure 

> Both `PreparedStatement` and `CallableStatement` derived from Statement.

PreparedStatement:
---

- Represents a SQL statement that will be sent to the database
- Can be used for any CRUD operation
- PreparedStatement has methods to modify and read data from the database. 

Closing Resources:
---
- Like connections, PreparedStatements must be closed.
- Use try with resources
- Note that closing a connection will also close any associated prepared statement. 

`execute` Methods
--
Three `execute` methods on PreparedStatement 
 - executeUpdate
 - executeQuery
 - execute

**execute()**: 
--
> It is typically used when you want to execute multiple queries at the same time.
 
| Method        | Return Type | What is returned for SELECT | What is returned for INSERT/UPDATE/DELETE |
|---------------|-------------|-----------------------------|-------------------------------------------|
| execute       | boolean     | true                        | false                                     |
| executeQuery  | ResultSet   | data                        | n/a                                       | 
| executeUpdate | int         | n/a                         | number of rows changed                    |
# Demo :: Create and Execute Queries with a PreparedStatement

````java
import java.sql.*;

public class Application {

  static String url = "jdbc:mysql://localhost:3306/loboticket";
  static String userName = "loboticket";
  static String password = "root";

  public static void main(String[] args) throws SQLException {
            /*
                 1. Get Connection and Close it, using Try Resources
            */
    try (Connection conn = DriverManager.getConnection(url, userName, password)) {

      /* Demo : Using PreparedStatement's Execute Method
       */
      String sql = "insert into venues(name,capacity) values ('The House Next Door', 20)";
      var stmt = conn.prepareStatement(sql);

      boolean result = stmt.execute(); //execute():: Returns Boolean 

      if (!result) {
        if (stmt.getUpdateCount() > 0) {
          System.out.println("Update the database");
        } else {
          System.out.println("No update");
        }
      } else {
        System.out.println("Result was not a count");
      }
    }

  }


  // Method :: simpleDeleteExecuteUpdate
  private static void simpleDeleteExecuteUpdate(Connection conn) throws SQLException {

     
           /*
                 2. PreparedStatement() : DELETE SQL Command 
          */
    String sql = "delete from venues where name= 'The House Next Door'";
    Var stmt = conn.prepareStatement(sql);
         
          /*
                 3. ResultSet : executeUpdate()
          */
    int result = stmt.executeUpdate();
       
         /*
                4. Check The Result value : Using If Statement 
         */
    if (result > 0) {
      System.out.println("Update the database By Deleting ");
    } else {
      System.out.println("Update Failed");
    }

  }

  // Method :: simpleUpdateWithExecuteUpdate
  private static void simpleUpdateWithExecuteUpdate(Connection conn) throws SQLException {

               /*
                 2. PreparedStatement() : Update SQL Command 
          */
    String sql = "update venues set capacity = 30 where name= 'The House Next Door'";
    Var stmt = conn.prepareStatement(sql);
         
          /*
                 3. ResultSet : executeUpdate()
          */
    int result = stmt.executeUpdate();
       
         /*
                4. Check The Result value : Using If Statement 
         */
    if (result > 0) {
      System.out.println("Update the database ");
    }

  }


  //Method :: simpleInsertWithExecuteUpdate
  private static void simpleInsertWithExecuteUpdate(Connection conn) throws SQLException {

          /*
                 2. PreparedStatement() : Insert SQL Command 
          */
    String sql = "insert into venues(name,capacity) values('The House Next Door',20)";
    Var stmt = conn.prepareStatement(sql);
         
          /*
                 3. ResultSet : executeUpdate()
          */
    int result = stmt.executeUpdate();
       
         /*
                4. Check The Result value : Using If Statement 
         */
    if (result > 0) {
      System.out.println("Update the database ");
    }

  }


  // Method :: simpleReadWithExecuteQuery
  private static void simpleReadWithExecuteQuery(Connection conn) throws SQLException {
 
          /*
                 2. PreparedStatement() : Select SQL Command
          */
    String sql = "select name,capacity from venues";
    Var stmt = conn.prepareStatement(sql);
         /*
                 3. ResultSet : executeQuery()
          */
    ResultSet rs = stmt.executeQuery();
        
        /*
                4. Iterate the ResultSet Using While Loop and Pass rs.next()
         */

    while (rs.next()) {
      System.out.println(".");
    }

    System.out.println();

  }
}


/*
How to extract methods using IntelliJ:

- Select the expression or lines of code fitting the method we want to create
- Right-click the selected area
- rigger the Refactor > Extract > Method option
- Type in the method information: its name, its visibility and its parameters
- Press Enter

 */
````
Parameterzing PreparedStatement:
---

> PreparedStatement can be parameterized.
- Can pass parameters into the query
- Parameters represented by `'?' `in the query string.
- Parameters have a type 
  - Int, String etc
- Set the value of the parameter by position 
  - 1 based position not 0 

Example :: PreparedStatement With Parameter
-
````java

import java.sql.*;

public class Application {

    static String url = "jdbc:mysql://localhost:3306/loboticket";
    static String userName = "loboticket";
    static String password = "root";

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

          String sql = "insert into venues (name, capacity) values(?,?)"; //Passing Parameter By Using ? ?

          var stmt = conn.prepareStatement(sql);
          stmt.setObject(1,"Empire State Park");
          stmt.setObject(2,3000);
          
          int result = stmt.executeUpdate();

          if (result > 0) {
            System.out.println("Update the database");
          }
        }
    }
        
    
    private static void selectWithParameter(Connection conn) throws SQLException{
      String sql = "select name,capacity from venues where name like ?";

      var stmt = conn.prepareStatement(sql);
      stmt.setString(1,"%the%");

      ResultSet rs = stmt.executeQuery();

      while(rs.next()){
        System.out.println(".");
      }
      System.out.println();

    }

  private static void insertWithParameter(Connection conn) throws SQLException {
    String sql = "insert into venues (name, capacity) values(?,?)"; //Passing Parameter By Using ? ?

    var stmt = conn.prepareStatement(sql);
    
    stmt.setString(1, "Empire State Park"); //Parameter-1
    stmt.setInt(2, 3000); //Patrameter-2  
    
    int result = stmt.executeUpdate();

    if (result > 0) {
      System.out.println("Update the database");
    }
  }
}

````

preparedStatement Set Methods:
---
| Method       | Parameter Type | Example Database Type |
|--------------|----------------|-----------------------|
| setBoolean() | Boolean        | BOOLEAN               |
| setDouble()  | Double         | DOUBLE                |
| setInt()     | Int            | INTEGER               |
| setLong()    | Long           | BIGINT                | 
| setObject()  | Object         | Any Type              |
| setString()  | String         | CHAR, VARCHAR         | 

 
# MO-6 :: Working with Data from a PreparedStatement

Topics To Cover::
--
- Processing data using a ReasultSet
- Modifying data
- Setting null values
- Getting data by column name and position

The ResultSet:
--
- Execute the query to get a ResultSet
- Has a `cursor`
- Call 'next' to move the cursor
   - Returns true if there is a row to process
  - false otherwise
- Get values from the rows 

Suppose You Only Want To Read One Row from a Table
--
Maybe a count or an aggregate function; In that case you can use:
`if(rs.next())` instead `while(rs.next())`. 

Dos and Don't
--
> Check the return value of rs.next()

> Access any data with first calling rs.next()

> Use an invalid column number

> Use an invalid column name

Examples:
--

````java

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {


  static String url = "jdbc:mysql://localhost:3306/loboticket";
  static String userName = "loboticket";
  static String password = "root";

  public static void main(String[] args) throws SQLException {

    try (Connection conn = DriverManager.getConnection(url, userName, password)) {
    
        String sql = "select count(*) as count from gigs";
        
        var stmt = conn.prepareStatement(sql);
        var rs = stmt.executeQuery();
        
        if(rs.next()){
          System.out.println("The number of gigs is " + rs.getInt("count"));
        }
     
    }
  }
  
  private static void useResultSetWithName(Connection conn) throws SQLException{
    String sql = "select name,capacity from venues where name like ? ";

    var stmt = conn.prepareStatement(sql);
    stmt.setString(1, "%the%");

    ResultSet rs = stmt.executeQuery();

    while(rs.next()){
      String name = rs.getString("name");
      int capacity = rs.getInt("capacity");

      System.out.println(name+  " has capacity " + capacity);
    }

  }


  private static void useResultSetWithIds(Connection conn) throws IOException {

    String sql = "select name,capacity from venues where name like ? ";

    var stmt = conn.prepareStatement(sql);
    stmt.setString(1, "%the%");

    ResultSet rs = stmt.executeQuery();

    while(rs.next()){
      String name = rs.getString(1);
      int capacity = rs.getInt(2);

      System.out.println(name+  " has capacity " + capacity);
    }

  }

}


````

Using JDBC GetObject
--
resultSet Get methods
--
| Method     | Parameter Type |
|------------|----------------|
| getBoolean | boolean        | 
| getDouble  | double         |
| getInt     | int            |
| getLong    | long           |
| getObject  | Object         |
| getString  | String         |

````java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {


    static String url = "jdbc:mysql://localhost:3306/loboticket";
    static String userName = "loboticket";
    static String password = "root";

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

            String sql = "select capacity, name from venues where name like ?";

            var stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%the%");

            ResultSet rs = stmt.executeQuery();
            
            String name = "";
            int capacity = 0;
            
            while(rs.next()){
                Object nameValue = rs.getObject("name");
                
                if(nameValue instanceof String) name = (String) nameValue;
                
                Object capacityValue = rs.getObject("capacity");
                
                if(capacityValue instanceof Integer) capacity = (int)capacityValue;

                System.out.println(name + "has capacity" + capacity);
            }

        }
    }

}

````

Binding JDBC Parameters:
--
> Binding parameters in a Select:

- We can bind parameters in SELECT statement
- can also Bind Null

Closing Resources:
--
- Like connections and prepared statements result sets must be closed.
- Use try with resources
- Note that closing a prepared statement will also close any associated result sets.

````java
import java.sql.*;

public class Application {


  static String url = "jdbc:mysql://localhost:3306/loboticket";
  static String userName = "loboticket";
  static String password = "root";

  public static void main(String[] args) throws  SQLException {
    try (Connection conn = DriverManager.getConnection(url, userName, password)) {
      insertAct(conn, "Baby Driver", null);
    }
  }

  private static void insertAct(Connection conn, String name, String recordLabel) throws SQLException {

    var sql = "insert into Acts (name,recordLabel) values(?,?)";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, name);

      if (recordLabel != null)
        ps.setString(2, recordLabel);
      else
        ps.setNull(2, Types.CHAR);
      
      ps.executeUpdate();
    }
  }
}


````

Summary:
--
- Executing queries with a PreparedStatement returns a ResultSet
- ResultSets have a cursor
- Most move the cursor before accessing the data
- Access the data by column , either indexed (1-based) or name

# MO-7 : Working with a CallableStatement

- Database has stored procedure.
- Use a CallableStatement to execute a stored procedure.
- Show how to pass data to the CallableStatement.
- Show how to retrieve data from the CallableStatement

Setup
--
> Our database has four stored procedure
 - Get a list of all the acts
 - Report on what gigs are running when
 - Tells us the total sales
 - Try and raise the ticket price

These allow us to show `IN,OUT and IN/OUT ` parameters. 

CallableStatement Syntax::
----------------
Called Procedure Syntax is :
--
   > { call procedure_name() }

> Where the `procedure_name` is the name of the stored procedure in the database. 


````
create procedure GetActs()
begin
  select acts.name, acts.recordlabel
  from acts
  where act.recordlabel is NOT null
  
  order by acts.name;
end

````
Stored Procedure:
--
This gets all the acts with a record label.

CallableStatement with IN Parameters
--
- Use CallableStatement to call stored procedures
- Set `IN parameters` just like PreparedStatement

Stored Procedure:
--
This generates a 'Gig Report' between dates.
It has 2 IN parameters.

````
create procedure GigReport(IN startdate Date, IN enddate Date)

begin 

  select gigs.date, acts.name 'Acts' , acts.recordlabel , venues.name 'Venue' , ticketssold,
         venues.capacity
         
  from gigs join acts on acts.id = gigs.actid
            join venues on venues.id = gigs.venueid
            
  where date>= startdate and date <= enddate
  order by gigs.date;
  
 end;

````

Using OUT Parameters:
--
> Can use the `?=` syntax
- {?= call sproc_name(?)}
- This is optional
- Not all JDBC drivers support this 

> Register the out parameter

Stored Procedure
--
> This returns the sum of all the sales in the database.

> It has 1 OUT parameter.



````

create procedure GetTotalSales(OUT sales decimal(8,2))
begin
  select sum(currentValue) 'totalsales' from 
     (select ticketssold,price,ticketssold*price 'currentvalue' from gigs salestable
  into sales;
end;

````

Using INOUT Parameter:
--
> A `mixture` of `IN and OUT` calls

> Use `?` for each parameter

> For `IN` parameters set a value

> For INOUT parameters set a value

> `Register` the INOUT parameters

`setNewPrice` Stored Procedure
--

> This tries to update the sales price for gig

> It has 2 IN parameters

> It has 1 OUT parameters

````
create procedure SetNewPrice(IN gigid int, IN percentage decimal(8,2), inout maxprice decimal(8,2))

begin 
     declare gigprice decimal(8,2) default 0.0;
     declare proposedprice decimal(8,2);
     set gigprice = (select max(price) from gigs where id = gigid);
     set proposedprice = gigprice + (gigprice * percentage);
     if(proposedprice <maxprice)
     then 
       set maxprice = proposedprice;
       update gigs set price = proposedprice where id = gigid;
     else
       set maxprice = gigprice;
     
     end if;
end;


````

````java

import javax.swing.*;
import java.sql.*;

public class Application {


    static String url = "jdbc:mysql://localhost:3306/loboticket";
    static String userName = "loboticket";
    static String password = "root";

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

            var sql = "{call SetNewPrice(?, ?, ?)}";

            try (CallableStatement stmt = conn.prepareCall(sql)) {

                stmt.setInt(1, 2);
                stmt.setDouble(2, 0.2); //20%
                stmt.setDouble(3, 12); //Maximum value

                stmt.registerOutParameter(3, Types.DOUBLE);
                stmt.execute();
                System.out.println("New Price: " + stmt.getDouble(3));
            }
        }
    }

        
        
        //Demo :: OUT Parameter
      private static void csOutParameter(Connection conn) throws SQLException{
          var sql = "{call GetTotalSales(?)}";

          try(CallableStatement cs = conn.prepareCall(sql)){
               cs.registerOutParameter(1,Types.DOUBLE);

               cs.execute();

          System.out.println("Total sales is : " + cs.getDouble(1));

        }
      }
        
        
        
        //Demo :: IN Parameter
        private static void csGigReport (Connection conn) throws SQLException {

            var sql = "{ call GigReport(?,?)} ";

            try (CallableStatement cs = conn.prepareCall(sql)) {

                cs.setDate("startdate", Date.valueOf(LocaleDate.of(2022, 11, 1)));
                cs.setDate("enddate", Date.valueOf(LocalDate.of(2022, 11, 7)));

                var rs = cs.executeQuery();

                while (rs.next()) {

                    var date = rs.getDate("date");
                    var name = rs.getString("act");
                    var recordLabel = rs.getString("recordLabel");
                    var venue = rs.getString("venue");
                    var ticketsSold = rs.getInt("ticketsSold");
                    var capacity = rs.getInt("capacity");

                    System.out.println(date + " " + name + " " + recordLabel + " " + venue + " " + ticketsSold + " " + capacity);
                }

            }


// Demo :: callableStatement() 
            private static void csGetActsWithRecordLabel (Connection conn) throws SQLException {

                // Called procedure
                var sql = " { call GetActs()}  ";
                //CallableStatement
                try (CallableStatement cs = conn.prepareCall(sql)) {
                    var rs = cs.executeQuery();

                    while (rs.next()) {
                        var name = rs.getString("name");
                        var recordLabel = rs.getString("recordLabel");

                        System.out.println(name + " - " + recordLabel);
                    }
                }
            }
        }
    }
}


````
