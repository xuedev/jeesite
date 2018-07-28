/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.service.retcode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.api.service.entity.retcode.ServiceRetCode;
import com.api.service.dao.retcode.ServiceRetCodeDao;

/**
 * 返回码表Service
 * @author 薛刚希
 * @version 2018-07-28
 */
@Service
@Transactional(readOnly = true)
public class ServiceRetCodeService extends CrudService<ServiceRetCodeDao, ServiceRetCode> {

	public ServiceRetCode get(String id) {
		return super.get(id);
	}
	
	public List<ServiceRetCode> findList(ServiceRetCode serviceRetCode) {
		return super.findList(serviceRetCode);
	}
	
	public Page<ServiceRetCode> findPage(Page<ServiceRetCode> page, ServiceRetCode serviceRetCode) {
		return super.findPage(page, serviceRetCode);
	}
	
	@Transactional(readOnly = false)
	public void save(ServiceRetCode serviceRetCode) {
		super.save(serviceRetCode);
	}
	
	@Transactional(readOnly = false)
	public void delete(ServiceRetCode serviceRetCode) {
		super.delete(serviceRetCode);
	}
	
}