/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.linking.bill.trade.web.market;

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
import com.linking.bill.trade.entity.market.BillMarketStatus;
import com.linking.bill.trade.service.market.BillMarketStatusService;

/**
 * 市场状态表修改Controller
 * @author xuqq
 * @version 2018-07-31
 */
@Controller
@RequestMapping(value = "${adminPath}/trade/market/billMarketStatus")
public class BillMarketStatusController extends BaseController {

	@Autowired
	private BillMarketStatusService billMarketStatusService;
	
	@ModelAttribute
	public BillMarketStatus get(@RequestParam(required=false) String id) {
		BillMarketStatus entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = billMarketStatusService.get(id);
		}
		if (entity == null){
			entity = new BillMarketStatus();
		}
		return entity;
	}
	
	@RequiresPermissions("trade:market:billMarketStatus:view")
	@RequestMapping(value = {"list", ""})
	public String list(BillMarketStatus billMarketStatus, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BillMarketStatus> page = billMarketStatusService.findPage(new Page<BillMarketStatus>(request, response), billMarketStatus); 
		model.addAttribute("page", page);
		return "bill/trade/market/billMarketStatusList";
	}

	@RequiresPermissions("trade:market:billMarketStatus:view")
	@RequestMapping(value = "form")
	public String form(BillMarketStatus billMarketStatus, Model model) {
		model.addAttribute("billMarketStatus", billMarketStatus);
		return "bill/trade/market/billMarketStatusForm";
	}

	@RequiresPermissions("trade:market:billMarketStatus:edit")
	@RequestMapping(value = "save")
	public String save(BillMarketStatus billMarketStatus, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, billMarketStatus)){
			return form(billMarketStatus, model);
		}
		billMarketStatusService.save(billMarketStatus);
		addMessage(redirectAttributes, "保存市场状态变更成功");
		return "redirect:"+Global.getAdminPath()+"/trade/market/billMarketStatus/?repage";
	}
	
	@RequiresPermissions("trade:market:billMarketStatus:edit")
	@RequestMapping(value = "delete")
	public String delete(BillMarketStatus billMarketStatus, RedirectAttributes redirectAttributes) {
		billMarketStatusService.delete(billMarketStatus);
		addMessage(redirectAttributes, "删除市场状态变更成功");
		return "redirect:"+Global.getAdminPath()+"/trade/market/billMarketStatus/?repage";
	}

}