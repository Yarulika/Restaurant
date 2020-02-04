My hints, tips, lessons learned

//=================================================
    // CODE EVALUATION (analysis)
    //Sonar Cube && Sonar Lint (?plugin) (then Analyze with e.g. sonar cube)
    // 1) Remove unused code
    // 2) format code
    // Optimise imports + reformat code (from parent folder)
//=================================================
TODO

Exception handling:
- ResponseEntity<T>
- throws custom exception (PersonNotFoundException)

Queries:
- use naming queries (when simple) 
- better not native query
- Querydsl 
- criteria query  

NULL:
better not return null: empty response if none
service layer: return optional or collection
    // if List - return empty list
    // if single obj - Optional
controller level (only controller knows about http and rest): empty response if none

save: checks before
delete: check id exists - else throw exception
update : check, exception
PATCH: takes parameters (check each param)


Pagination + sorting (for find all)

Controller validation: @Valid @Notnull

Entity validation: @NotNull @Min @Max
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
//=================================================

//    /{customerId}
//    @PathVariable Integer customerId

//    @RequestBody (vs ResponseBody, Param)
//    @RequestParam
//=================================================
** serialVersionUID **
The serialVersionUID is used as a version control in a Serializable class. 
If you do not explicitly declare a serialVersionUID, JVM will do it for you automatically, based on various aspects of your Serializable class, as described in the Java(TM) Object Serialization Specification.

IntelliJ Preferences -> Editor -> Inspections -> Java -> Serialization issues -> 
Serializable class without 'serialVersionUID' - set flag and click 'OK'.

//=================================================
SELECT * FROM restaurant.orders
WHERE person_id = 2;
----
SELECT person_id, SUM(cost) as summary
FROM orders
GROUP BY person_id
ORDER BY summary DESC
----
SELECT * FROM persons 
JOIN (
	SELECT orders.person_id AS ID, SUM(orders.cost) AS COST FROM orders
	GROUP BY orders.person_id
    ) AS sum ON persons.person_id = sum.ID
ORDER BY COST DESC

//=================================================
ALTER TABLE `restaurant`.`meals` 
CHANGE COLUMN `meal_title` `meal_title` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `price` `price` INT(11) NOT NULL ;

//=================================================
//  //PersonController
    // $ curl -v -X POST "http://localhost:8080/persons/add?fName=one&lName=two&email=aaa@a.com"
    // @RequestParam means it is a parameter from the GET or POST request
//    @PostMapping(path="/add")
//    public String addPersonParamsWay(
//                    @RequestParam String fName,
//                    @RequestParam String lName,
//                    @RequestParam String email,
//                    @RequestParam String address,
//                    @RequestParam String username,
//                    @RequestParam String password) {
//        if (personService.ifPersonExistsByEmail(email)) {
//            return "exists";
//        }
//        else {
//            Person p = new Person();
//            p.setFirstName(fName);
//            p.setLastName(lName);
//            p.setEmail(email);
//            p.setAddress(address);
//            p.setUsername(username);
//            p.setPassword(password);
//            personService.save(p);
//            return "saved";
//        }
//    }
//=================================================
//        Optional<Person> person = personService.findPersonByEmail(email);
//        if (person.isPresent()) {
//            return person.get();
//        } else {
//            return null;
//        }
// EQUAL =
//        return personService.findPersonByEmail(email).orElse(null);

//=================================================
            return ResponseEntity.status(200).header("X-APP-VERSION", "v.1.000").body(p.get());
//=================================================
    // $ curl -v -X GET "http://localhost:8080/persons/aaa@a.com"
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    void teaPot() {}
    @GetMapping(path = "/{email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email) {
        Optional<Person> p = personService.findByEmail(email);
        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        } else {
            return ResponseEntity.notFound().build();
        }

//return ResponseEntity.status(404).body(personService.findPersonByEmail(email))
    }
    
//=================================================

@NotNull VS @NotEmpty VS and @NotBlank
@NotNull: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, but it can be empty
@NotEmpty: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null and its size/length is greater than zero
@NotBlank: a constrained String is valid as long as it's not null and the trimmed length is greater than zero

//=================================================
//public class PersonService 

    public Person findByIdOrNull(Integer id) {
        return personRepository.findById(id).orElse(null);
//        Explanation: //before using optional - check if exists
//        Optional<Person> optionalPerson = personRepository.findById(id);
//        if (optionalPerson.isPresent()) {
//            optionalPerson.get();
//        }else{
//            return null;
//        }
//        return optionalPerson.orElse(null);
//        return personRepository.findById(id);
    }
//=================================================


