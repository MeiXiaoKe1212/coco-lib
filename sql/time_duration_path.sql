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

 Date: 18/05/2023 14:13:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for time_duration_path
-- ----------------------------
DROP TABLE IF EXISTS `time_duration_path`;
CREATE TABLE `time_duration_path`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `time_duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间范围字符',
  `html_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '页面位置(xpath形式)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of time_duration_path
-- ----------------------------
INSERT INTO `time_duration_path` VALUES (1, '800~830', '/html/body/div[1]/div[6]/ul/li[1]');
INSERT INTO `time_duration_path` VALUES (2, '830~900', '/html/body/div[1]/div[6]/ul/li[2]');
INSERT INTO `time_duration_path` VALUES (3, '900~930', '/html/body/div[1]/div[6]/ul/li[3]');
INSERT INTO `time_duration_path` VALUES (4, '930~1000', '/html/body/div[1]/div[6]/ul/li[4]');
INSERT INTO `time_duration_path` VALUES (5, '1000~1030', '/html/body/div[1]/div[6]/ul/li[5]');
INSERT INTO `time_duration_path` VALUES (6, '1030~1100', '/html/body/div[1]/div[6]/ul/li[6]');
INSERT INTO `time_duration_path` VALUES (7, '1100~1130', '/html/body/div[1]/div[6]/ul/li[7]');
INSERT INTO `time_duration_path` VALUES (8, '1130~1200', '/html/body/div[1]/div[6]/ul/li[8]');
INSERT INTO `time_duration_path` VALUES (9, '1200~1230', '/html/body/div[1]/div[6]/ul/li[9]');
INSERT INTO `time_duration_path` VALUES (10, '1230~1300', '/html/body/div[1]/div[6]/ul/li[10]');
INSERT INTO `time_duration_path` VALUES (11, '1300~1330', '/html/body/div[1]/div[6]/ul/li[11]');
INSERT INTO `time_duration_path` VALUES (12, '1330~1400', '/html/body/div[1]/div[6]/ul/li[12]');
INSERT INTO `time_duration_path` VALUES (13, '1400~1430', '/html/body/div[1]/div[6]/ul/li[13]');
INSERT INTO `time_duration_path` VALUES (14, '1430~1500', '/html/body/div[1]/div[6]/ul/li[14]');
INSERT INTO `time_duration_path` VALUES (15, '1500~1530', '/html/body/div[1]/div[6]/ul/li[15]');
INSERT INTO `time_duration_path` VALUES (16, '1530~1600', '/html/body/div[1]/div[6]/ul/li[16]');
INSERT INTO `time_duration_path` VALUES (17, '1600~1630', '/html/body/div[1]/div[6]/ul/li[17]');
INSERT INTO `time_duration_path` VALUES (18, '1630~1700', '/html/body/div[1]/div[6]/ul/li[18]');
INSERT INTO `time_duration_path` VALUES (19, '1700~1730', '/html/body/div[1]/div[6]/ul/li[19]');
INSERT INTO `time_duration_path` VALUES (20, '1730~1800', '/html/body/div[1]/div[6]/ul/li[20]');
INSERT INTO `time_duration_path` VALUES (21, '1800~1830', '/html/body/div[1]/div[6]/ul/li[21]');
INSERT INTO `time_duration_path` VALUES (22, '1830~1900', '/html/body/div[1]/div[6]/ul/li[22]');
INSERT INTO `time_duration_path` VALUES (23, '1900~1930', '/html/body/div[1]/div[6]/ul/li[23]');
INSERT INTO `time_duration_path` VALUES (24, '1930~2000', '/html/body/div[1]/div[6]/ul/li[24]');
INSERT INTO `time_duration_path` VALUES (25, '2000~2030', '/html/body/div[1]/div[6]/ul/li[25]');
INSERT INTO `time_duration_path` VALUES (26, '2030~2100', '/html/body/div[1]/div[6]/ul/li[26]');
INSERT INTO `time_duration_path` VALUES (27, '2100~2130', '/html/body/div[1]/div[6]/ul/li[27]');
INSERT INTO `time_duration_path` VALUES (28, '2130~2200', '/html/body/div[1]/div[6]/ul/li[28]');

SET FOREIGN_KEY_CHECKS = 1;
