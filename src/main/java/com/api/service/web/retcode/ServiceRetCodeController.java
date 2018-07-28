/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.api.service.web.retcode;

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
import com.api.service.entity.retcode.ServiceRetCode;
import com.api.service.service.retcode.ServiceRetCodeService;

/**
 * 返回码表Controller
 * @author 薛刚希
 * @version 2018-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/service/retcode/serviceRetCode")
public class ServiceRetCodeController extends BaseController {

	@Autowired
	private ServiceRetCodeService serviceRetCodeService;
	
	@ModelAttribute
	public ServiceRetCode get(@RequestParam(required=false) String id) {
		ServiceRetCode entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = serviceRetCodeService.get(id);
		}
		if (entity == null){
			entity = new ServiceRetCode();
		}
		return entity;
	}
	
	@RequiresPermissions("service:retcode:serviceRetCode:view")
	@RequestMapping(value = {"list", ""})
	public String list(ServiceRetCode serviceRetCode, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ServiceRetCode> page = serviceRetCodeService.findPage(new Page<ServiceRetCode>(request, response), serviceRetCode); 
		model.addAttribute("page", page);
		return "api/service/retcode/serviceRetCodeList";
	}

	@RequiresPermissions("service:retcode:serviceRetCode:view")
	@RequestMapping(value = "form")
	public String form(ServiceRetCode serviceRetCode, Model model) {
		model.addAttribute("serviceRetCode", serviceRetCode);
		return "api/service/retcode/serviceRetCodeForm";
	}

	@RequiresPermissions("service:retcode:serviceRetCode:edit")
	@RequestMapping(value = "save")
	public String save(ServiceRetCode serviceRetCode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, serviceRetCode)){
			return form(serviceRetCode, model);
		}
		serviceRetCodeService.save(serviceRetCode);
		addMessage(redirectAttributes, "保存返回码表成功");
		return "redirect:"+Global.getAdminPath()+"/service/retcode/serviceRetCode/?repage";
	}
	
	@RequiresPermissions("service:retcode:serviceRetCode:edit")
	@RequestMapping(value = "delete")
	public String delete(ServiceRetCode serviceRetCode, RedirectAttributes redirectAttributes) {
		serviceRetCodeService.delete(serviceRetCode);
		addMessage(redirectAttributes, "删除返回码表成功");
		return "redirect:"+Global.getAdminPath()+"/service/retcode/serviceRetCode/?repage";
	}

}