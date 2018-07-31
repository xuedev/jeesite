/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.linking.bill.trade.dao.market;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.linking.bill.trade.entity.market.BillMarketStatus;

/**
 * 市场状态表修改DAO接口
 * @author xuqq
 * @version 2018-07-31
 */
@MyBatisDao
public interface BillMarketStatusDao extends CrudDao<BillMarketStatus> {
	
}