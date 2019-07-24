/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 120.26.8.206:3306
 Source Schema         : first

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 24/07/2019 15:54:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item_info
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `price` decimal(15,2) DEFAULT NULL COMMENT '销售价',
  `is_active` int(11) DEFAULT '1' COMMENT '是否有效（1=是；0=否）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code` (`code`) USING BTREE COMMENT '商品编码唯一'
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of item_info
-- ----------------------------
BEGIN;
INSERT INTO `item_info` VALUES (1, '10010', 'Java编程思想', 58.50, 1, '2019-01-13 14:07:58', NULL);
INSERT INTO `item_info` VALUES (2, '10011', '由浅入深实战分布式中间件', 45.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (3, '10012', 'Dubbo实战教程', 68.00, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (4, '10013', 'JVM深入实战指南', 38.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (5, '10014', 'SpringBoot实战', 56.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (6, '10015', 'SpringCloud实战', 64.00, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (7, '10017', 'Mysql实战指南', 75.50, 1, '2019-01-13 14:07:59', NULL);
COMMIT;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `is_active` int(255) DEFAULT '1',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order_record
-- ----------------------------
BEGIN;
INSERT INTO `order_record` VALUES (1, 1, 2, 'charspan', '2019-07-24 14:17:06', 1, NULL);
INSERT INTO `order_record` VALUES (2, 2, 2, 'charspan', '2019-07-24 15:30:03', 1, NULL);
INSERT INTO `order_record` VALUES (3, 2, 12, 'tom', '2019-07-24 15:45:44', 1, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
