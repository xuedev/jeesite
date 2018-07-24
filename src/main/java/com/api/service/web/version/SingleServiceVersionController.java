/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.web.version;

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
import com.api.service.entity.version.SingleServiceVersion;
import com.api.service.service.version.SingleServiceVersionService;

/**
 * 服务版本Controller
 * @author 薛刚希
 * @version 2018-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/service/version/singleServiceVersion")
public class SingleServiceVersionController extends BaseController {

	@Autowired
	private SingleServiceVersionService singleServiceVersionService;
	
	@ModelAttribute
	public SingleServiceVersion get(@RequestParam(required=false) String id) {
		SingleServiceVersion entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = singleServiceVersionService.get(id);
		}
		if (entity == null){
			entity = new SingleServiceVersion();
		}
		return entity;
	}
	
	@RequiresPermissions("service:version:singleServiceVersion:view")
	@RequestMapping(value = {"list", ""})
	public String list(SingleServiceVersion singleServiceVersion, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SingleServiceVersion> page = singleServiceVersionService.findPage(new Page<SingleServiceVersion>(request, response), singleServiceVersion); 
		model.addAttribute("page", page);
		return "api/service/version/singleServiceVersionList";
	}

	@RequiresPermissions("service:version:singleServiceVersion:view")
	@RequestMapping(value = "form")
	public String form(SingleServiceVersion singleServiceVersion, Model model) {
		model.addAttribute("singleServiceVersion", singleServiceVersion);
		return "api/service/version/singleServiceVersionForm";
	}

	@RequiresPermissions("service:version:singleServiceVersion:edit")
	@RequestMapping(value = "save")
	public String save(SingleServiceVersion singleServiceVersion, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, singleServiceVersion)){
			return form(singleServiceVersion, model);
		}
		singleServiceVersionService.save(singleServiceVersion);
		addMessage(redirectAttributes, "保存服务版本成功");
		return "redirect:"+Global.getAdminPath()+"/service/version/singleServiceVersion/?repage";
	}
	
	@RequiresPermissions("service:version:singleServiceVersion:edit")
	@RequestMapping(value = "delete")
	public String delete(SingleServiceVersion singleServiceVersion, RedirectAttributes redirectAttributes) {
		singleServiceVersionService.delete(singleServiceVersion);
		addMessage(redirectAttributes, "删除服务版本成功");
		return "redirect:"+Global.getAdminPath()+"/service/version/singleServiceVersion/?repage";
	}

}