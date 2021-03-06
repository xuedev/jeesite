CREATE TABLE `ax_service_info` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `service_code` varchar(128) NOT NULL COMMENT '接口服务代码',
  `service_name` varchar(256) DEFAULT NULL COMMENT '服务名称',
  `service_center_url` varchar(256) DEFAULT NULL COMMENT '服务中心地址',
  `service_group` varchar(256) DEFAULT NULL COMMENT '服务组名称',
  `is_need_login` varchar(2) DEFAULT NULL COMMENT '登录认证方式[01:登录令牌认证;02:不需登录认证;03:加密验签认证;]',
  `is_allow_cross_domain` varchar(2) DEFAULT NULL COMMENT '是否允许跨域[00:否;01:是;]',
  `service_type` varchar(2) DEFAULT NULL COMMENT '服务类型[01:DATA_SERVICE;02:DATA_QUERY;]',
  `adap_mode` varchar(2) DEFAULT NULL COMMENT '适配模式[01:适配当前版本;02:访问传入版本;]适配 当有当前接口时根据调用的接口版本自动寻找如果不存在或已停用则使用当前接口 强制省级：不管使用什么版号 最后都将使用当前接口传入版本的逻辑实现',
  `comm_mode` int(11) DEFAULT NULL COMMENT '请求方式[1:不限;2:POST;3:GET;]',
  `inter_status` int(11) DEFAULT NULL COMMENT '接口状态[1:创建;2:开发中;3:上线;4:下线;5:删除;99:升级;]',
  `pro_code` varchar(32) DEFAULT NULL COMMENT '项目编码',
  `app_code` varchar(32) DEFAULT NULL COMMENT '应用编码',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务接口基本信息表';