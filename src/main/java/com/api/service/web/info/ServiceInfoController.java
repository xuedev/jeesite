/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.web.info;

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
import com.api.service.entity.info.ServiceInfo;
import com.api.service.service.info.ServiceInfoService;

/**
 * 服务基本信息Controller
 * @author 薛刚希
 * @version 2018-07-26
 */
@Controller
@RequestMapping(value = "${adminPath}/service/info/serviceInfo")
public class ServiceInfoController extends BaseController {

	@Autowired
	private ServiceInfoService serviceInfoService;
	
	@ModelAttribute
	public ServiceInfo get(@RequestParam(required=false) String id) {
		ServiceInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = serviceInfoService.get(id);
		}
		if (entity == null){
			entity = new ServiceInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("service:info:serviceInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ServiceInfo serviceInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ServiceInfo> page = serviceInfoService.findPage(new Page<ServiceInfo>(request, response), serviceInfo); 
		model.addAttribute("page", page);
		return "api/service/info/serviceInfoList";
	}

	@RequiresPermissions("service:info:serviceInfo:view")
	@RequestMapping(value = "form")
	public String form(ServiceInfo serviceInfo, Model model) {
		model.addAttribute("serviceInfo", serviceInfo);
		return "api/service/info/serviceInfoForm";
	}

	@RequiresPermissions("service:info:serviceInfo:edit")
	@RequestMapping(value = "save")
	public String save(ServiceInfo serviceInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, serviceInfo)){
			return form(serviceInfo, model);
		}
		serviceInfoService.save(serviceInfo);
		addMessage(redirectAttributes, "保存服务信息成功");
		return "redirect:"+Global.getAdminPath()+"/service/info/serviceInfo/?repage";
	}
	
	@RequiresPermissions("service:info:serviceInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ServiceInfo serviceInfo, RedirectAttributes redirectAttributes) {
		serviceInfoService.delete(serviceInfo);
		addMessage(redirectAttributes, "删除服务信息成功");
		return "redirect:"+Global.getAdminPath()+"/service/info/serviceInfo/?repage";
	}

}