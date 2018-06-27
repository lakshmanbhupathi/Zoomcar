# Zoomcar

Car/bike rentals application

**Problem statement**

As discussed, I would like you to work on a basic spring boot application. 

You will be writing APIs for a vehicle leasing software (ex: zoomcar)
The application maintains inventory of cars, that can be booked for renting. A customer can call following apis

- list vehicles (all, by type (e.g. sedan, hatchback etc.))
- book a vehicle,
- view past bookings

Use tech stack of your choice, in-memory persistence would be just fine - if you can demonstrate JPA great.

Some evaluation parameters:

1. Instructions on how to build and run. 
2. Spring integration tests.
3. Exception handling.
4. Usage of right response codes.
5. Signs of extensible solution. 
6. Any indication of design patterns. 

**Solution**

Application with complete solution

Technology stack:

- Java 10 
- Spring boot 2.0.3.RELEASE 
- Spring JPA
- H2 embedded database
- PostMan
- gradle 4.6 (build tool) 
- Github 
- Intellij Idea 18 

Instructions:

0. Make sure JDK 8 installed ( JDK 10 used for development purpose, but works fine with JDK 8)
1. Please install latest gradle 4.6
2. Open project as gradle project from Intellij Idea(for eclipse please install gradle plugin prior to import).
3. Run ZoomcarApplication.main(), now web application will be up on http://localhost:8080)
4. Install POSTMAN from chrome app store
5. import Zoomcar.postman_collection.json collection into postman
6. Now you can run API's from already made API requests in Postman.

Instructions to run test cases:

`cd {project_dir}`

`gradle test`


