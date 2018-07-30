/*
Navicat MySQL Data Transfer

Source Server         : 51.106
Source Server Version : 50717
Source Host           : 192.168.51.106:3306
Source Database       : platform_service

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-30 11:55:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ax_query_sql`
-- ----------------------------
DROP TABLE IF EXISTS `ax_query_sql`;
CREATE TABLE `ax_query_sql` (
  `id` varchar(32) NOT NULL COMMENT '查询ID',
  `querysqlId` varchar(32) DEFAULT NULL COMMENT '查询sqlID',
  `queryGroupId` varchar(32) DEFAULT NULL COMMENT '查询分组ID',
  `seqNo` int(11) DEFAULT '0' COMMENT '查询序号 从0开始',
  `querySqlType` varchar(2) DEFAULT NULL COMMENT '查询SQL数据类型[01:SQL语句;02:静态数据;]',
  `queryDes` text COMMENT '查询说明',
  `querySql` text COMMENT '查询SQL',
  `dataSource` varchar(32) DEFAULT NULL COMMENT '数据源',
  `proCode` varchar(32) DEFAULT NULL COMMENT '项目编码',
  `appCode` varchar(32) DEFAULT NULL COMMENT '应用编码',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查询语句表';

-- ----------------------------
-- Records of ax_query_sql
-- ---------------------------
