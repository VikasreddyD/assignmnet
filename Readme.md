# Getting Started

The Clearing House- Bank Search Application

Java Spring Boot REST API - Backend for Bank Search Application

Requirements

Java JDK-1.8 or 1.8+
Spring Boot Embeded Tomcat
Start local server

API's 
1. Traverse to Project location and Run mvn clean install to build the project
2. Execute the command to run application mvn spring-boot:run
3. Copy paster Swagger URL- http://localhost:8080/swagger-ui/index.html#/ to open the shared API
5. Search a Bank - http://localhost:8080/bank/search
Example- Search a bank by State - http://localhost:8080/bank/search?state=NY
Example- Search a bank by State and City - http://localhost:8080/bank/search?state=NY&city=New%20York
Example- Search a bank by State, City and Zipcode - http://localhost:8080/bank/search?zipCode=10018&state=NY&city=New%20York
Example- Search a bank by State, City, Zipcode and type - http://localhost:8080/bank/search?zipCode=10018&state=NY&city=New%20York&type=ATM


