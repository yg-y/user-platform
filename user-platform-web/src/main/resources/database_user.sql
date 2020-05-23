/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:3306
 Source Schema         : database_user

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 23/05/2020 22:25:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '登录名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `classz` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '班级',
  `college` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '学院',
  `address` varchar(1024) COLLATE utf8mb4_bin NOT NULL COMMENT '地址',
  `id_card` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '学号',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (24, '桑之落矣', 'young@test.com', '123456', '20软件1', '计算机学院', '广东省', '0104150701', 1590224847814, 1590224847814);
INSERT INTO `tb_user` VALUES (25, '其黄而陨', 'qihuang@er.com', '123456', '20软件1', '计算机', '浙江省', '0104150702', 1590224887626, 1590224887626);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
