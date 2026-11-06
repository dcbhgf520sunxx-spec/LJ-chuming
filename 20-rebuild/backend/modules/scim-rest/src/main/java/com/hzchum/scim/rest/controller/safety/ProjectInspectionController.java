package com.hzchum.scim.rest.controller.safety;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionTaskRecordBiz;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionUserBiz;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionTaskRecordDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-巡检管理")
@RestController
@RequestMapping("/api/mes/inspection")
@Validated
public class ProjectInspectionController {
   private static final Logger log = LoggerFactory.getLogger(ProjectInspectionController.class);
   @Resource
   private ProjectInspectionBiz projectInspectionBiz;
   @Resource
   private ProjectInspectionUserBiz projectInspectionUserBiz;
   @Resource
   private ProjectInspectionTaskRecordBiz projectInspectionTaskRecordBiz;

   @ApiOperation("获取项目中巡检人员")
   @GetMapping("/getInspectionUserByProjectId")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:get')")
   public ResultVO getInspectionUserByProjectId() {
      log.info("API调用：获取项目中巡检人员");
      return ResultBuilder.success(this.projectInspectionUserBiz.getAllInspectionUser());
   }

   @ApiOperation("获取人员巡检详情")
   @GetMapping("/getInspectionTaskDetail")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:detail') or @projectInspectionController.isCurrentInspectionUser(#p0)")
   public ResultVO getInspectionTaskDetail(Long userId, LocalDate date, Integer inspectionSiteOptionType) {
      log.info("API调用：获取人员巡检详情");
      return ResultBuilder.success(this.projectInspectionTaskRecordBiz.getInspectionTaskDetail(userId, date, inspectionSiteOptionType));
   }

   @ApiOperation("获取巡检信息")
   @GetMapping("/getInspectionTaskInfo")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:get') or @projectInspectionController.isCurrentInspectionUser(#p0)")
   public ResultVO getInspectionTaskInfo(Long userId, LocalDate startDate, LocalDate endDate, Integer inspectionSiteOptionType) {
      log.info("获取巡检信息");
      return ResultBuilder.success(this.projectInspectionTaskRecordBiz.getInspectionTaskInfo(userId, startDate, endDate, inspectionSiteOptionType));
   }

   @ApiOperation("获取巡检信息汇总")
   @GetMapping("/getInspectionSummaryByProjectId")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:get') or @projectInspectionController.isCurrentInspectionUser(#p0)")
   public ResultVO getInspectionSummaryByProjectId(Long userId, Integer inspectionSiteOptionType) {
      log.info("API调用：获取巡检信息汇总");
      return ResultBuilder.success(this.projectInspectionTaskRecordBiz.getInspectionSummaryByUserId(userId, inspectionSiteOptionType));
   }

   @ApiOperation("app治安巡检任务查询")
   @GetMapping("/getInspectionTask")
   public ResultVO getInspectionTask() {
      log.info("API调用:获取人员当前项目 质安巡检任务");
      return ResultBuilder.success(this.projectInspectionTaskRecordBiz.getInspectionTask());
   }

   @ApiOperation("app质安巡检任务扫码")
   @PostMapping("/scanningCode")
   @SignerCheck(lockKey = "#projectInspectionTaskRecordDTOParam.projectInspectionId")
   public ResultVO scanningCode(@RequestBody ProjectInspectionTaskRecordDTOParam projectInspectionTaskRecordDTOParam) {
      log.info("API调用:app质安巡检扫码");
      return ResultBuilder.success(this.projectInspectionTaskRecordBiz.scanningCode(projectInspectionTaskRecordDTOParam));
   }

   @ApiOperation("人员巡检路线详情查询")
   @GetMapping("/getLineDetail")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet') or @projectInspectionController.canReadOwnInspectionLine(#p0)")
   public ResultVO getLineDetail(@RequestParam Long id) {
      log.info("API调用:人员巡检路线详情查询");
      return ResultBuilder.success(this.projectInspectionUserBiz.getLineDetail(id));
   }

   @ApiOperation("巡检点分页查询")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet')")
   public ResultVO getPage() {
      log.info("API调用:巡检点分页查询");
      return ResultBuilder.success(this.projectInspectionBiz.getPage());
   }

   @ApiOperation("人员巡检路线查询")
   @GetMapping("/getLine")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingGet')")
   public ResultVO getLine() {
      log.info("API调用:人员巡检路线查询");
      return ResultBuilder.success(this.projectInspectionUserBiz.getLine());
   }

   @ApiOperation("人员巡检线路状态修改")
   @PutMapping("/updateLineStatus")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#id")
   public ResultVO updateLineStatus(Long id) {
      log.info("API调用:人员巡检路线查询");
      return ResultBuilder.success(this.projectInspectionUserBiz.updateLineStatus(id));
   }

   @ApiOperation("修改巡检线是否强制巡检")
   @PutMapping("")
   @PreAuthorize("@permission.check('safety_quality_inspection_manage:settingEdit')")
   @SignerCheck(lockKey = "#id")
   public ResultVO updateLineMandatoryInspection(Long id) {
      log.info("API调用:修改巡检线是否强制巡检");
      return ResultBuilder.success(this.projectInspectionUserBiz.updateLineMandatoryInspection(id));
   }
   public boolean isCurrentInspectionUser(Long userId) {
      return userId != null && userId.equals(UserUtil.getCurrentUserId());
   }

   public boolean canReadOwnInspectionLine(Long id) {
      ProjectInspectionUser line = this.projectInspectionUserBiz.getById(id);
      return line != null && isCurrentInspectionUser(line.getUserId());
   }
}
