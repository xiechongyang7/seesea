/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : seesea

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-10-11 20:50:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `address_id` varchar(20) NOT NULL COMMENT '地址表id',
  `address_user_id` varchar(20) NOT NULL COMMENT '用户id',
  `address_province` varchar(50) DEFAULT NULL COMMENT '省',
  `address_city` varchar(50) DEFAULT NULL COMMENT '市',
  `address_area` varchar(255) DEFAULT NULL COMMENT '区',
  `address_detail` varchar(255) DEFAULT NULL,
  `address_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `唯一` (`address_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_friend
-- ----------------------------
DROP TABLE IF EXISTS `tb_friend`;
CREATE TABLE `tb_friend` (
  `friend_id` varchar(20) NOT NULL COMMENT '粉丝表id',
  `friend_fan_id` varchar(20) NOT NULL COMMENT '粉丝的id',
  `friend_attention_id` varchar(20) NOT NULL COMMENT '关注人id',
  PRIMARY KEY (`friend_id`),
  KEY `fan` (`friend_fan_id`),
  KEY `attention` (`friend_attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_gateway_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_gateway_log`;
CREATE TABLE `tb_gateway_log` (
  `req_id` varchar(20) NOT NULL COMMENT '请求id',
  `req_param` varchar(300) DEFAULT NULL COMMENT '请求参数',
  `rsp_param` varchar(300) DEFAULT NULL,
  `isEncrypt` tinyint(1) DEFAULT NULL COMMENT '是否严密0验证1不验证',
  `isSign` tinyint(1) DEFAULT NULL COMMENT '是否签名0签名1不签名',
  `service_id` varchar(8) DEFAULT NULL COMMENT '服务id',
  `req_time` datetime DEFAULT NULL COMMENT '请求时间',
  `rsp_time` datetime DEFAULT NULL,
  `rsp_code` varchar(4) DEFAULT NULL COMMENT '返回状态',
  `rsp_msg` varchar(300) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL COMMENT '请求用户id',
  PRIMARY KEY (`req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `login_id` varchar(20) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `login_time` datetime DEFAULT NULL,
  `login_num` int(11) DEFAULT NULL,
  `login_session` varchar(255) DEFAULT NULL,
  `login_falt` int(11) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_praise
-- ----------------------------
DROP TABLE IF EXISTS `tb_praise`;
CREATE TABLE `tb_praise` (
  `praise_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '点赞表id',
  `praise_user_id` varchar(20) NOT NULL COMMENT '点赞人id',
  `praise_book_id` varchar(20) DEFAULT NULL COMMENT '点赞的书id',
  `praise_comment_id` varchar(20) DEFAULT NULL COMMENT '点赞评论id',
  `praise_review_id` varchar(20) DEFAULT NULL COMMENT '点赞书评id',
  PRIMARY KEY (`praise_id`),
  KEY `praise_user_id` (`praise_user_id`),
  KEY `praise_book_id` (`praise_book_id`),
  KEY `praise_review_id` (`praise_review_id`),
  KEY `praise_comment_id` (`praise_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_service
-- ----------------------------
DROP TABLE IF EXISTS `tb_service`;
CREATE TABLE `tb_service` (
  `service_id` varchar(20) NOT NULL COMMENT '服务id',
  `service_name` varchar(20) DEFAULT NULL COMMENT '服务名称',
  `service_remark` varchar(100) DEFAULT NULL COMMENT '服务介绍',
  `service_url` varchar(50) NOT NULL COMMENT '路由地址',
  `isCheck` tinyint(1) DEFAULT NULL COMMENT '是否校验0校验1不校验',
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_sms_send_check
-- ----------------------------
DROP TABLE IF EXISTS `tb_sms_send_check`;
CREATE TABLE `tb_sms_send_check` (
  `sms_id` varchar(20) NOT NULL COMMENT '短信id',
  `sms_channel` varchar(20) NOT NULL COMMENT '短信通道',
  `user_id` varchar(0) DEFAULT NULL COMMENT '用户id',
  `sms_work` varchar(30) DEFAULT NULL COMMENT '业务',
  `sms_send_code` varchar(8) NOT NULL COMMENT '验证码',
  `sms_send_status` char(2) DEFAULT NULL COMMENT '发送状态',
  `sms_send_msg` varchar(255) DEFAULT NULL COMMENT '信息',
  `sms_check_code` char(2) DEFAULT NULL COMMENT '校验验证码',
  `sms_check_status` varchar(255) DEFAULT NULL COMMENT '校验状态',
  `sms_check_msg` varchar(255) DEFAULT NULL COMMENT '校验信息',
  `sms_send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `sms_check_time` datetime DEFAULT NULL COMMENT '校验时间',
  `phone` varchar(18) NOT NULL COMMENT '手机号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`sms_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `user_sex` int(11) DEFAULT NULL COMMENT '用户性别',
  `user_portrait` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_nickname` varchar(255) NOT NULL DEFAULT '游客' COMMENT '用户昵称',
  `user_signature` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `user_email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `user_birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `user_vip` int(1) DEFAULT '0' COMMENT '是否为vip',
  `user_coin` int(20) DEFAULT '20000' COMMENT '用户金币',
  `user_phone` varchar(255) NOT NULL COMMENT '用户手机号码',
  `user_passward` varchar(255) NOT NULL COMMENT '用户密码',
  `user_statu` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
