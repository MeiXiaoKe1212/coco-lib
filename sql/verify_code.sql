/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云河源
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 47.115.219.60:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 18/05/2023 14:12:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for verify_code
-- ----------------------------
DROP TABLE IF EXISTS `verify_code`;
CREATE TABLE `verify_code`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of verify_code
-- ----------------------------
INSERT INTO `verify_code` VALUES (1, '7a38ad31f4ab11ed');
INSERT INTO `verify_code` VALUES (2, '7a38bee9f4ab11ed');
INSERT INTO `verify_code` VALUES (3, '7a38c016f4ab11ed');
INSERT INTO `verify_code` VALUES (4, '7a38c09ef4ab11ed');
INSERT INTO `verify_code` VALUES (5, '7a38c0e3f4ab11ed');
INSERT INTO `verify_code` VALUES (6, '7a38c11cf4ab11ed');
INSERT INTO `verify_code` VALUES (7, '7a38c155f4ab11ed');
INSERT INTO `verify_code` VALUES (8, '7a38c188f4ab11ed');
INSERT INTO `verify_code` VALUES (9, '7a38c1c7f4ab11ed');
INSERT INTO `verify_code` VALUES (10, '7a38c2b4f4ab11ed');
INSERT INTO `verify_code` VALUES (11, '7a38c335f4ab11ed');
INSERT INTO `verify_code` VALUES (12, '7a38c36df4ab11ed');
INSERT INTO `verify_code` VALUES (13, '7a38c3a5f4ab11ed');
INSERT INTO `verify_code` VALUES (14, '7a38c3d9f4ab11ed');
INSERT INTO `verify_code` VALUES (15, '7a38c4b7f4ab11ed');
INSERT INTO `verify_code` VALUES (16, '7a38c4eff4ab11ed');
INSERT INTO `verify_code` VALUES (17, '7a38c541f4ab11ed');
INSERT INTO `verify_code` VALUES (18, '7a38c57ff4ab11ed');
INSERT INTO `verify_code` VALUES (19, '7a38c5c2f4ab11ed');
INSERT INTO `verify_code` VALUES (20, '7a38c5faf4ab11ed');

SET FOREIGN_KEY_CHECKS = 1;
