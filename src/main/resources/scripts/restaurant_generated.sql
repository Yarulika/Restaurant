-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema restaurant
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema restaurant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaurant` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `restaurant` ;

-- -----------------------------------------------------
-- Table `restaurant`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`persons` (
  `person_id` INT(20) NOT NULL,
  `first_name` VARCHAR(15) NULL DEFAULT NULL,
  `last_name` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `user_name` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`orders` (
  `order_id` INT(20) NOT NULL,
  `person_id` INT(20) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `cost` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `person_id` (`person_id` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`person_id`)
    REFERENCES `restaurant`.`persons` (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`meals` (
  `meal_id` INT(20) NOT NULL,
  `meal_title` VARCHAR(45) NULL DEFAULT NULL,
  `price` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`meal_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`order_meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`order_meals` (
  `order_id` INT(20) NULL DEFAULT NULL,
  `meal_id` INT(20) NULL DEFAULT NULL,
  `quality` INT(10) NULL DEFAULT NULL,
  `unit_price` INT(10) NULL DEFAULT NULL,
  INDEX `order_id` (`order_id` ASC) VISIBLE,
  INDEX `meal_id` (`meal_id` ASC) VISIBLE,
  CONSTRAINT `meal_order_ibfk_1`
    FOREIGN KEY (`order_id`)
    REFERENCES `restaurant`.`orders` (`order_id`),
  CONSTRAINT `meal_order_ibfk_2`
    FOREIGN KEY (`meal_id`)
    REFERENCES `restaurant`.`meals` (`meal_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`roles` (
  `role_id` INT(20) NOT NULL,
  `role_title` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`person_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`person_roles` (
  `person_id` INT(20) NULL DEFAULT NULL,
  `role_id` INT(20) NULL DEFAULT NULL,
  INDEX `person_id` (`person_id` ASC) VISIBLE,
  INDEX `role_id` (`role_id` ASC) VISIBLE,
  CONSTRAINT `person_role_ibfk_1`
    FOREIGN KEY (`person_id`)
    REFERENCES `restaurant`.`persons` (`person_id`),
  CONSTRAINT `person_role_ibfk_2`
    FOREIGN KEY (`role_id`)
    REFERENCES `restaurant`.`roles` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- TODO: remove all script folder since we have db.migration