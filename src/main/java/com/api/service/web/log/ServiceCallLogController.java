/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.web.log;

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
import com.api.service.entity.log.ServiceCallLog;
import com.api.service.service.log.ServiceCallLogService;

/**
 * 服务调用日志Controller
 * @author 薛刚希
 * @version 2018-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/service/log/serviceCallLog")
public class ServiceCallLogController extends BaseController {

	@Autowired
	private ServiceCallLogService serviceCallLogService;
	
	@ModelAttribute
	public ServiceCallLog get(@RequestParam(required=false) String id) {
		ServiceCallLog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = serviceCallLogService.get(id);
		}
		if (entity == null){
			entity = new ServiceCallLog();
		}
		return entity;
	}
	
	@RequiresPermissions("service:log:serviceCallLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(ServiceCallLog serviceCallLog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ServiceCallLog> page = serviceCallLogService.findPage(new Page<ServiceCallLog>(request, response), serviceCallLog); 
		model.addAttribute("page", page);
		return "api/service/log/serviceCallLogList";
	}

	@RequiresPermissions("service:log:serviceCallLog:view")
	@RequestMapping(value = "form")
	public String form(ServiceCallLog serviceCallLog, Model model) {
		model.addAttribute("serviceCallLog", serviceCallLog);
		return "api/service/log/serviceCallLogForm";
	}

	@RequiresPermissions("service:log:serviceCallLog:edit")
	@RequestMapping(value = "save")
	public String save(ServiceCallLog serviceCallLog, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, serviceCallLog)){
			return form(serviceCallLog, model);
		}
		serviceCallLogService.save(serviceCallLog);
		addMessage(redirectAttributes, "保存服务调用日志成功");
		return "redirect:"+Global.getAdminPath()+"/service/log/serviceCallLog/?repage";
	}
	
	@RequiresPermissions("service:log:serviceCallLog:edit")
	@RequestMapping(value = "delete")
	public String delete(ServiceCallLog serviceCallLog, RedirectAttributes redirectAttributes) {
		serviceCallLogService.delete(serviceCallLog);
		addMessage(redirectAttributes, "删除服务调用日志成功");
		return "redirect:"+Global.getAdminPath()+"/service/log/serviceCallLog/?repage";
	}

}