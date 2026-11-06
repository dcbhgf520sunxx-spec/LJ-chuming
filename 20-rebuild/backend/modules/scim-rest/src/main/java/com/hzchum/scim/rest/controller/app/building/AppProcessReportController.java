package com.hzchum.scim.rest.controller.app.building;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "立式-报工")
@RestController
@RequestMapping("/api/app/process/report")
public class AppProcessReportController {
   private static final Logger log = LoggerFactory.getLogger(AppProcessReportController.class);
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;

   @ApiOperation("工序报工汇总")
   @GetMapping("/summary")
   public ResultVO<ProcessReportSummaryDTO> getProcessReportSummary(Long processId) {
      log.info("API 调用 ：工序报工汇总");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.taskProcessService.getProcessReportSummaryAV2(processId, user));
   }

   @ApiOperation("工序报工项目信息列表")
   @GetMapping("/page")
   public ResultVO<List<ProcessReportListDTO>> findProcessReportProjectList(Long processId, String projectName) {
      log.info("API 调用 ：工序报工项目信息列表");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.taskProcessService.findProcessReportProjectListAV2(processId, projectName, user));
   }

   @ApiOperation("用户获取任务工单分页列表")
   @GetMapping("/task_order/process/page")
   public ResultVO taskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取任务工单分页列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         this.taskBiz
            .taskOrderProcessPageAV2(
               projectId, monomerId, areaId, areaBatchId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum, sort, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("APP报工根据任务工单获取任务列表")
   @GetMapping("/v2/task_order/{id}/task/page")
   @PreAuthorize("@permission.check('artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO pageProductTaskByTaskOrderId(
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Long classId,
      String serialNumber,
      Boolean boolAssist,
      Long assistGroupId,
      @PathVariable("id") Long taskOrderId,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：APP报工根据任务工单获取任务列表");
      return ResultBuilder.success(
         this.taskBiz
            .pageArtifactProcessByTaskOrderIdAV2(
               taskTypeEnum,
               monomerId,
               areaId,
               areaBatchId,
               processId,
               classId,
               serialNumber,
               boolAssist,
               assistGroupId,
               taskOrderId,
               boolLastProcessEnum,
               pageNumber,
               pageSize
            )
      );
   }
}
