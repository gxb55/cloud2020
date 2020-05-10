/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : seata_order

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/05/2020 21:09:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '产品id',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `money` decimal(11, 0) NULL DEFAULT NULL COMMENT '金额',
  `status` int(1) NULL DEFAULT NULL COMMENT '订单状态 0创建中 1已完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (7, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (8, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (9, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (10, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (11, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (12, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (13, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (14, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (15, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (16, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (17, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (18, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (19, 1, 1, 10, 100, 1);
INSERT INTO `t_order` VALUES (20, 1, 1, 10, 100, 0);
INSERT INTO `t_order` VALUES (21, 1, 1, 10, 100, 0);

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime(0) NULL,
  `log_modified` datetime(0) NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
