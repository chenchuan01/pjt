/*
Navicat MySQL Data Transfer

Source Server         : 0-Local DB
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : pjt

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-01-03 17:04:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for syscompetence
-- ----------------------------
DROP TABLE IF EXISTS `syscompetence`;
CREATE TABLE `syscompetence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `createDate` datetime DEFAULT NULL COMMENT 'createTime',
  `updateDate` datetime DEFAULT NULL COMMENT 'updateTime',
  `status` tinyint(4) DEFAULT NULL COMMENT 'status',
  `displayMenu` tinyint(1) NOT NULL COMMENT 'displayMenu',
  `icon` varchar(255) DEFAULT NULL COMMENT 'icon',
  `menuName` varchar(100) DEFAULT NULL COMMENT 'menuName',
  `name` varchar(50) DEFAULT NULL COMMENT 'name',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `parentId` bigint(20) DEFAULT NULL COMMENT 'parentId',
  PRIMARY KEY (`id`),
  KEY `FK7F27FA56CAD972A9` (`parentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限菜单表';

-- ----------------------------
-- Records of syscompetence
-- ----------------------------
INSERT INTO `syscompetence` VALUES ('1', '2016-12-30 11:26:54', '2016-12-30 11:26:56', '0', '1', '&#xe614;', '系统管理', '系统管理', '', null);
INSERT INTO `syscompetence` VALUES ('2', '2017-01-03 12:05:50', '2017-01-03 12:05:52', '0', '1', null, '系统用户', '系统用户', '/sys/user.htm', '1');
INSERT INTO `syscompetence` VALUES ('3', '2017-01-03 16:25:49', '2017-01-03 16:25:52', '0', '1', null, '用户权限', '用户权限', '/sys/auth.htm', '1');
INSERT INTO `syscompetence` VALUES ('4', '2017-01-03 16:26:52', '2017-01-03 16:26:55', '0', '1', null, '角色管理', '角色管理', '/sys/role.htm', '1');

-- ----------------------------
-- Table structure for sysconfiger
-- ----------------------------
DROP TABLE IF EXISTS `sysconfiger`;
CREATE TABLE `sysconfiger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `updateDate` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `value` longtext COMMENT '值',
  `remarks` varchar(255) DEFAULT NULL,
  `type` int(8) DEFAULT NULL COMMENT '类型1',
  `langTname` char(2) DEFAULT NULL COMMENT '语言代号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of sysconfiger
-- ----------------------------

-- ----------------------------
-- Table structure for sysrole
-- ----------------------------
DROP TABLE IF EXISTS `sysrole`;
CREATE TABLE `sysrole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `createDate` datetime DEFAULT NULL COMMENT 'createTime',
  `updateDate` datetime DEFAULT NULL COMMENT 'lastUpdateTime',
  `status` tinyint(4) DEFAULT NULL COMMENT 'status',
  `description` varchar(255) DEFAULT NULL COMMENT 'description',
  `name` varchar(50) NOT NULL COMMENT 'name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sysrole
-- ----------------------------
INSERT INTO `sysrole` VALUES ('1', '2016-12-30 11:24:13', '2016-12-30 11:24:15', '0', '系统管理员', '系统管理员');

-- ----------------------------
-- Table structure for sysrole_syscompetence
-- ----------------------------
DROP TABLE IF EXISTS `sysrole_syscompetence`;
CREATE TABLE `sysrole_syscompetence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `status` tinyint(4) NOT NULL,
  `sysroleId` bigint(20) NOT NULL COMMENT 'sysroleId',
  `competencesId` bigint(20) NOT NULL COMMENT 'competencesId',
  PRIMARY KEY (`id`),
  KEY `sysroleId` (`sysroleId`),
  KEY `competencesId` (`competencesId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysrole_syscompetence
-- ----------------------------
INSERT INTO `sysrole_syscompetence` VALUES ('1', '2016-12-30 11:28:04', '2016-12-30 11:28:07', '0', '1', '1');
INSERT INTO `sysrole_syscompetence` VALUES ('2', '2017-01-03 12:06:45', '2017-01-03 12:06:47', '0', '1', '2');
INSERT INTO `sysrole_syscompetence` VALUES ('3', '2017-01-03 12:06:45', '2017-01-03 12:06:47', '0', '1', '3');
INSERT INTO `sysrole_syscompetence` VALUES ('4', '2017-01-03 12:06:45', '2017-01-03 12:06:47', '0', '1', '4');

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `createDate` datetime NOT NULL COMMENT 'createTime',
  `updateDate` datetime NOT NULL COMMENT 'updateTime',
  `status` tinyint(4) NOT NULL COMMENT 'status',
  `lastLoginTime` datetime DEFAULT NULL COMMENT 'lastLoginTime',
  `loginName` varchar(50) NOT NULL COMMENT 'loginName',
  `loginPassword` varchar(50) DEFAULT NULL COMMENT 'loginPassword',
  `niceName` varchar(100) DEFAULT NULL COMMENT 'niceName',
  `tel` varchar(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL COMMENT 'roleId',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName` (`loginName`),
  KEY `FK98727C18DE4E0C0A` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='存储后台管理人员数据';

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('1', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-03 17:03:11', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPwd` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '0', '2016-12-20 11:40:28', '2016-12-20 11:40:28');
