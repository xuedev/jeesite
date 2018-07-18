/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.management.modules.sample.web;

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
import com.management.modules.sample.entity.Sample;
import com.management.modules.sample.service.SampleService;

/**
 * 代码示例Controller
 * @author 薛刚希
 * @version 2018-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/sample/sample")
public class SampleController extends BaseController {

	@Autowired
	private SampleService sampleService;
	
	@ModelAttribute
	public Sample get(@RequestParam(required=false) String id) {
		Sample entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sampleService.get(id);
		}
		if (entity == null){
			entity = new Sample();
		}
		return entity;
	}
	
	@RequiresPermissions("sample:sample:view")
	@RequestMapping(value = {"list", ""})
	public String list(Sample sample, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Sample> page = sampleService.findPage(new Page<Sample>(request, response), sample); 
		model.addAttribute("page", page);
		return "modules/sample/sampleList";
	}

	@RequiresPermissions("sample:sample:view")
	@RequestMapping(value = "form")
	public String form(Sample sample, Model model) {
		model.addAttribute("sample", sample);
		return "modules/sample/sampleForm";
	}

	@RequiresPermissions("sample:sample:edit")
	@RequestMapping(value = "save")
	public String save(Sample sample, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sample)){
			return form(sample, model);
		}
		sampleService.save(sample);
		addMessage(redirectAttributes, "保存示例成功");
		return "redirect:"+Global.getAdminPath()+"/sample/sample/?repage";
	}
	
	@RequiresPermissions("sample:sample:edit")
	@RequestMapping(value = "delete")
	public String delete(Sample sample, RedirectAttributes redirectAttributes) {
		sampleService.delete(sample);
		addMessage(redirectAttributes, "删除示例成功");
		return "redirect:"+Global.getAdminPath()+"/sample/sample/?repage";
	}

}