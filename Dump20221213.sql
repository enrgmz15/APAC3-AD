CREATE DATABASE  IF NOT EXISTS `joc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `joc`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: joc
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `Controla`
--

DROP TABLE IF EXISTS `Controla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Controla` (
  `Especie` int NOT NULL,
  `Poder` int NOT NULL,
  PRIMARY KEY (`Especie`,`Poder`),
  KEY `Poder` (`Poder`),
  CONSTRAINT `Controla_ibfk_1` FOREIGN KEY (`Especie`) REFERENCES `Especies` (`IdEspecie`),
  CONSTRAINT `Controla_ibfk_2` FOREIGN KEY (`Poder`) REFERENCES `Poders` (`IdPoder`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Controla`
--

LOCK TABLES `Controla` WRITE;
/*!40000 ALTER TABLE `Controla` DISABLE KEYS */;
/*!40000 ALTER TABLE `Controla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Especies`
--

DROP TABLE IF EXISTS `Especies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Especies` (
  `IdEspecie` int NOT NULL AUTO_INCREMENT,
  `PuntsVida` int NOT NULL,
  `Tipus` varchar(30) NOT NULL,
  PRIMARY KEY (`IdEspecie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Especies`
--

LOCK TABLES `Especies` WRITE;
/*!40000 ALTER TABLE `Especies` DISABLE KEYS */;
/*!40000 ALTER TABLE `Especies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jugadors`
--

DROP TABLE IF EXISTS `Jugadors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Jugadors` (
  `IdPlayer` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `Nivell` int NOT NULL,
  `Personatge` int DEFAULT NULL,
  PRIMARY KEY (`IdPlayer`),
  UNIQUE KEY `Personatge` (`Personatge`),
  CONSTRAINT `Jugadors_ibfk_1` FOREIGN KEY (`Personatge`) REFERENCES `Personatges` (`IdPersonatge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugadors`
--

LOCK TABLES `Jugadors` WRITE;
/*!40000 ALTER TABLE `Jugadors` DISABLE KEYS */;
/*!40000 ALTER TABLE `Jugadors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Personatges`
--

DROP TABLE IF EXISTS `Personatges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Personatges` (
  `IdPersonatge` int NOT NULL AUTO_INCREMENT,
  `Descripcio` varchar(200) DEFAULT NULL,
  `Especie` int NOT NULL,
  PRIMARY KEY (`IdPersonatge`),
  KEY `Especie` (`Especie`),
  CONSTRAINT `Personatges_ibfk_1` FOREIGN KEY (`Especie`) REFERENCES `Especies` (`IdEspecie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Personatges`
--

LOCK TABLES `Personatges` WRITE;
/*!40000 ALTER TABLE `Personatges` DISABLE KEYS */;
/*!40000 ALTER TABLE `Personatges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Poders`
--

DROP TABLE IF EXISTS `Poders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Poders` (
  `IdPoder` int NOT NULL AUTO_INCREMENT,
  `Tipus` varchar(50) NOT NULL,
  `Caracteristiques` varchar(100) NOT NULL,
  PRIMARY KEY (`IdPoder`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Poders`
--

LOCK TABLES `Poders` WRITE;
/*!40000 ALTER TABLE `Poders` DISABLE KEYS */;
/*!40000 ALTER TABLE `Poders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-13 16:03:39
