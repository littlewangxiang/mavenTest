/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-09-23 16:42:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_table`
-- ----------------------------
DROP TABLE IF EXISTS `admin_table`;
CREATE TABLE `admin_table` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(55) NOT NULL COMMENT '管理员名称',
  `admin_pass` varchar(55) NOT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin_table
-- ----------------------------
INSERT INTO `admin_table` VALUES ('1', 'admin', '111111');

-- ----------------------------
-- Table structure for `advertise_table`
-- ----------------------------
DROP TABLE IF EXISTS `advertise_table`;
CREATE TABLE `advertise_table` (
  `adv_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL COMMENT '日期',
  `adv_title` varchar(55) DEFAULT NULL COMMENT '广告标题',
  `adv_content` varchar(255) DEFAULT NULL COMMENT '广告内容',
  PRIMARY KEY (`adv_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='广告表';

-- ----------------------------
-- Records of advertise_table
-- ----------------------------
INSERT INTO `advertise_table` VALUES ('1', '2016-02-01', '广告title', '广告内容');

-- ----------------------------
-- Table structure for `basket_table`
-- ----------------------------
DROP TABLE IF EXISTS `basket_table`;
CREATE TABLE `basket_table` (
  `basket_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品号',
  `user_id` int(11) NOT NULL COMMENT '数值',
  `basket_count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`basket_id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of basket_table
-- ----------------------------
INSERT INTO `basket_table` VALUES ('1', '1', '1', '1');
INSERT INTO `basket_table` VALUES ('2', '1', '1', '12');
INSERT INTO `basket_table` VALUES ('3', '1', '1', '12');
INSERT INTO `basket_table` VALUES ('4', '1', '1', '1111');

-- ----------------------------
-- Table structure for `product_table`
-- ----------------------------
DROP TABLE IF EXISTS `product_table`;
CREATE TABLE `product_table` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(55) NOT NULL COMMENT '商品名称',
  `brand` varchar(55) NOT NULL COMMENT '品牌',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `review` varchar(255) DEFAULT NULL COMMENT '评价',
  `sales` int(11) DEFAULT '0' COMMENT '销量',
  `date` date NOT NULL COMMENT '生产日期',
  `material` varchar(55) DEFAULT NULL,
  `size` varchar(55) DEFAULT NULL,
  `type_id` int(11) NOT NULL COMMENT '商品类型（外键）',
  `color` varchar(55) DEFAULT NULL COMMENT '颜色',
  `weight` int(11) DEFAULT NULL COMMENT '重量',
  PRIMARY KEY (`product_id`),
  KEY `type_id` (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product_table
-- ----------------------------
INSERT INTO `product_table` VALUES ('1', '奥迪A6', '奥迪', '360000', '奥迪车系是很厉害的车系', null, '800000', '2015-10-20', null, null, '1', null, null);
INSERT INTO `product_table` VALUES ('2', '奥迪A6', '奥迪', '360000', '奥迪车系是很厉害的车系', null, '800000', '2015-10-20', null, null, '1', null, null);
INSERT INTO `product_table` VALUES ('3', '奥迪A6', '奥迪', '360000', '奥迪车系是很厉害的车系', null, '800000', '2015-10-20', null, null, '1', null, null);
INSERT INTO `product_table` VALUES ('4', '奥迪A6', '奥迪', '360000', '奥迪车系是很厉害的车系', null, '800000', '2015-10-20', null, null, '1', null, null);

-- ----------------------------
-- Table structure for `sub_table`
-- ----------------------------
DROP TABLE IF EXISTS `sub_table`;
CREATE TABLE `sub_table` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sub_code` varchar(255) NOT NULL COMMENT '订单号',
  `pay` int(11) NOT NULL COMMENT '付款金额',
  `user_id` int(11) NOT NULL COMMENT '用户号（外键）',
  `sub_date` date NOT NULL COMMENT '订单日期',
  `product_id` int(11) NOT NULL COMMENT '商品号',
  `address` varchar(255) NOT NULL COMMENT '收件地址',
  `phone` varchar(255) NOT NULL COMMENT '收件人联系电话',
  PRIMARY KEY (`sub_id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of sub_table
-- ----------------------------
INSERT INTO `sub_table` VALUES ('1', '20151110-089', '10', '1', '2015-11-10', '1', '清华园', '1888888');
INSERT INTO `sub_table` VALUES ('3', '20151110-089', '10', '1', '2015-11-10', '1', '清华园', '1888888');
INSERT INTO `sub_table` VALUES ('4', '2312341324', '45', '1', '2016-01-29', '1', '河北工程大学', '13645789554');
INSERT INTO `sub_table` VALUES ('5', '234234234', '34', '1', '2016-01-29', '1', '河北大学一号院', '13645789551');
INSERT INTO `sub_table` VALUES ('6', '234234234', '34', '1', '2016-01-29', '1', '河北大学一号院', '13645789551');

-- ----------------------------
-- Table structure for `type_table`
-- ----------------------------
DROP TABLE IF EXISTS `type_table`;
CREATE TABLE `type_table` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(55) NOT NULL COMMENT '商品类型名称',
  `content` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品种类表';

-- ----------------------------
-- Records of type_table
-- ----------------------------
INSERT INTO `type_table` VALUES ('1', '汽车', '汽车是一种交通工具');
INSERT INTO `type_table` VALUES ('3', '水果', '主要是由植物结出的果实');

-- ----------------------------
-- Table structure for `t_integration`
-- ----------------------------
DROP TABLE IF EXISTS `t_integration`;
CREATE TABLE `t_integration` (
  `id` int(11) NOT NULL,
  `integration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_integration
-- ----------------------------
INSERT INTO `t_integration` VALUES ('1', '80');

-- ----------------------------
-- Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', 'qie', '的所发生的', '2016-09-19 15:45:05', '0');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `u_id` int(11) NOT NULL,
  `roleCode` varchar(50) NOT NULL,
  `roleName` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `rg_id` int(11) NOT NULL COMMENT '角色分组',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'ROLE_ADMIN_GOODS_ADD', '发布商品', 'ADMIN', '1');
INSERT INTO `t_role` VALUES ('2', 'ROLE_USER_ORDER_LIST', '查看订单列表', 'USER', '2');

-- ----------------------------
-- Table structure for `t_role_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_group`;
CREATE TABLE `t_role_group` (
  `u_id` int(11) NOT NULL,
  `rg_name` varchar(80) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色分组（本质就是部门名称）';

-- ----------------------------
-- Records of t_role_group
-- ----------------------------
INSERT INTO `t_role_group` VALUES ('1', '商品管理', 'ADMIN');
INSERT INTO `t_role_group` VALUES ('2', '用户中心', 'USER');
INSERT INTO `t_role_group` VALUES ('3', '用户管理', 'ADMIN');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'dfsd');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('4', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  `user_role` varchar(50) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=MyISAM AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'zhanglei', 'qweasd', 'USER');
INSERT INTO `user` VALUES ('3', '\"ceshi\"', '\"pass\"', 'USER');
INSERT INTO `user` VALUES ('4', 'admin', '1111', 'ADMIN');
INSERT INTO `user` VALUES ('5', '\"wangxiagn\"', '\"1111\"', 'USER');
INSERT INTO `user` VALUES ('6', '王小样', '123456', 'USER');
INSERT INTO `user` VALUES ('7', '王洋', '123456', 'USER');
INSERT INTO `user` VALUES ('8', '嘿嘿', '567', 'USER');
INSERT INTO `user` VALUES ('9', '哈哈34', '434', 'USER');
INSERT INTO `user` VALUES ('12', 'wx', '11111', 'USER');
INSERT INTO `user` VALUES ('56', 'testmyself', '11111', 'USER');
INSERT INTO `user` VALUES ('57', 'testmyself', '11111', 'USER');
INSERT INTO `user` VALUES ('67', '嗷嗷', '123', 'USER');

-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(55) NOT NULL COMMENT '名称',
  `user_pass` varchar(55) NOT NULL COMMENT '密码',
  `address` varchar(100) NOT NULL COMMENT '收件地址',
  `user_mail` varchar(55) NOT NULL COMMENT '用户邮箱',
  `question` varchar(100) DEFAULT NULL COMMENT '密保问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '密保答案',
  `sex` varchar(10) DEFAULT NULL,
  `phone` varchar(11) NOT NULL COMMENT '电话',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', 'wangxiang', '1111', '河北工业大学', '1775924476@qq.com', null, null, null, '12345678901');
INSERT INTO `user_table` VALUES ('2', '小明', '1111', '建国门', '123456@163.com', '最喜欢的动物', '小狗', '男', '1367129177');
INSERT INTO `user_table` VALUES ('3', '小红', '123456', '天安门', '456789@qq.com', '你的姓名', '小红', '女', '789653');
INSERT INTO `user_table` VALUES ('4', 'wangxiang', '1111', '河北工业大学', '1775924476@qq.com', null, null, null, '12345678901');
