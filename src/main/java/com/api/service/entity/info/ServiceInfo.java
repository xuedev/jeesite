/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.entity.info;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 服务基本信息Entity
 * @author 薛刚希
 * @version 2018-07-24
 */
public class ServiceInfo extends DataEntity<ServiceInfo> {
	
	private static final long serialVersionUID = 1L;
	private String serviceCode;		// 服务代码
	private String serviceName;		// 服务名称
	private String isNeedLogin;		// 登录认证方式
	private String isAllowCrossDomain;		// 是否允许跨域
	private String serviceType;		// 服务类型
	private String adapMode;		// 适配模式
	private String commMode;		// 请求方式
	private String interStatus;		// 接口状态
	private String proCode;		// 项目编码
	private String appCode;		// 应用编码
	private List<ServiceVersion> serviceVersionList = Lists.newArrayList();		// 子表列表
	
	public ServiceInfo() {
		super();
	}

	public ServiceInfo(String id){
		super(id);
	}

	@Length(min=1, max=128, message="服务代码长度必须介于 1 和 128 之间")
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	@Length(min=0, max=256, message="服务名称长度必须介于 0 和 256 之间")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	@Length(min=0, max=2, message="登录认证方式长度必须介于 0 和 2 之间")
	public String getIsNeedLogin() {
		return isNeedLogin;
	}

	public void setIsNeedLogin(String isNeedLogin) {
		this.isNeedLogin = isNeedLogin;
	}
	
	@Length(min=0, max=2, message="是否允许跨域长度必须介于 0 和 2 之间")
	public String getIsAllowCrossDomain() {
		return isAllowCrossDomain;
	}

	public void setIsAllowCrossDomain(String isAllowCrossDomain) {
		this.isAllowCrossDomain = isAllowCrossDomain;
	}
	
	@Length(min=0, max=2, message="服务类型长度必须介于 0 和 2 之间")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	@Length(min=0, max=2, message="适配模式长度必须介于 0 和 2 之间")
	public String getAdapMode() {
		return adapMode;
	}

	public void setAdapMode(String adapMode) {
		this.adapMode = adapMode;
	}
	
	@Length(min=0, max=11, message="请求方式长度必须介于 0 和 11 之间")
	public String getCommMode() {
		return commMode;
	}

	public void setCommMode(String commMode) {
		this.commMode = commMode;
	}
	
	@Length(min=0, max=11, message="接口状态长度必须介于 0 和 11 之间")
	public String getInterStatus() {
		return interStatus;
	}

	public void setInterStatus(String interStatus) {
		this.interStatus = interStatus;
	}
	
	@Length(min=0, max=32, message="项目编码长度必须介于 0 和 32 之间")
	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	
	@Length(min=0, max=32, message="应用编码长度必须介于 0 和 32 之间")
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	public List<ServiceVersion> getServiceVersionList() {
		return serviceVersionList;
	}

	public void setServiceVersionList(List<ServiceVersion> serviceVersionList) {
		this.serviceVersionList = serviceVersionList;
	}
}