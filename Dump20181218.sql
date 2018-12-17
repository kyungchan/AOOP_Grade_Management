CREATE DATABASE  IF NOT EXISTS `grademanager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `grademanager`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: grademanager
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attands`
--

DROP TABLE IF EXISTS `attands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attands` (
  `StudentNum` varchar(20) NOT NULL,
  `Week1_1` int(1) NOT NULL DEFAULT '0',
  `Week1_2` int(1) NOT NULL DEFAULT '0',
  `Week2_1` int(1) NOT NULL DEFAULT '0',
  `Week2_2` int(1) NOT NULL DEFAULT '0',
  `Week3_1` int(1) NOT NULL DEFAULT '0',
  `Week3_2` int(1) NOT NULL DEFAULT '0',
  `Week4_1` int(1) NOT NULL DEFAULT '0',
  `Week4_2` int(1) NOT NULL DEFAULT '0',
  `Week5_1` int(1) NOT NULL DEFAULT '0',
  `Week5_2` int(1) NOT NULL DEFAULT '0',
  `Week6_1` int(1) NOT NULL DEFAULT '0',
  `Week6_2` int(1) NOT NULL DEFAULT '0',
  `Week7_1` int(1) NOT NULL DEFAULT '0',
  `Week7_2` int(1) NOT NULL DEFAULT '0',
  `Week8_1` int(1) NOT NULL DEFAULT '0',
  `Week8_2` int(1) NOT NULL DEFAULT '0',
  `Week9_1` int(1) NOT NULL DEFAULT '0',
  `Week9_2` int(1) NOT NULL DEFAULT '0',
  `Week10_1` int(1) NOT NULL DEFAULT '0',
  `Week10_2` int(1) NOT NULL DEFAULT '0',
  `Week11_1` int(1) NOT NULL DEFAULT '0',
  `Week11_2` int(1) NOT NULL DEFAULT '0',
  `Week12_1` int(1) NOT NULL DEFAULT '0',
  `Week12_2` int(1) NOT NULL DEFAULT '0',
  `Week13_1` int(1) NOT NULL DEFAULT '0',
  `Week13_2` int(1) NOT NULL DEFAULT '0',
  `Week14_1` int(1) NOT NULL DEFAULT '0',
  `Week14_2` int(1) NOT NULL DEFAULT '0',
  `Week15_1` int(1) NOT NULL DEFAULT '0',
  `Week15_2` int(1) NOT NULL DEFAULT '0',
  `Week16_1` int(1) NOT NULL DEFAULT '0',
  `Week16_2` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`StudentNum`),
  KEY `StudentNum` (`StudentNum`),
  CONSTRAINT `attands_ibfk_1` FOREIGN KEY (`StudentNum`) REFERENCES `students` (`studentnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attands`
--

LOCK TABLES `attands` WRITE;
/*!40000 ALTER TABLE `attands` DISABLE KEYS */;
INSERT INTO `attands` VALUES ('60112147',2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0),('60121877',2,0,0,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0),('60131455',2,2,2,2,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60141287',2,2,2,2,1,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60141460',2,2,2,2,1,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60141542',0,2,2,2,1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60141627',2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60141758',2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60142167',0,2,0,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60151541',0,2,0,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60151678',0,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60152001',0,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60152156',0,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60152321',0,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60161125',0,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60161236',0,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60161369',0,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60161666',0,2,2,2,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60161762',0,2,2,2,1,1,1,1,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60162265',0,2,2,2,1,1,1,1,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60171367',0,2,0,2,0,2,2,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60171423',0,2,0,2,0,2,2,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60171648',2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60171662',2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172030',2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172101',0,2,0,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172122',2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172133',2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172164',2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172198',2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60172214',2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2),('60182154',2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2);
/*!40000 ALTER TABLE `attands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `StudentNum` varchar(20) NOT NULL,
  `ScoreAttand` int(3) NOT NULL DEFAULT '0',
  `scoreMid` int(3) NOT NULL DEFAULT '0',
  `scoreFinal` int(3) NOT NULL DEFAULT '0',
  `scoreHomework` int(3) NOT NULL DEFAULT '0',
  `scoreQuiz` int(3) NOT NULL DEFAULT '0',
  `scorePPT` int(3) NOT NULL DEFAULT '0',
  `scoreReport` int(3) NOT NULL DEFAULT '0',
  `scoreEtc` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`StudentNum`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`StudentNum`) REFERENCES `students` (`studentnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('60112147',70,59,13,34,74,90,100,100),('60121877',40,95,30,50,30,90,100,80),('60131455',87,40,20,70,77,80,100,100),('60141287',90,64,80,100,85,90,100,100),('60141460',90,52,92,96,55,80,100,100),('60141542',84,59,73,73,65,90,100,100),('60141627',97,100,70,45,62,100,100,100),('60141758',97,95,30,30,30,100,100,100),('60142167',77,44,10,70,53,100,90,100),('60151541',77,79,30,63,70,10,50,100),('60151678',87,68,30,60,80,100,90,60),('60152001',87,20,100,100,100,90,90,100),('60152156',87,24,30,47,32,70,100,100),('60152321',87,100,100,0,82,100,60,100),('60161125',84,63,80,60,65,10,100,20),('60161236',84,30,0,40,6,100,100,50),('60161369',84,14,28,40,30,100,100,100),('60161666',77,50,70,62,70,90,100,100),('60161762',57,98,100,92,94,90,70,60),('60162265',57,50,56,60,90,100,90,100),('60171367',40,51,21,91,72,0,100,80),('60171423',40,70,40,40,90,80,100,100),('60171648',70,17,44,32,63,90,100,80),('60171662',100,100,89,90,100,80,100,100),('60172030',100,86,77,88,100,100,100,100),('60172101',70,20,34,49,22,90,80,100),('60172122',90,50,24,43,82,80,100,100),('60172133',90,42,37,50,52,100,10,100),('60172164',90,70,40,70,55,90,100,100),('60172198',100,20,20,70,10,90,100,100),('60172214',100,39,8,71,51,80,80,100),('60182154',100,67,66,88,30,100,70,100);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setting`
--

DROP TABLE IF EXISTS `setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `setting` (
  `num` int(2) NOT NULL,
  `ratioAttand` int(2) DEFAULT '10',
  `ratioMid` int(2) DEFAULT '15',
  `ratioFinal` int(2) DEFAULT '20',
  `ratioHomework` int(2) DEFAULT '15',
  `ratioQuiz` int(2) DEFAULT '10',
  `ratioPPT` int(2) DEFAULT '10',
  `ratioReport` int(2) DEFAULT '10',
  `ratioEtc` int(2) DEFAULT '10',
  `ratioAP` int(2) DEFAULT '10',
  `ratioA0` int(2) DEFAULT '15',
  `ratioBP` int(2) DEFAULT '15',
  `ratioB0` int(2) DEFAULT '15',
  `ratioCP` int(2) DEFAULT '15',
  `ratioC0` int(2) DEFAULT '15',
  `ratioD` int(2) DEFAULT '10',
  `ratioF` int(2) DEFAULT '5',
  `privacy` int(1) DEFAULT '0',
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` VALUES (0,10,15,20,15,10,10,10,10,10,15,15,15,15,15,10,5,0);
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `StudentNum` varchar(8) NOT NULL,
  `StudentName` varchar(30) NOT NULL,
  `StudentGrade` int(1) NOT NULL,
  PRIMARY KEY (`StudentNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('60112147','유동환',4),('60121877','유현욱',4),('60131455','한성균',3),('60141287','조성식',4),('60141460','임세준',3),('60141542','송정민',3),('60141627','강병진',3),('60141758','김남홍',4),('60142167','전소미',2),('60151541','박윤호',2),('60151678','박대훈',2),('60152001','김재곤',2),('60152156','박철수',2),('60152321','김선학',3),('60161125','임석주',2),('60161236','김윤하',2),('60161369','이창헌',2),('60161666','유진',3),('60161762','김세은',2),('60162265','최재희',2),('60171367','박보은',2),('60171423','최진우',2),('60171648','김정석',2),('60171662','김새롬',2),('60172030','장민해',2),('60172101','김지은',2),('60172122','김성윤',2),('60172133','양예림',2),('60172164','박찬진',2),('60172198','김서연',2),('60172214','감재민',2),('60182154','김채린',1);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-18  0:01:55
