/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : pjt

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-01-11 13:33:52
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='权限菜单表';

-- ----------------------------
-- Records of syscompetence
-- ----------------------------
INSERT INTO `syscompetence` VALUES ('1', '2016-12-30 11:26:54', '2016-12-30 11:26:56', '0', '1', '&#xe614;', '系统管理', '系统管理', '', null);
INSERT INTO `syscompetence` VALUES ('2', '2017-01-03 12:05:50', '2017-01-03 12:05:52', '0', '1', null, '系统用户', '系统用户', '/sys/user.htm', '1');
INSERT INTO `syscompetence` VALUES ('3', '2017-01-03 16:25:49', '2017-01-03 16:25:52', '0', '1', null, '用户权限', '用户权限', '/sys/action.htm', '1');
INSERT INTO `syscompetence` VALUES ('4', '2017-01-03 16:26:52', '2017-01-03 16:26:55', '0', '1', null, '角色管理', '角色管理', '/sys/role.htm', '1');
INSERT INTO `syscompetence` VALUES ('5', '2017-01-04 11:41:21', '2017-01-04 11:41:23', '0', '1', '&#xe612;', '用户管理', '用户管理', '', null);
INSERT INTO `syscompetence` VALUES ('6', '2017-01-04 15:29:51', '2017-01-04 15:29:53', '0', '1', null, '用户列表', '用户列表', '/user/userlist.htm', '5');
INSERT INTO `syscompetence` VALUES ('7', '2017-01-09 13:34:27', '2017-01-09 13:34:30', '0', '0', null, '添加用户', '添加用户', '/user/adduser.htm', '5');
INSERT INTO `syscompetence` VALUES ('8', '2017-01-09 13:57:40', '2017-01-09 13:57:43', '0', '0', null, '修改用户', '修改用户', '/user/updateuser.htm', '5');
INSERT INTO `syscompetence` VALUES ('9', '2017-01-09 13:58:34', '2017-01-09 13:58:36', '0', '0', null, '删除用户', '删除用户', '/user/deleteuser.htm', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysrole_syscompetence
-- ----------------------------
INSERT INTO `sysrole_syscompetence` VALUES ('1', '2016-12-30 11:28:04', '2016-12-30 11:28:07', '0', '1', '1');
INSERT INTO `sysrole_syscompetence` VALUES ('2', '2017-01-03 12:06:45', '2017-01-03 12:06:47', '0', '1', '2');
INSERT INTO `sysrole_syscompetence` VALUES ('3', '2017-01-03 12:06:45', '2017-01-03 12:06:47', '0', '1', '3');
INSERT INTO `sysrole_syscompetence` VALUES ('4', '2017-01-03 12:06:45', '2017-01-03 12:06:47', '0', '1', '4');
INSERT INTO `sysrole_syscompetence` VALUES ('5', '2017-01-04 11:43:06', '2017-01-04 11:43:09', '0', '1', '5');
INSERT INTO `sysrole_syscompetence` VALUES ('6', '2017-01-04 15:30:18', '2017-01-04 15:30:21', '0', '1', '6');
INSERT INTO `sysrole_syscompetence` VALUES ('7', '2017-01-09 13:34:57', '2017-01-09 13:35:01', '0', '1', '7');
INSERT INTO `sysrole_syscompetence` VALUES ('8', '2017-01-09 13:58:59', '2017-01-09 13:59:02', '0', '1', '8');
INSERT INTO `sysrole_syscompetence` VALUES ('9', '2017-01-09 13:59:16', '2017-01-09 13:59:20', '0', '1', '9');

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
INSERT INTO `sysuser` VALUES ('1', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('2', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin1', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('3', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin2', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('4', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin3', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('5', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin4', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('6', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin5', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('7', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin6', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('8', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin7', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('9', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin8', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('10', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin9', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('11', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin10', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('12', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin11', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('13', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin12', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('14', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin13', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('15', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin14', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('16', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin15', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');
INSERT INTO `sysuser` VALUES ('17', '2016-12-30 11:24:00', '2016-12-30 11:24:02', '0', '2017-01-11 13:10:04', 'admin16', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '1', '2016-12-20 11:40:28', '2016-12-20 11:40:28');
INSERT INTO `user` VALUES ('2', '321', '632', '1', '2017-01-10 16:34:05', '2017-01-10 17:28:28');
INSERT INTO `user` VALUES ('3', '124', '123', '1', '2017-01-10 16:34:13', '2017-01-10 17:28:31');
INSERT INTO `user` VALUES ('4', '123', '123', '1', '2017-01-10 17:28:43', '2017-01-10 17:28:43');
INSERT INTO `user` VALUES ('5', '123', '456', '1', '2017-01-10 17:28:46', '2017-01-10 17:28:46');
INSERT INTO `user` VALUES ('6', '456', '123', '1', '2017-01-10 17:28:48', '2017-01-10 17:28:48');
INSERT INTO `user` VALUES ('7', '123', '654', '1', '2017-01-10 17:28:50', '2017-01-10 17:28:50');
INSERT INTO `user` VALUES ('8', '789', '789', '1', '2017-01-10 17:28:53', '2017-01-10 17:28:53');
INSERT INTO `user` VALUES ('9', '456', '456', '1', '2017-01-10 17:28:55', '2017-01-10 17:28:55');
INSERT INTO `user` VALUES ('10', '123', '654', '1', '2017-01-10 17:29:10', '2017-01-10 17:29:10');
INSERT INTO `user` VALUES ('11', '321', '456', null, null, null);
INSERT INTO `user` VALUES ('12', '365', '124', null, null, null);
INSERT INTO `user` VALUES ('29', '123', '123', '0', '2017-01-10 16:30:53', '2017-01-10 16:30:53');
INSERT INTO `user` VALUES ('30', 'xiao', 'dsa', '1', '2017-01-10 16:32:52', '2017-01-10 16:32:52');
