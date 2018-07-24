/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.service.version;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.api.service.entity.version.SingleServiceVersion;
import com.api.service.dao.version.SingleServiceVersionDao;

/**
 * 服务版本Service
 * @author 薛刚希
 * @version 2018-07-24
 */
@Service
@Transactional(readOnly = true)
public class SingleServiceVersionService extends CrudService<SingleServiceVersionDao, SingleServiceVersion> {

	public SingleServiceVersion get(String id) {
		return super.get(id);
	}
	
	public List<SingleServiceVersion> findList(SingleServiceVersion singleServiceVersion) {
		return super.findList(singleServiceVersion);
	}
	
	public Page<SingleServiceVersion> findPage(Page<SingleServiceVersion> page, SingleServiceVersion singleServiceVersion) {
		return super.findPage(page, singleServiceVersion);
	}
	
	@Transactional(readOnly = false)
	public void save(SingleServiceVersion singleServiceVersion) {
		super.save(singleServiceVersion);
	}
	
	@Transactional(readOnly = false)
	public void delete(SingleServiceVersion singleServiceVersion) {
		super.delete(singleServiceVersion);
	}
	
}