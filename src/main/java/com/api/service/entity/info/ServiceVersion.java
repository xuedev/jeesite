/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.entity.info;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 服务基本信息Entity
 * @author 薛刚希
 * @version 2018-07-26
 */
public class ServiceVersion extends DataEntity<ServiceVersion> {
	
	private static final long serialVersionUID = 1L;
	private String serviceCode;		// 服务编码 父类
	private String channel;		// 服务渠道
	private String version;		// 版本号
	private String verStatus;		// 接口状态
	private String dataDes;		// 接口明细
	private String dataExample;		// 接口示例
	private String dataReturndes;		// 返回结果
	private String isCurrent;		// 当前版本
	private String retDataType;		// 返回数据类型
	private String className;		// 类名
	private String imitateData;		// 模拟报文
	private String queryGroupid;		// 查询分组ID
	private String proCode;		// 项目编码
	private String appCode;		// 应用编码
	
	public ServiceVersion() {
		super();
	}

	public ServiceVersion(String serviceCode){
		this.serviceCode=serviceCode;
	}


	@Length(min=1, max=128, message="服务编码长度必须介于 1 和 128 之间")
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	@Length(min=1, max=2, message="服务渠道长度必须介于 1 和 2 之间")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	@Length(min=1, max=8, message="版本号长度必须介于 1 和 8 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Length(min=0, max=2, message="接口状态长度必须介于 0 和 2 之间")
	public String getVerStatus() {
		return verStatus;
	}

	public void setVerStatus(String verStatus) {
		this.verStatus = verStatus;
	}
	
	public String getDataDes() {
		return dataDes;
	}

	public void setDataDes(String dataDes) {
		this.dataDes = dataDes;
	}
	
	public String getDataExample() {
		return dataExample;
	}

	public void setDataExample(String dataExample) {
		this.dataExample = dataExample;
	}
	
	public String getDataReturndes() {
		return dataReturndes;
	}

	public void setDataReturndes(String dataReturndes) {
		this.dataReturndes = dataReturndes;
	}
	
	@Length(min=0, max=2, message="当前版本长度必须介于 0 和 2 之间")
	public String getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(String isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	@Length(min=0, max=2, message="返回数据类型长度必须介于 0 和 2 之间")
	public String getRetDataType() {
		return retDataType;
	}

	public void setRetDataType(String retDataType) {
		this.retDataType = retDataType;
	}
	
	@Length(min=0, max=512, message="类名长度必须介于 0 和 512 之间")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getImitateData() {
		return imitateData;
	}

	public void setImitateData(String imitateData) {
		this.imitateData = imitateData;
	}
	
	@Length(min=0, max=32, message="查询分组ID长度必须介于 0 和 32 之间")
	public String getQueryGroupid() {
		return queryGroupid;
	}

	public void setQueryGroupid(String queryGroupid) {
		this.queryGroupid = queryGroupid;
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