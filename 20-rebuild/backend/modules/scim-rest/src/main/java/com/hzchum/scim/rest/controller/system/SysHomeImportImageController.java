package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.system.core.api.biz.SysHomeImportImageBiz;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeImportImageSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-导入图片")
@RestController
@RequestMapping("/api/img")
public class SysHomeImportImageController {
   private static final Logger log = LoggerFactory.getLogger(SysHomeImportImageController.class);
   @Resource
   private SysHomeImportImageBiz sysHomeImportImageBiz;
   @Resource
   private AttachmentService attachmentService;

   @ApiOperation("导入图片")
   @PostMapping("/import")
   public ResultVO saveSysHomeImportImage(@RequestBody SysHomeImportImageSaveParam sysHomeImportImageSaveParam) {
      log.info("API 调用 ：导入图片");
      return ResultBuilder.success(
         this.sysHomeImportImageBiz.saveSysHomeImportImage(BeanUtil.copy(sysHomeImportImageSaveParam, SysHomeImportImageSaveParam.class))
      );
   }

   @ApiOperation("图片列表")
   @GetMapping("/lists")
   public ResultVO getSysHomeImportImagePage() {
      log.info("API 调用 ：图片列表");
      return ResultBuilder.success(this.sysHomeImportImageBiz.getSysHomeImportImagePage());
   }
}
