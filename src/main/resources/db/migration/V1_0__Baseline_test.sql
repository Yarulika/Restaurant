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
CREATE SCHEMA IF NOT EXISTS `restaurant` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `restaurant` ;

-- -----------------------------------------------------
-- Table `restaurant`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`meals` (
  `meal_id` INT(11) NOT NULL,
  `meal_title` VARCHAR(255) NULL DEFAULT NULL,
  `price` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`meal_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`persons` (
  `person_id` INT(11) NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`orders` (
  `order_id` INT(11) NOT NULL,
  `cost` INT(11) NULL DEFAULT NULL,
  `date` DATETIME(6) NULL DEFAULT NULL,
  `person_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `FK9qntjmy82o15pyak9igalicsn` (`person_id` ASC) VISIBLE,
  CONSTRAINT `FK9qntjmy82o15pyak9igalicsn`
    FOREIGN KEY (`person_id`)
    REFERENCES `restaurant`.`persons` (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`order_meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`order_meals` (
  `order_meals_id` INT(11) NOT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `unit_price` INT(11) NULL DEFAULT NULL,
  `meal_id` INT(11) NULL DEFAULT NULL,
  `order_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_meals_id`),
  INDEX `FKjxd746gurxd3ox7owngu7jmit` (`meal_id` ASC) VISIBLE,
  INDEX `FKh3j3qrqr3blhwl2a6y5mdf77f` (`order_id` ASC) VISIBLE,
  CONSTRAINT `FKh3j3qrqr3blhwl2a6y5mdf77f`
    FOREIGN KEY (`order_id`)
    REFERENCES `restaurant`.`orders` (`order_id`),
  CONSTRAINT `FKjxd746gurxd3ox7owngu7jmit`
    FOREIGN KEY (`meal_id`)
    REFERENCES `restaurant`.`meals` (`meal_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`roles` (
  `role_id` INT(11) NOT NULL,
  `role_title` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurant`.`persons_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`persons_roles` (
  `person_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`person_id`, `role_id`),
  INDEX `FKnac3je6s0rn90x5ovsqta5e9j` (`role_id` ASC) VISIBLE,
  CONSTRAINT `FKnac3je6s0rn90x5ovsqta5e9j`
    FOREIGN KEY (`role_id`)
    REFERENCES `restaurant`.`roles` (`role_id`),
  CONSTRAINT `FKpl1er8ibdrcw0milr440bvaxe`
    FOREIGN KEY (`person_id`)
    REFERENCES `restaurant`.`persons` (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
