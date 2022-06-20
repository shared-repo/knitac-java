-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: trade_board
-- ------------------------------------------------------
-- Server version	10.7.3-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `tradeno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `writer` varchar(20) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `regdate` datetime NOT NULL DEFAULT current_timestamp(),
  `deleted` tinyint(4) NOT NULL DEFAULT 0,
  `categoryid` varchar(20) DEFAULT NULL,
  `views` int(11) DEFAULT 0,
  PRIMARY KEY (`tradeno`),
  KEY `fk_board_member_idx` (`writer`),
  KEY `fk_board_board_category1_idx` (`categoryid`),
  CONSTRAINT `fk_board_member` FOREIGN KEY (`writer`) REFERENCES `member` (`memberid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES
(82,'오늘 날씨가 비가와서 출근하기 힘드네요.','user','','2022-06-15 04:28:32',0,'Free',5),
(83,'자켓 팝니다 사실분 쪽지 주세요!','user','15만원 새상품\r\n12만원에 팔아요.','2022-06-15 04:33:08',0,'Trade',1),
(84,'안녕하세요 david입니다','david','이렇게 글을 한번 올려봅니다.\r\n눈이 한쪽이 안떠져서 혹시 오타가 있을 수 있습니다.','2022-06-15 06:06:12',0,'Trade',0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boardattach`
--

DROP TABLE IF EXISTS `boardattach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boardattach` (
  `attachno` int(11) NOT NULL AUTO_INCREMENT,
  `boardno` int(11) NOT NULL,
  `userfilename` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `savedfilename` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `downloadcount` int(11) DEFAULT 0,
  PRIMARY KEY (`attachno`),
  KEY `fk` (`boardno`),
  CONSTRAINT `fk` FOREIGN KEY (`boardno`) REFERENCES `board` (`tradeno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boardattach`
--

LOCK TABLES `boardattach` WRITE;
/*!40000 ALTER TABLE `boardattach` DISABLE KEYS */;
INSERT INTO `boardattach` VALUES
(53,82,'202206150648050001.jpg','cd5a0a48-5c19-43a7-a40e-2628c97f65fb.jpg',0),
(54,83,'165161223516198.jpg','f671da33-a21c-475a-a84c-fd11ab089e86.jpg',0);
/*!40000 ALTER TABLE `boardattach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `memberid` varchar(20) NOT NULL,
  `passwd` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `birth` datetime NOT NULL,
  `phone` varchar(20) NOT NULL,
  `manager` tinyint(4) NOT NULL DEFAULT 0,
  `regDate` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES
('123','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','123','0123-12-03 00:00:00','123123123',0,'2022-06-15 05:56:38'),
('david','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','김성익','2000-12-25 00:00:00','01044451234',0,'2022-06-15 06:02:59'),
('goliath','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','골리앗','1423-01-13 00:00:00','01099993321',0,'2022-06-15 06:18:27'),
('iamuser1','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','홍길동','2020-01-01 00:00:00','1231231234',0,'2022-06-13 08:19:09'),
('shin','78f463ea8e299e86d0a7a36e29217daf86692c2ae19347651daa67996395f172','신지영','2022-06-10 00:00:00','01012341234',0,'2022-06-10 05:59:54'),
('user','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','jyo','0001-01-01 00:00:00','123',1,'2022-06-13 08:26:27'),
('수강생김씨비번123','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','김성익','2000-12-25 00:00:00','01044451234',0,'2022-06-15 06:01:59');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `messageno` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(20) NOT NULL,
  `content` varchar(500) NOT NULL,
  `senddate` datetime NOT NULL DEFAULT current_timestamp(),
  `receivedate` datetime DEFAULT NULL,
  `receiver` varchar(20) NOT NULL,
  PRIMARY KEY (`messageno`),
  KEY `fk_send_member1_idx` (`sender`),
  KEY `fk_message_member1_idx` (`receiver`),
  CONSTRAINT `fk_message_member1` FOREIGN KEY (`receiver`) REFERENCES `member` (`memberid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_send_member1` FOREIGN KEY (`sender`) REFERENCES `member` (`memberid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES
(32,'123','123','2022-06-15 05:57:00',NULL,'iamuser1'),
(33,'david','쪽지를 보냅니다.\r\n\r\n님아 제시요!','2022-06-15 06:15:10',NULL,'iamuser1'),
(34,'goliath','다윗 잘지내냐?\r\n\r\n이마 아직도 아프다.','2022-06-15 06:19:58',NULL,'david'),
(35,'user','111','2022-06-15 07:08:46',NULL,'user');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `reportno` int(11) NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) NOT NULL,
  `content` varchar(500) NOT NULL,
  `regdate` datetime NOT NULL DEFAULT current_timestamp(),
  `title` varchar(100) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`reportno`),
  KEY `fk_board_member_idx` (`writer`),
  CONSTRAINT `fk_board_member1` FOREIGN KEY (`writer`) REFERENCES `member` (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `send`
--

DROP TABLE IF EXISTS `send`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `send` (
  `sendno` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `writer` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `writername` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `receiver` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `receivername` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(500) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime NOT NULL DEFAULT current_timestamp(),
  `readyn` varchar(1) COLLATE utf8mb3_unicode_ci NOT NULL DEFAULT 'N',
  PRIMARY KEY (`sendno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `send`
--

LOCK TABLES `send` WRITE;
/*!40000 ALTER TABLE `send` DISABLE KEYS */;
INSERT INTO `send` VALUES
('1','100','신지영','101','정우진','와 ㅋㅋㅋㅋㅋㅋ','2022-06-03 12:24:40','N'),
('10','100','신지영','102','이범규','내일은 화요일','2022-06-03 12:26:46','N'),
('2','100','신지영','101','정우진','ㅋㅋㅋㅋ','2022-06-03 12:26:41','N'),
('3','100','신지영','102','이범규','ㅋㅋㅋㅋㅋㅋㅋ','2022-06-03 12:26:42','N'),
('4','100','신지영','101','정우진','ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ','2022-06-03 12:26:43','N'),
('5','100','신지영','101','정우진','와 벌써화요일','2022-06-03 12:26:43','N'),
('6','100','신지영','101','정우진','놀고싶다','2022-06-03 12:26:44','N'),
('7','100','신지영','101','정우진','ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ','2022-06-03 12:26:44','N'),
('8','100','신지영','102','이범규','ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ','2022-06-03 12:26:45','N'),
('9','100','신지영','102','이범규','오예 ㅎㅎㅎㅎㅎ','2022-06-03 12:26:45','N');
/*!40000 ALTER TABLE `send` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-20  4:08:20
