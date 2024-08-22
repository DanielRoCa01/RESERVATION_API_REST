drop database if exists facilities_reservations;
create database facilities_reservations;
Use facilities_reservation;

CREATE TABLE `facility` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `space` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `opening_time` time DEFAULT NULL,
  `closing_time` time DEFAULT NULL,
  `description` mediumtext,
  `facility_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SPACE_FACILITY_idx` (`facility_id`),
  CONSTRAINT `FK_SPACE_FACILITY` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `division` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` mediumtext,
  `facility_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DIVISION_FACILITY_idx` (`facility_id`),
  CONSTRAINT `FK_DIVISION_FACILITY` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `division_id` int DEFAULT NULL,
  `facility_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_FACILITY_idx` (`facility_id`),
  KEY `FK_USER_DIVISION_idx` (`division_id`),
  CONSTRAINT `FK_USER_FACILITY` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`),
  CONSTRAINT `FK_USER_DIVISION` FOREIGN KEY (`division_id`) REFERENCES `division` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `space_id` int NOT NULL,
  `starting_time` time DEFAULT NULL,
  `ending_time` time DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`),
  KEY `FK_RESERVATION_SPACE_idx` (`space_id`),
  KEY `FK_RESERVATION_USER_idx` (`user_id`),
  CONSTRAINT `FK_RESERVATION_SPACE` FOREIGN KEY (`user_id`) REFERENCES `space` (`id`),
  CONSTRAINT `FK_RESERVATION_USER` FOREIGN KEY (`space_id`) REFERENCES `user` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;