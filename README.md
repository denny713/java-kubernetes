# java-kubernetes

System Requirement
-	Java with JDK 17 Version
-	Maven 3.9.9 Version
-	Spring Boot 3.2.5 Version
-	Kafka as Message Broker
-	PostgreSQL as a Database
-	Docker as a Container
-	Postman as a Testing Tool
Description
-	This project have 2 services (Producers and Consumers)
-	Producers Service to generate data and produce the message into kafka
-	Consumers Service to retrieve from kafka and put into PostgreSQL database using JPA
How to Test
-	Extract .rar file into specific path  (In this case in the D:/ztest)
-	After extract the file, build the application using commant ‘docker-compose up -d’ and automatic install PostgreSQL, Kafka, Zookeeper, and the Producers and Consumers Service
-	The database and table automatically created while the application was running 
-	Run the project using this curl in the terminal or using Postman tools
curl -v http://localhost:7070/produce
-	If success, you can get this response data and the data already filled in the database
 
 Created By
 Denny Afrizal