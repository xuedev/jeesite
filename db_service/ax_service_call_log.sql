CREATE TABLE `ax_service_call_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `service_code` varchar(128) NOT NULL COMMENT '服务代码',
  `service_name` varchar(256) DEFAULT NULL COMMENT '服务名称',
  `channel` varchar(2) NOT NULL COMMENT '服务渠道[00:所有渠道,01:网页;02:WAP;03:微信;04:安卓;05:苹果;]',
  `service_center_url` varchar(256) DEFAULT NULL COMMENT '服务中心地址',
  `service_group` varchar(256) DEFAULT NULL COMMENT '服务组名称',
  `class_name` varchar(512) DEFAULT NULL COMMENT '服务类名',
  `version` varchar(8) NOT NULL COMMENT '版本号',
  `service_type` varchar(2) DEFAULT NULL COMMENT '服务类型',
  `query_groupId` varchar(32) DEFAULT NULL COMMENT '查询分组ID',
	`request_ip` text COMMENT '请求IP',
  `request_data` text COMMENT '请求报文',
  `response_data` text COMMENT '返回报文',
  `request_time` datetime NOT NULL COMMENT '请求时间',
  `response_time` datetime NOT NULL COMMENT '返回时间',
  `handle_time` varchar(24) NOT NULL COMMENT '处理时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务调用日志表';

