/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.management.modules.sample.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 代码示例Entity
 * @author 薛刚希
 * @version 2018-07-18
 */
public class Sample extends DataEntity<Sample> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 用户名
	private String password;		// 密码
	
	public Sample() {
		super();
	}

	public Sample(String id){
		super(id);
	}

	@Length(min=0, max=64, message="用户名长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="密码长度必须介于 0 和 64 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}