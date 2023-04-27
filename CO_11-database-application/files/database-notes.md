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