/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : forum

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 10/15/2017 21:48:49 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(20) NOT NULL COMMENT '论坛名字',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实名字',
  `email` varchar(320) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT '1' COMMENT '1=有效,2=无效,3=已删除',
  `qq` varchar(20) DEFAULT NULL COMMENT '绑定的qq号',
  `role` varchar(20) NOT NULL DEFAULT '' COMMENT '用户角色',
  `password` varchar(100) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_forum_name` (`forum_name`) USING BTREE,
  UNIQUE KEY `index_qq` (`qq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
