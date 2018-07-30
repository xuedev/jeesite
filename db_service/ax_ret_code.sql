CREATE TABLE `ax_ret_code` (
	`id` varchar(64) NOT NULL COMMENT '编号',
  `ret_code` varchar(32) NOT NULL COMMENT '返回码',
  `ret_msg` varchar(1024) DEFAULT NULL COMMENT '返回码说明',
  `pro_code` varchar(32) DEFAULT NULL COMMENT '项目编码',
  `app_code` varchar(32) DEFAULT NULL COMMENT '应用编码',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime  DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime  DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',

  PRIMARY KEY (`ret_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息返回码表';