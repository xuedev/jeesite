/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.service.info;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.api.service.entity.info.ServiceInfo;
import com.api.service.dao.info.ServiceInfoDao;

/**
 * 服务基本信息Service
 * @author 薛刚希
 * @version 2018-07-24
 */
@Service
@Transactional(readOnly = true)
public class ServiceInfoService extends CrudService<ServiceInfoDao, ServiceInfo> {

	public ServiceInfo get(String id) {
		return super.get(id);
	}
	
	public List<ServiceInfo> findList(ServiceInfo serviceInfo) {
		return super.findList(serviceInfo);
	}
	
	public Page<ServiceInfo> findPage(Page<ServiceInfo> page, ServiceInfo serviceInfo) {
		return super.findPage(page, serviceInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ServiceInfo serviceInfo) {
		super.save(serviceInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ServiceInfo serviceInfo) {
		super.delete(serviceInfo);
	}
	
}