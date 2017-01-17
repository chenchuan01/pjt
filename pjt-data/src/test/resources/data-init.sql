/*
Navicat MySQL Data Transfer

Source Server         : 0-Local DB
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : pjt

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-01-17 16:55:27
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='权限菜单表';

-- ----------------------------
-- Records of syscompetence
-- ----------------------------
INSERT INTO `syscompetence` VALUES ('1', '2016-12-30 11:26:54', '2016-12-30 11:26:56', '0', '1', '&#xe614;', '系统管理', '系统管理', '', null);
INSERT INTO `syscompetence` VALUES ('2', '2017-01-03 12:05:50', '2017-01-03 12:05:52', '0', '1', null, '系统用户', '系统用户', '/sys/user.htm', '1');
INSERT INTO `syscompetence` VALUES ('3', '2017-01-17 13:12:10', '2017-01-17 13:12:13', '0', '0', null, '新增修改系统用户', '系统管理', '/sys/userform.htm', '1');
INSERT INTO `syscompetence` VALUES ('4', '2017-01-17 13:13:20', '2017-01-17 13:13:22', '0', '1', null, '系统角色', '系统角色', '/sys/role.htm', '1');
INSERT INTO `syscompetence` VALUES ('5', '2017-01-17 13:14:20', '2017-01-17 13:14:23', '0', '0', null, '新增修改系统角色', '新增修改系统角色', '/sys/roleform.htm', '1');
INSERT INTO `syscompetence` VALUES ('6', '2017-01-17 13:15:20', '2017-01-17 13:15:22', '0', '1', null, '系统权限', '系统权限', '/sys/authority.htm', '1');
INSERT INTO `syscompetence` VALUES ('7', '2017-01-17 13:16:09', '2017-01-17 13:16:12', '0', '0', null, '新增修改系统权限', '新增修改系统权限', '/sys/authform.htm', '1');
INSERT INTO `syscompetence` VALUES ('8', '2017-01-17 13:17:46', '2017-01-17 13:17:48', '0', '1', '&#xe613;', 'APP用户管理', 'APP用户管理', '', null);
INSERT INTO `syscompetence` VALUES ('9', '2017-01-17 13:19:29', '2017-01-17 13:19:32', '0', '0', null, '新增修改APP用户', '新增修改APP用户', '/user/userform.htm', '8');
INSERT INTO `syscompetence` VALUES ('10', '2017-01-17 13:20:22', '2017-01-17 13:20:24', '0', '0', null, '删除APP用户', '删除APP用户', '/user/deleteuser.htm', '8');
INSERT INTO `syscompetence` VALUES ('11', '2017-01-17 13:25:13', '2017-01-17 13:25:15', '0', '1', null, 'APP用户列表', 'APP用户列表', '/user/userlist.htm', '8');
INSERT INTO `syscompetence` VALUES ('12', '2017-01-17 16:53:59', '2017-01-17 16:54:01', '0', '0', null, '删除系统权限', '删除系统权限', '/sys/deleteauth.htm', '1');

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
INSERT INTO `sysrole` VALUES ('1', '2017-01-17 14:55:54', '2017-01-17 14:55:54', '0', '系统管理员', '系统管理员');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysrole_syscompetence
-- ----------------------------
INSERT INTO `sysrole_syscompetence` VALUES ('1', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '1');
INSERT INTO `sysrole_syscompetence` VALUES ('2', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '2');
INSERT INTO `sysrole_syscompetence` VALUES ('3', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '3');
INSERT INTO `sysrole_syscompetence` VALUES ('4', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '4');
INSERT INTO `sysrole_syscompetence` VALUES ('5', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '5');
INSERT INTO `sysrole_syscompetence` VALUES ('6', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '6');
INSERT INTO `sysrole_syscompetence` VALUES ('7', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '7');
INSERT INTO `sysrole_syscompetence` VALUES ('8', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '8');
INSERT INTO `sysrole_syscompetence` VALUES ('9', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '9');
INSERT INTO `sysrole_syscompetence` VALUES ('10', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '10');
INSERT INTO `sysrole_syscompetence` VALUES ('11', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '11');
INSERT INTO `sysrole_syscompetence` VALUES ('12', '2017-01-17 13:21:48', '2017-01-17 13:21:53', '0', '1', '12');

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
INSERT INTO `sysuser` VALUES ('1', '2017-01-17 14:55:49', '2017-01-17 14:55:49', '0', '2017-01-17 14:55:49', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', '13987654321', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '0', '2017-01-17 14:54:15', '2017-01-17 14:54:15');
INSERT INTO `user` VALUES ('2', '321', '632', '0', '2017-01-10 16:34:05', '2017-01-10 17:28:28');
INSERT INTO `user` VALUES ('3', '124', '123', '0', '2017-01-17 14:54:23', '2017-01-17 14:54:23');
INSERT INTO `user` VALUES ('4', '123', '123', '0', '2017-01-10 17:28:43', '2017-01-10 17:28:43');
INSERT INTO `user` VALUES ('5', '123', '456', '0', '2017-01-10 17:28:46', '2017-01-10 17:28:46');
INSERT INTO `user` VALUES ('6', '456', '123', '0', '2017-01-10 17:28:48', '2017-01-10 17:28:48');
INSERT INTO `user` VALUES ('7', '123', '654', '0', '2017-01-10 17:28:50', '2017-01-10 17:28:50');
INSERT INTO `user` VALUES ('8', '789', '789', '0', '2017-01-10 17:28:53', '2017-01-10 17:28:53');
INSERT INTO `user` VALUES ('9', '456', '456', '0', '2017-01-10 17:28:55', '2017-01-10 17:28:55');
INSERT INTO `user` VALUES ('10', '123', '654', '1', '2017-01-10 17:29:10', '2017-01-10 17:29:10');
INSERT INTO `user` VALUES ('29', '123', '123', '0', '2017-01-10 16:30:53', '2017-01-10 16:30:53');
INSERT INTO `user` VALUES ('30', 'xiao', 'dsa', '1', '2017-01-10 16:32:52', '2017-01-10 16:32:52');
INSERT INTO `user` VALUES ('35', '123', '321', '1', '2017-01-17 14:11:02', '2017-01-17 14:11:02');
