package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysHomeInformationNoticeBiz;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeInformationNoticePageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeInformationNoticeSaveParam;
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

@Api(tags = "系统管理-通知公告")
@RestController
@RequestMapping("/api/notice")
public class SysHomeInformationNoticeController {
   private static final Logger log = LoggerFactory.getLogger(SysHomeInformationNoticeController.class);
   @Resource
   private SysHomeInformationNoticeBiz sysHomeInformationNoticeBiz;

   @ApiOperation("通知公告创建")
   @PostMapping("/create")
   public ResultVO saveSysHomeInformationNotice(@RequestBody SysHomeInformationNoticeSaveParam sysHomeInformationNoticeSaveParam) {
      log.info("API 调用 ：通知公告创建");
      return ResultBuilder.success(
         this.sysHomeInformationNoticeBiz
            .saveSysHomeInformationNotice(BeanUtil.copy(sysHomeInformationNoticeSaveParam, SysHomeInformationNoticeSaveParam.class))
      );
   }

   @ApiOperation("通知公告删除")
   @DeleteMapping("/delete")
   public ResultVO deleteSysHomeInformationNotice(@RequestParam Long id) {
      log.info("API 调用 ：通知公告删除");
      return ResultBuilder.success(this.sysHomeInformationNoticeBiz.deleteSysHomeInformationNotice(id));
   }

   @ApiOperation("通知公告详情")
   @GetMapping("/detail")
   public ResultVO sysHomeInformationNoticeDetail(Long id) {
      log.info("API 调用 ：通知公告详情");
      return ResultBuilder.success(this.sysHomeInformationNoticeBiz.sysHomeInformationNoticeDetailDTO(id));
   }

   @ApiOperation("通知公告列表")
   @GetMapping("/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "informantDateTime", value = "创建日期", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "createUserName", value = "创建人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "内容", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
      }
   )
   public ResultVO<PageVO<SysHomeInformationNoticePageDTO>> getSysHomeInformationNoticePage(
      LocalDateTime informantDateTime,
      String createUserName,
      String title,
      String content,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:通知公告列表");
      return ResultBuilder.success(
         this.sysHomeInformationNoticeBiz.getSysHomeInformationNoticePage(informantDateTime, createUserName, title, content, pageNumber, pageSize)
      );
   }

   @ApiOperation("通知公告列表下载")
   @PostMapping("/list/download")
   public void downloadAttachment(@RequestBody DownloadAttachmentCommonDTO dto, HttpServletResponse response) {
      log.info("API调用:通知公告列表下载");
      this.sysHomeInformationNoticeBiz.downloadAttachment(dto, response);
   }
}
