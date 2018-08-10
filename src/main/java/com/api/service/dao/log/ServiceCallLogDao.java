/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.dao.log;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.api.service.entity.log.ServiceCallLog;

/**
 * 服务调用日志DAO接口
 * @author 薛刚希
 * @version 2018-08-10
 */
@MyBatisDao
public interface ServiceCallLogDao extends CrudDao<ServiceCallLog> {
	
}