/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.entity.log;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 服务调用日志Entity
 * @author 薛刚希
 * @version 2018-08-10
 */
public class ServiceCallLog extends DataEntity<ServiceCallLog> {
	
	private static final long serialVersionUID = 1L;
	private String serviceCode;		// 服务代码
	private String serviceName;		// 服务名称
	private String channel;		// 服务渠道
	private String serviceCenterUrl;		// 服务中心
	private String serviceGroup;		// 服务组
	private String className;		// 服务类名
	private String version;		// 版本号
	private String serviceType;		// 服务类型
	private String queryGroupid;		// 查询分组ID
	private String requestIp;		// 请求IP
	private String requestData;		// 请求报文
	private String responseData;		// 返回报文
	private Date requestTime;		// 请求时间
	private Date responseTime;		// 返回时间
	private String handleTime;		// 处理时间
	private Date beginRequestTime;		// 开始 请求时间
	private Date endRequestTime;		// 结束 请求时间
	private Date beginResponseTime;		// 开始 返回时间
	private Date endResponseTime;		// 结束 返回时间
	private String beginHandleTime;		// 开始 处理时间
	private String endHandleTime;		// 结束 处理时间
	
	public ServiceCallLog() {
		super();
	}

	public ServiceCallLog(String id){
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
	
	@Length(min=1, max=2, message="服务渠道长度必须介于 1 和 2 之间")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	@Length(min=0, max=256, message="服务中心长度必须介于 0 和 256 之间")
	public String getServiceCenterUrl() {
		return serviceCenterUrl;
	}

	public void setServiceCenterUrl(String serviceCenterUrl) {
		this.serviceCenterUrl = serviceCenterUrl;
	}
	
	@Length(min=0, max=256, message="服务组长度必须介于 0 和 256 之间")
	public String getServiceGroup() {
		return serviceGroup;
	}

	public void setServiceGroup(String serviceGroup) {
		this.serviceGroup = serviceGroup;
	}
	
	@Length(min=0, max=512, message="服务类名长度必须介于 0 和 512 之间")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Length(min=1, max=8, message="版本号长度必须介于 1 和 8 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Length(min=0, max=2, message="服务类型长度必须介于 0 和 2 之间")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	@Length(min=0, max=32, message="查询分组ID长度必须介于 0 和 32 之间")
	public String getQueryGroupid() {
		return queryGroupid;
	}

	public void setQueryGroupid(String queryGroupid) {
		this.queryGroupid = queryGroupid;
	}
	
	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	
	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	
	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="请求时间不能为空")
	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="返回时间不能为空")
	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}
	
	@Length(min=1, max=24, message="处理时间长度必须介于 1 和 24 之间")
	public String getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	
	public Date getBeginRequestTime() {
		return beginRequestTime;
	}

	public void setBeginRequestTime(Date beginRequestTime) {
		this.beginRequestTime = beginRequestTime;
	}
	
	public Date getEndRequestTime() {
		return endRequestTime;
	}

	public void setEndRequestTime(Date endRequestTime) {
		this.endRequestTime = endRequestTime;
	}
		
	public Date getBeginResponseTime() {
		return beginResponseTime;
	}

	public void setBeginResponseTime(Date beginResponseTime) {
		this.beginResponseTime = beginResponseTime;
	}
	
	public Date getEndResponseTime() {
		return endResponseTime;
	}

	public void setEndResponseTime(Date endResponseTime) {
		this.endResponseTime = endResponseTime;
	}
		
	public String getBeginHandleTime() {
		return beginHandleTime;
	}

	public void setBeginHandleTime(String beginHandleTime) {
		this.beginHandleTime = beginHandleTime;
	}
	
	public String getEndHandleTime() {
		return endHandleTime;
	}

	public void setEndHandleTime(String endHandleTime) {
		this.endHandleTime = endHandleTime;
	}
		
}