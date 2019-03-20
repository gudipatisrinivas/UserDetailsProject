# UserDetailsProject

This application does the following.

-- Spring Boot Microservice that can perform CRUD operations on H2 Datbased which is a Inmemory Databsed and maintain a user record.

-- Spring Batch job that can read a pipe delimited CSV file that contains a list of terminated users users and make a REST API call to Spring Boot microservice to update the status of the user to suspended

-- Simple Angular UI application that run from NodeJs using Express library.

-- UI should allow us to view a user by username, should make call to NodeJs to get user data, NodeJS should make call to Spring Boot Microservice to get needed data and return to UI.


How to Install this Application :

1.Check out the GIT Branch in to your SpringBoot Based project in STS.
2.Make Sure that no other application is running on the port 8080.
3.Make sure you have the NodeJS installed on you machine.
4.Run this as Spring Boot Application and hit the below in the url.


