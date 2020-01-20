My hints, tips, lessons learned

//    /{customerId}
//    @PathVariable Integer customerId

//    @RequestBody (vs ResponseBody, Param)
//    @RequestParam
//=================================================
SELECT * FROM restaurant.orders
WHERE person_id = 2;
----
SELECT person_id, SUM(cost) as summary
FROM orders
GROUP BY person_id
ORDER BY summary DESC

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