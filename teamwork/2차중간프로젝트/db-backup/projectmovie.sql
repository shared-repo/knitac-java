-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: projectmovie
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `memberid` varchar(40) COLLATE utf8mb3_unicode_ci NOT NULL,
  `passwd` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `usertype` varchar(40) COLLATE utf8mb3_unicode_ci NOT NULL DEFAULT 'user',
  `active` tinyint(4) DEFAULT 1,
  `regdate` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES
('aaaa','61be55a8e2f6b4e172338bddf184d6dbee29c98853e0a0485ecee7f27b9af0b4','duly3003@naver.com','user',1,'2022-06-10 06:22:15'),
('abc','ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad','duly3003@naver.com','user',1,'2022-06-03 04:56:04'),
('AdminLHD','beb525577111e81d535db5e89f1c35692477e9c0008859033eefec3c5256be43','fjs456@naver.com','user',0,'2022-06-03 04:58:24'),
('duly','9c674815dcc7b39bd05d30b8cd432cfff8bf7ab2e2a1a6cae2f997f835e671e6','duly3003@naver.com','user',1,'2022-06-07 06:45:35'),
('duly3','96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e','kks@naver.com','admin',1,'2022-06-07 07:02:10'),
('duly30003','74234e98afe7498fb5daf1f36ac2d78acc339464f950703b8c019892f982b90b','epee6606@naver.com','user',1,'2022-06-03 01:45:31'),
('duly3003','73f38dc2025d2e4c338b224fdf267d30376a21bfdfc49c588425db85c488181b','epee6606@naver.com','user',1,'2022-06-07 06:46:50'),
('jkj','c617d97bba59d03c13ee004111cef6e65f330f53fc04ddf29dea3bd187ca757b','jkj@example.com','user',0,'2022-06-03 04:57:23'),
('jkj1','0b5570bd976a78dcdbc1ab69fcbcc5f2d04529e69106391928f8ad5f0b2c1db6','jkj1@example.com','user',1,'2022-06-07 03:04:01'),
('kkks','89f525958dfb418d9b52e13c26e218d0216844d45b3b83702c6b76a7ef8e5654','kkks@naver.com','user',0,'2022-06-08 07:50:46'),
('kks','500f879d65d8b31653d48c2ac0537e9088ed97229be5841fbd5db741cada0819','duly3003@naver.com','user',1,'2022-06-03 02:00:22'),
('LHD-Admin','beb525577111e81d535db5e89f1c35692477e9c0008859033eefec3c5256be43','fjs45678@gmail.com','user',0,'2022-06-07 00:27:39'),
('LHD-User','35aa5d3571bd32b86907e1cb820db6674dc71d50d8d20f0638e59caaa50fddc8','fjs45678@gmail.com','user',1,'2022-06-07 03:19:01'),
('LHDAdmin','35aa5d3571bd32b86907e1cb820db6674dc71d50d8d20f0638e59caaa50fddc8','fjs456@naver.com','admin',1,'2022-06-07 03:21:18'),
('lostArk','a614d286e1c96dc1300ccbf76d45dee73fd7b17ae4eaa5420d3fc513244ae52e','lostArk@naver.com','user',1,'2022-06-03 01:59:28'),
('max','74234e98afe7498fb5daf1f36ac2d78acc339464f950703b8c019892f982b90b','maxstim@daum.net','user',1,'2022-06-07 06:53:06'),
('test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','test@naver.com','user',1,'2022-06-15 06:09:42'),
('test2','60303ae22b998861bce3b28f33eec1be758a213c86c93c076dbe9f558c11c752','test@naver.com','user',1,'2022-06-15 06:33:59'),
('test3','96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e','test3@daum.net','user',1,'2022-06-15 09:19:54');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_board`
--

DROP TABLE IF EXISTS `free_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `free_board` (
  `boardno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(3000) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `readcount` int(11) DEFAULT 0,
  `deleted` tinyint(4) DEFAULT 0,
  `writer` varchar(40) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`boardno`),
  KEY `fk_free_board_account_idx` (`writer`),
  CONSTRAINT `fk_free_board_account` FOREIGN KEY (`writer`) REFERENCES `account` (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_board`
--

LOCK TABLES `free_board` WRITE;
/*!40000 ALTER TABLE `free_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_boardattach`
--

DROP TABLE IF EXISTS `free_boardattach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `free_boardattach` (
  `attachno` int(11) NOT NULL AUTO_INCREMENT,
  `userfilename` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `savefilename` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `downloadcount` int(11) DEFAULT 0,
  `free_board_boardno` int(11) NOT NULL,
  PRIMARY KEY (`attachno`),
  KEY `fk_free_boardattach_free_board1_idx` (`free_board_boardno`),
  CONSTRAINT `fk_free_boardattach_free_board1` FOREIGN KEY (`free_board_boardno`) REFERENCES `free_board` (`boardno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_boardattach`
--

LOCK TABLES `free_boardattach` WRITE;
/*!40000 ALTER TABLE `free_boardattach` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_boardattach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inqu_board`
--

DROP TABLE IF EXISTS `inqu_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inqu_board` (
  `boardno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(3000) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `deleted` tinyint(4) DEFAULT 0,
  `writer` varchar(40) COLLATE utf8mb3_unicode_ci NOT NULL,
  `lock` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`boardno`),
  KEY `fk_inqu_board_account1_idx` (`writer`),
  CONSTRAINT `fk_inqu_board_account1` FOREIGN KEY (`writer`) REFERENCES `account` (`memberid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inqu_board`
--

LOCK TABLES `inqu_board` WRITE;
/*!40000 ALTER TABLE `inqu_board` DISABLE KEYS */;
INSERT INTO `inqu_board` VALUES
(3,'수정된 글입니다.','수정테스트입니다.\r\n\r\n확인해주세요!','2022-06-03 07:35:22',0,'jkj',NULL),
(4,'test(수정)',' test(수정)','2022-06-03 08:17:01',1,'jkj',NULL),
(5,'test2','test2','2022-06-06 09:50:32',1,'jkj',NULL),
(6,'test4','test','2022-06-06 09:56:30',1,'jkj',NULL),
(7,'안녕하세요','안녕하세요','2022-06-06 10:06:16',0,'jkj',NULL),
(8,'안녕하세요','안녕하세요~~','2022-06-06 10:07:19',0,'jkj',NULL),
(9,'안녕하세요','123123','2022-06-07 00:44:21',0,'duly30003',NULL),
(10,'문의드립니다','빠른 결제를 바랍니다.','2022-06-07 01:58:43',0,'LHD-Admin',NULL),
(11,'하이용','!!!!!하이하이','2022-06-07 03:17:01',0,'jkj1',NULL),
(12,'ter()수정','tre(수정)','2022-06-07 05:57:35',0,'jkj',NULL),
(13,'tes','tes','2022-06-07 05:57:53',0,'jkj',NULL),
(14,'수정 테스트입니다.','빠른 확인을 부탁합니다.','2022-06-07 07:38:52',0,'LHDAdmin',NULL),
(15,'첨부파일 테스트','테스타ㅡ,','2022-06-07 07:40:33',0,'jkj',NULL),
(16,'첨부파일 테스트1','테스트','2022-06-07 07:41:36',0,'jkj',NULL),
(17,'하하호','하하호','2022-06-07 07:44:39',0,'duly3',NULL),
(18,'비밀글 테스트','테[스트','2022-06-07 07:54:43',0,'jkj',0),
(19,'비밀글 테스트1','xptmxm','2022-06-07 07:56:46',0,'jkj',0),
(20,'비밀글테스트2','테스트','2022-06-07 08:15:07',0,'jkj',1),
(21,'System testing','빠른 확인을 바랍니다.','2022-06-08 02:33:49',0,'LHDAdmin',1),
(22,'Testing','esdrwearewqa','2022-06-08 02:56:27',1,'jkj',1),
(23,'dsa','dsa','2022-06-08 05:01:01',0,'jkj',1),
(24,'test','test','2022-06-08 05:02:50',0,'jkj',1),
(25,'test','test','2022-06-08 05:10:22',1,'jkj',1),
(26,'test','test','2022-06-08 05:11:49',1,'jkj',1),
(27,'test','test','2022-06-08 05:13:53',1,'jkj',1),
(28,'123','123','2022-06-08 05:18:07',0,'jkj',1),
(29,'12312','321312','2022-06-08 05:20:02',0,'jkj',1),
(30,'321','321','2022-06-08 05:21:41',0,'jkj',1),
(31,'45545','54545','2022-06-08 05:23:14',0,'jkj',1),
(32,'5432','542','2022-06-08 05:28:30',0,'jkj',1),
(33,'첨부파일 테스트','확인 부탁드립니다.','2022-06-08 05:32:43',0,'LHDAdmin',1),
(34,'321321','321321','2022-06-08 05:36:39',1,'jkj',1),
(35,'412','421','2022-06-08 05:45:41',1,'jkj',1),
(36,'1561','023123','2022-06-08 05:48:53',0,'jkj',1),
(37,'1031','05231','2022-06-08 05:49:49',0,'jkj',1),
(38,'안녕하세요','123','2022-06-08 08:08:12',0,'duly3',1),
(39,'4312','4123dsa','2022-06-08 09:02:19',1,'jkj',1),
(40,'첨부파일 테스트','321','2022-06-08 09:03:39',0,'jkj',1),
(41,'첨부파일테스트','테스트','2022-06-08 09:10:13',0,'jkj',1),
(42,'412','412','2022-06-09 02:44:54',0,'jkj1',1),
(43,'321','321','2022-06-09 04:34:23',0,'jkj1',0),
(44,'test','testtes','2022-06-09 05:38:42',1,'jkj1',0),
(45,'321','321dsdas','2022-06-10 03:37:40',1,'jkj1',0),
(46,'EveryBody Do The Flop!','쾅쾅쾅쾅쾅','2022-06-10 05:53:06',0,'LHDAdmin',0),
(47,'첨부파일 테스트','빠른확인을바랍니다','2022-06-10 06:00:46',0,'LHDAdmin',0),
(48,'123','123','2022-06-10 06:15:04',1,'duly3',0),
(49,'asdada','asdadsa','2022-06-10 06:22:38',1,'aaaa',0),
(50,'테스트','123','2022-06-10 06:26:12',0,'aaaa',0),
(51,'123123','123123','2022-06-10 06:37:43',0,'duly3',0),
(55,'re(수정)','tes','2022-06-10 08:23:44',0,'jkj1',0),
(56,'teglib test','test','2022-06-10 08:24:31',1,'jkj1',0),
(57,'','','2022-06-15 05:50:51',0,'jkj1',0),
(58,'','','2022-06-15 05:50:52',0,'jkj1',0),
(59,'','ㅁㄴㅇㅁㄴㅇ','2022-06-15 06:40:00',0,'test2',0),
(60,'ㅁㄴㅇㅁㄴㅇ','ㅁㄴㅇㅁㄴㅇ','2022-06-15 06:40:07',0,'test2',0),
(61,'제목도 수정됨','수정됨','2022-06-15 07:07:44',1,'duly3',0),
(62,'test','123(수정)','2022-06-15 09:20:58',1,'test3',0);
/*!40000 ALTER TABLE `inqu_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inqu_boardattach`
--

DROP TABLE IF EXISTS `inqu_boardattach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inqu_boardattach` (
  `attachno` int(11) NOT NULL AUTO_INCREMENT,
  `userfilename` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `savedfilename` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `downloadcount` int(11) DEFAULT 0,
  `inqu_boardno` int(11) NOT NULL,
  PRIMARY KEY (`attachno`),
  KEY `fk_boardattach_inqu_board_idx` (`inqu_boardno`),
  CONSTRAINT `fk_boardattach_inqu_board` FOREIGN KEY (`inqu_boardno`) REFERENCES `inqu_board` (`boardno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inqu_boardattach`
--

LOCK TABLES `inqu_boardattach` WRITE;
/*!40000 ALTER TABLE `inqu_boardattach` DISABLE KEYS */;
INSERT INTO `inqu_boardattach` VALUES
(1,'4조 기능명세서.docx','8a017c8b-aefa-4ce8-a4b4-6a6a5f404713.docx',0,16),
(2,'music (1).mp3','569c8ac4-8b92-4793-b2e4-b9f28bef5896.mp3',0,21),
(3,'cat.mp4','6961a055-21a2-46c9-b965-ba34a7866671.mp4',0,33),
(4,'01. 지원자(OOO) 입사지원서 양식_강남아이티아카데미 이력서(워드).docx','757ff236-fc4c-4278-ae42-15ad79a66a9c.docx',0,41),
(5,'01. 지원자(OOO) 입사지원서 양식_강남아이티아카데미 강남(2022)_.hwp','6edd0c05-5c8b-4bf3-b17f-9bce39a55750.hwp',0,42),
(6,'4조 기능명세서.docx','e7443f2f-b609-4dd9-8853-67495df70380.docx',0,44),
(7,'토큰.txt','2c9a954c-3b84-4659-9ec7-2492fc11e6ec.txt',0,47),
(8,'hr.sql','438e0d48-9d33-4a8d-bb83-71d7ecb83a95.sql',0,49),
(11,'4조 기능명세서.docx','e0c332d3-8f6f-4579-b125-678746cab7c7.docx',0,56),
(12,'hr.sql','b842a7cc-0147-4df1-af5e-b9bd2c07cee2.sql',0,62);
/*!40000 ALTER TABLE `inqu_boardattach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_board`
--

DROP TABLE IF EXISTS `notice_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice_board` (
  `boardno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(3000) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `deleted` tinyint(4) DEFAULT 0,
  `writer` varchar(40) COLLATE utf8mb3_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`boardno`),
  KEY `fk_inqu_board_account1_idx` (`writer`),
  CONSTRAINT `fk_inqu_board_account10` FOREIGN KEY (`writer`) REFERENCES `account` (`memberid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_board`
--

LOCK TABLES `notice_board` WRITE;
/*!40000 ALTER TABLE `notice_board` DISABLE KEYS */;
INSERT INTO `notice_board` VALUES
(1,'system_testing','빠른 확인을 바랍니다.','2022-06-03 00:00:00',1,'AdminLHD','프로모션'),
(2,'asdfasdf','asdfsafd','2022-06-03 08:10:44',1,'abc','회원 재제'),
(3,'systemtesting','systemtest','2022-06-03 08:15:32',0,'abc','게시판 추가 및 삭제'),
(4,'asdf','asdf','2022-06-03 08:15:38',1,'abc','회원 재제'),
(5,'asdf','asdf','2022-06-03 08:15:44',1,'abc','회원 재제'),
(6,'system testing','system testing','2022-06-07 00:28:38',1,'abc','회원 재제'),
(7,'st','asdf','2022-06-07 01:42:39',0,'AdminLHD','편의 개선'),
(8,'asdf','asdf','2022-06-07 01:42:56',1,'abc','이벤트'),
(9,'wwww','wwwwwww','2022-06-07 01:43:09',1,'AdminLHD','회원 재제'),
(10,'wwwww','wwwwwww','2022-06-07 02:34:15',0,'LHD-Admin','회원 재제'),
(11,'asfd','asdfsafd','2022-06-07 02:34:50',1,'LHD-Admin','회원 재제'),
(12,'수정/삭제 테스트 1','System Test입니다.','2022-06-07 04:31:39',1,'LHDAdmin','프로모션'),
(13,'첨부파일 테스팅','asdfasfd','2022-06-07 04:38:14',1,'LHDAdmin','편의 개선'),
(14,'수정 테스트 123','ㅁㄴㅇㄹㅁㄴㅇㄻㄴㄹㅇ','2022-06-07 05:40:32',0,'LHDAdmin','회원 재제'),
(15,'수정 테스트 2','빠른 확인을 바랍니다.','2022-06-07 06:44:53',0,'LHDAdmin','이벤트'),
(16,'첨부파일 테스트','빠른 확인을 바랍니다.','2022-06-08 01:13:05',1,'LHDAdmin','회원 재제'),
(17,'asdfasdf','ㅁㄴㅇㄻㄴㅇㄹ','2022-06-09 05:56:40',1,'LHDAdmin','회원 재제'),
(18,'aaeeaaee','ㄱㄴㄷㄻㅄ','2022-06-09 05:57:58',1,'LHDAdmin','프로모션'),
(19,'System tesTing','HeYEEEYYEEEYY','2022-06-09 06:03:41',0,'LHDAdmin','편의 개선'),
(20,'WRYYYYYYY','WRYYYYY','2022-06-09 07:02:04',0,'LHDAdmin','게시판 추가 및 삭제'),
(21,'System testing','시스템 테스팅 시즌 464189152699호','2022-06-10 06:09:02',1,'LHDAdmin','게시판 추가 및 삭제'),
(22,'system testing','asdfasdf','2022-06-10 06:33:04',0,'LHDAdmin','이벤트'),
(23,'asd','asd','2022-06-15 06:53:32',1,'duly3','이벤트'),
(24,'화가 많이남','화가많이남','2022-06-15 07:08:45',0,'duly3','회원 재제'),
(25,'ㅁㄴㅇ','123123','2022-06-15 07:09:34',1,'duly3','회원 재제');
/*!40000 ALTER TABLE `notice_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_boardattach`
--

DROP TABLE IF EXISTS `notice_boardattach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice_boardattach` (
  `attachno` int(11) NOT NULL AUTO_INCREMENT,
  `userfilename` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `savefilename` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `downloadcount` int(11) NOT NULL DEFAULT 0,
  `notice_boardno` int(11) NOT NULL,
  PRIMARY KEY (`attachno`),
  KEY `fk_inqu_boardattach_copy1_notice_board1_idx` (`notice_boardno`),
  CONSTRAINT `fk_inqu_boardattach_copy1_notice_board1` FOREIGN KEY (`notice_boardno`) REFERENCES `notice_board` (`boardno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_boardattach`
--

LOCK TABLES `notice_boardattach` WRITE;
/*!40000 ALTER TABLE `notice_boardattach` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_boardattach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_board`
--

DROP TABLE IF EXISTS `review_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review_board` (
  `boardno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(5000) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `readcount` int(11) DEFAULT 0,
  `total` int(11) DEFAULT 0,
  `deleted` tinyint(4) DEFAULT 0,
  `writer` varchar(40) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`boardno`),
  KEY `fk_review_board_account1_idx` (`writer`),
  CONSTRAINT `fk_review_board_account1` FOREIGN KEY (`writer`) REFERENCES `account` (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_board`
--

LOCK TABLES `review_board` WRITE;
/*!40000 ALTER TABLE `review_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_boardattach`
--

DROP TABLE IF EXISTS `review_boardattach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review_boardattach` (
  `attachno` int(11) NOT NULL AUTO_INCREMENT,
  `userfilename` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `savefilename` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `downloadcount` int(11) DEFAULT 0,
  `review_board_boardno` int(11) NOT NULL,
  PRIMARY KEY (`attachno`),
  KEY `fk_inqu_boardattach_copy2_review_board1_idx` (`review_board_boardno`),
  CONSTRAINT `fk_inqu_boardattach_copy2_review_board1` FOREIGN KEY (`review_board_boardno`) REFERENCES `review_board` (`boardno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_boardattach`
--

LOCK TABLES `review_boardattach` WRITE;
/*!40000 ALTER TABLE `review_boardattach` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_boardattach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-20  4:07:44
