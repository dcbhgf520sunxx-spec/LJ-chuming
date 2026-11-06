package com.hzchum.scim.rest.controller.mes.enclosure.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.ProjectTreeResponseDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post.ReportSaveVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目任务-围护")
@RestController
@RequestMapping("/api/mes/enclosure/app/order")
public class EnclosureAPPTaskController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureAPPTaskController.class);
   @Resource
   private MesEnclosureTaskBiz taskBiz;

   @ApiOperation("获取项目树(围护)")
   @GetMapping("/project")
   public ResultVO<List<ProjectTreeResponseDTO>> getProjecTrees(
      @RequestParam(required = false, defaultValue = "8") Integer projectType, @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：获取项目树(围护)");
      return ResultBuilder.success(this.taskBiz.getProjecTrees(projectType, lumpSumSystemType));
   }

   @ApiOperation("用户获取任务工单分页列表(围护)")
   @GetMapping("/page")
   public ResultVO taskOrderPage(
      Long projectId,
      Long planId,
      String orderNumber,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取任务工单分页列表(围护)");
      PageVO<AppTaskOrderSummaryDTO> pageVO = this.taskBiz.taskOrderPage(projectId, planId, orderNumber, projectType, lumpSumSystemType, pageNumber, pageSize);
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("用户根据任务工单获取任务列表")
   @GetMapping("/task/page")
   public ResultVO<PageVO<AppEnclosureTaskDTO>> pageProductTaskByTaskOrderId(
      Long projectId,
      Long planId,
      String serialNumber,
      Long taskOrderId,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户根据任务工单获取任务列表");
      return ResultBuilder.success(
         this.taskBiz.pageProductTaskByTaskOrderId(projectId, planId, serialNumber, taskOrderId, projectType, lumpSumSystemType, pageNumber, pageSize)
      );
   }

   @ApiOperation("用户根据任务id获取任务列表")
   @GetMapping("/task/{id}")
   public ResultVO<AppEnclosureTaskDTO> taskByTaskId(@PathVariable Long id) {
      log.info("API 调用 ：用户根据任务id获取任务列表");
      return ResultBuilder.success(this.taskBiz.taskByTaskId(id));
   }

   @ApiOperation("任务上报(围护)")
   @PostMapping("/task/report")
   public ResultVO report(@RequestBody ReportSaveVORequest report) {
      log.info("API 调用 ：任务上报(围护)");
      return ResultBuilder.success(this.taskBiz.report(report.getId(), report.getReportQuantity()));
   }

   @ApiOperation("任务上报记录(围护)")
   @GetMapping("/task/report/records")
   public ResultVO<PageVO<ProduceTeamReportDTO>> reportRecords(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：任务上报记录(围护)");
      return ResultBuilder.success(
         this.taskBiz.reportRecords(startDate, endDate, projectId, serialNumber, projectType, lumpSumSystemType, pageNumber, pageSize)
      );
   }

   @ApiOperation("任务上报总量(围护)")
   @GetMapping("/task/report/total")
   public ResultVO<Map<String, BigDecimal>> reportTotal(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：任务上报记录(围护)");
      return ResultBuilder.success(this.taskBiz.reportTotal(startDate, endDate, projectId, serialNumber, projectType, lumpSumSystemType));
   }
}
