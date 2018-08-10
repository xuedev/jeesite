/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.service.log;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.api.service.entity.log.ServiceCallLog;
import com.api.service.dao.log.ServiceCallLogDao;

/**
 * 服务调用日志Service
 * @author 薛刚希
 * @version 2018-08-10
 */
@Service
@Transactional(readOnly = true)
public class ServiceCallLogService extends CrudService<ServiceCallLogDao, ServiceCallLog> {

	public ServiceCallLog get(String id) {
		return super.get(id);
	}
	
	public List<ServiceCallLog> findList(ServiceCallLog serviceCallLog) {
		return super.findList(serviceCallLog);
	}
	
	public Page<ServiceCallLog> findPage(Page<ServiceCallLog> page, ServiceCallLog serviceCallLog) {
		return super.findPage(page, serviceCallLog);
	}
	
	@Transactional(readOnly = false)
	public void save(ServiceCallLog serviceCallLog) {
		super.save(serviceCallLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(ServiceCallLog serviceCallLog) {
		super.delete(serviceCallLog);
	}
	
}