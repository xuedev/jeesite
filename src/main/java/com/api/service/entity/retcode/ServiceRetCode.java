/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.entity.retcode;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 返回码表Entity
 * @author 薛刚希
 * @version 2018-07-28
 */
public class ServiceRetCode extends DataEntity<ServiceRetCode> {
	
	private static final long serialVersionUID = 1L;
	private String retCode;		// 返回代码
	private String retMsg;		// 返回信息
	private String proCode;		// 项目编码
	private String appCode;		// 应用编码
	
	public ServiceRetCode() {
		super();
	}

	public ServiceRetCode(String id){
		super(id);
	}

	@Length(min=1, max=32, message="返回代码长度必须介于 1 和 32 之间")
	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	
	@Length(min=0, max=1024, message="返回信息长度必须介于 0 和 1024 之间")
	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
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
	
}