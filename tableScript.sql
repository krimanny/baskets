CREATE TABLE `tbl_basket` (
  `basket_id` bigint NOT NULL AUTO_INCREMENT,
  `total_price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`basket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `tbl_item` (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `basket_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK45y5ncqbh3dvt0ja73y9mfx0g` (`basket_id`),
  CONSTRAINT `FK45y5ncqbh3dvt0ja73y9mfx0g` FOREIGN KEY (`basket_id`) REFERENCES `tbl_basket` (`basket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci