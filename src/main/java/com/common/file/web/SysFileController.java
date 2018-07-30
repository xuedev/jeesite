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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传类Controller
 *
 * @author huangyr
 * @version 2018-07-28
 */
@Controller
@RequestMapping(value = "/fileupload")
public class SysFileController extends BaseController {
    public static final int fileType = 0;
    public static final int imageType = 1;
    public static final int videoType = 2;
    public static final int audioType = 3;
    @Autowired
    private SysFileService sysFileService;


    @RequestMapping(value = "saveFile",method = RequestMethod.POST)
    @ResponseBody
    public Object saveFile(@RequestParam(required = false) MultipartFile file, HttpServletRequest request) {

        return save(file, fileType);
    }

    @RequestMapping(value = "saveImage",method = RequestMethod.POST)
    @ResponseBody
    public Object saveImage(@RequestParam(required = false) MultipartFile file, HttpServletRequest request) {
        return save(file, imageType);
    }

    @RequestMapping(value = "saveVideo",method = RequestMethod.POST)
    @ResponseBody
    public Object saveVideo(@RequestParam(required = false) MultipartFile file, HttpServletRequest request) {
        return save(file, videoType);
    }

    @RequestMapping(value = "saveAudio",method = RequestMethod.POST)
    @ResponseBody
    public Object saveAudio(@RequestParam(required = false) MultipartFile file, HttpServletRequest request) {
        return save(file, audioType);
    }
    /**
     * 保存
     * @param file
     * @param filter
     * @return
     */
    private BaseResult<SysFile> save(MultipartFile file, int filter) {
        if (null != file && !file.isEmpty()) {
            String fileid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            String date = DateUtils.getDate();
            String fileParentPath = Global.getUploadFilePath() + date;
            String fileType = "unknown";
            try {
                FileType type = FileTypeJudge.getType(file.getInputStream());
                String msg = null;
                if (filter == imageType && !FileTypeJudge.isImageType(type)) {
                    msg = "文件类型必须是图片";
                } else if (filter == videoType && !FileTypeJudge.isVideoType(type)) {
                    msg = "文件类型必须是视频类型";
                } else if (filter == audioType && !FileTypeJudge.isAudioType(type)) {
                    msg = "文件类型必须是音频类型";
                }
                if (StringUtils.isNotBlank(msg)) {
                    return new BaseResult<SysFile>(1, msg,null);
                }
                if (type != null) {
                    fileType = type.name();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName = FileUpload.fileUp(file, fileParentPath, fileid);
            SysFile sysFile = new SysFile();
            sysFile.setFileid(fileid);
            sysFile.setType(fileType);
            sysFile.setUrl(date + "/" + fileName);
            User user = UserUtils.getUser();
            /**
             * 暂无Token验证,
             * 如果没有登录用户,
             * 则默认用户id为0
             *
             */
            if (StringUtils.isBlank(user.getId())) {

                user.setId("0");
                sysFile.setCreateBy(user);
                sysFile.setUpdateBy(user);
            }
            sysFileService.save(sysFile);
            if (StringUtils.isNotBlank(sysFile.getId())) {
                sysFile = sysFileService.getFile(fileid);
                sysFile.setUrl(Global.USERFILES_BASE_URL+sysFile.getUrl());
                return new BaseResult<SysFile>(0, "上传成功", sysFile);
            }
        }
        return new BaseResult<SysFile>(0, "上传失败",null);
    }
}