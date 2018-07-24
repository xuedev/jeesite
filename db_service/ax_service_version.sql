CREATE TABLE `ax_service_version` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `service_code` varchar(128) NOT NULL COMMENT '服务编码',
  `channel` varchar(2) NOT NULL COMMENT '服务渠道[00:所有渠道,01:网页;02:WAP;03:微信;04:安卓;05:苹果;]',
  `version` varchar(8) NOT NULL COMMENT '版本号',
  `ver_status` int(2) DEFAULT NULL COMMENT '接口状态[1:创建;2:开发中;3:上线;4:下线;5:删除;99:升级;]',
  `data_des` text COMMENT '接口明细说明',
  `data_example` text COMMENT '接口示例',
  `data_returnDes` text COMMENT '返回结果报文',
  `is_current` varchar(2) DEFAULT NULL COMMENT '是否当前版本[00:否;01:是;]',
  `ret_data_type` varchar(2) DEFAULT NULL COMMENT '返回数据类型[01:报文;02:文本块;]',
  `class_name` varchar(512) DEFAULT NULL COMMENT '类名 全路径加载时使用',
  `imitate_data` text COMMENT '模拟报文 开发中的接口返回模拟报文',
  `query_groupId` varchar(32) DEFAULT NULL COMMENT '查询分组ID',
  `pro_code` varchar(32) DEFAULT NULL COMMENT '项目编码',
  `app_code` varchar(32) DEFAULT NULL COMMENT '应用编码',

  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',

  PRIMARY KEY (`service_code`,`channel`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务接口版本表';