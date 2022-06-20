-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: teamone
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
  `boardno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(4000) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime NOT NULL DEFAULT current_timestamp(),
  `readcount` int(11) NOT NULL DEFAULT 0,
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  `category` varchar(5) COLLATE utf8mb3_unicode_ci NOT NULL,
  `writer` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `posttype` varchar(5) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`boardno`),
  KEY `fk_board_member1_idx` (`writer`),
  CONSTRAINT `fk_board_member1` FOREIGN KEY (`writer`) REFERENCES `member` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES
(3,'','','2022-06-02 06:53:06',0,0,'info','dd',NULL),
(4,'','','2022-06-02 07:28:23',0,0,'info','dd',NULL),
(6,'하이라이트 1','하이라이트 1','2022-06-02 07:49:49',1,1,'highl','dd',NULL),
(7,'dd','ddd','2022-06-02 08:56:08',0,0,'info','dd',NULL),
(8,'aaa','dddd','2022-06-02 09:02:46',0,0,'info','aa',NULL),
(13,'테스트','테스트','2022-06-03 04:01:00',0,0,'info','dd',NULL),
(16,'하이라이트 21','하이라이트 21','2022-06-03 09:11:42',0,0,'highl','dd',NULL),
(21,'하이라이트 5','하이라이트 5','2022-06-07 01:53:54',0,1,'highl','dd',NULL),
(22,'하이라이트 6','하이라이트 6','2022-06-07 03:58:07',0,0,'highl','dd',NULL),
(23,'하이라이트 7','하이라이트 7','2022-06-07 03:58:20',0,0,'highl','dd',NULL),
(24,'하이라이트 8','하이라이트 8','2022-06-07 03:58:29',0,0,'highl','dd',NULL),
(25,'하이라이트 9','하이라이트 9','2022-06-07 03:58:41',0,0,'highl','dd',NULL),
(26,'20220607secondtest','secondtest','2022-06-07 04:26:23',0,0,'free','dd',NULL),
(29,'thirdtst','thirdtst','2022-06-07 04:47:30',0,0,'free','dd',NULL),
(30,'하이라이트 10','하이라이트 10','2022-06-07 05:03:27',0,0,'highl','dd',NULL),
(31,'자유게시판 게시글 내용 확인 테스트','on test','2022-06-07 05:08:22',0,0,'free','dd',NULL),
(32,'등록 후 게시글 상세보기 페이지 여부 테스트','on test','2022-06-07 05:13:09',0,0,'free','dd',NULL),
(33,'게시글 작성 후 게시판으로 이동 테스트--성공','게시글 내용 보기 구현 문제 해결 및 완성할것','2022-06-07 05:14:44',0,0,'free','dd',NULL),
(34,'하이라이트 11','하이라이트 11','2022-06-07 05:20:40',0,0,'highl','dd',NULL),
(39,'여러줄 쓰기 테스트중','on t\r\ne\r\ns\r\nt','2022-06-07 06:56:26',0,0,'free','dd',NULL),
(43,'하이라이트 111','하이라이트 111','2022-06-07 07:38:54',0,0,'highl','dd',NULL),
(44,'하이라이트 112','하이라이트 112','2022-06-07 07:41:06',0,0,'highl','dd',NULL),
(45,'하이라이트 113','하이라이트 113','2022-06-07 07:41:46',0,0,'highl','dd',NULL),
(46,'하이라이트 편집','하이라이트 편wlq','2022-06-07 07:46:34',0,0,'highl','dd',NULL),
(49,'적정사이즈 측정중','뭐','2022-06-07 10:19:03',0,0,'free','dd',NULL),
(50,'한페이지 게시글','몇개면 될까','2022-06-07 10:19:16',0,0,'free','dd',NULL),
(51,'1','1','2022-06-07 10:19:36',0,0,'free','dd',NULL),
(52,'게시글 2','yee','2022-06-07 10:19:47',0,0,'free','dd',NULL),
(53,'게시글번호 수정','no를 No로','2022-06-07 10:59:58',0,0,'free','dd',NULL),
(55,'더 테스트','The test','2022-06-07 11:01:52',0,0,'free','dd',NULL),
(57,'더해보자','어디까지 가나 보자','2022-06-07 11:03:35',0,0,'free','dd',NULL),
(65,'테스트','ㅇㅇ','2022-06-08 03:12:25',0,0,'info','venus',NULL),
(66,'ㅇㅇㅇ','11111\r\n			                ','2022-06-08 03:13:11',0,0,'info','venus',NULL),
(67,'v','ㄹㄹ','2022-06-08 03:14:31',0,0,'info','venus',NULL),
(68,'','하이라이트 11111','2022-06-08 04:08:00',0,0,'highl','dd',NULL),
(69,'하이라이트 1234','하이라이트 1234','2022-06-08 04:22:41',1,0,'highl','dd',NULL),
(70,'페이지 넘어가는지 확인중','이상여부 확인','2022-06-08 05:32:15',0,0,'free','dd',NULL),
(71,'졸음깰 음료수 추천받는다','1. 박카스\r\n2. 구론산\r\n3. 기타등등','2022-06-08 06:06:58',0,0,'free','dd',NULL),
(72,'20220608 최종 오류메시지(페이지 설정)','java.sql.SQLException: Before start of result set\r\n	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129)\r\n	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)\r\n	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:89)\r\n	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:63)\r\n	at com.mysql.cj.jdbc.result.ResultSetImpl.checkRowPos(ResultSetImpl.java:532)\r\n	at com.mysql.cj.jdbc.result.ResultSetImpl.getObject(ResultSetImpl.java:1322)\r\n	at com.mysql.cj.jdbc.result.ResultSetImpl.getInt(ResultSetImpl.java:830)\r\n	at com.teamone.dao.FreeBoardDao.selectBoardCount(FreeBoardDao.java:215)\r\n	at com.teamone.service.FreeBoardService.findBoardCount(FreeBoardService.java:41)\r\n	at com.teamone.servlet.FreeBoardListServlet.doGet(FreeBoardListServlet.java:41)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197)\r\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\r\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\r\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135)\r\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\r\n	at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:687)\r\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\r\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360)\r\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399)\r\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\r\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:890)\r\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1743)\r\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)\r\n	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\r\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n	at java.base/java.lang.Thread.run(Thread.java:833)\r\n','2022-06-08 11:09:55',0,0,'free','dd',NULL),
(73,'tst','tst1','2022-06-09 01:24:09',0,0,'free','dd',NULL),
(78,'글번호가 세로로 증가중','버튼이 문제인가?','2022-06-09 05:21:16',0,0,'free','dd',NULL),
(79,'3페이지 만드는중','도배중','2022-06-09 06:03:01',0,0,'free','dd',NULL),
(80,'3페이지','','2022-06-09 06:03:08',0,0,'free','dd',NULL),
(82,'실험','','2022-06-09 06:03:49',0,0,'free','dd',NULL),
(84,'테스트중','','2022-06-09 06:04:09',0,0,'free','dd',NULL),
(85,'test','test','2022-06-09 06:04:20',0,0,'free','dd',NULL),
(86,'testing','','2022-06-09 06:04:39',0,0,'free','dd',NULL),
(87,'on test','','2022-06-09 06:04:44',0,0,'free','dd',NULL),
(88,'실험중','','2022-06-09 06:05:08',0,0,'free','dd',NULL),
(89,'ㅇㅇ','','2022-06-09 06:05:21',0,0,'free','dd',NULL),
(90,'도배아님','','2022-06-09 06:07:00',0,0,'free','dd','일상'),
(91,'눈치게임 1','2\r\n3 3\r\n아\r\n3 나와','2022-06-09 06:08:00',0,0,'free','dd','유머'),
(93,'낙서장입니다','선넘는 발언만 하지 말고 쓰고싶은말 다 쓰세요','2022-06-09 09:04:29',0,0,'free','dd','정보'),
(94,'ㅇㅇ','ㅇㅇ','2022-06-09 14:45:52',0,0,'info','dd',NULL),
(95,'ㅇㅇ','ㅇㅇ','2022-06-09 14:47:37',0,0,'info','dd',NULL),
(98,'dd','0','2022-06-10 07:13:41',0,0,'free','dd','일상'),
(100,'분류테스트','분류 나오는지 시험중','2022-06-10 09:26:16',0,0,'free','dd','일상'),
(101,'게시글 상세보기 밀림현상 해결 완료','Dao sql 구문에서 posttype이 추가가 안되어있었음','2022-06-10 10:07:55',0,0,'free','dd','정보'),
(102,'분류 수정 테스트','유머를 정보로\r\n구현 완료','2022-06-10 10:08:22',0,0,'free','dd','정보'),
(103,'글쓰기 페이지 JQuery 변환 테스트','이상여부 확인요망','2022-06-13 07:19:46',0,0,'free','dd','일상'),
(104,'잡담란 신설','별 이상은 없겠지','2022-06-13 07:20:55',0,0,'free','dd','잡담'),
(105,'다시 테스트중','이상여부 확인','2022-06-13 07:28:08',0,0,'free','dd','잡담'),
(108,'ㅁㅁ11','하이 테스트','2022-06-13 07:56:06',0,0,'highl','dd',NULL),
(109,'수정은 되냐','안되면 큰일인데','2022-06-13 08:02:09',0,0,'free','dd','일상'),
(112,'ㅇㅇㅇㅇㅇㅇ','			                dd\r\n			                ','2022-06-13 09:53:42',0,0,'info','dd',NULL),
(113,'ㅇㅇㅇ','ㅇㅇ','2022-06-15 09:00:30',0,0,'info','dd',NULL),
(114,'ㅇㅇㅇ','ㅇㅇ','2022-06-15 09:40:45',0,0,'info','dd',NULL);
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
  `userfilename` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `savedfilename` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `downloadcount` int(11) NOT NULL DEFAULT 0,
  `boardno` int(11) NOT NULL,
  PRIMARY KEY (`attachno`),
  KEY `fk_boardattach_board_idx` (`boardno`),
  CONSTRAINT `fk_boardattach_board` FOREIGN KEY (`boardno`) REFERENCES `board` (`boardno`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boardattach`
--

LOCK TABLES `boardattach` WRITE;
/*!40000 ALTER TABLE `boardattach` DISABLE KEYS */;
INSERT INTO `boardattach` VALUES
(3,'스크린샷(1).png','427e6650-f1ba-4072-9560-bcf1a5a1eba1.png',0,30),
(4,'nature-1.jpg','0ff68c13-be8c-437d-88b6-b135bfd6ca67.jpg',0,34),
(5,'스크린샷(1).png','36ac9e76-2ba0-49c1-aebb-d87b0a4aa9ec.png',0,45),
(6,'스크린샷(1).png','dfe628e3-d6e0-4e81-9a49-57a49f4f2a47.png',0,46),
(7,'스크린샷(1).png','656eef68-9fc8-4c47-8c6e-c3bdcdf91709.png',0,68),
(8,'스크린샷(1).png','424bdd17-493c-4a89-bc95-fcf8f2c779a4.png',0,69),
(9,'스크린샷(1).png','0936c825-588d-4694-a429-2177e2806f57.png',0,108);
/*!40000 ALTER TABLE `boardattach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boardcomment`
--

DROP TABLE IF EXISTS `boardcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boardcomment` (
  `commentno` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) COLLATE utf8mb3_unicode_ci NOT NULL,
  `regdate` datetime NOT NULL DEFAULT current_timestamp(),
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  `groupno` int(11) NOT NULL,
  `step` int(11) NOT NULL,
  `depth` int(11) NOT NULL,
  `boardno` int(11) NOT NULL,
  `writer` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`commentno`),
  KEY `fk_boardcomment_board1_idx` (`boardno`),
  KEY `fk_boardcomment_member1_idx` (`writer`),
  CONSTRAINT `fk_boardcomment_board1` FOREIGN KEY (`boardno`) REFERENCES `board` (`boardno`),
  CONSTRAINT `fk_boardcomment_member1` FOREIGN KEY (`writer`) REFERENCES `member` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boardcomment`
--

LOCK TABLES `boardcomment` WRITE;
/*!40000 ALTER TABLE `boardcomment` DISABLE KEYS */;
INSERT INTO `boardcomment` VALUES
(2,'abcdd','2022-06-14 08:27:36',0,0,1,0,108,'dd'),
(3,'vdfawef','2022-06-15 01:31:55',1,0,1,0,108,'dd'),
(8,'꿀잼입니다\r\n\r\nㄴㄴㄴ\r\n','2022-06-15 02:07:27',0,0,1,0,108,'dd'),
(9,'ㅂㅈㄷㄱㅁㄴㅇ','2022-06-15 03:00:15',0,0,1,0,69,'dd'),
(10,'ㅂㅈㄷㄱㅁㄴㅇ12','2022-06-15 03:00:20',0,0,1,0,69,'dd'),
(11,'asdff','2022-06-15 04:16:28',0,0,1,0,22,'dd');
/*!40000 ALTER TABLE `boardcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `userid` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `nickname` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `passwd` varchar(15) COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(25) COLLATE utf8mb3_unicode_ci NOT NULL,
  `usertype` varchar(10) COLLATE utf8mb3_unicode_ci DEFAULT 'user',
  `regdate` datetime DEFAULT current_timestamp(),
  `active` tinyint(1) DEFAULT 1,
  `welcome` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `gender` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES
('aa','aa','aa','aa','user','2022-06-02 09:01:49',1,'aa',2),
('dd','dd','dd','dd@example.com','user','2022-06-02 06:51:58',1,'dd',1),
('venus','venus','venus','venus','user','2022-06-07 04:40:00',1,'venus',1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rec`
--

DROP TABLE IF EXISTS `rec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rec` (
  `rec_no` int(11) NOT NULL AUTO_INCREMENT,
  `boardno` int(11) NOT NULL,
  `userid` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`rec_no`),
  KEY `fk_rec_board1_idx` (`boardno`),
  KEY `fk_rec_member1_idx` (`userid`),
  CONSTRAINT `fk_rec_board1` FOREIGN KEY (`boardno`) REFERENCES `board` (`boardno`),
  CONSTRAINT `fk_rec_member1` FOREIGN KEY (`userid`) REFERENCES `member` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rec`
--

LOCK TABLES `rec` WRITE;
/*!40000 ALTER TABLE `rec` DISABLE KEYS */;
/*!40000 ALTER TABLE `rec` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-20  4:08:01
