/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.management.modules.sample.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.management.modules.sample.entity.Sample;

/**
 * 代码示例DAO接口
 * @author 薛刚希
 * @version 2018-07-18
 */
@MyBatisDao
public interface SampleDao extends CrudDao<Sample> {
	
}