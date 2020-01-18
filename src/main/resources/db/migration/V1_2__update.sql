CREATE TABLE IF NOT EXISTS `restaurant`.`test2` (
                                                   `test_id` INT(11) NOT NULL,
                                                   `test_title` VARCHAR(255) NULL DEFAULT NULL,
                                                   PRIMARY KEY (`test_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;