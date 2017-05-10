CREATE DATABASE  IF NOT EXISTS `schoolpal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `schoolpal`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: schoolpal
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
  `id` char(50) NOT NULL,
  `root_id` char(50) NOT NULL,
  `parent_id` char(50) NOT NULL,
  `orgnization_id` char(50) NOT NULL,
  `name` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `budget` decimal(16,2) DEFAULT '0.00',
  `cost` decimal(16,2) DEFAULT '0.00',
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update` datetime NOT NULL,
  `leads` int(11) DEFAULT '0',
  `opportunities` int(11) DEFAULT '0',
  `contracts` int(11) DEFAULT '0',
  `total_amount` decimal(20,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `root_id` (`root_id`),
  KEY `parent_id` (`parent_id`),
  KEY `orgnization_id` (`orgnization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_t_contact_t_leads1_idx` (`leads_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_t_contract_t_org1_idx` (`orgnization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_t_contract_customer_t_contract1_idx` (`contract_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_t_course_prototype_t_course_type1_idx` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_t_course_t_course_prototype1_idx` (`proto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `c_action` (`c_action`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `create_time` datetime NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_leads_t_leads_status1_idx` (`status`),
  KEY `fk_t_leads_t_leads_stage1_idx` (`stage`),
  KEY `fk_t_leads_t_leads_source1_idx` (`source`),
  KEY `fk_t_leads_t_leads_type1_idx` (`type`),
  KEY `fk_t_leads_t_user1_idx` (`creator_id`),
  KEY `fk_t_leads_t_user2_idx` (`executive_id`),
  KEY `fk_t_leads_t_org1_idx` (`orgnization_id`),
  KEY `fk_t_leads_t_activity1_idx` (`channel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_leads_parent`
--

DROP TABLE IF EXISTS `t_leads_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_parent` (
  `id` char(50) NOT NULL,
  `leads_id` char(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `weichat` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `id_type` int(1) DEFAULT NULL,
  `id_code` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update` datetime NOT NULL,
  `relation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `leads_id_idx` (`leads_id`),
  UNIQUE KEY `c_cellphone_UNIQUE` (`cellphone`),
  UNIQUE KEY `id_type_code_UNIQUE` (`id_type`,`id_code`),
  KEY `creator_id_idx` (`creator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `t_leads_student`
--

DROP TABLE IF EXISTS `t_leads_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leads_student` (
  `id` char(50) NOT NULL,
  `leads_id` char(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `id_type` int(1) DEFAULT NULL,
  `id_code` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `school_grade` varchar(45) DEFAULT NULL,
  `class_grade` varchar(45) DEFAULT NULL,
  `school_name` varchar(45) DEFAULT NULL,
  `creator_id` char(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `leads_id_idx` (`leads_id`),
  KEY `id_type_code` (`id_type`,`id_code`),
  KEY `creator_id_idx` (`creator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `c_create_time` datetime NOT NULL,
  `c_modifier` char(50) DEFAULT NULL,
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
  UNIQUE KEY `id_type_code_UNIQUE` (`id_type`,`id_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `c_org_id` (`c_org_id`,`c_order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_t_role_function_t_function1_idx` (`c_function_root_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_role_function_exclude`
--

DROP TABLE IF EXISTS `t_role_function_exclude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_function_exclude` (
  `c_role_id` char(50) NOT NULL,
  `c_function_id` char(50) NOT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`c_role_id`,`c_function_id`),
  KEY `fk_t_role_function_exclude_t_function1_idx` (`c_function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `relation` varchar(45) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_cust_id_UNIQUE` (`student_id`,`parent_id`),
  UNIQUE KEY `cust_student_id_UNIQUE` (`parent_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `create_time` datetime NOT NULL,
  `last_update` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `id_type_code` (`id_type`,`id_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `c_create_time` datetime NOT NULL,
  `c_last_visit_time` datetime DEFAULT NULL,
  `c_last_visit_ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_username_UNIQUE` (`c_loginname`),
  KEY `c_nickname` (`c_nickname`),
  KEY `c_org_id` (`c_org_id`),
  KEY `c_org_root_id` (`c_org_root_id`,`c_org_id`),
  KEY `c_creator` (`c_creator`),
  KEY `c_realname` (`c_realname`),
  KEY `c_email` (`c_email`),
  KEY `c_qq` (`c_qq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `c_user_id` char(50) NOT NULL,
  `c_role_id` char(50) NOT NULL,
  `c_available` tinyint(1) DEFAULT NULL,
  `c_creator` char(50) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`c_user_id`,`c_role_id`),
  KEY `c_role_id` (`c_role_id`),
  KEY `fk_t_user_role_t_role1_idx` (`c_role_id`),
  KEY `fk_t_user_role_t_user1_idx` (`c_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
CREATE DEFINER=`schoolpal`@`%` FUNCTION `f_current_id`(tableName VARCHAR(50)) RETURNS varchar(50) CHARSET utf8
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
CREATE DEFINER=`schoolpal`@`%` FUNCTION `f_next_id`(tableName VARCHAR(50)) RETURNS varchar(50) CHARSET utf8
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

-- Dump completed on 2017-03-23 21:11:54
