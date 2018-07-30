/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.entity.group;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * SQL查询分组Entity
 * @author hs
 * @version 2018-07-30
 */
public class QueryGroup extends DataEntity<QueryGroup> {
	
	private static final long serialVersionUID = 1L;
	private String querygroupid;		// 查询分组ID
	private String querygroupdes;		// 查询介绍
	private String showtype;		// 展示方式
	private Integer showcount;		// 每页条数
	private String cachetype;		// 缓存类型
	private Integer cachetime;		// 缓存时长
	private String cachekey;		// 缓存KEY
	private String interceptor;		// 拦截器
	private String queryreference;		// 查询引用
	private String procode;		// 项目编码
	private String appcode;		// 应用编码
	private String ispubliccall;		// 是否允许公共调
	
	public QueryGroup() {
		super();
	}

	public QueryGroup(String id){
		super(id);
	}

	@Length(min=1, max=32, message="查询分组ID长度必须介于 1 和 32 之间")
	public String getQuerygroupid() {
		return querygroupid;
	}

	public void setQuerygroupid(String querygroupid) {
		this.querygroupid = querygroupid;
	}
	
	public String getQuerygroupdes() {
		return querygroupdes;
	}

	public void setQuerygroupdes(String querygroupdes) {
		this.querygroupdes = querygroupdes;
	}
	
	@Length(min=0, max=2, message="展示方式长度必须介于 0 和 2 之间")
	public String getShowtype() {
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	
	public Integer getShowcount() {
		return showcount;
	}

	public void setShowcount(Integer showcount) {
		this.showcount = showcount;
	}
	
	@Length(min=0, max=2, message="缓存类型长度必须介于 0 和 2 之间")
	public String getCachetype() {
		return cachetype;
	}

	public void setCachetype(String cachetype) {
		this.cachetype = cachetype;
	}
	
	public Integer getCachetime() {
		return cachetime;
	}

	public void setCachetime(Integer cachetime) {
		this.cachetime = cachetime;
	}
	
	@Length(min=0, max=128, message="缓存KEY长度必须介于 0 和 128 之间")
	public String getCachekey() {
		return cachekey;
	}

	public void setCachekey(String cachekey) {
		this.cachekey = cachekey;
	}
	
	@Length(min=0, max=256, message="拦截器长度必须介于 0 和 256 之间")
	public String getInterceptor() {
		return interceptor;
	}

	public void setInterceptor(String interceptor) {
		this.interceptor = interceptor;
	}
	
	@Length(min=0, max=512, message="查询引用长度必须介于 0 和 512 之间")
	public String getQueryreference() {
		return queryreference;
	}

	public void setQueryreference(String queryreference) {
		this.queryreference = queryreference;
	}
	
	@Length(min=0, max=32, message="项目编码长度必须介于 0 和 32 之间")
	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}
	
	@Length(min=0, max=32, message="应用编码长度必须介于 0 和 32 之间")
	public String getAppcode() {
		return appcode;
	}

	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}
	
	@Length(min=0, max=2, message="是否允许公共调长度必须介于 0 和 2 之间")
	public String getIspubliccall() {
		return ispubliccall;
	}

	public void setIspubliccall(String ispubliccall) {
		this.ispubliccall = ispubliccall;
	}
	
}