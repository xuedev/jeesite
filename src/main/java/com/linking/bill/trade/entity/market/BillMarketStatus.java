/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.linking.bill.trade.entity.market;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 市场状态表修改Entity
 * @author xuqq
 * @version 2018-07-31
 */
public class BillMarketStatus extends DataEntity<BillMarketStatus> {
	
	private static final long serialVersionUID = 1L;
	private String status;		// 市场状态
	
	public BillMarketStatus() {
		super();
	}

	public BillMarketStatus(String id){
		super(id);
	}

	@Length(min=1, max=1, message="市场状态长度必须介于 1 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}