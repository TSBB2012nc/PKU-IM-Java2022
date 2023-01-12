/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : java-2022

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 12/01/2023 16:16:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for index
-- ----------------------------
DROP TABLE IF EXISTS `index`;
CREATE TABLE `index`  (
  `COUNTRY` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `D11` float NULL DEFAULT NULL,
  `D111` float NULL DEFAULT NULL,
  `D112` float NULL DEFAULT NULL,
  `D12` float NULL DEFAULT NULL,
  `D121` float NULL DEFAULT NULL,
  `D122` float NULL DEFAULT NULL,
  `YEAR` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`COUNTRY`, `YEAR`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index
-- ----------------------------
INSERT INTO `index` VALUES ('中国', 0.916667, 0.833333, 1, 0.0344432, 0.0104068, 0.0104068, '2019');
INSERT INTO `index` VALUES ('中国', 1, 1, 1, 0.00440399, 0, 0, '2020');
INSERT INTO `index` VALUES ('中国', 1, 1, 1, 0.030819, 0.0479323, 0.0479323, '2021');
INSERT INTO `index` VALUES ('俄国', 0, 0, 0, 0.00189215, 0.0037843, 0.0037843, '2019');
INSERT INTO `index` VALUES ('俄国', 0, 0, 0, 0.00662252, 0.013245, 0.013245, '2020');
INSERT INTO `index` VALUES ('俄国', 0, 0, 0, 0, 0, 0, '2021');
INSERT INTO `index` VALUES ('法国', 0.057282, 0.0227273, 0.0918367, 0.00950292, 0, 0, '2019');
INSERT INTO `index` VALUES ('法国', 0.0687531, 0.0703125, 0.0671937, 0.0017616, 0, 0, '2020');
INSERT INTO `index` VALUES ('法国', 0.0436455, 0.0565217, 0.0307692, 0.00577542, 0.0110432, 0.0110432, '2021');
INSERT INTO `index` VALUES ('美国', 0.839286, 1, 0.678571, 1, 1, 1, '2019');
INSERT INTO `index` VALUES ('美国', 0.562932, 0.71875, 0.407115, 1, 1, 1, '2020');
INSERT INTO `index` VALUES ('美国', 0.395803, 0.523913, 0.267692, 1, 1, 1, '2021');
INSERT INTO `index` VALUES ('英国', 0.120748, 0.0833333, 0.158163, 0.0227044, 0.013245, 0.013245, '2019');
INSERT INTO `index` VALUES ('英国', 0.0786808, 0.0625, 0.0948617, 0.0189294, 0.0231788, 0.0231788, '2020');
INSERT INTO `index` VALUES ('英国', 0.0538629, 0.0369565, 0.0707692, 0.0194377, 0.0216165, 0.0216165, '2021');

SET FOREIGN_KEY_CHECKS = 1;
