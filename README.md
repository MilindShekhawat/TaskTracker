# TaskTracker
RESTful API written in Java that communicates with a PostgreSQL database to perform CRUD operations.

## How To Use
Download the zip or clone this project.

To run this Project you'll need an IDE like Maven or Intellij.

1. First of all, go to `applications.properties` and setup your username and password of your postgreSQL database.
There is no need to create a database as the application does it itself.
The application creates a database tasktracker with following attributes.

```
  |    id    |  title  |  description  | due_date  | 
  +----------+---------+---------------+-----------+ 
  |  String  |  String |    String     |   Date    |
```
&emsp;`id` is our primary key. <br>
&emsp;`id` is written in a format `T<number>` such as `T1`.

2. Run the TaskTrackerApplication. The localhost server is running on port 8080 by default. We can access the server by going to 
&emsp;```http://localhost:8080/tasks```

4. The API can perform all CRUD operations. We can use Postman to perform all requests. The API returns output in .json format.
+ GET Requests
  + `http://localhost:8080/tasks`: 
    Retrieves all tasks.
  + `http://localhost:8080/tasks/{id}`: 
    Retrieve tasks by id.
+ POST Requests
  + `http://localhost:8080/tasks`: 
    Create a new task.
+ DELETE Requests
  + `http://localhost:8080/tasks/{id}`: 
    Delete a task by id.
+ PUT Requests
  + `http://localhost:8080/tasks/{id}`: 
    Edit a task by id. <br>
  `http://localhost:8080/tasks/T1?due_date=2023-08-08`: Updates date of the task with id T1.

## Functionality
The application has multiple classes.
### TaskTrackerApplication
&emsp;Base Spring Boot application.
### TaskTracker
&emsp;This class represents the table. It contains variables like id, title, etc. It contains getters and setters for those variables.
### TaskTrackerController
&emsp;This is the controller class. It is responsible for making HTTP requests to our local server.
### TaskTrackerService
&emsp;This is a service class. It contains business logic on how to process the HTTP requests and throw exceptions on invalid data.
### TaskTrackerRepository
&emsp;This class extends JPARepository class.
### TaskTrackerConfiguration
&emsp;This is a configuration class. Since we are using Create-Drop functionality, we can pass initial values for rows in this class.
