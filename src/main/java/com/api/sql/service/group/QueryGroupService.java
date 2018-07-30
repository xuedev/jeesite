/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.service.group;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.api.sql.entity.group.QueryGroup;
import com.api.sql.dao.group.QueryGroupDao;

/**
 * SQL查询分组Service
 * @author hs
 * @version 2018-07-30
 */
@Service
@Transactional(readOnly = true)
public class QueryGroupService extends CrudService<QueryGroupDao, QueryGroup> {

	public QueryGroup get(String id) {
		return super.get(id);
	}
	
	public List<QueryGroup> findList(QueryGroup queryGroup) {
		return super.findList(queryGroup);
	}
	
	public Page<QueryGroup> findPage(Page<QueryGroup> page, QueryGroup queryGroup) {
		return super.findPage(page, queryGroup);
	}
	
	@Transactional(readOnly = false)
	public void save(QueryGroup queryGroup) {
		super.save(queryGroup);
	}
	
	@Transactional(readOnly = false)
	public void delete(QueryGroup queryGroup) {
		super.delete(queryGroup);
	}
	
}