-- Test data for `persons`, `meals`

INSERT INTO `restaurant`.`persons` (`person_id`,`first_name`,`last_name`,`email`,`address`,`username`,`password`) VALUES (1,'testFN1','testLN1','test1@test.com','anyaddress','spring','$2a$10$Jr6aq/ElFcGfJVncSJXub.t9FJX6Thi/9McvQ6lIxi6p2s31H7Kmi');
INSERT INTO `restaurant`.`persons` (`person_id`,`first_name`,`last_name`,`email`,`address`,`username`,`password`) VALUES (2,'testFN2','testLN2','test2@test.com','anyaddress','spring','$2a$10$Jr6aq/ElFcGfJVncSJXub.t9FJX6Thi/9McvQ6lIxi6p2s31H7Kmi');
INSERT INTO `restaurant`.`persons` (`person_id`,`first_name`,`last_name`,`email`,`address`,`username`,`password`) VALUES (3,'testFN3','testLN3','test3@test.com','anyaddress','spring','$2a$10$Jr6aq/ElFcGfJVncSJXub.t9FJX6Thi/9McvQ6lIxi6p2s31H7Kmi');
INSERT INTO `restaurant`.`persons` (`person_id`,`first_name`,`last_name`,`email`,`address`,`username`,`password`) VALUES (4,'testFN4','testLN4','test4@test.com','anyaddress','spring','$2a$10$Jr6aq/ElFcGfJVncSJXub.t9FJX6Thi/9McvQ6lIxi6p2s31H7Kmi');
INSERT INTO `restaurant`.`persons` (`person_id`,`first_name`,`last_name`,`email`,`address`,`username`,`password`) VALUES (5,'testFN5','testLN5','test5@test.com','anyaddress','spring','$2a$10$Jr6aq/ElFcGfJVncSJXub.t9FJX6Thi/9McvQ6lIxi6p2s31H7Kmi');


INSERT INTO `restaurant`.`persons_roles` (`person_id`,`role_id`) VALUES (1,1);
INSERT INTO `restaurant`.`persons_roles` (`person_id`,`role_id`) VALUES (1,2);
INSERT INTO `restaurant`.`persons_roles` (`person_id`,`role_id`) VALUES (2,1);
INSERT INTO `restaurant`.`persons_roles` (`person_id`,`role_id`) VALUES (3,2);
INSERT INTO `restaurant`.`persons_roles` (`person_id`,`role_id`) VALUES (4,1);
INSERT INTO `restaurant`.`persons_roles` (`person_id`,`role_id`) VALUES (5,2);


INSERT INTO `restaurant`.`meals` (`meal_id`, `meal_title`, `price`) VALUES ('1', 'Chicken salad', '11');
INSERT INTO `restaurant`.`meals` (`meal_id`, `meal_title`, `price`) VALUES ('2', 'Meatballs with spaghetti', '22');
INSERT INTO `restaurant`.`meals` (`meal_id`, `meal_title`, `price`) VALUES ('3', 'Coffee', '4');

INSERT INTO `restaurant`.`orders` (`order_id`, `cost`, `date`, `person_id`) VALUES ('1', '30', '1581067440', '1');
INSERT INTO `restaurant`.`orders` (`order_id`, `cost`, `date`, `person_id`) VALUES ('2', '20', '1581067440', '2');
INSERT INTO `restaurant`.`orders` (`order_id`, `cost`, `date`, `person_id`) VALUES ('3', '80', '1580734800', '2');

INSERT INTO `restaurant`.`order_meals` (`order_meals_id`, `quantity`, `unit_price`, `meal_id`, `order_id`) VALUES ('1', '1', '20', '1', '1');
INSERT INTO `restaurant`.`order_meals` (`order_meals_id`, `quantity`, `unit_price`, `meal_id`, `order_id`) VALUES ('2', '2', '15', '3', '2');
INSERT INTO `restaurant`.`order_meals` (`order_meals_id`, `quantity`, `unit_price`, `meal_id`, `order_id`) VALUES ('3', '10', '22', '2', '3');

