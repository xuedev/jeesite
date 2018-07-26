/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.dao.info;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.api.service.entity.info.ServiceInfo;

/**
 * 服务基本信息DAO接口
 * @author 薛刚希
 * @version 2018-07-26
 */
@MyBatisDao
public interface ServiceInfoDao extends CrudDao<ServiceInfo> {
	
}