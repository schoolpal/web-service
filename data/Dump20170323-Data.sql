CREATE DATABASE  IF NOT EXISTS `schoolpal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `schoolpal`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: www.dinner3000.com    Database: schoolpal
-- ------------------------------------------------------
-- Server version	5.5.52-MariaDB

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
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_command_type`
--

LOCK TABLES `t_command_type` WRITE;
/*!40000 ALTER TABLE `t_command_type` DISABLE KEYS */;
INSERT INTO `t_command_type` VALUES 
(1,'Add','Add'),
(2,'Mod','Modify'),
(3,'Del','Delete'),
(4,'Auth','Authorize'),
(5,'Enable','Enable');
/*!40000 ALTER TABLE `t_command_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_contact`
--

LOCK TABLES `t_contact` WRITE;
/*!40000 ALTER TABLE `t_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_contract`
--

LOCK TABLES `t_contract` WRITE;
/*!40000 ALTER TABLE `t_contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_contract_parent`
--

LOCK TABLES `t_contract_parent` WRITE;
/*!40000 ALTER TABLE `t_contract_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contract_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_course_prototype`
--

LOCK TABLES `t_course_prototype` WRITE;
/*!40000 ALTER TABLE `t_course_prototype` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_course_prototype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_course_session`
--

LOCK TABLES `t_course_session` WRITE;
/*!40000 ALTER TABLE `t_course_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_course_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_course_type`
--

LOCK TABLES `t_course_type` WRITE;
/*!40000 ALTER TABLE `t_course_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_crm_audit`
--

LOCK TABLES `t_crm_audit` WRITE;
/*!40000 ALTER TABLE `t_crm_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_audit` ENABLE KEYS */;
UNLOCK TABLES;

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
('7','7','7','系统','系统管理','/ajax/sys/',1,7,'',NULL),
('7-1','7','7','','组织管理','/ajax/sys/',2,1,'',NULL),
('7-1-1','7','7-1','','新建','/ajax/sys/org/add.do',3,1,'',1),
('7-1-2','7','7-1','','编辑','/ajax/sys/org/mod.do',3,2,'',2),
('7-1-3','7','7-1','','删除','/ajax/sys/org/del.do',3,3,'',3),
('7-2','7','7','','角色管理','/ajax/sys/role/',2,2,'',NULL),
('7-2-1','7','7-2','','新建','/ajax/sys/role/add.do',3,1,'',1),
('7-2-2','7','7-2','','编辑','/ajax/sys/role/mod.do',3,2,'',2),
('7-2-3','7','7-2','','删除','/ajax/sys/role/del.do',3,3,'',3),
('7-3','7','7','','权限管理','/ajax/sys/role/',2,3,'',NULL),
('7-3-1','7','7-3','','授权','/ajax/sys/role/auth.do',3,1,'',4),
('7-4','7','7','','用户管理','/ajax/sys/user/',2,4,'',NULL),
('7-4-1','7','7-4','','新建','/ajax/sys/user/add.do',3,1,'',1),
('7-4-2','7','7-4','','编辑','/ajax/sys/user/mod.do',3,2,'',2),
('7-4-3','7','7-4','','删除','/ajax/sys/user/del.do',3,3,'',3),
('7-4-4','7','7-4','','启用/停用','/ajax/sys/user/enable.do',3,4,'',5);
/*!40000 ALTER TABLE `t_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_id_type`
--

LOCK TABLES `t_id_type` WRITE;
/*!40000 ALTER TABLE `t_id_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_id_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_index`
--

LOCK TABLES `t_index` WRITE;
/*!40000 ALTER TABLE `t_index` DISABLE KEYS */;
INSERT INTO `t_index` VALUES ('t_log','161227',1844,1,15),('t_org','161227',21,1,8),('t_role','161227',22,1,8),('t_user','161227',29,1,8),('t_user_role','161227',7,1,8);
/*!40000 ALTER TABLE `t_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads`
--

LOCK TABLES `t_leads` WRITE;
/*!40000 ALTER TABLE `t_leads` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads_parent`
--

LOCK TABLES `t_leads_parent` WRITE;
/*!40000 ALTER TABLE `t_leads_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads_source`
--

LOCK TABLES `t_leads_source` WRITE;
/*!40000 ALTER TABLE `t_leads_source` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads_stage`
--

LOCK TABLES `t_leads_stage` WRITE;
/*!40000 ALTER TABLE `t_leads_stage` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads_status`
--

LOCK TABLES `t_leads_status` WRITE;
/*!40000 ALTER TABLE `t_leads_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads_student`
--

LOCK TABLES `t_leads_student` WRITE;
/*!40000 ALTER TABLE `t_leads_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_leads_type`
--

LOCK TABLES `t_leads_type` WRITE;
/*!40000 ALTER TABLE `t_leads_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_leads_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_org`
--

LOCK TABLES `t_org` WRITE;
/*!40000 ALTER TABLE `t_org` DISABLE KEYS */;
INSERT INTO `t_org` VALUES ('16010100000001','sp','校客科技','','上地软件园1号','北京市','海淀区','','110000','110108','','曹磊','13666666666','16010100000001','16010100000001','16010100000001','2016-12-27 14:03:44','sp-admin','2016-12-28 16:25:43',1,1),('16122700000009','rise','瑞思教育',NULL,'广渠门','北京市','东城区','','110000','110101',NULL,'孙','','16010100000001','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000010','','瑞思北京分公司',NULL,'','北京市','东城区','','110000','110101',NULL,'','','16122700000009','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000011','AAA','瑞思东城校区',NULL,'dsgsdfgsd','北京市','东城区','','110000','110101',NULL,'sdgfasdg','3245435','16122700000010','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000012','rise-02','瑞思西城校区',NULL,'','北京市','西城区','','110000','110102',NULL,'','','16122700000010','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000013','unclesam','山姆大叔',NULL,'金源时代','北京市','海淀区','','110000','110108',NULL,'黄','139','16010100000001','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000014','unclesam-qh','山姆大叔清河中心',NULL,'清河中心','北京市','海淀区','','110000','110108',NULL,'黄','139','16122700000013','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000015','unclesam-mtg','山姆大叔门头沟中心',NULL,'门头沟','北京市','通州区','','110000','110112',NULL,'张里','13','16122700000013','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000016','rise-hd','瑞思海淀校区',NULL,'海淀','北京市','海淀区','','110000','110108',NULL,'张','123456','16122700000010','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000017','rise-chy','瑞思朝阳校区',NULL,'朝阳区','北京市','朝阳区','','110000','110105',NULL,'李','14567778','16122700000010','16010100000001','sp-admin',NULL,NULL,NULL,1,1),('16122700000018','rise-shjsh','瑞思石景山校区',NULL,'石景山区','北京市','石景山区','','110000','110107',NULL,'李','王','16122700000010','16010100000001','sp-admin',NULL,NULL,NULL,1,1);
/*!40000 ALTER TABLE `t_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_parent`
--

LOCK TABLES `t_parent` WRITE;
/*!40000 ALTER TABLE `t_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_rank`
--

LOCK TABLES `t_rank` WRITE;
/*!40000 ALTER TABLE `t_rank` DISABLE KEYS */;
INSERT INTO `t_rank` VALUES (1,'经理',1),(2,'主管',2),(3,'专员',3),(4,'系统管理员',4);
/*!40000 ALTER TABLE `t_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES ('16010100000001','16010100000001','系统管理员','系统超级管理员',1,1,4,'16010100000001','2016-12-27 14:03:58'),('16122700000009','16010100000001','测试专员','测试数据',1,1,3,'sp-admin',NULL),('16122700000010','16010100000001','测试主管','测试数据',1,1,2,'sp-admin',NULL),('16122700000011','16010100000001','测试经理','测试数据',1,1,1,'sp-admin',NULL),('16122700000012','16122700000009','孙一丁','CEO',1,1,1,'sp-admin',NULL),('16122700000013','16122700000009','系统管理员','IT总监',1,1,4,'sp-admin',NULL),('16122700000014','16122700000009','顾问主管','销售课程',1,1,2,'sp-admin',NULL),('16122700000015','16122700000011','校长','',1,1,1,'sp-admin',NULL),('16122700000016','16122700000011','课程销售主管','课程顾问主管',1,1,2,'sp-admin',NULL),('16122700000017','16122700000011','前台','前台接待人员',1,1,3,'sp-admin',NULL),('16122700000019','16122700000011','教务长','主管教学事务',1,1,2,'sp-admin',NULL),('16122700000022','16010100000001','ceshi002','',1,1,3,'sp-admin',NULL);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_role_function`
--

LOCK TABLES `t_role_function` WRITE;
/*!40000 ALTER TABLE `t_role_function` DISABLE KEYS */;
INSERT INTO `t_role_function` VALUES ('16010100000001','7',1),('16122700000001','7',1),('16122700000002','1',1),('16122700000009','5',1),('16122700000011','1',1),('16122700000011','2',1),('16122700000011','3',1),('16122700000011','4',1),('16122700000011','5',1),('16122700000011','6',1),('16122700000012','1',1),('16122700000012','2',1),('16122700000012','3',1),('16122700000012','4',1),('16122700000012','5',1),('16122700000012','6',1),('16122700000013','7',1),('16122700000014','2',1),('16122700000015','1',1),('16122700000015','2',1),('16122700000015','3',1),('16122700000015','4',1),('16122700000015','5',1),('16122700000015','6',1),('16122700000016','2',1),('16122700000017','3',1),('16122700000019','6',1),('16122700000022','4',1);
/*!40000 ALTER TABLE `t_role_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_role_function_exclude`
--

LOCK TABLES `t_role_function_exclude` WRITE;
/*!40000 ALTER TABLE `t_role_function_exclude` DISABLE KEYS */;
INSERT INTO `t_role_function_exclude` VALUES ('16122700000012','1-1-3','sp-admin',NULL),('16122700000012','1-2-3','sp-admin',NULL);
/*!40000 ALTER TABLE `t_role_function_exclude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_stu_par_relation`
--

LOCK TABLES `t_stu_par_relation` WRITE;
/*!40000 ALTER TABLE `t_stu_par_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_stu_par_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_student`
--

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES 
('16010100000001','sp-admin','14e1b600b1fd579f47433b88e8d85291','校客管理员','校客管理员','13600000000','sp-admin@schoolpal.com','6666666',1,'16010100000001','16010100000001','16010100000001','2016-12-27 14:03:38','2017-03-23 05:12:08','127.0.0.1'),
('16122700000010','test-1','14e1b600b1fd579f47433b88e8d85291','测试','测试','','','',1,'16010100000001','16010100000001','test-1',NULL,NULL,NULL),
('16122700000020','rise-01','14e1b600b1fd579f47433b88e8d85291','曹磊','123','13810102222','caolei1919@126.com','1112231',1,'16122700000009','16010100000001','rise-01',NULL,'2017-03-14 08:42:17','114.250.150.216'),
('16122700000022','rise-dch-01','14e1b600b1fd579f47433b88e8d85291','caolei','','158','','',1,'16122700000011','16010100000001','rise-dch-01',NULL,'2017-03-14 23:06:56','114.241.62.154'),
('16122700000023','test-2','74be16979710d4c4e7c6647856088456','ceshi','ceshi','111','','',1,'16010100000001','16010100000001','test-2',NULL,NULL,NULL),
('16122700000024','test-3','14e1b600b1fd579f47433b88e8d85291','ceshi','ceshi','111','','',1,'16010100000001','16010100000001','test-3',NULL,NULL,NULL),
('16122700000025','ceshi','14e1b600b1fd579f47433b88e8d85291','ceshi','','111','xxx@xxx.com','',1,'16010100000001','16010100000001','ceshi',NULL,NULL,NULL),
('16122700000029','test-10','14e1b600b1fd579f47433b88e8d85291','ceshi','','18611111111','aa@aa.com','',1,'16010100000001','16010100000001','test-10',NULL,'2017-03-23 05:47:33','127.0.0.1');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES 
('16010100000001','16010100000001',1,'16010100000001','2016-12-27 14:04:05'),
('16122700000010','16122700000009',1,NULL,NULL),
('16122700000010','16122700000010',1,NULL,NULL),
('16122700000020','16122700000013',1,NULL,NULL),
('16122700000022','16122700000015',1,NULL,NULL),
('16122700000023','16122700000009',1,NULL,NULL),
('16122700000023','16122700000010',1,NULL,NULL),
('16122700000023','16122700000011',1,NULL,NULL),
('16122700000024','16010100000001',1,NULL,NULL),
('16122700000029','16010100000001',1,NULL,NULL),
('16122700000029','16122700000011',1,NULL,NULL),
('16122700000029','16122700000022',1,NULL,NULL);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_widget_type`
--

LOCK TABLES `t_widget_type` WRITE;
/*!40000 ALTER TABLE `t_widget_type` DISABLE KEYS */;
INSERT INTO `t_widget_type` VALUES 
(1,'Menu'),
(2,'MenuItem'),
(3,'Command');
/*!40000 ALTER TABLE `t_widget_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-23 20:59:10
