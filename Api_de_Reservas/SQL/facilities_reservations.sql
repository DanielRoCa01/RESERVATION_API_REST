drop database if exists facilities_reservations;
create database facilities_reservations;
Use facilities_reservations;

CREATE TABLE `facility` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `facility` VALUES
(1,'Oficinas','Oficinas de una aseguradora a todo riesgo'),
(2,'VideoClub','Esto es un videoclub'),
(3,'Colegio','Esto es un colegio');

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

INSERT INTO `space` VALUES 
(1,'Escritorio 1','XS','07:00:00','21:00:00','Escritorio pegado a la pared derecha',1),
(2,'Escritorio 2','XS','08:00:00','20:30:00','Escritorio pegado a la pared izquierda',1),
(3,'Escritorio 3','S','07:00:00','22:00:00','Escritorio pegado a la pared del fondo',2),
(4,'Despacho 1','S','08:00:00','19:00:00','Despacho pequeño para le gestion de tramites con privacidad',2),
(5,'Despacho 2','M','08:00:00','19:00:00','Despacho mediano para la gestion de tramites con privacidad a un mayor numero de personas.',2),
(6,'Sala de reuniones 1','S','09:00:00','19:00:00','Sala de reuniones pequeña ubicada en la primera planta',3),
(7,'Sala de reuniones 2','M','10:00:00','19:00:00','Sala de reuniones mediana ubicada en la segunda planta',3),
(8,'Sala de reuniones 3','L','10:00:00','18:00:00','Sala de reuniones grande ubicada en la tercera planta',3),
(9,'Pistas deportivas','L','08:00:00','20:00:00','Se trata de unas pistas de futbol y baloncesto.',1);

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

INSERT INTO `division` VALUES (1,'GENERAL','Proposito general',1),
(2,'Informaticos','Seccion de control de la red informatica de la oficina',1),
(3,'GENERAL','Proposito general',2),
(4,'GENERAL','Proposito general',3),
(5,'Chupapingas','Son expertos mamaescrotos y fan de sanderson',3);

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

INSERT INTO `user` VALUES 
(1,'Nacho','ADMINISTRADOR',1,1),
(2,'Luis','USUARIO',2,1),
(3,'Raul','ADMINISTRADOR',2,1),
(4,'Felipe','ADMINISTRADOR',1,3),
(5,'Fernando','ADMINISTRADOR',3,1);


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

INSERT INTO `reservation` VALUES 
(1,1,1,'10:00:00','11:00:00','2024-05-31','Torneo de futbol','RESERVADA'),
(2,1,2,'10:00:00','14:00:00','2024-05-31','Torneo de pin pon','RESERVADA'),
(3,2,3,'16:00:00','18:00:00','2024-05-31','','RESERVADA'),
(4,2,2,'10:00:00','12:00:00','2024-05-31','','RESERVADA'),
(5,2,1,'10:00:00','13:00:00','2024-05-31','CANCELADA','RESERVADA'),
(6,2,2,'10:00:00','13:00:00','2024-05-31','CANCELADA','RESERVADA'),
(7,3,3,'12:00:00','14:00:00','2024-05-30','CANCELADA','RESERVADA'),
(8,3,1,'10:00:00','14:00:00','2024-06-07','CANCELADA','Curso de prevencion de riesgos laborales');

