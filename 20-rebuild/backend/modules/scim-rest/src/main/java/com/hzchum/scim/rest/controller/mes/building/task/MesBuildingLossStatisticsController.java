package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWorkshopBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveDateDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES损耗统计")
@RestController
@RequestMapping("/api/mes/building/task")
public class MesBuildingLossStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingLossStatisticsController.class);
   @Autowired
   private MesBuildingTaskService taskService;
   @Resource
   ReportService reportService;
   @Resource
   ContractProjectBiz projectBiz;
   @Resource
   MesBuildingWorkshopBiz workshopBiz;

   @ApiOperation("损耗统计列表")
   @GetMapping("/loss_statistics")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:get','mes_loss_statistics:get')")
   public ResultVO lossStatistics(
      Long workShopId,
      Long branchCompanyId,
      Integer status,
      String projectName,
      String year,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：损耗统计列表");
      return ResultBuilder.success(this.taskService.getLossStatisticsList(workShopId, branchCompanyId, status, projectName, year, pageNumber, pageSize));
   }

   @ApiOperation("损耗统计列表-打印")
   @GetMapping("/loss_statistics/print")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:print','mes_loss_statistics:export')")
   public ResultVO lossStatisticsPrint(Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String year) {
      log.info("API 调用 ：损耗统计列表-打印");
      return ResultBuilder.success(this.taskService.getLossStatisticsListPrint(workShopId, branchCompanyId, projectStatus, projectName, year));
   }

   @ApiOperation("损耗统计详情列表")
   @GetMapping("/loss_statistics_detail")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:get','mes_loss_statistics:productionDetail')")
   public ResultVO getLossStatisticsTaskDetail(Long projectId, Long workShopId, Integer projectStatus, String projectName, String year) {
      log.info("API 调用 ：损耗统计详情列表");
      return ResultBuilder.success(new ListVO<>(this.taskService.getLossStatisticsTaskDetail(projectId, workShopId, projectStatus, projectName, year)));
   }

   @ApiOperation("损耗统计详情列表下载")
   @GetMapping("/loss_statistics_detail/print")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:print','mes_loss_statistics:productionExport')")
   public ResultVO getLossStatisticsTaskDetailPrint(Long projectId, Long workShopId, Integer projectStatus, String projectName, String year) {
      log.info("API 调用 ：损耗统计详情列表下载");
      return ResultBuilder.success(this.taskService.getLossStatisticsTaskDetailPrint(projectId, workShopId, projectStatus, projectName, year));
   }

   @ApiOperation("损耗统计汇总")
   @GetMapping("/loss_summary")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:get','mes_loss_statistics:get')")
   public ResultVO lossSummary(Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String year) {
      log.info("API 调用 ：损耗统计汇总");
      return ResultBuilder.success(this.taskService.getLossStatisticsSummary(workShopId, branchCompanyId, projectStatus, projectName, year));
   }

   @ApiOperation("领用统计(明细)")
   @PostMapping("/getReceiveDateDetail")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:get','mes_loss_statistics:receiveDetail')")
   public ResultVO getReceiveDateDetail(Long projectId, Long workShopId, Integer basicClass, Integer status, String year) {
      log.info("API 调用 : 领用统计");
      QueryReceiveDateDTOParam queryReceiveDateDTOParam = new QueryReceiveDateDTOParam();
      if (projectId != null) {
         queryReceiveDateDTOParam.setProjectIds(Collections.singletonList(projectId));
      }

      if (workShopId != null) {
         queryReceiveDateDTOParam.setWorkShopIds(Collections.singletonList(workShopId));
      }

      if (year != null) {
         queryReceiveDateDTOParam.setYear(Integer.valueOf(year));
      }

      ReceiveDateDTO receiveDateDetail = this.reportService.getReceiveDateDetailV2(queryReceiveDateDTOParam);
      if (basicClass != null) {
         receiveDateDetail.setPlantOutboundDetailList(
            receiveDateDetail.getPlantOutboundDetailList().stream().filter(e -> e.getBasicClass().equals(basicClass)).collect(Collectors.toList())
         );
         receiveDateDetail.setPlantReturnDetailList(
            receiveDateDetail.getPlantReturnDetailList().stream().filter(e -> e.getBasicClass().equals(basicClass)).collect(Collectors.toList())
         );
      }

      return ResultBuilder.success(receiveDateDetail);
   }

   @ApiOperation("领用统计(明细)")
   @GetMapping("/getReceiveDateDetail/print")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:print','mes_loss_statistics:receivePrint')")
   public ResultVO getReceiveDateDetailPrint(Long projectId, Long workShopId, Integer basicClass, Integer status, String year) {
      log.info("API 调用 : 领用统计");
      QueryReceiveDateDTOParam queryReceiveDateDTOParam = new QueryReceiveDateDTOParam();
      if (projectId != null) {
         queryReceiveDateDTOParam.setProjectIds(Collections.singletonList(projectId));
      }

      if (workShopId != null) {
         queryReceiveDateDTOParam.setWorkShopIds(Collections.singletonList(workShopId));
      }

      if (year != null) {
         queryReceiveDateDTOParam.setYear(Integer.valueOf(year));
      }

      ReceiveDateDTO receiveDateDetail = this.reportService.getReceiveDateDetailV2(queryReceiveDateDTOParam);
      if (basicClass != null) {
         receiveDateDetail.setPlantOutboundDetailList(
            receiveDateDetail.getPlantOutboundDetailList().stream().filter(e -> e.getBasicClass().equals(basicClass)).collect(Collectors.toList())
         );
         receiveDateDetail.setPlantReturnDetailList(
            receiveDateDetail.getPlantReturnDetailList().stream().filter(e -> e.getBasicClass().equals(basicClass)).collect(Collectors.toList())
         );
      }

      ContractProject project = this.projectBiz.getById(projectId);
      PrintVO<Object> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getShortName());
      if (workShopId != null) {
         header.put("workshopName", this.workshopBiz.getById(workShopId).getName());
      }

      header.put("year", year);
      printVO.setHeader(header);
      printVO.setTable(receiveDateDetail);
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("钢材投料详情")
   @GetMapping("/steel_feeding_detail")
   public ResultVO steelFeedingDetail(Long projectId, Long workShopId, Integer basicClass, String year) {
      log.info("API 调用 ：钢材投料详情");
      return ResultBuilder.success(this.taskService.getSteelFeedingDetail(projectId, workShopId, basicClass, year));
   }

   @ApiOperation("钢材投料详情")
   @GetMapping("/steel_feeding_detail/print")
   public ResultVO steelFeedingDetailPrint(Long projectId, Long workShopId, Integer basicClass, String year) {
      log.info("API 调用 ：钢材投料详情");
      return ResultBuilder.success(this.taskService.getSteelFeedingDetailPrint(projectId, workShopId, basicClass, year));
   }

   @ApiOperation("零件上报详情")
   @GetMapping("/part_report_detail")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:get','mes_loss_statistics:productionDetail')")
   public ResultVO getPartReportDetail(Long projectId, Long workShopId, Integer partType, String year) {
      log.info("API 调用 ：零件上报详情");
      return ResultBuilder.success(this.taskService.getPartReportDetail(projectId, workShopId, partType, year));
   }

   @ApiOperation("零件上报详情-打印")
   @GetMapping("/part_report_detail/print")
   @PreAuthorize("@permission.check('mes_loss_statistics_v2:print','mes_loss_statistics:productionExport')")
   public ResultVO getPartReportDetailPrint(Long projectId, Long workShopId, Integer partType, String year) {
      log.info("API 调用 ：零件上报详情-打印");
      return ResultBuilder.success(this.taskService.getPartReportDetailPrint(projectId, workShopId, partType, year));
   }

   @ApiOperation("平均班组能力分析近一年详情")
   @GetMapping("/avg_line_ton")
   public ResultVO getAvgProductionLineInfo(LineSchedulingInfoDTOParam param) {
      log.info("API 调用 ：平均班组能力分析近一年详情");
      return ResultBuilder.success(this.taskService.getAvgProductionLineInfo(param));
   }

   @ApiOperation("工单未完成任务")
   @GetMapping("/order_uncompleted")
   public ResultVO getOrderUncompletedInfo(LineSchedulingInfoDTOParam param) {
      log.info("API 调用 ：工单未完成任务");
      return ResultBuilder.success(this.taskService.getOrderUncompletedInfo(param));
   }

   @ApiOperation("工单未完成任务详情")
   @GetMapping("/order_uncompleted_detail")
   public ResultVO getOrderUncompletedDetailInfo(Long orderId, Long teamId) {
      log.info("API 调用 ：工单未完成任务详情");
      return ResultBuilder.success(this.taskService.getOrderUncompletedDetailInfo(orderId, teamId));
   }

   @ApiOperation("此项目排产详情")
   @GetMapping("/current_project_scheduling")
   public ResultVO getCurrentProjectScheduling(Long projectId, String serialNumber, Long teamId) {
      log.info("API 调用 ：此项目排产详情");
      return ResultBuilder.success(this.taskService.getCurrentProjectScheduling(projectId, serialNumber, teamId));
   }
}
