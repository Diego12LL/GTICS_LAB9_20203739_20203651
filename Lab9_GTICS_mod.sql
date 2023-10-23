CREATE DATABASE  IF NOT EXISTS `partidossdci` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `partidossdci`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: partidossdci
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `deporte`
--

DROP TABLE IF EXISTS `deporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deporte` (
  `iddeporte` int NOT NULL AUTO_INCREMENT,
  `nombreDeporte` varchar(45) NOT NULL,
  `pesoDeporte` int NOT NULL,
  PRIMARY KEY (`iddeporte`),
  UNIQUE KEY `nombreActividad_UNIQUE` (`nombreDeporte`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deporte`
--

LOCK TABLES `deporte` WRITE;
/*!40000 ALTER TABLE `deporte` DISABLE KEYS */;
INSERT INTO `deporte` VALUES (1,'Natación',20),(2,'Fútbol',12),(3,'Básquet',15),(4,'Voley',25),(5,'Tenis',13);
/*!40000 ALTER TABLE `deporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `idequipo` int NOT NULL AUTO_INCREMENT,
  `nombreEquipo` varchar(45) NOT NULL,
  `colorEquipo` varchar(45) NOT NULL,
  `mascota` varchar(45) NOT NULL,
  PRIMARY KEY (`idequipo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombreEquipo`),
  UNIQUE KEY `color_UNIQUE` (`colorEquipo`),
  UNIQUE KEY `mascota_UNIQUE` (`mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,'Telecos','Celeste','Murciélago'),(2,'Civiles','Amarillo','Hormiga'),(3,'Mecánicos','Azul','Perro'),(4,'Informáticos','Verde','Gusano'),(5,'Ambientales','Verde Claro','Loro'),(6,'FuerzaTeleca','Morado','Telitoo'),(7,'FibraTóxica','Azul Oscuro','Telito');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialpartidos`
--

DROP TABLE IF EXISTS `historialpartidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialpartidos` (
  `idhistorialPartidos` int NOT NULL AUTO_INCREMENT,
  `partido_idpartido` int NOT NULL,
  `horaFecha` datetime NOT NULL,
  PRIMARY KEY (`idhistorialPartidos`),
  KEY `fk_historialPartidos_partido1_idx` (`partido_idpartido`),
  CONSTRAINT `fk_historialPartidos_partido1` FOREIGN KEY (`partido_idpartido`) REFERENCES `partido` (`idpartido`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialpartidos`
--

LOCK TABLES `historialpartidos` WRITE;
/*!40000 ALTER TABLE `historialpartidos` DISABLE KEYS */;
INSERT INTO `historialpartidos` VALUES (1,2,'2023-10-22 11:58:28'),(2,3,'2023-10-22 12:22:17'),(3,4,'2023-10-22 12:22:31'),(4,5,'2023-10-22 12:22:43'),(5,6,'2023-10-22 18:54:32'),(6,7,'2023-10-22 19:09:31'),(7,8,'2023-10-22 19:09:42'),(8,9,'2023-10-22 19:09:57'),(9,11,'2023-10-22 19:10:18'),(10,12,'2023-10-22 19:10:57'),(11,13,'2023-10-22 19:11:23'),(12,14,'2023-10-22 19:11:34');
/*!40000 ALTER TABLE `historialpartidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `idparticipante` int NOT NULL AUTO_INCREMENT,
  `equipo` int NOT NULL,
  `carrera` varchar(45) NOT NULL,
  `codigo` decimal(10,0) NOT NULL,
  `tipoParticipante` varchar(45) NOT NULL,
  PRIMARY KEY (`idparticipante`),
  KEY `fk_participante_equipo_idx` (`equipo`),
  CONSTRAINT `fk_participante_equipo` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`idequipo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (1,1,'IngTeleco',20203739,'Estudiante'),(2,1,'IngTeleco',20203637,'Estudiante'),(3,1,'IngCivil',26279090,'JP'),(4,2,'IncInform',12121314,'Estudiante'),(5,2,'IngMetalúrgica',20203439,'Estudiante'),(6,2,'IngMetalúrgica',20203439,'Estudiante');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantespartido`
--

DROP TABLE IF EXISTS `participantespartido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantespartido` (
  `idparticipantesPartido` int NOT NULL,
  `partido_idpartido` int NOT NULL,
  `participante_idparticipante` int NOT NULL,
  `horaFecha` datetime NOT NULL,
  PRIMARY KEY (`idparticipantesPartido`),
  KEY `fk_participantesPartido_partido1_idx` (`partido_idpartido`),
  KEY `fk_participantesPartido_participante1_idx` (`participante_idparticipante`),
  CONSTRAINT `fk_participantesPartido_participante1` FOREIGN KEY (`participante_idparticipante`) REFERENCES `participante` (`idparticipante`),
  CONSTRAINT `fk_participantesPartido_partido1` FOREIGN KEY (`partido_idpartido`) REFERENCES `partido` (`idpartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantespartido`
--

LOCK TABLES `participantespartido` WRITE;
/*!40000 ALTER TABLE `participantespartido` DISABLE KEYS */;
INSERT INTO `participantespartido` VALUES (1,2,1,'2023-10-22 11:58:28'),(2,2,2,'2023-10-22 11:58:28'),(3,2,3,'2023-10-22 11:58:28'),(4,2,4,'2023-10-22 11:58:28'),(5,3,1,'2023-10-22 11:58:28'),(6,3,2,'2023-10-22 11:58:28'),(7,4,3,'2023-10-22 11:58:28'),(8,4,4,'2023-10-22 11:58:28'),(9,5,5,'2023-10-22 11:58:28'),(10,6,6,'2023-10-22 11:58:28'),(11,7,6,'2023-10-22 11:58:28');
/*!40000 ALTER TABLE `participantespartido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `idpartido` int NOT NULL AUTO_INCREMENT,
  `equipoA` int NOT NULL,
  `equipoB` int NOT NULL,
  `scoreA` int NOT NULL,
  `scoreB` int NOT NULL,
  `deporte_iddeporte` int NOT NULL,
  PRIMARY KEY (`idpartido`),
  KEY `fk_partido_equipo1_idx` (`equipoA`),
  KEY `fk_partido_equipo2_idx` (`equipoB`),
  KEY `fk_partido_deporte1_idx` (`deporte_iddeporte`),
  CONSTRAINT `fk_partido_deporte1` FOREIGN KEY (`deporte_iddeporte`) REFERENCES `deporte` (`iddeporte`),
  CONSTRAINT `fk_partido_equipo1` FOREIGN KEY (`equipoA`) REFERENCES `equipo` (`idequipo`),
  CONSTRAINT `fk_partido_equipo2` FOREIGN KEY (`equipoB`) REFERENCES `equipo` (`idequipo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (2,1,2,20,3,1),(3,2,1,2,9,2),(4,2,1,2,30,3),(5,2,3,2,30,4),(6,3,4,4,5,2),(7,6,7,4,5,3),(8,4,7,9,0,3),(9,1,6,11,12,5),(11,3,6,100,101,5),(12,4,5,12,13,2),(13,5,6,2,8,3),(14,5,7,9,4,4);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-22 23:06:17
