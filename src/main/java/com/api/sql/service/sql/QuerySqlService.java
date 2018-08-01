/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.service.sql;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.api.sql.entity.sql.QuerySql;
import com.api.sql.dao.sql.QuerySqlDao;

/**
 * SQL查询分组sqlService
 * @author hs
 * @version 2018-08-01
 */
@Service
@Transactional(readOnly = true)
public class QuerySqlService extends CrudService<QuerySqlDao, QuerySql> {

	public QuerySql get(String id) {
		return super.get(id);
	}
	
	public List<QuerySql> findList(QuerySql querySql) {
		return super.findList(querySql);
	}
	
	public Page<QuerySql> findPage(Page<QuerySql> page, QuerySql querySql) {
		return super.findPage(page, querySql);
	}
	
	@Transactional(readOnly = false)
	public void save(QuerySql querySql) {
		super.save(querySql);
	}
	
	@Transactional(readOnly = false)
	public void delete(QuerySql querySql) {
		super.delete(querySql);
	}
	
}