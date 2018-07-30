/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.dao.group;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.api.sql.entity.group.QueryGroup;

/**
 * SQL查询分组DAO接口
 * @author hs
 * @version 2018-07-30
 */
@MyBatisDao
public interface QueryGroupDao extends CrudDao<QueryGroup> {
	
}