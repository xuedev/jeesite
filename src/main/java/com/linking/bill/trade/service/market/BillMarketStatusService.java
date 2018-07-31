/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.linking.bill.trade.service.market;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.linking.bill.trade.entity.market.BillMarketStatus;
import com.linking.bill.trade.dao.market.BillMarketStatusDao;

/**
 * 市场状态表修改Service
 * @author xuqq
 * @version 2018-07-31
 */
@Service
@Transactional(readOnly = true)
public class BillMarketStatusService extends CrudService<BillMarketStatusDao, BillMarketStatus> {

	public BillMarketStatus get(String id) {
		return super.get(id);
	}
	
	public List<BillMarketStatus> findList(BillMarketStatus billMarketStatus) {
		return super.findList(billMarketStatus);
	}
	
	public Page<BillMarketStatus> findPage(Page<BillMarketStatus> page, BillMarketStatus billMarketStatus) {
		return super.findPage(page, billMarketStatus);
	}
	
	@Transactional(readOnly = false)
	public void save(BillMarketStatus billMarketStatus) {
		super.save(billMarketStatus);
	}
	
	@Transactional(readOnly = false)
	public void delete(BillMarketStatus billMarketStatus) {
		super.delete(billMarketStatus);
	}
	
}