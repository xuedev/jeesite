/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.sql.web.sql;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.api.sql.entity.sql.QuerySql;
import com.api.sql.service.sql.QuerySqlService;

/**
 * SQL查询分组sqlController
 * @author hs
 * @version 2018-08-01
 */
@Controller
@RequestMapping(value = "${adminPath}/sql/sql/querySql")
public class QuerySqlController extends BaseController {

	@Autowired
	private QuerySqlService querySqlService;
	
	@ModelAttribute
	public QuerySql get(@RequestParam(required=false) String id) {
		QuerySql entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = querySqlService.get(id);
		}
		if (entity == null){
			entity = new QuerySql();
		}
		return entity;
	}
	
	@RequiresPermissions("sql:sql:querySql:view")
	@RequestMapping(value = {"list", ""})
	public String list(QuerySql querySql, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<QuerySql> page = querySqlService.findPage(new Page<QuerySql>(request, response), querySql); 
		model.addAttribute("page", page);
		return "api/sql/sql/querySqlList";
	}

	@RequiresPermissions("sql:sql:querySql:view")
	@RequestMapping(value = "form")
	public String form(QuerySql querySql, Model model) {
		model.addAttribute("querySql", querySql);
		return "api/sql/sql/querySqlForm";
	}

	@RequiresPermissions("sql:sql:querySql:edit")
	@RequestMapping(value = "save")
	public String save(QuerySql querySql, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, querySql)){
			return form(querySql, model);
		}
		querySqlService.save(querySql);
		addMessage(redirectAttributes, "保存sql查询分组sql成功");
		return "redirect:"+Global.getAdminPath()+"/sql/sql/querySql/?repage";
	}
	
	@RequiresPermissions("sql:sql:querySql:edit")
	@RequestMapping(value = "delete")
	public String delete(QuerySql querySql, RedirectAttributes redirectAttributes) {
		querySqlService.delete(querySql);
		addMessage(redirectAttributes, "删除sql查询分组sql成功");
		return "redirect:"+Global.getAdminPath()+"/sql/sql/querySql/?repage";
	}

}