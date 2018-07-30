/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.common.file.dao;

import com.common.file.entity.SysFile;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import org.apache.poi.ss.formula.functions.T;

/**
 * 文件上传类DAO接口
 * @author huangyr
 * @version 2018-07-28
 */
@MyBatisDao
public interface SysFileDao extends CrudDao<SysFile> {

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public SysFile getFile(String id);

}