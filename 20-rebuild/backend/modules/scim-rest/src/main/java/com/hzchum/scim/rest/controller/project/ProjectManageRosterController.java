package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.project.core.api.biz.ProjectManageRosterBiz;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectManageRosterQuery;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageRosterSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "项目管理-花名册")
@RequestMapping("/api/project/manage/roster")
@RestController
public class ProjectManageRosterController {
   private static final Logger log = LoggerFactory.getLogger(ProjectManageRosterController.class);
   @Autowired
   private ProjectManageRosterBiz rosterBiz;

   @ApiOperation("花名册人员信息分页")
   @GetMapping("/page")
   public ResultVO rosterPage(
      ProjectManageRosterQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API 调用 ：花名册人员信息分页查询");
      return ResultBuilder.success(this.rosterBiz.rosterPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("花名册人员信息下载")
   @GetMapping("/download")
   public void rosterDownload(ProjectManageRosterQuery query, HttpServletResponse response) {
      log.info("API 调用 ：花名册人员信息下载");
      this.rosterBiz.rosterDownload(query, response);
   }

   @ApiOperation("花名册人员简单信息列表")
   @GetMapping("/simpleList")
   public ResultVO simpleInfoList(ProjectManageRosterQuery query) {
      log.info("API 调用 ：花名册人员简单信息列表");
      return ResultBuilder.success(this.rosterBiz.simpleInfoList(query));
   }

   @ApiOperation("民族列表")
   @GetMapping("/nation-list")
   public ResultVO nationList() {
      log.info("API 调用 ：民族列表");
      return ResultBuilder.success(this.rosterBiz.nationList());
   }

   @ApiOperation("按年龄统计人数")
   @GetMapping("/age-statistics")
   public ResultVO ageStatistics(@RequestParam Long projectId) {
      log.info("API 调用 ：按年龄统计人数");
      return ResultBuilder.success(this.rosterBiz.ageStatistics(projectId));
   }

   @ApiOperation("花名册人员详情查询")
   @GetMapping("/getRosterInfo")
   public ResultVO getRosterInfo(@RequestParam Long id) {
      log.info("API 调用 ：花名册人员详情查询");
      return ResultBuilder.success(this.rosterBiz.getRosterInfo(id));
   }

   @ApiOperation("花名册人员基本信息")
   @GetMapping("/getRosterBaseInfo")
   public ResultVO getRosterInfo() {
      log.info("API 调用 ：花名册人员基本信息");
      return ResultBuilder.success(this.rosterBiz.getBaseUserInfo());
   }

   @ApiOperation("花名册人员信息二维码打印")
   @GetMapping("/qr-code/print")
   public ResultVO qrCodePrint(@RequestParam Long id) {
      log.info("API 调用 ：花名册人员信息二维码打印");
      return ResultBuilder.success(this.rosterBiz.qrCodePrint(id));
   }

   @ApiOperation("花名册信息注册")
   @PostMapping
   public ResultVO saveRoster(@RequestBody @Validated(Add.class) ProjectManageRosterSaveParam param) {
      log.info("API 调用 ：花名册信息注册");
      return ResultBuilder.success(this.rosterBiz.saveRoster(param));
   }

   @ApiOperation("花名册人员信息修改")
   @PutMapping
   @SignerCheck(lockKey = "#param.id", message = "花名册人员信息正在修改请刷新稍后重试")
   public ResultVO updateRoster(@RequestBody @Validated(Update.class) ProjectManageRosterSaveParam param) {
      log.info("API 调用 ：花名册人员信息修改");
      return ResultBuilder.success(this.rosterBiz.updateRoster(param));
   }

   @ApiOperation("花名册人员状态修改")
   @PutMapping("/updateStatus")
   @SignerCheck(lockKey = "#id", message = "花名册人员正在修改请刷新稍后重试")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 ：花名册人员状态修改");
      return ResultBuilder.success(this.rosterBiz.updateStatus(id, status));
   }

   @ApiOperation("花名册人员删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('install_labor_manage:del')")
   @SignerCheck(lockKey = "#id", message = "花名册人员正在删除请刷新稍后重试")
   public ResultVO deleteRoster(@RequestParam Long id) {
      log.info("API 调用 ：删除花名册");
      return ResultBuilder.success(this.rosterBiz.deleteRoster(id));
   }

   @ApiOperation("花名册人员exl模板下载")
   @GetMapping("/exportRosterTemplate")
   public void exportRosterTemplate(HttpServletResponse response) {
      log.info("API调用:花名册人员exl模板下载");
      this.rosterBiz.exportRosterTemplate(response);
   }

   @ApiOperation("花名册批量倒入")
   @PostMapping("/import")
   public ResultVO importRoster(@RequestPart MultipartFile file, @RequestParam("projectId") Long projectId, HttpServletResponse response) {
      log.info("API 调用 ：花名册批量倒入");
      return ResultBuilder.success(this.rosterBiz.importRoster(file, projectId, response));
   }

   @ApiOperation("花名册二维码下载")
   @GetMapping("/downloadRosterQR")
   public void downloadRosterQR(ProjectManageRosterQuery query) {
      log.info("API调用: 花名册二维码下载");
      this.rosterBiz.downloadRosterQR(query);
   }
}
