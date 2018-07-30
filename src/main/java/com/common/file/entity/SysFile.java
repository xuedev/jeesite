/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.common.file.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 文件上传类Entity
 * @author huangyr
 * @version 2018-07-28
 */
public class SysFile extends DataEntity<SysFile> {
	
	private static final long serialVersionUID = 1L;
	private String fileid;		// 文件id
	private String url;		// 文件路径
	private String type;		// 文件类型
	
	public SysFile() {
		super();
	}

	public SysFile(String id){
		super(id);
	}

	@Length(min=1, max=65, message="文件id长度必须介于 1 和 65 之间")
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	
	@Length(min=1, max=100, message="文件路径长度必须介于 1 和 100 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=1, max=2000, message="文件类型长度必须介于 1 和 2000 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}