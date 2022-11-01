# springboot-db-handler
Database name --> restapi
Initially create the database 'restapi'
The mini project code deals with creating a table 'blog' and performing CRUD operations
Blog.java
  It needs a class Blog( table name) with three fields Id, title and content which is to be mapped with mysql table.
  Constructors have to be defined.
  Getter and setter methods for each field has to be written
  toString() method has to be overridden
BlogRepository.java
  Interface BlogRepository extending JpaRepository has to be written. The methods like findById, findByTitle, findByContent etc. are implemented by default
  Just method invocation has to be done.
BlogController.java
  This class is used to implement the CRUD operations in Blog table.
  It is used to map the URL involved in REST API.
success.html
  Shows the output data given as response from the controller
index.html
  Sample webpage to receive content and title and for testing username and password parameters
