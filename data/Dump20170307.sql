CREATE DATABASE  IF NOT EXISTS `schoolpal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `schoolpal`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: schoolpal
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.20-MariaDB

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
-- Table structure for table `t_activity`
--

DROP TABLE IF EXISTS `t_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity` (
  `id` int(11) NOT NULL,
  `root_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `budget` decimal(8,2) DEFAULT NULL,
  `cost` decimal(8,2) DEFAULT NULL,
  `exective_id` char(50) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `root_id` (`root_id`),
  KEY `parent_id` (`parent_id`),
  KEY `fk_t_activity_t_user1_idx` (`exective_id`),
  KEY `fk_t_activity_t_user2_idx` (`creator_id`),
  CONSTRAINT `fk_t_activity_t_user1` FOREIGN KEY (`exective_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_activity_t_user2` FOREIGN KEY (`creator_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_command_type`
--

DROP TABLE IF EXISTS `t_command_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_command_type` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_code` varchar(50) DEFAULT NULL,
  `c_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_command_type`
--

LOCK TABLES `t_command_type` WRITE;
/*!40000 ALTER TABLE `t_command_type` DISABLE KEYS */;
INSERT INTO `t_command_type` VALUES (1,'Add','Add'),(2,'Mod','Modify'),(3,'Del','Delete'),(4,'Auth','Authorize');
/*!40000 ALTER TABLE `t_command_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_contact`
--

DROP TABLE IF EXISTS `t_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contact` (
  `id` char(50) NOT NULL,
  `leads_id` char(50) DEFAULT NULL,
  `approach` varchar(45) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `executive_id` char(50) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_contact_t_user1_idx` (`executive_id`),
  KEY `fk_t_contact_t_leads1_idx` (`leads_id`),
  CONSTRAINT `fk_t_contact_t_leads1` FOREIGN KEY (`leads_id`) REFERENCES `t_leads` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contact_t_user1` FOREIGN KEY (`executive_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contact`
--

LOCK TABLES `t_contact` WRITE;
/*!40000 ALTER TABLE `t_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_contract`
--

DROP TABLE IF EXISTS `t_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contract` (
  `id` char(50) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `original_price` decimal(8,2) DEFAULT NULL,
  `discount_price` decimal(8,2) DEFAULT NULL,
  `final_price` decimal(8,2) DEFAULT NULL,
  `paid` decimal(8,2) DEFAULT NULL,
  `course_type` varchar(45) DEFAULT NULL,
  `course_ori_id` int(1) DEFAULT NULL,
  `course_hours` varchar(45) DEFAULT NULL,
  `course_times` varchar(45) DEFAULT NULL,
  `stu_ori_id` char(50) DEFAULT NULL,
  `stu_firstname` varchar(45) DEFAULT NULL,
  `stu_lastname` varchar(45) DEFAULT NULL,
  `stu_gender` int(1) DEFAULT NULL,
  `stu_id_type` int(1) DEFAULT NULL,
  `stu_id_code` varchar(45) DEFAULT NULL,
  `stu_birthday` varchar(45) DEFAULT NULL,
  `stu_grade` varchar(45) DEFAULT NULL,
  `stu_school_name` varchar(45) DEFAULT NULL,
  `orgnization_id` char(50) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `executive_id` char(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_contract_t_student1_idx` (`stu_ori_id`),
  KEY `fk_t_contract_t_course_session1_idx` (`course_ori_id`),
  KEY `fk_t_contract_t_id_type1_idx` (`stu_id_type`),
  KEY `fk_t_contract_t_user1_idx` (`creator_id`),
  KEY `fk_t_contract_t_user2_idx` (`executive_id`),
  KEY `fk_t_contract_t_org1_idx` (`orgnization_id`),
  CONSTRAINT `fk_t_contract_t_course_session1` FOREIGN KEY (`course_ori_id`) REFERENCES `t_course_session` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contract_t_id_type1` FOREIGN KEY (`stu_id_type`) REFERENCES `t_id_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contract_t_org1` FOREIGN KEY (`orgnization_id`) REFERENCES `t_org` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contract_t_student1` FOREIGN KEY (`stu_ori_id`) REFERENCES `t_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contract_t_user1` FOREIGN KEY (`creator_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contract_t_user2` FOREIGN KEY (`executive_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contract`
--

LOCK TABLES `t_contract` WRITE;
/*!40000 ALTER TABLE `t_contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_contract_parent`
--

DROP TABLE IF EXISTS `t_contract_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contract_parent` (
  `id` char(20) NOT NULL,
  `contract_id` char(20) DEFAULT NULL,
  `parent_ori_id` char(20) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `weichat` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `relationship` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_contract_customer_t_customer1_idx` (`parent_ori_id`),
  KEY `fk_t_contract_customer_t_contract1_idx` (`contract_id`),
  CONSTRAINT `fk_t_contract_customer_t_contract1` FOREIGN KEY (`contract_id`) REFERENCES `t_contract` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_contract_customer_t_customer1` FOREIGN KEY (`parent_ori_id`) REFERENCES `t_parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contract_parent`
--

LOCK TABLES `t_contract_parent` WRITE;
/*!40000 ALTER TABLE `t_contract_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contract_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course_prototype`
--

DROP TABLE IF EXISTS `t_course_prototype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course_prototype` (
  `id` int(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `hours` decimal(4,2) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_course_prototype_t_course_type1_idx` (`type`),
  CONSTRAINT `fk_t_course_prototype_t_course_type1` FOREIGN KEY (`type`) REFERENCES `t_course_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course_prototype`
--

LOCK TABLES `t_course_prototype` WRITE;
/*!40000 ALTER TABLE `t_course_prototype` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_course_prototype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course_session`
--

DROP TABLE IF EXISTS `t_course_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course_session` (
  `id` int(11) NOT NULL,
  `proto_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `hours` decimal(4,2) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_course_t_course_prototype1_idx` (`proto_id`),
  CONSTRAINT `fk_t_course_t_course_prototype1` FOREIGN KEY (`proto_id`) REFERENCES `t_course_prototype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course_session`
--

LOCK TABLES `t_course_session` WRITE;
/*!40000 ALTER TABLE `t_course_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_course_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course_type`
--

DROP TABLE IF EXISTS `t_course_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course_type` (
  `id` int(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course_type`
--

LOCK TABLES `t_course_type` WRITE;
/*!40000 ALTER TABLE `t_course_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_crm_audit`
--

DROP TABLE IF EXISTS `t_crm_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_crm_audit` (
  `id` bigint(20) NOT NULL,
  `table` varchar(45) DEFAULT NULL,
  `prime_id` char(50) DEFAULT NULL,
  `action_user_id` char(50) DEFAULT NULL,
  `action_type` varchar(45) DEFAULT NULL,
  `action_time` datetime DEFAULT NULL,
  `old_value` text,
  `new_value` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_crm_audit`
--

LOCK TABLES `t_crm_audit` WRITE;
/*!40000 ALTER TABLE `t_crm_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_function`
--

DROP TABLE IF EXISTS `t_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_function` (
  `c_id` char(50) NOT NULL,
  `c_root_id` varchar(50) DEFAULT NULL,
  `c_parent_id` varchar(50) DEFAULT NULL,
  `c_name_short` varchar(50) DEFAULT NULL,
  `c_name_long` varchar(50) DEFAULT NULL,
  `c_action` varchar(255) DEFAULT NULL,
  `c_widget_type_id` int(11) DEFAULT NULL,
  `c_order_num` int(11) DEFAULT NULL,
  `c_icon` varchar(50) DEFAULT NULL,
  `c_command_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `c_order` (`c_order_num`),
  KEY `c_root_id` (`c_root_id`,`c_order_num`),
  KEY `c_parent_id` (`c_parent_id`,`c_order_num`),
  KEY `fk_t_function_t_widget_type1_idx` (`c_widget_type_id`),
  KEY `fk_t_function_t_command_type1_idx` (`c_command_type_id`),
  KEY `c_action` (`c_action`),
  CONSTRAINT `fk_t_function_t_command_type1` FOREIGN KEY (`c_command_type_id`) REFERENCES `t_command_type` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_function_t_widget_type1` FOREIGN KEY (`c_widget_type_id`) REFERENCES `t_widget_type` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_function`
--

LOCK TABLES `t_function` WRITE;
/*!40000 ALTER TABLE `t_function` DISABLE KEYS */;
INSERT INTO `t_function` VALUES 
('1','1','1','市场','市场管理','/ajax/mkt/',1,1,'',NULL),
('1-1','1','1','','市场活动','/ajax/mkt/',2,1,'',NULL),
('1-1-1','1','1-1','','新建','/ajax/mkt/activity/add.do',3,1,'',1),
('1-1-2','1','1-1','','编辑','/ajax/mkt/activity/mod.do',3,2,'',2),
('1-1-3','1','1-1','','删除','/ajax/mkt/activity/del.do',3,3,'',3),
('1-2','1','1','','销售线索','/ajax/mkt/',2,1,'',NULL),
('1-2-1','1','1-2','','新建','/ajax/mkt/leads/add.do',3,1,'',1),
('1-2-2','1','1-2','','编辑','/ajax/mkt/leads/mod.do',3,2,'',2),
('1-2-3','1','1-2','','删除','/ajax/mkt/leads/del.do',3,3,'',3),
('2','2','2','销售','销售管理','/ajax/sales',1,2,'',NULL),
('3','3','3','客服','客户服务','/ajax/service',1,3,'',NULL),
('4','4','4','财务','财务管理','/ajax/finance',1,4,'',NULL),
('5','5','5','教务','教务管理','/ajax/academy',1,5,'',NULL),
('6','6','6','教学','教学管理','/ajax/education',1,6,'',NULL),
('7','7','7','系统','系统管理','/sys/',1,7,'',NULL),
('7-1','7','7','','组织管理','/ajax/sys/',2,1,'',NULL),
('7-1-1','7','7-1','','新建','/config/sys/org/add.do',3,1,'',1),
('7-1-2','7','7-1','','编辑','/config/sys/org/mod.do',3,2,'',2),
('7-1-3','7','7-1','','删除','/config/sys/org/del.do',3,3,'',3),
('7-2','7','7','','角色管理','/config/sys/role/',2,2,'',NULL),
('7-2-1','7','7-2','','新建','/config/sys/role/add.do',3,1,'',1),
('7-2-2','7','7-2','','编辑','/config/sys/role/mod.do',3,2,'',2),
('7-2-3','7','7-2','','删除','/config/sys/role/new.do',3,3,'',3),
('7-3','7','7','','权限管理','/config/sys/auth/',2,3,'',NULL),
('7-3-1','7','7-3','','授权','/config/sys/auth/mod.do',3,1,'',4),
('7-4','7','7','','用户管理','/config/sys/user/',2,4,'',NULL),
('7-4-1','7','7-4','','新建','/config/sys/user/add.do',3,1,'',1),
('7-4-2','7','7-4','','编辑','/config/sys/user/mod.do',3,2,'',2),
('7-4-3','7','7-4','','删除','/config/sys/user/del.do',3,3,'',3),
('7-4-4','7','7-4','','启用','/config/sys/user/enable.do',3,4,'',NULL),
('7-4-5','7','7-4','','停用','/config/sys/user/disable.do',3,5,'',NULL);
/*!40000 ALTER TABLE `t_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_id_type`
--

DROP TABLE IF EXISTS `t_id_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_id_type` (
  `id` int(1) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_id_type`
--

LOCK TABLES `t_id_type` WRITE;
/*!40000 ALTER TABLE `t_id_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_id_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_index`
--

DROP TABLE IF EXISTS `t_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_index` (
  `c_table` varchar(50) NOT NULL,
  `c_prefix` varchar(50) DEFAULT NULL,
  `c_current` bigint(20) unsigned DEFAULT NULL,
  `c_step` int(11) DEFAULT NULL,
  `c_bits` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`c_table`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_index`
--

LOCK TABLES `t_index` WRITE;
/*!40000 ALTER TABLE `t_index` DISABLE KEYS */;
INSERT INTO `t_index` VALUES ('t_log','161227',1209,1,15),('t_org','161227',2,1,8),('t_role','161227',2,1,8),('t_user','161227',3,1,8),('t_user_role','161227',7,1,8);
/*!40000 ALTER TABLE `t_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads`
--

DROP TABLE IF EXISTS `t_leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads` (
  `id` char(50) NOT NULL,
  `course_type` varchar(45) DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `source` int(1) DEFAULT NULL,
  `channel` int(11) DEFAULT NULL,
  `stage` int(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `orgnization_id` char(50) DEFAULT NULL,
  `executive_id` char(50) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_leads_t_leads_status1_idx` (`status`),
  KEY `fk_t_leads_t_leads_stage1_idx` (`stage`),
  KEY `fk_t_leads_t_leads_source1_idx` (`source`),
  KEY `fk_t_leads_t_leads_type1_idx` (`type`),
  KEY `fk_t_leads_t_user1_idx` (`creator_id`),
  KEY `fk_t_leads_t_user2_idx` (`executive_id`),
  KEY `fk_t_leads_t_org1_idx` (`orgnization_id`),
  KEY `fk_t_leads_t_activity1_idx` (`channel`),
  CONSTRAINT `fk_t_leads_t_activity1` FOREIGN KEY (`channel`) REFERENCES `t_activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_leads_source1` FOREIGN KEY (`source`) REFERENCES `t_leads_source` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_leads_stage1` FOREIGN KEY (`stage`) REFERENCES `t_leads_stage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_leads_status1` FOREIGN KEY (`status`) REFERENCES `t_leads_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_leads_type1` FOREIGN KEY (`type`) REFERENCES `t_leads_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_org1` FOREIGN KEY (`orgnization_id`) REFERENCES `t_org` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_user1` FOREIGN KEY (`creator_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_t_user2` FOREIGN KEY (`executive_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads`
--

LOCK TABLES `t_leads` WRITE;
/*!40000 ALTER TABLE `t_leads` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads_parent`
--

DROP TABLE IF EXISTS `t_leads_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_parent` (
  `leads_id` char(50) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `weichat` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `id_type` int(1) DEFAULT NULL,
  `id_code` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `executive_id` varchar(50) DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`leads_id`),
  UNIQUE KEY `c_cellphone_UNIQUE` (`cellphone`),
  UNIQUE KEY `id_type_code_UNIQUE` (`id_type`,`id_code`),
  KEY `fk_t_leads_customer_t_user1_idx` (`creator_id`),
  KEY `fk_t_leads_customer_t_user2_idx` (`executive_id`),
  CONSTRAINT `fk_t_leads_customer_t_id_type1` FOREIGN KEY (`id_type`) REFERENCES `t_id_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_customer_t_leads1` FOREIGN KEY (`leads_id`) REFERENCES `t_leads` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_customer_t_user1` FOREIGN KEY (`creator_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_customer_t_user2` FOREIGN KEY (`executive_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads_parent`
--

LOCK TABLES `t_leads_parent` WRITE;
/*!40000 ALTER TABLE `t_leads_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads_source`
--

DROP TABLE IF EXISTS `t_leads_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_source` (
  `id` int(1) NOT NULL,
  `type` int(1) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads_source`
--

LOCK TABLES `t_leads_source` WRITE;
/*!40000 ALTER TABLE `t_leads_source` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads_stage`
--

DROP TABLE IF EXISTS `t_leads_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_stage` (
  `id` int(1) NOT NULL,
  `type` int(1) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads_stage`
--

LOCK TABLES `t_leads_stage` WRITE;
/*!40000 ALTER TABLE `t_leads_stage` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads_status`
--

DROP TABLE IF EXISTS `t_leads_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_status` (
  `id` int(1) NOT NULL,
  `type` int(1) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads_status`
--

LOCK TABLES `t_leads_status` WRITE;
/*!40000 ALTER TABLE `t_leads_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads_student`
--

DROP TABLE IF EXISTS `t_leads_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_student` (
  `leads_id` char(50) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `id_type` int(1) DEFAULT NULL,
  `id_code` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `school_grade` varchar(45) DEFAULT NULL,
  `class_grade` varchar(45) DEFAULT NULL,
  `school_name` varchar(45) DEFAULT NULL,
  `executive_id` char(50) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`leads_id`),
  KEY `id_type_code` (`id_type`,`id_code`),
  KEY `fk_t_leads_student_t_user1_idx` (`executive_id`),
  KEY `fk_t_leads_student_t_user2_idx` (`creator_id`),
  CONSTRAINT `fk_t_leads_student_t_id_type1` FOREIGN KEY (`id_type`) REFERENCES `t_id_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_student_t_leads1` FOREIGN KEY (`leads_id`) REFERENCES `t_leads` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_student_t_user1` FOREIGN KEY (`executive_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_leads_student_t_user2` FOREIGN KEY (`creator_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads_student`
--

LOCK TABLES `t_leads_student` WRITE;
/*!40000 ALTER TABLE `t_leads_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leads_type`
--

DROP TABLE IF EXISTS `t_leads_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_type` (
  `id` int(1) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leads_type`
--

LOCK TABLES `t_leads_type` WRITE;
/*!40000 ALTER TABLE `t_leads_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log`
--

DROP TABLE IF EXISTS `t_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log` (
  `c_id` char(50) NOT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  `c_type` varchar(50) DEFAULT NULL,
  `c_title` varchar(50) DEFAULT NULL,
  `c_desc` varchar(2048) DEFAULT NULL,
  `c_debug` text,
  `c_service_ip` varchar(50) DEFAULT NULL,
  `c_user_ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log`
--

LOCK TABLES `t_log` WRITE;
/*!40000 ALTER TABLE `t_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_org`
--

DROP TABLE IF EXISTS `t_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_org` (
  `c_id` char(50) NOT NULL,
  `c_code` varchar(50) NOT NULL,
  `c_name` varchar(50) DEFAULT NULL,
  `c_name_abbr` varchar(50) DEFAULT NULL,
  `c_address` varchar(512) DEFAULT NULL,
  `c_state` varchar(50) DEFAULT NULL,
  `c_city` varchar(50) DEFAULT NULL,
  `c_county` varchar(50) DEFAULT NULL,
  `c_state_code` varchar(50) DEFAULT NULL,
  `c_city_code` varchar(50) DEFAULT NULL,
  `c_county_code` varchar(50) DEFAULT NULL,
  `c_owner` varchar(50) DEFAULT NULL,
  `c_owner_phone` varchar(50) DEFAULT NULL,
  `c_parent_id` char(50) DEFAULT NULL,
  `c_root_id` char(50) DEFAULT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  `c_modifier` varchar(50) DEFAULT NULL,
  `c_modify_time` datetime DEFAULT NULL,
  `c_available` tinyint(1) DEFAULT NULL,
  `c_order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_code_UNIQUE` (`c_code`),
  KEY `c_name` (`c_name`),
  KEY `c_name_abbr` (`c_name_abbr`),
  KEY `c_owner` (`c_owner`),
  KEY `c_owner_phone` (`c_owner_phone`),
  KEY `c_parent_id` (`c_parent_id`,`c_order_num`),
  KEY `c_root_id` (`c_root_id`,`c_order_num`),
  KEY `c_order` (`c_order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_org`
--

LOCK TABLES `t_org` WRITE;
/*!40000 ALTER TABLE `t_org` DISABLE KEYS */;
INSERT INTO `t_org` VALUES ('16010100000001','sp','校客科技','','上地软件园1号','北京市','海淀区','','110000','110108','','曹磊','13666666666','16010100000001','16010100000001','16010100000001','2016-12-27 14:03:44','sp-admin','2016-12-28 16:25:43',1,1);
/*!40000 ALTER TABLE `t_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_parent`
--

DROP TABLE IF EXISTS `t_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_parent` (
  `id` char(50) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `weichat` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `id_type` int(1) DEFAULT NULL,
  `id_code` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `executive_id` char(50) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `c_cellphone_UNIQUE` (`cellphone`),
  UNIQUE KEY `id_type_code_UNIQUE` (`id_type`,`id_code`),
  CONSTRAINT `fk_t_customer_t_id_type1` FOREIGN KEY (`id_type`) REFERENCES `t_id_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_parent`
--

LOCK TABLES `t_parent` WRITE;
/*!40000 ALTER TABLE `t_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_rank`
--

DROP TABLE IF EXISTS `t_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rank` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) DEFAULT NULL,
  `c_order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `c_name` (`c_name`),
  KEY `c_order` (`c_order_num`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_rank`
--

LOCK TABLES `t_rank` WRITE;
/*!40000 ALTER TABLE `t_rank` DISABLE KEYS */;
INSERT INTO `t_rank` VALUES (1,'经理',1),(2,'主管',2),(3,'专员',3),(4,'系统管理员',4);
/*!40000 ALTER TABLE `t_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `c_id` char(50) NOT NULL,
  `c_org_id` char(50) DEFAULT NULL,
  `c_name` varchar(50) DEFAULT NULL,
  `c_desc` varchar(1024) DEFAULT NULL,
  `c_available` tinyint(1) DEFAULT NULL,
  `c_order_num` int(11) DEFAULT NULL,
  `c_rank_id` int(11) DEFAULT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `fk_t_role_t_rank_idx` (`c_rank_id`),
  KEY `fk_t_role_t_org1_idx` (`c_org_id`),
  KEY `c_name` (`c_name`),
  KEY `c_order` (`c_order_num`),
  KEY `c_org_id` (`c_org_id`,`c_order_num`),
  CONSTRAINT `fk_t_role_t_org1` FOREIGN KEY (`c_org_id`) REFERENCES `t_org` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_role_t_rank` FOREIGN KEY (`c_rank_id`) REFERENCES `t_rank` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES ('16010100000001','16010100000001','系统管理员','系统超级管理员',1,1,4,'16010100000001','2016-12-27 14:03:58');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_function`
--

DROP TABLE IF EXISTS `t_role_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_function` (
  `c_role_id` char(50) NOT NULL,
  `c_function_root_id` char(50) NOT NULL,
  `c_order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_role_id`,`c_function_root_id`),
  KEY `c_role_id` (`c_role_id`),
  KEY `c_order` (`c_order_num`),
  KEY `fk_t_role_function_t_function1_idx` (`c_function_root_id`),
  CONSTRAINT `fk_t_role_function_t_function1` FOREIGN KEY (`c_function_root_id`) REFERENCES `t_function` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_role_function_t_role1` FOREIGN KEY (`c_role_id`) REFERENCES `t_role` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_function`
--

LOCK TABLES `t_role_function` WRITE;
/*!40000 ALTER TABLE `t_role_function` DISABLE KEYS */;
INSERT INTO `t_role_function` VALUES ('16010100000001','7',1),('16122700000001','7',1),('16122700000002','1',1);
/*!40000 ALTER TABLE `t_role_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_function_exclude`
--

DROP TABLE IF EXISTS `t_role_function_exclude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_function_exclude` (
  `c_role_id` char(50) DEFAULT NULL,
  `c_function_id` char(50) DEFAULT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  KEY `c_role_id` (`c_role_id`),
  KEY `fk_t_role_function_exclude_t_function1_idx` (`c_function_id`),
  CONSTRAINT `fk_t_role_function_exclude_t_function1` FOREIGN KEY (`c_function_id`) REFERENCES `t_function` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_role_function_exclude_t_role1` FOREIGN KEY (`c_role_id`) REFERENCES `t_role` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_function_exclude`
--

LOCK TABLES `t_role_function_exclude` WRITE;
/*!40000 ALTER TABLE `t_role_function_exclude` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_role_function_exclude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_stu_par_relation`
--

DROP TABLE IF EXISTS `t_stu_par_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_stu_par_relation` (
  `id` char(50) NOT NULL,
  `student_id` char(50) NOT NULL,
  `parent_id` char(50) NOT NULL,
  `relationship` varchar(45) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_cust_id_UNIQUE` (`student_id`,`parent_id`),
  UNIQUE KEY `cust_student_id_UNIQUE` (`parent_id`,`student_id`),
  CONSTRAINT `fk_t_stu_cust_relation_t_customer1` FOREIGN KEY (`parent_id`) REFERENCES `t_parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_stu_cust_relation_t_student1` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_stu_par_relation`
--

LOCK TABLES `t_stu_par_relation` WRITE;
/*!40000 ALTER TABLE `t_stu_par_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_stu_par_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_student` (
  `id` char(50) NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `id_type` int(1) DEFAULT NULL,
  `id_code` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `school_grade` varchar(45) DEFAULT NULL,
  `class_grade` varchar(45) DEFAULT NULL,
  `school_name` varchar(45) DEFAULT NULL,
  `executive_id` char(50) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `id_type_code` (`id_type`,`id_code`),
  CONSTRAINT `fk_t_student_t_id_type1` FOREIGN KEY (`id_type`) REFERENCES `t_id_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_student`
--

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `c_id` char(50) NOT NULL,
  `c_loginname` varchar(50) NOT NULL,
  `c_loginpass` varchar(50) DEFAULT NULL,
  `c_realname` varchar(50) DEFAULT NULL,
  `c_nickname` varchar(50) DEFAULT NULL,
  `c_phone` varchar(50) DEFAULT NULL,
  `c_email` varchar(50) DEFAULT NULL,
  `c_qq` varchar(50) DEFAULT NULL,
  `c_available` tinyint(1) DEFAULT NULL,
  `c_org_id` char(50) DEFAULT NULL,
  `c_org_root_id` char(50) DEFAULT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  `c_last_visit_time` datetime DEFAULT NULL,
  `c_last_visit_ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_username_UNIQUE` (`c_loginname`),
  UNIQUE KEY `c_phone` (`c_phone`),
  KEY `c_nickname` (`c_nickname`),
  KEY `c_org_id` (`c_org_id`),
  KEY `c_org_root_id` (`c_org_root_id`,`c_org_id`),
  KEY `c_creator` (`c_creator`),
  KEY `c_realname` (`c_realname`),
  KEY `c_email` (`c_email`),
  KEY `c_qq` (`c_qq`),
  CONSTRAINT `fk_t_user_t_org1` FOREIGN KEY (`c_org_id`) REFERENCES `t_org` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES ('16010100000001','sp-admin','14e1b600b1fd579f47433b88e8d85291','校客管理员','校客管理员','13600000000','sp-admin@schoolpal.com','6666666',1,'16010100000001','16010100000001','16010100000001','2016-12-27 14:03:38','2017-02-24 00:06:49','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `c_id` char(50) NOT NULL,
  `c_user_id` char(50) DEFAULT NULL,
  `c_role_id` char(50) DEFAULT NULL,
  `c_available` tinyint(1) DEFAULT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `fk_t_user_role_t_role1_idx` (`c_role_id`),
  KEY `fk_t_user_role_t_user1_idx` (`c_user_id`),
  CONSTRAINT `fk_t_user_role_t_role1` FOREIGN KEY (`c_role_id`) REFERENCES `t_role` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_user_role_t_user1` FOREIGN KEY (`c_user_id`) REFERENCES `t_user` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES ('16010100000001','16010100000001','16010100000001',1,'16010100000001','2016-12-27 14:04:05');
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_widget_type`
--

DROP TABLE IF EXISTS `t_widget_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_widget_type` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_widget_type`
--

LOCK TABLES `t_widget_type` WRITE;
/*!40000 ALTER TABLE `t_widget_type` DISABLE KEYS */;
INSERT INTO `t_widget_type` VALUES (1,'Menu'),(2,'MenuItem'),(3,'Command');
/*!40000 ALTER TABLE `t_widget_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'schoolpal'
--

--
-- Dumping routines for database 'schoolpal'
--
/*!50003 DROP FUNCTION IF EXISTS `f_current_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`schoolpal`@`localhost` FUNCTION `f_current_id`(tableName VARCHAR(50)) RETURNS varchar(50) CHARSET utf8
BEGIN
    DECLARE cPrefix VARCHAR(50);
    DECLARE cCurrent INT;
    DECLARE cBits TINYINT;

    SELECT
        c_prefix, c_current, c_bits
        INTO
        cPrefix, cCurrent, cBits
    FROM
        t_index
    WHERE
        c_table = tableName;

    RETURN CONCAT(cPrefix, LPAD(CONCAT(cCurrent, ''), cBits, '0'));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_next_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`schoolpal`@`localhost` FUNCTION `f_next_id`(tableName VARCHAR(50)) RETURNS varchar(50) CHARSET utf8
BEGIN
    UPDATE t_index
    SET c_current = c_current + c_step
    WHERE c_table = tableName;

    RETURN f_current_id(tableName);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-07 17:52:15
