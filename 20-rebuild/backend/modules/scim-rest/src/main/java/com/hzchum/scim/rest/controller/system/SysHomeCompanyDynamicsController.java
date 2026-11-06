package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysHomeCompanyDynamicsBiz;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCompanyDynamicsPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeCompanyDynamicsSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-公司动态")
@RestController
@RequestMapping("/api/dynamics")
public class SysHomeCompanyDynamicsController {
   private static final Logger log = LoggerFactory.getLogger(SysHomeCompanyDynamicsController.class);
   @Resource
   private SysHomeCompanyDynamicsBiz sysHomeCompanyDynamicsBiz;

   @ApiOperation("公司动态创建")
   @PostMapping("/create")
   public ResultVO saveSysHomeCompanyDynamics(@RequestBody SysHomeCompanyDynamicsSaveParam sysHomeCompanyDynamicsSaveParam) {
      log.info("API 调用 ：公司动态创建");
      return ResultBuilder.success(
         this.sysHomeCompanyDynamicsBiz.saveSysHomeCompanyDynamics(BeanUtil.copy(sysHomeCompanyDynamicsSaveParam, SysHomeCompanyDynamicsSaveParam.class))
      );
   }

   @ApiOperation("公司动态删除")
   @DeleteMapping("/delete")
   public ResultVO deleteSysHomeCompanyDynamics(@RequestParam Long id) {
      log.info("API 调用 ：公司动态删除");
      return ResultBuilder.success(this.sysHomeCompanyDynamicsBiz.deleteSysHomeCompanyDynamics(id));
   }

   @ApiOperation("公司动态详情")
   @GetMapping("/detail")
   public ResultVO sysHomeCompanyDynamicsDetail(Long id) {
      log.info("API 调用 ：公司动态详情");
      return ResultBuilder.success(this.sysHomeCompanyDynamicsBiz.sysHomeCompanyDynamicsDetailDTO(id));
   }

   @ApiOperation("公司动态列表")
   @GetMapping("/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "informantDateTime", value = "创建日期", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "createUserName", value = "创建人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
      }
   )
   public ResultVO<PageVO<SysHomeCompanyDynamicsPageDTO>> getSysHomeCompanyDynamicsPage(
      LocalDateTime informantDateTime,
      String createUserName,
      String title,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:公司动态列表");
      return ResultBuilder.success(this.sysHomeCompanyDynamicsBiz.getSysHomeCompanyDynamicsPage(informantDateTime, createUserName, title, pageNumber, pageSize));
   }

   @ApiOperation("公司动态列表下载")
   @PostMapping("/list/download")
   public void downloadAttachment(@RequestBody DownloadAttachmentCommonDTO dto, HttpServletResponse response) {
      log.info("API调用:公司动态列表下载");
      this.sysHomeCompanyDynamicsBiz.downloadAttachment(dto, response);
   }
}
