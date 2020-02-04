
# Restaurant (Assignment to practice Spring Boot) 
Java web application provides a REST API to manage main restaurant functions: saving information about customers and employees, orders and menu; returns JSON response.

## Development requirements:

1) JDK 8
2) MySql

## Main functions: 

1) View by role: customers and employees
2) View all people
3) Update all person details
4) Update certain person's field
5) Delete person
6) Get person by email
7) Create order
8) List all today's orders
9) List person's orders
10) List top 10 persons by highest payment

## Provided API:

1) Get all persons (both customers and employees) available in restaurand data base
```
curl --header 'Accept: application/json' 'http://localhost:8080/restaurant/persons'
```
2) Get restaurant's employees
```
curl --header 'Accept: application/json' 'http://localhost:8080/restaurant/employees'
```
3) Get restaurant's customers
```
curl --header 'Accept: application/json' 'http://localhost:8080/restaurant/customers'
```
4) Add new person
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"firstName": "test0", "lastName": "test0", "email": "test0@test.com", "address": "anyaddress", "username": "test0", "password": "test0", "roles": [{ "roleId": 1, "roleTitle": "customer"}]}' \
  http://localhost:8080/restaurant/persons
```
5) Update all the details of existing person
```
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"personId":1,"firstName":"test0NEW","lastName":"test0NEW","email":"test0NEW@test.com","address":"anyaddressNEW","username":"test0NEW","password":"test0NEW","roles":[{"roleId":1,"roleTitle":"customer"}]}' \
  http://localhost:8080/restaurant/persons
```
6) Update specifies details of existing person using {personId}
```
curl --header "Content-Type: application/json" \
  --request PATCH \
  --data '{"personId":1,"firstName":"updateThisOnly"}' \
  http://localhost:8080/restaurant/persons/1
```

//TBD
//TODO
* its good idea but, usually we put in readme file couple of points/ look how to make Headlines, points, text..
* Overview
* Getting it to work
* Requirements
* Build the app
* Run the spring app
* Run Tests and generate test-coverage report
* Swagger UI
* Feature work
* Technical comments

//
Tools used:
-    Java
-    Spring Boot
-    Spring Web
-    Spring Data JPA (Hibernate)
-    Flyway Migration
-    MySQL
-    JUnit
-    Lombok

Institute: Software Development Academy
Course: Java Helsinki 1, 2019-2020

@Anna Yarulina, 2020
