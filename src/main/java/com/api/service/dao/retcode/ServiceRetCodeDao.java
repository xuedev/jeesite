/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.dao.retcode;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.api.service.entity.retcode.ServiceRetCode;

/**
 * 返回码表DAO接口
 * @author 薛刚希
 * @version 2018-07-28
 */
@MyBatisDao
public interface ServiceRetCodeDao extends CrudDao<ServiceRetCode> {
	
}