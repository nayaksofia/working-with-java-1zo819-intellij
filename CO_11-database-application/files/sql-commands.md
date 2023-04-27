# SQL COMMAND [Created In MySQL Workbench :: Sofia]

Step-1 : Create a Schema ::
````
 CREATE SCHEMA `loboticket` ;
````
Step-2 : Creates Tables
````
Table-1 : Acts
---------------------------
CREATE TABLE `loboticket`.`Acts` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `RecordLabel` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`));
  

Table- 2: Gigs
-----------------------------
CREATE TABLE `loboticket`.`Gigs` (
  `Id` INT NOT NULL,
  `VenueId` INT NOT NULL,
  `ActId` INT NOT NULL,
  `TicketsSold` VARCHAR(45) NULL,
  `Price` FLOAT NULL,
  `Date` DATE NULL,
  PRIMARY KEY (`Id`));
  
 Table-3 Venues
 -------------------
 CREATE TABLE `loboticket`.`Venues` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Capacity` DOUBLE NULL,
  PRIMARY KEY (`Id`));




````

# MySql Command With Example

## Reference

1. Learn from > [mysql-query-command](https://www.educba.com/mysql-query-commands/)

> Create Database: `create database sonoo;`

> Show Database : `show databases;`

> To Delete Database: `drop database sonoo;` //Delete database

> To select database : `use db_world;`  //Use particular database in mysql .

> Filter ::`select * from emp;` where `emp` is a table.

> Show Table: `show tables;`

> Detail Of The Table : `describe table_name;`

> Delete A Table : `drop table table_name;`


> CREATE TABLE countries( countryname varchar(60), countryid varchar(4), regionid decimal(10,0););

> `DESC countries;`

> `select sum(salary) from employee where emp_age>30;`

> `select * from myschema.views;`

## Insert command
```
INSERT INTO EMPLOYEE (EMP_NAME, EMP_SAL) Values (‘TOM’,’3000’);

```
## Update
```
UPDATE EMPLOYEE SET EMP_SAL=6000 WHERE EMP_ID=200;
```
