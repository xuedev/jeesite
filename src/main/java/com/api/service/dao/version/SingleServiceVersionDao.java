/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.dao.version;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.api.service.entity.version.SingleServiceVersion;

/**
 * 服务版本DAO接口
 * @author 薛刚希
 * @version 2018-07-24
 */
@MyBatisDao
public interface SingleServiceVersionDao extends CrudDao<SingleServiceVersion> {
	
}