package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysHomeEnterpriseNetdiskBiz;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeEnterpriseNetdiskPageDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPhonePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeEnterpriseNetdiskSaveParam;
import com.hzchum.scim.system.core.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-企业云盘")
@RestController
@RequestMapping("/api/enterprisenetdisk")
public class SysHomeEnterpriseNetdiskController {
   private static final Logger log = LoggerFactory.getLogger(SysHomeEnterpriseNetdiskController.class);
   @Resource
   private SysHomeEnterpriseNetdiskBiz sysHomeEnterpriseNetdiskBiz;
   @Resource
   private UserService userService;

   @ApiOperation("企业云盘创建")
   @PostMapping("/create")
   public ResultVO saveSysHomeEnterpriseNetdisk(@RequestBody SysHomeEnterpriseNetdiskSaveParam sysHomeEnterpriseNetdiskSaveParam) {
      log.info("API 调用 ：企业云盘创建");
      return ResultBuilder.success(
         this.sysHomeEnterpriseNetdiskBiz
            .saveSysHomeEnterpriseNetdisk(BeanUtil.copy(sysHomeEnterpriseNetdiskSaveParam, SysHomeEnterpriseNetdiskSaveParam.class))
      );
   }

   @ApiOperation("企业云盘删除")
   @DeleteMapping("/delete")
   public ResultVO deleteSysHomeEnterpriseNetdisk(@RequestParam Long id) {
      log.info("API 调用 ：企业云盘删除");
      return ResultBuilder.success(this.sysHomeEnterpriseNetdiskBiz.deleteSysHomeEnterpriseNetdisk(id));
   }

   @ApiOperation("企业云盘列表")
   @GetMapping("/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "informantDateTime", value = "创建日期", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "createUserName", value = "创建人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sysHomeFileType", value = "系统文件类型", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
      }
   )
   public ResultVO<PageVO<SysHomeEnterpriseNetdiskPageDTO>> getSysHomeEnterpriseNetdiskPage(
      LocalDateTime informantDateTime,
      String createUserName,
      Integer sysHomeFileType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:企业云盘列表");
      return ResultBuilder.success(
         this.sysHomeEnterpriseNetdiskBiz.getSysHomeEnterpriseNetdiskPage(informantDateTime, createUserName, sysHomeFileType, pageNumber, pageSize)
      );
   }

   @ApiOperation("企业云盘下载")
   @PostMapping("/list/download")
   public void downloadAttachment(@RequestBody DownloadAttachmentCommonDTO dto, HttpServletResponse response) {
      log.info("API调用:企业云盘列表下载");
      this.sysHomeEnterpriseNetdiskBiz.downloadAttachment(dto, response);
   }

   @ApiOperation("用户基础数据查询")
   @GetMapping("/basic-info")
   public ResultVO getUserBasicInfo() {
      log.info("API调用:用户查询");
      return ResultBuilder.success(this.sysHomeEnterpriseNetdiskBiz.getUserBasicInfo());
   }

   @ApiOperation("获取重置密码短信验证码")
   @GetMapping("/send")
   public ResultVO sendPhoneVerifyCode(String phone) {
      log.info("API调用:获取重置密码短信验证码");
      return ResultBuilder.success(this.userService.sendPhoneVerifyCode(phone));
   }

   @ApiOperation("根据手机号重置密码")
   @PutMapping("/reset")
   public ResultVO resetPassword(@Valid @RequestBody UserResetPhonePasswordRequestVO requestVO) {
      log.info("API调用:根据手机号重置密码");
      return ResultBuilder.success(this.userService.resetPassword(requestVO));
   }
}
