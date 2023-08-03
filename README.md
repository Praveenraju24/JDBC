# JDBC WITH MYSQL

This project is about how to connect with MySql database and how to perform CRUD operations with MySql database by using JAVA JDBC API .JDBC API is a platform independent where this feature is not in ODBC .

Steps to follow 

1) Download mysql database from given below link according to our system requirements.
   link : https://dev.mysql.com/downloads/installer/
   
2) create a java file in eclipse then create a class in src folder
   
3) Load the connection
   here we need to load the specific jdbc drivers to connect with mysql database . Drivers will help us to connect with database . we can load 
   drivers by using class.forName() method.
   
4) get connection
   After loading necessary jdbc drivers we need establish the connection with Driver manager class by providing url , username,password.
   
5) Driver Manager class
   Driver Manager will manage the drivers for allocation and deallocation with database .The object of driver Manager class can be used to        provide object for statement.

6) Statement Interface
   statement interface provides a object that is used to execute queries of MySql.It contains several Methods.
   
7) ResultSet Interface
   Sometime Queries will generate output example select query at that time we can use ResultSet object where cursor points to first line of 
   output.we have several methods to traverse through output by using ResultSet object.

8) Adding JAR file   
   when we downloaded mysql database as in 1st step it contains jar file named mysql-connector-java-8.0.22 .Click on our present project then 
   properties->add external jars->class path here add that jar file then succesfully connected with MYSQL database.

I HAVE PROVIDED ALL CODE THAT REQUIRED TO ESTABLISH CONNECTION AND PERFORM CRUD OPERATION WITH MYSQL DATABASE.

A/C steps specified above i have code it sequentially .use your own username and password !!!!.
   
