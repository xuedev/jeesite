/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.management.modules.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.management.modules.sample.entity.Sample;
import com.management.modules.sample.dao.SampleDao;

/**
 * 代码示例Service
 * @author 薛刚希
 * @version 2018-07-18
 */
@Service
@Transactional(readOnly = true)
public class SampleService extends CrudService<SampleDao, Sample> {

	public Sample get(String id) {
		return super.get(id);
	}
	
	public List<Sample> findList(Sample sample) {
		return super.findList(sample);
	}
	
	public Page<Sample> findPage(Page<Sample> page, Sample sample) {
		return super.findPage(page, sample);
	}
	
	@Transactional(readOnly = false)
	public void save(Sample sample) {
		super.save(sample);
	}
	
	@Transactional(readOnly = false)
	public void delete(Sample sample) {
		super.delete(sample);
	}
	
}