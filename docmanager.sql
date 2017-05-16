/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50067
Source Host           : 127.0.0.1:3306
Source Database       : docmanager

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2016-12-13 20:46:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for honours
-- ----------------------------
DROP TABLE IF EXISTS `honours`;
CREATE TABLE `honours` (
  `ho_uuid` char(36) NOT NULL COMMENT '荣誉称号 uuid',
  `ho_name` varchar(50) NOT NULL default '' COMMENT '称号名称',
  `ho_rank` varchar(40) NOT NULL default '' COMMENT '奖品级别:国家级、省级、院校级',
  `ho_date` date NOT NULL COMMENT '获奖时间',
  `ho_teacher_order` int(11) NOT NULL default '1' COMMENT '排名',
  `ho_org` varchar(255) default NULL COMMENT '颁发组织',
  `ho_desc` varchar(255) default NULL COMMENT '颁发组织',
  `fk_teacher_code` bigint(20) default NULL COMMENT '教师外键',
  PRIMARY KEY  (`ho_uuid`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `honours_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of honours
-- ----------------------------

-- ----------------------------
-- Table structure for magazine
-- ----------------------------
DROP TABLE IF EXISTS `magazine`;
CREATE TABLE `magazine` (
  `mag_uuid` char(36) NOT NULL COMMENT '表主键 uuid',
  `mag_name` varchar(100) NOT NULL default '' COMMENT '名',
  `mag_level` varchar(20) NOT NULL default '' COMMENT '级别：国家级 省级 市级 学校级别',
  `mag_pub_date` date NOT NULL COMMENT '发表时间',
  `mag_teacher_order` int(11) NOT NULL default '1' COMMENT '排名',
  `fk_teacher_code` bigint(20) default NULL COMMENT '教师外键',
  PRIMARY KEY  (`mag_uuid`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `magazine_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of magazine
-- ----------------------------

-- ----------------------------
-- Table structure for patents
-- ----------------------------
DROP TABLE IF EXISTS `patents`;
CREATE TABLE `patents` (
  `pat_uuid` char(36) NOT NULL COMMENT '专利表主键 uuid',
  `pat_name` varchar(150) NOT NULL default '' COMMENT '专利名称',
  `pat_type` varchar(50) NOT NULL default '' COMMENT '类型:科研类、工程类、管理类',
  `pat_code` varchar(100) NOT NULL COMMENT '专利代码',
  `pat_date` date NOT NULL COMMENT '申请专利时间',
  `pat_teacher_order` int(11) NOT NULL default '1' COMMENT '排名',
  `fk_teacher_code` bigint(20) default NULL COMMENT '教师外键',
  PRIMARY KEY  (`pat_uuid`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `patents_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patents
-- ----------------------------

-- ----------------------------
-- Table structure for prizes
-- ----------------------------
DROP TABLE IF EXISTS `prizes`;
CREATE TABLE `prizes` (
  `pri_uuid` char(36) NOT NULL COMMENT '奖品表主键 uuid',
  `pri_name` varchar(150) NOT NULL default '' COMMENT '奖品名称',
  `pri_rank` varchar(40) NOT NULL default '' COMMENT '奖品级别:国家级、省级、院校级',
  `pri_date` date NOT NULL COMMENT '获奖时间',
  `pri_teacher_order` int(11) NOT NULL default '1' COMMENT '排名',
  `pri_desc` varchar(255) default NULL COMMENT '备注',
  `fk_teacher_code` bigint(20) default NULL COMMENT '教师外键',
  PRIMARY KEY  (`pri_uuid`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `prizes_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prizes
-- ----------------------------

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `pro_uuid` char(36) NOT NULL COMMENT '表主键 uuid',
  `pro_name` varchar(150) NOT NULL default '' COMMENT '名称',
  `pro_level` varchar(50) NOT NULL default '' COMMENT '级别:国家级 省市级 学校级',
  `pro_start_date` date NOT NULL COMMENT '开始时间',
  `pro_end_date` date NOT NULL COMMENT '结束时间',
  `pro_teacher_order` int(11) NOT NULL default '1' COMMENT '排名',
  `fk_teacher_code` bigint(20) default NULL COMMENT '教师外键',
  PRIMARY KEY  (`pro_uuid`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projects
-- ----------------------------

-- ----------------------------
-- Table structure for query_cache
-- ----------------------------
DROP TABLE IF EXISTS `query_cache`;
CREATE TABLE `query_cache` (
  `cache_id` int(11) NOT NULL auto_increment COMMENT '缓存表主键自增',
  `file_type` varchar(40) NOT NULL default '' COMMENT '文件类型:如： 、专利、著作等',
  `fk_teacher_code` bigint(20) NOT NULL COMMENT '外键：教工编号，方便检索',
  `file_name` varchar(100) NOT NULL default '' COMMENT '文件名',
  `file_path` varchar(200) NOT NULL default '' COMMENT '保存路径',
  `teacher_name` varchar(20) NOT NULL default '' COMMENT '作者姓名',
  `project_name` varchar(100) NOT NULL default '' COMMENT '名称',
  `file_date` date NOT NULL COMMENT '文件发布日期等',
  `orders` int(11) NOT NULL default '1' COMMENT '该教师所在本中的排名',
  `fk_file_uuid` char(36) NOT NULL COMMENT '文件uuid',
  PRIMARY KEY  (`cache_id`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `query_cache_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of query_cache
-- ----------------------------

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `teacher_id` int(11) NOT NULL auto_increment COMMENT '教师主键自增',
  `teacher_name` varchar(30) NOT NULL default '' COMMENT '教师姓名',
  `teacher_code` bigint(20) NOT NULL COMMENT '教师编号，唯一',
  `college` varchar(40) NOT NULL default '' COMMENT '教师所在学院',
  `major` varchar(40) NOT NULL default '' COMMENT '教师所在专业',
  PRIMARY KEY  (`teacher_id`),
  UNIQUE KEY `teacher_code` (`teacher_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('1', '小王', '20131236', '电气与计算机学院', '计算机科学与技术');
INSERT INTO `teachers` VALUES ('5', '小王', '20131237', '水电费', '水电费');
INSERT INTO `teachers` VALUES ('6', '小张', '201234567', '电气学院', '自动化');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL auto_increment COMMENT '用户表主键自增',
  `username` varchar(40) NOT NULL default '' COMMENT '唯一账号，不可重复，不能为空',
  `password` varchar(40) NOT NULL default '' COMMENT '密码 不能为空',
  `real_name` varchar(40) NOT NULL default '' COMMENT '真实姓名',
  `user_type` varchar(2) NOT NULL default '2' COMMENT '用户类型：1：代表管理员 2:代表文件录入员',
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '小刘', '2');

-- ----------------------------
-- Table structure for works
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
  `work_uuid` char(36) NOT NULL COMMENT '著作表主键 uuid',
  `work_name` varchar(100) NOT NULL default '' COMMENT '著作名称',
  `work_publish` varchar(50) NOT NULL default '' COMMENT '出版社',
  `work_isbn` varchar(50) NOT NULL default '' COMMENT '著作编号',
  `work_date` date NOT NULL COMMENT '出版时间',
  `work_teacher_order` int(11) NOT NULL default '1' COMMENT '排名',
  `fk_teacher_code` bigint(20) default NULL COMMENT '教师外键',
  PRIMARY KEY  (`work_uuid`),
  KEY `fk_teacher_code` (`fk_teacher_code`),
  CONSTRAINT `works_ibfk_1` FOREIGN KEY (`fk_teacher_code`) REFERENCES `teachers` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of works
-- ----------------------------
