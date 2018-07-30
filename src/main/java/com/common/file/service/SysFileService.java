/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.common.file.service;

import com.common.file.dao.SysFileDao;
import com.common.file.entity.SysFile;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件上传类Service
 * @author huangyr
 * @version 2018-07-28
 */
@Service
@Transactional(readOnly = true)
public class SysFileService extends CrudService<SysFileDao, SysFile> {

	public SysFile get(String id) {
		return super.get(id);
	}
	
	public List<SysFile> findList(SysFile sysFile) {
		return super.findList(sysFile);
	}
	
	public Page<SysFile> findPage(Page<SysFile> page, SysFile sysFile) {
		return super.findPage(page, sysFile);
	}
	
	@Transactional(readOnly = false)
	public void save(SysFile sysFile) {
		super.save(sysFile);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysFile sysFile) {
		super.delete(sysFile);
	}

	public SysFile getFile(String id) {
		return dao.getFile(id);
	}

}