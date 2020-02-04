-- -----------------------------------------------------
-- Schema restaurant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaurant`
    DEFAULT CHARACTER SET utf8
    COLLATE utf8_bin;
USE `restaurant`;


-- -----------------------------------------------------
-- Table `restaurant`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`persons`
(
    `person_id`  INT(11)      NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NULL DEFAULT NULL,
    `last_name`  VARCHAR(255) NULL DEFAULT NULL,
    `email`      VARCHAR(255) NULL DEFAULT NULL,
    `address`    VARCHAR(255) NULL DEFAULT NULL,
    `username`   VARCHAR(255) NULL DEFAULT NULL,
    `password`   VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`person_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `restaurant`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`orders`
(
    `order_id`  INT(11)    NOT NULL AUTO_INCREMENT,
    `cost`      INT(11)    NULL DEFAULT NULL,
    `date`      BIGINT(20) NULL DEFAULT NULL,
    `person_id` INT(11)    NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`person_id`) REFERENCES `restaurant`.`persons` (`person_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `restaurant`.`meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`meals`
(
    `meal_id`    INT(11)      NOT NULL AUTO_INCREMENT,
    `meal_title` VARCHAR(255) NOT NULL,
    `price`      INT(11)      NOT NULL,
    PRIMARY KEY (`meal_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `restaurant`.`order_meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`order_meals`
(
    `order_meals_id` INT(11) NOT NULL AUTO_INCREMENT,
    `quantity`       INT(11) NOT NULL DEFAULT 1,
    `unit_price`     INT(11) NOT NULL DEFAULT 0,
    `meal_id`        INT(11) NOT NULL ,
    `order_id`       INT(11) NOT NULL ,
    PRIMARY KEY (`order_meals_id`),
    FOREIGN KEY (`order_id`) REFERENCES `restaurant`.`orders` (`order_id`),
    FOREIGN KEY (`meal_id`) REFERENCES `restaurant`.`meals` (`meal_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `restaurant`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`roles`
(
    `role_id`    INT(11)      NOT NULL AUTO_INCREMENT,
    `role_title` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`role_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `restaurant`.`persons_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`persons_roles`
(
    `person_id` INT(11) NOT NULL AUTO_INCREMENT,
    `role_id`   INT(11) NOT NULL,
    PRIMARY KEY (`person_id`, `role_id`),
    FOREIGN KEY (`role_id`) REFERENCES `restaurant`.`roles` (`role_id`),
    FOREIGN KEY (`person_id`) REFERENCES `restaurant`.`persons` (`person_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;
