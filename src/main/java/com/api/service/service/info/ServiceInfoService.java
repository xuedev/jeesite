/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.service.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.api.service.entity.info.ServiceInfo;
import com.api.service.dao.info.ServiceInfoDao;
import com.api.service.entity.info.ServiceVersion;
import com.api.service.dao.info.ServiceVersionDao;

/**
 * 服务基本信息Service
 * @author 薛刚希
 * @version 2018-07-24
 */
@Service
@Transactional(readOnly = true)
public class ServiceInfoService extends CrudService<ServiceInfoDao, ServiceInfo> {

	@Autowired
	private ServiceVersionDao serviceVersionDao;
	
	public ServiceInfo get(String id) {
		ServiceInfo serviceInfo = super.get(id);
		ServiceVersion s = new ServiceVersion();
		s.setServiceCode(serviceInfo.getServiceCode());
		serviceInfo.setServiceVersionList(serviceVersionDao.findList(s));
		return serviceInfo;
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
		for (ServiceVersion serviceVersion : serviceInfo.getServiceVersionList()){
			if (serviceVersion.getId() == null){
				continue;
			}
			if (ServiceVersion.DEL_FLAG_NORMAL.equals(serviceVersion.getDelFlag())){
				if (StringUtils.isBlank(serviceVersion.getId())){
					serviceVersion.setServiceCode(serviceInfo.getServiceCode());
					serviceVersion.preInsert();
					serviceVersionDao.insert(serviceVersion);
				}else{
					serviceVersion.preUpdate();
					serviceVersionDao.update(serviceVersion);
				}
			}else{
				serviceVersionDao.delete(serviceVersion);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(ServiceInfo serviceInfo) {
		super.delete(serviceInfo);
		ServiceVersion s = new ServiceVersion();
		s.setServiceCode(serviceInfo.getServiceCode());
		serviceVersionDao.delete(s);
	}
	
}