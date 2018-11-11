/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : menu

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-11-01 10:16:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `desk`
-- ----------------------------
DROP TABLE IF EXISTS `desk`;
CREATE TABLE `desk` (
  `desk_id` varchar(36) NOT NULL,
  `desk_name` int(11) NOT NULL COMMENT '几号桌',
  `desk_room` varchar(36) NOT NULL,
  `desk_num` int(11) NOT NULL DEFAULT '4' COMMENT '能坐多少人',
  PRIMARY KEY (`desk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of desk
-- ----------------------------
INSERT INTO `desk` VALUES ('14cb5d3e-64e9-44ef-99ca-0e8e31ef1618', '1231', '5cdd74f8-9e5f-4f05-8093-e4b5254a5034', '1231');
INSERT INTO `desk` VALUES ('1920f501-a3fc-40d9-ab5a-5480d0f4971a', '11111', '5cdd74f8-9e5f-4f05-8093-e4b5254a5034', '11');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(36) NOT NULL,
  `order_user_id` varchar(36) NOT NULL,
  `order_price` double NOT NULL DEFAULT '0',
  `order_desk` varchar(36) NOT NULL COMMENT '这个订单在多少号桌',
  `order_created_time` varchar(50) NOT NULL COMMENT '创建时间',
  `order_flag` int(11) NOT NULL DEFAULT '1' COMMENT '1没买单，2买单',
  `order_delete` int(2) NOT NULL DEFAULT '1' COMMENT '1正常2删除',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('d87b0f3e-7ecf-41e4-9708-9364a2d0a1f2', '6fbb71f5-d9ee-11e8-9b2d-e4f89cbef13a', '13246', '14cb5d3e-64e9-44ef-99ca-0e8e31ef1618', '2018年11月01日 09:32:18', '2', '1');

-- ----------------------------
-- Table structure for `order_vage`
-- ----------------------------
DROP TABLE IF EXISTS `order_vage`;
CREATE TABLE `order_vage` (
  `order_id` varchar(36) NOT NULL,
  `vage_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_vage
-- ----------------------------
INSERT INTO `order_vage` VALUES ('d87b0f3e-7ecf-41e4-9708-9364a2d0a1f2', '00222490-5ed9-4d08-841e-b5f4376af78a');
INSERT INTO `order_vage` VALUES ('d87b0f3e-7ecf-41e4-9708-9364a2d0a1f2', 'fb8efe54-57c7-4564-ac49-cc2deeb921b6');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` varchar(36) NOT NULL,
  `room_name` varchar(36) NOT NULL COMMENT '房间名称，xx房',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('5cdd74f8-9e5f-4f05-8093-e4b5254a5034', '12312');
INSERT INTO `room` VALUES ('cc6eb775-03b1-44b3-bfae-0640dc24ba4b', '房间1号');
INSERT INTO `room` VALUES ('ce7566e0-7269-4db2-994a-8b2c1781a5ac', '哈哈');
INSERT INTO `room` VALUES ('e285e4ed-7a6a-4c72-88d3-2d68669161e4', '一号房');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` varchar(36) NOT NULL,
  `type_name` varchar(36) NOT NULL,
  `type_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('a50442ef-b819-41c4-bd3a-73c1ec628f65', '新增1', '31380725');
INSERT INTO `type` VALUES ('bb963773-dce4-11e8-b150-e4f89cbef13a', '肉类', '246');
INSERT INTO `type` VALUES ('bc11036b-dce4-11e8-b150-e4f89cbef13a', '肉类', '134');
INSERT INTO `type` VALUES ('bc292c50-dce4-11e8-b150-e4f89cbef13a', '肉类', '0');
INSERT INTO `type` VALUES ('bfbed28a-dce4-11e8-b150-e4f89cbef13a', '蔬菜', '20');
INSERT INTO `type` VALUES ('c4038297-dce4-11e8-b150-e4f89cbef13a', '水果', '0');
INSERT INTO `type` VALUES ('c417dd1c-dce4-11e8-b150-e4f89cbef13a', '水果', '0');
INSERT INTO `type` VALUES ('c53dadc9-dce4-11e8-b150-e4f89cbef13a', '水果', '0');
INSERT INTO `type` VALUES ('c78b2eb1-dce4-11e8-b150-e4f89cbef13a', '甜点', '0');
INSERT INTO `type` VALUES ('c79f2b10-dce4-11e8-b150-e4f89cbef13a', '甜点', '0');
INSERT INTO `type` VALUES ('c7d2aa1c-dce4-11e8-b150-e4f89cbef13a', '甜点', '0');
INSERT INTO `type` VALUES ('c7f077ca-dce4-11e8-b150-e4f89cbef13a', '甜点', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(36) NOT NULL,
  `username` varchar(36) NOT NULL,
  `password` varchar(36) NOT NULL,
  `user_flag` int(2) NOT NULL DEFAULT '1' COMMENT '1为用户。2为管理员',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6fbb71f5-d9ee-11e8-9b2d-e4f89cbef13a', '123', '123', '1');
INSERT INTO `user` VALUES ('782e6081-d9ee-11e8-9b2d-e4f89cbef13a', 'admin', 'admin', '2');

-- ----------------------------
-- Table structure for `vagetable`
-- ----------------------------
DROP TABLE IF EXISTS `vagetable`;
CREATE TABLE `vagetable` (
  `vage_id` varchar(36) NOT NULL,
  `vage_name` varchar(36) NOT NULL,
  `vage_type` varchar(36) NOT NULL COMMENT '菜品类型（蔬菜？肉？甜点？）',
  `vage_num` int(11) NOT NULL DEFAULT '0',
  `vage_price` double(10,0) NOT NULL DEFAULT '0',
  `vage_delete` int(11) NOT NULL COMMENT '1正常2删除',
  PRIMARY KEY (`vage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vagetable
-- ----------------------------
INSERT INTO `vagetable` VALUES ('00222490-5ed9-4d08-841e-b5f4376af78a', '1231111111111111111', 'bb963773-dce4-11e8-b150-e4f89cbef13a', '123', '13123', '1');
INSERT INTO `vagetable` VALUES ('1664bd7c-c2e9-47d6-8db5-20dfd17a1852', 'svfsd', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '12', '321', '1');
INSERT INTO `vagetable` VALUES ('3593cbb0-14c7-4bed-8c12-725313a0ae4b', '123213', 'bc11036b-dce4-11e8-b150-e4f89cbef13a', '123', '12313', '1');
INSERT INTO `vagetable` VALUES ('39cbb0cc-abdc-492d-92f7-9cf37459ce8a', '12312', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '31232131', '12313', '1');
INSERT INTO `vagetable` VALUES ('4c1e7953-24b4-47a2-aec5-cf3c41e141f7', 'cvsdf', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '123', '123', '1');
INSERT INTO `vagetable` VALUES ('5ef2744b-9b24-4273-97a9-4a69d8c5dfec', '1231', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '12312', '1231', '1');
INSERT INTO `vagetable` VALUES ('6b4cc53e-dcc2-4f39-ac49-28b362f2d54e', 'bfsdg', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '123', '123', '1');
INSERT INTO `vagetable` VALUES ('982b6441-0822-48f6-9465-8565b79a16c2', 'cs', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '123', '123', '1');
INSERT INTO `vagetable` VALUES ('9fd17459-52a8-449b-9b1e-d48b261c30c3', '123', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '123', '123', '1');
INSERT INTO `vagetable` VALUES ('b74e4ad7-e27c-4a2e-af6e-996f6ac56e86', '12313', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '123213', '12321', '1');
INSERT INTO `vagetable` VALUES ('b83449b9-7ce6-4a82-9037-ce94a72dc0eb', '12313', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '121', '1121', '1');
INSERT INTO `vagetable` VALUES ('bc2e99a8-c9d6-49b6-b347-e95f0b4ee979', '123121312', 'bb963773-dce4-11e8-b150-e4f89cbef13a', '123', '123123', '1');
INSERT INTO `vagetable` VALUES ('de336805-bbb8-4927-b5af-d32c3ecbe90f', '12e3', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '12321', '123', '1');
INSERT INTO `vagetable` VALUES ('f1953db9-ce0f-462c-983c-1a1ecdaf9f61', '123', 'bc11036b-dce4-11e8-b150-e4f89cbef13a', '11', '111', '1');
INSERT INTO `vagetable` VALUES ('f7f2f332-583d-488c-8dbc-df806033b8c2', '卷心菜', 'bfbed28a-dce4-11e8-b150-e4f89cbef13a', '20', '1', '2');
INSERT INTO `vagetable` VALUES ('fb8efe54-57c7-4564-ac49-cc2deeb921b6', 'xcsdd', 'a50442ef-b819-41c4-bd3a-73c1ec628f65', '123', '123', '1');
