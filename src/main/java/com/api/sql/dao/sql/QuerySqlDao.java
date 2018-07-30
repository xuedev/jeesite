/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.dao.sql;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.api.sql.entity.sql.QuerySql;

/**
 * SQL查询分组sqlDAO接口
 * @author hs
 * @version 2018-07-30
 */
@MyBatisDao
public interface QuerySqlDao extends CrudDao<QuerySql> {
	
}