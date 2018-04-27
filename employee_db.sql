/*
Navicat MySQL Data Transfer

Source Server         : employees
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : employee_db

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-27 21:17:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_db_name` (`name`) USING BTREE COMMENT '姓名唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('0', '小红', '22', 'female');
INSERT INTO `employee` VALUES ('1', '小强', '21', 'male');
INSERT INTO `employee` VALUES ('2', '小明', '19', 'male');
INSERT INTO `employee` VALUES ('3', '小芳', '19', 'female');
INSERT INTO `employee` VALUES ('4', '小智', '23', 'male');
