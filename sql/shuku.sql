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

 Date: 18/05/2023 14:12:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shuku
-- ----------------------------
DROP TABLE IF EXISTS `shuku`;
CREATE TABLE `shuku`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书库缩写',
  `html_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '页面位置(xpath形式)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shuku
-- ----------------------------
INSERT INTO `shuku` VALUES (1, '6625', '/html/body/div[1]/ul[1]/li[1]/span');
INSERT INTO `shuku` VALUES (2, '6693', '/html/body/div[1]/ul[1]/li[2]/span');
INSERT INTO `shuku` VALUES (3, '6709', '/html/body/div[1]/ul[1]/li[3]/span');
INSERT INTO `shuku` VALUES (4, '6694', '/html/body/div[1]/ul[1]/li[4]/span');
INSERT INTO `shuku` VALUES (5, '6697', '/html/body/div[1]/ul[1]/li[5]/span');
INSERT INTO `shuku` VALUES (6, '6677', '/html/body/div[1]/ul[1]/li[6]/span');
INSERT INTO `shuku` VALUES (7, '6710', '/html/body/div[1]/ul[1]/li[7]/span');
INSERT INTO `shuku` VALUES (8, '6675', '/html/body/div[1]/ul[1]/li[8]/span');
INSERT INTO `shuku` VALUES (9, '6657', '/html/body/div[1]/ul[1]/li[9]/span');
INSERT INTO `shuku` VALUES (10, '6656', '/html/body/div[1]/ul[1]/li[10]/span');
INSERT INTO `shuku` VALUES (11, '6676', '/html/body/div[1]/ul[1]/li[11]/span');
INSERT INTO `shuku` VALUES (12, '6670', '/html/body/div[1]/ul[1]/li[12]/span');
INSERT INTO `shuku` VALUES (13, '6626', '/html/body/div[1]/ul[1]/li[13]/span');
INSERT INTO `shuku` VALUES (14, '6711', '/html/body/div[1]/ul[1]/li[14]/span');

SET FOREIGN_KEY_CHECKS = 1;
