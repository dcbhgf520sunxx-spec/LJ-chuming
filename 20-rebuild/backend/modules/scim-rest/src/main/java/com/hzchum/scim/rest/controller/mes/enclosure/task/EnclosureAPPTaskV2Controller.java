package com.hzchum.scim.rest.controller.mes.enclosure.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDTO;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post.ReportSaveVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

@Api(tags = "(新)项目任务-围护")
@RestController
@RequestMapping("/api/v2/mes/enclosure/app")
public class EnclosureAPPTaskV2Controller {
   private static final Logger log = LoggerFactory.getLogger(EnclosureAPPTaskV2Controller.class);
   @Resource
   private MesEnclosureTaskBiz taskBiz;
   @Resource
   private TechEnclosureBiz enclosureBiz;

   @ApiOperation("(新)用户获取任务工单分页列表(围护)")
   @GetMapping("/order/page")
   public ResultVO taskOrderPageV2(
      Long projectId,
      Long areaId,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：(新)用户获取任务工单分页列表(围护)");
      PageVO<AppTaskOrderSummaryDTO> pageVO = this.taskBiz.taskOrderPageV2(projectId, areaId, orderNumber, pageNumber, pageSize);
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("(新)用户根据任务工单获取任务列表")
   @GetMapping("/order/task/page")
   public ResultVO<PageVO<AppEnclosureTaskDTO>> pageProductTaskByTaskOrderIdV2(
      Long projectId,
      Long areaId,
      String serialNumber,
      Long taskOrderId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：(新)用户根据任务工单获取任务列表");
      return ResultBuilder.success(this.taskBiz.pageProductTaskByTaskOrderIdV2(projectId, areaId, serialNumber, taskOrderId, pageNumber, pageSize));
   }

   @ApiOperation("(新)任务上报(围护)")
   @PostMapping("/order/task/report")
   public ResultVO reportV2(@RequestBody ReportSaveVORequest report) {
      log.info("API 调用 ：(新)任务上报(围护)");
      return ResultBuilder.success(this.taskBiz.reportV2(report.getId(), report.getReportQuantity()));
   }

   @ApiOperation("任务上报记录(围护)")
   @GetMapping("/order/task/report/records")
   public ResultVO<PageVO<ProduceTeamReportDTO>> reportRecordsV2(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：任务上报记录(围护)");
      return ResultBuilder.success(this.taskBiz.reportRecordsV2(startDate, endDate, projectId, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("任务上报总量(围护)")
   @GetMapping("/order/task/report/total")
   public ResultVO<Map<String, BigDecimal>> reportTotalV2(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber
   ) {
      log.info("API 调用 ：任务上报记录(围护)");
      return ResultBuilder.success(this.taskBiz.reportTotalV2(startDate, endDate, projectId, serialNumber));
   }

   @ApiOperation("(新)根据围护id 查询 围护信息")
   @ApiImplicitParam(name = "id", value = "围护id", paramType = "path", required = true)
   @GetMapping("/app/id/{id}")
   public ResultVO<EnclosureDTO> getByIdV2(@PathVariable("id") Long id) {
      log.info("app端 Api调用: (新)根据围护id 查询围护信息");
      return ResultBuilder.success(this.enclosureBiz.getEnclosureDTOByIdV2(id));
   }
}
