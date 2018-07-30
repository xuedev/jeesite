/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.common.file.web;

import com.common.file.bean.BaseResult;
import com.common.file.entity.SysFile;
import com.common.file.service.SysFileService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.*;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传类Controller
 *
 * @author huangyr
 * @version 2018-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/fileindex")
public class SysFileIndexController extends BaseController {
    /**
     * @return
     */
    @RequiresPermissions("file:index")
    @RequestMapping(value = "index")
    public String info(Model model) {
        return "modules/test/fileUpload";
    }
}