/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.entity.sql;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * SQL查询分组sqlEntity
 * @author hs
 * @version 2018-07-30
 */
public class QuerySql extends DataEntity<QuerySql> {
	
	private static final long serialVersionUID = 1L;
	private String querysqlid;		// 查询sqlID
	private String querygroupid;		// 查询分组ID
	private String seqno;		// 查询序号
	private String querysqltype;		// 查询SQL数据类
	private String querydes;		// 查询说明
	private String querysql;		// 查询SQL
	private String datasource;		// 数据源
	private String procode;		// 项目编码
	private String appcode;		// 应用编码
	
	public QuerySql() {
		super();
	}

	public QuerySql(String id){
		super(id);
	}

	@Length(min=0, max=32, message="查询sqlID长度必须介于 0 和 32 之间")
	public String getQuerysqlid() {
		return querysqlid;
	}

	public void setQuerysqlid(String querysqlid) {
		this.querysqlid = querysqlid;
	}
	
	@Length(min=0, max=32, message="查询分组ID长度必须介于 0 和 32 之间")
	public String getQuerygroupid() {
		return querygroupid;
	}

	public void setQuerygroupid(String querygroupid) {
		this.querygroupid = querygroupid;
	}
	
	@Length(min=0, max=11, message="查询序号长度必须介于 0 和 11 之间")
	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	
	@Length(min=0, max=2, message="查询SQL数据类长度必须介于 0 和 2 之间")
	public String getQuerysqltype() {
		return querysqltype;
	}

	public void setQuerysqltype(String querysqltype) {
		this.querysqltype = querysqltype;
	}
	
	public String getQuerydes() {
		return querydes;
	}

	public void setQuerydes(String querydes) {
		this.querydes = querydes;
	}
	
	public String getQuerysql() {
		return querysql;
	}

	public void setQuerysql(String querysql) {
		this.querysql = querysql;
	}
	
	@Length(min=0, max=32, message="数据源长度必须介于 0 和 32 之间")
	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
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
	
}