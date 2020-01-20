Restaurant 
Assignment to practice Spring Boot 

Use cases covered:
    Create person
    View by role: customers and employees
    Update all person details
    Update certain person's field
    Delete person
    Get person by email
    Create order
    List all today's orders
    List person's orders
    List top 10 persons by highest payment

Tools used:
    Java
    Spring Boot
    Spring Web
    Spring Data JPA (Hibernate)
    Flyway Migration
    MySQL
    JUnit
    Lombok

Institute: Software Development Academy
Course: Java Helsinki 1, 2019-2020

@Anna Yarulina, 2020


//=================================================
TODO
before save: checks!
use naming queries 
returning null: better not return null
//empty response if none

at service layer: return optional
controller: (//empty response if none)
delete: check id exists before - exception
update : check, exception

PATCH: takes parameters (check each param)

if List - return empty list
if single obj - Optional

hints: (better not native query)
- query DSL
- criteria query  

Pagination + sorting (for find all)

validartion!! (Controller)
@Valid
@Notnull

for entity: @NotNull, @Mix @Max
regex annotation for email

Try to make custom exception: Spring exception handlers

//=================================================
// Requirements
//
// create user +
// update all user data (PUT) + 
// update certain user field +
// delete user +
// get user by email +
// create order + (TODO: finish meal)
// list all today's orders (TO FINISH findForToday())
// list user's order + 
// list top 10 users & payment order by highest payment
//
// Testing (Postman)
// insert 15 users
// update user #1 : all data
// update user #2: only name
// create orders for different users
//
// think about corner cases +  do validation
//=================================================

// unit tests
// frontend: list of users

+ Spring Boot response status code
//=================================================
