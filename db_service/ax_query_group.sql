/*
Navicat MySQL Data Transfer

Source Server         : 51.106
Source Server Version : 50717
Source Host           : 192.168.51.106:3306
Source Database       : platform_service

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-30 16:25:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ax_query_group`
-- ----------------------------
DROP TABLE IF EXISTS `ax_query_group`;
CREATE TABLE `ax_query_group` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `queryGroupId` varchar(32) NOT NULL COMMENT '查询分组ID',
  `queryGroupDes` text COMMENT '查询介绍',
  `showType` varchar(2) DEFAULT NULL COMMENT '展示方式[01:按记录;02:按页;]',
  `showCount` int(11) DEFAULT NULL COMMENT '每页条数 当展示方式为按页时使用',
  `cacheType` varchar(2) DEFAULT NULL COMMENT '缓存类型[01:不缓存;02:REDIS缓存;]',
  `cacheTime` int(11) DEFAULT NULL COMMENT '缓存时长单位毫秒',
  `cacheKey` varchar(128) DEFAULT NULL COMMENT '缓存KEY用于记录该数据缓存在缓存容器里面的标志key以方便对该缓存数据进行管理',
  `interceptor` varchar(256) DEFAULT NULL COMMENT '拦截器 主要有两个方法执行前,执行后',
  `queryReference` varchar(512) DEFAULT NULL COMMENT '查询引用该数据查询可能会引用另一个数据查询的结果，存储数据查询的引用编号，多个之间以英文逗号分开',
  `proCode` varchar(32) DEFAULT NULL COMMENT '项目编码',
  `appCode` varchar(32) DEFAULT NULL COMMENT '应用编码',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `isPublicCall` varchar(2) DEFAULT NULL COMMENT '是否允许公共调用[00:否;01:是;]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据查询分组表';

-- ----------------------------
-- Records of ax_query_group
-- ----------------------------

