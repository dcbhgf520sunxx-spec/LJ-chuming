package com.hzchum.scim.rest.controller.safety;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionBiz;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionUserBiz;
import com.hzchum.scim.system.core.api.enums.AuditStateEnum;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionLineDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ProjectLineApplyRemovePointDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-巡检管理配置")
@RestController
@RequestMapping("/api/mes/inspection/config")
@Validated
public class ProjectInspectionConfigController {
   private static final Logger log = LoggerFactory.getLogger(ProjectInspectionConfigController.class);
   @Resource
   private ProjectInspectionBiz projectInspectionBiz;
   @Resource
   private ProjectInspectionUserBiz projectInspectionUserBiz;

   @ApiOperation("巡检路线修改")
   @PutMapping("/updateLine")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#projectInspectionLineDTOParam.id")
   public ResultVO updateLine(@RequestBody ProjectInspectionLineDTOParam projectInspectionLineDTOParam) {
      log.info("API调用:巡检路线修改");
      return ResultBuilder.success(this.projectInspectionUserBiz.updateLine(projectInspectionLineDTOParam));
   }

   @ApiOperation("巡检路线删除")
   @DeleteMapping("/deleteLine")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#id")
   public ResultVO deleteLine(@RequestParam Long id) {
      log.info("API调用:巡检路线删除");
      return ResultBuilder.success(this.projectInspectionUserBiz.deleteLine(id));
   }

   @ApiOperation("巡检路线创建")
   @PostMapping("/saveLine")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#projectInspectionLineDTOParam.userId", message = "项目正在创建巡检线,请勿重复提交")
   public ResultVO saveLine(@RequestBody ProjectInspectionLineDTOParam projectInspectionLineDTOParam) {
      log.info("API调用:巡检路线创建");
      return ResultBuilder.success(this.projectInspectionUserBiz.saveLine(projectInspectionLineDTOParam));
   }

   @ApiOperation("线路巡检点移除：申请")
   @PostMapping("/applyRemoveLine")
   public ResultVO applyRemoveLine(@RequestBody @Validated ProjectLineApplyRemovePointDTOParam saveParam) {
      log.info("API调用:巡检点移除：申请");
      return ResultBuilder.success(this.projectInspectionUserBiz.applyRemoveLine(saveParam));
   }

   @ApiOperation("线路巡检点申请：列表")
   @GetMapping("/applyRemoveLine/page")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet')")
   public ResultVO applyRemoveLinePage(
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:线路巡检点申请：列表");
      return ResultBuilder.success(this.projectInspectionUserBiz.applyRemoveLinePage(pageNumber, pageSize));
   }

   @ApiOperation("线路巡检点申请：数量")
   @GetMapping("/applyNum")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet')")
   public ResultVO applyRemoveLinePage() {
      log.info("API调用:线路巡检点申请：数量");
      return ResultBuilder.success(this.projectInspectionUserBiz.applyNum());
   }

   @ApiOperation("线路巡检点申请：审核")
   @PostMapping("/applyRemoveLine/examine")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   public ResultVO auditApplyRemoveLine(
      @RequestParam Long recordId, @EnumValidator(value = AuditStateEnum.class, message = "审核状态有误!") @RequestParam(name = "auditStatus") Integer auditStatus
   ) {
      log.info("API调用:线路巡检点申请：审核");
      return ResultBuilder.success(this.projectInspectionUserBiz.auditResource(recordId, auditStatus));
   }

   @ApiOperation("巡检点创建")
   @PostMapping("")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   public ResultVO saveInspection(@RequestBody ProjectInspectionDTOParam projectInspectionParam) {
      log.info("API调用:巡检点创建");
      return ResultBuilder.success(this.projectInspectionBiz.saveInspection(projectInspectionParam));
   }

   @ApiOperation("巡检点修改")
   @PutMapping("")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   public ResultVO updateInspection(@RequestBody ProjectInspectionDTOParam projectInspectionParam) {
      log.info("API调用:巡检点修改");
      return ResultBuilder.success(this.projectInspectionBiz.updateInspection(projectInspectionParam));
   }

   @ApiOperation("巡检点状态修改")
   @PutMapping("/updateStatus")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#id", message = "巡检点正在修改,请勿重复提交")
   public ResultVO updateInspectionStatus(@RequestParam Long id) {
      log.info("API调用:巡检点状态修改");
      return ResultBuilder.success(this.projectInspectionBiz.updateInspectionStatus(id));
   }

   @ApiOperation("巡检点删除")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#id", message = "巡检点正在删除,请勿重复提交")
   public ResultVO deleteInspection(@RequestParam Long id) {
      log.info("API:巡检点删除");
      return ResultBuilder.success(this.projectInspectionBiz.deleteInspection(id));
   }

   @ApiOperation("巡检点二维码生成")
   @GetMapping("/printQrCode")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet')")
   public ResultVO printQrCode(@RequestParam Long id) {
      log.info("API调用:巡检点二维码生成");
      return ResultBuilder.success(this.projectInspectionBiz.printQrCode(id));
   }

   @ApiOperation("巡检点二维码批量")
   @GetMapping("/printQrCodeList")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet')")
   public void printQrCodeList(@RequestParam Long projectId) {
      log.info("API调用:巡检点二维码批量");
      this.projectInspectionBiz.printQrCodeList(projectId);
   }
}
