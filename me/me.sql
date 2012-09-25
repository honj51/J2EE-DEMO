/*
Navicat MySQL Data Transfer

Source Server         : root@localhost
Source Server Version : 50157
Source Host           : localhost:3306
Source Database       : me

Target Server Type    : MYSQL
Target Server Version : 50157
File Encoding         : 65001

Date: 2012-05-07 11:00:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_contact`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contact`;
CREATE TABLE `tbl_contact` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_last_name` varchar(45) NOT NULL,
  `_first_name` varchar(45) NOT NULL,
  `_wk_mail` varchar(45) DEFAULT NULL,
  `_ps_mail` varchar(45) DEFAULT NULL,
  `_home_phone` varchar(45) DEFAULT NULL,
  `_wk_phone` varchar(45) DEFAULT NULL,
  `_cell_phone` varchar(45) DEFAULT NULL,
  `_loc` varchar(45) DEFAULT NULL,
  `_zip` varchar(45) DEFAULT NULL,
  `_group_id` int(11) DEFAULT NULL,
  `_owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_group_id_F8034D04D33A4A43ADD5E7EC0B272CB0` (`_group_id`),
  KEY `fk_owner_id_ ADE2EA7F246144F2820DA0DF35F66C4A` (`_owner_id`),
  CONSTRAINT `fk_group_id_F8034D04D33A4A43ADD5E7EC0B272CB0` FOREIGN KEY (`_group_id`) REFERENCES `tbl_group` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_owner_id_ ADE2EA7F246144F2820DA0DF35F66C4A` FOREIGN KEY (`_owner_id`) REFERENCES `tbl_user` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_contact
-- ----------------------------
INSERT INTO `tbl_contact` VALUES ('1', '林', '锋', 'grossofans@gmail.com', 'grossofans@gmail.com', null, null, '182-2502-3233', null, null, '1', '1');

-- ----------------------------
-- Table structure for `tbl_email`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_email`;
CREATE TABLE `tbl_email` (
  `_user_id` int(11) NOT NULL,
  `_email` varchar(45) NOT NULL,
  `_order` int(11) NOT NULL,
  PRIMARY KEY (`_user_id`,`_email`),
  KEY `fk_user_id_2F5A72602E6F418883BF0804683154F0` (`_user_id`),
  CONSTRAINT `fk_user_id_2F5A72602E6F418883BF0804683154F0` FOREIGN KEY (`_user_id`) REFERENCES `tbl_user` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_email
-- ----------------------------
INSERT INTO `tbl_email` VALUES ('1', 'grossofans@gmail.com', '0');
INSERT INTO `tbl_email` VALUES ('1', '240845339@qq.com', '1');

-- ----------------------------
-- Table structure for `tbl_group`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_group`;
CREATE TABLE `tbl_group` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_name` varchar(45) NOT NULL,
  `_desc` varchar(255) DEFAULT NULL,
  `_owner_id` int(11) NOT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_owner_id_A2D4A1DE8DD245A295E650ABFC9DD7F6` (`_owner_id`),
  CONSTRAINT `fk_owner_id_A2D4A1DE8DD245A295E650ABFC9DD7F6` FOREIGN KEY (`_owner_id`) REFERENCES `tbl_user` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_group
-- ----------------------------
INSERT INTO `tbl_group` VALUES ('1', '朋友', null, '1');
INSERT INTO `tbl_group` VALUES ('2', '好友', null, '1');
INSERT INTO `tbl_group` VALUES ('3', '亲人', null, '1');

-- ----------------------------
-- Table structure for `tbl_role`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_name` varchar(45) NOT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `_name_UNIQUE` (`_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES ('2', 'ROLE_ADMIN');
INSERT INTO `tbl_role` VALUES ('1', 'ROLE_USER');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(45) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_last_name` varchar(45) NOT NULL,
  `_first_name` varchar(45) NOT NULL,
  `_lock` varchar(12) NOT NULL DEFAULT 'NON_LOCKED',
  `_sex` varchar(10) NOT NULL DEFAULT 'MALE',
  PRIMARY KEY (`_id`),
  UNIQUE KEY `_username_UNIQUE` (`_username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '林', '锋', 'NON_LOCKED', 'MALE');
INSERT INTO `tbl_user` VALUES ('2', 'zhanshang', '21232f297a57a5a743894a0e4a801fc3', '张', '三', 'NON_LOCKED', 'MALE');

-- ----------------------------
-- Table structure for `tbl_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role` (
  `_user_id` int(11) NOT NULL,
  `_role_id` int(11) NOT NULL,
  PRIMARY KEY (`_user_id`,`_role_id`),
  KEY `fk_user_id_889929D3D64B4413AF9867881DC27EC4` (`_user_id`),
  KEY `fk_role_id_9191852B4A8449D28980299E1F82BA40` (`_role_id`),
  CONSTRAINT `fk_user_id_889929D3D64B4413AF9867881DC27EC4` FOREIGN KEY (`_user_id`) REFERENCES `tbl_user` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_id_9191852B4A8449D28980299E1F82BA40` FOREIGN KEY (`_role_id`) REFERENCES `tbl_role` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user_role
-- ----------------------------
INSERT INTO `tbl_user_role` VALUES ('1', '1');
INSERT INTO `tbl_user_role` VALUES ('1', '2');
INSERT INTO `tbl_user_role` VALUES ('2', '1');
