package com.hzchum.scim.rest.controller.mes.building.report;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingOutputReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "中南定制报表记录")
@RestController
@RequestMapping("/api/mes/building/outputReport")
public class MesBuildingOutputReportController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingOutputReportController.class);
   @Autowired
   private MesBuildingOutputReportService mesBuildingOutputReportService;

   @ApiOperation("成品入库汇总(按月查询)")
   @GetMapping("/finishedProductWarehousingSummary")
   public ResultVO finishedProductWarehousingSummary(
      @RequestParam(required = false) String yearMonth, @RequestParam(required = false) Long workshopId, @RequestParam(required = false) String workshopName
   ) {
      return ResultBuilder.success(this.mesBuildingOutputReportService.finishedProductWarehousingSummary(yearMonth, workshopId, workshopName));
   }

   @ApiOperation("成品入库汇总下载(按月查询)")
   @GetMapping("/finishedProductWarehousingSummaryDownload")
   public void finishedProductWarehousingSummaryDownload(
      @RequestParam String yearMonth, @RequestParam Long workshopId, @RequestParam(required = false) String workshopName, HttpServletResponse response
   ) {
      this.mesBuildingOutputReportService.finishedProductWarehousingSummaryDownload(yearMonth, workshopId, workshopName, response);
   }

   @ApiOperation("成品入库汇总详情")
   @GetMapping("/finishedProductWarehousingSummaryDetail")
   public ResultVO finishedProductWarehousingSummaryDetail(
      @RequestParam String yearMonth,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) String structureType,
      @RequestParam(required = false) String workshopName
   ) {
      log.info("成品入库汇总详情，请求参数 yearMonth:{},workshopId:{},structureType:{}", yearMonth, workshopId, structureType);
      return ResultBuilder.success(
         this.mesBuildingOutputReportService.finishedProductWarehousingSummaryDetail(yearMonth, workshopId, structureType, workshopName)
      );
   }

   @ApiOperation("成品入库汇总详情下载")
   @GetMapping("/finishedProductWarehousingSummaryDetailDownload")
   public void finishedProductWarehousingSummaryDetailDownload(
      @RequestParam String yearMonth,
      @RequestParam Long workshopId,
      @RequestParam(required = false) String structureType,
      @RequestParam(required = false) String workshopName,
      HttpServletResponse response
   ) {
      log.info("成品入库汇总详情，请求参数 yearMonth:{},workshopId:{},structureType:{},workshopName:{}", yearMonth, workshopId, structureType, workshopName);
      this.mesBuildingOutputReportService.finishedProductWarehousingSummaryDetailDownload(yearMonth, workshopId, structureType, workshopName, response);
   }

   @ApiOperation("年度产量对比（按年查询）")
   @GetMapping("/yearlyOutputComparison")
   public ResultVO yearlyOutputComparison(@RequestParam(required = false) String year, @RequestParam(required = false) Long workshopId) {
      log.info("年度产量对比（按年查询），请求参数 year:{},workshopId:{}", year, workshopId);
      return ResultBuilder.success(this.mesBuildingOutputReportService.yearlyOutputComparison(year, workshopId));
   }

   @ApiOperation("年度产量对比（按年查询并且下载）")
   @GetMapping("/yearlyOutputComparisonDownload")
   public void yearlyOutputComparisonDownload(
      @RequestParam(required = false) String year,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) String workshopName,
      HttpServletResponse response
   ) {
      log.info("年度产量对比（按年查询），请求参数 year:{},workshopId:{},workshopName{}", year, workshopId, workshopName);
      this.mesBuildingOutputReportService.yearlyOutputComparisonDownload(year, workshopId, workshopName, response);
   }

   @ApiOperation("班组产量统计报表")
   @GetMapping("/teamOutputStatisticsReport")
   public ResultVO teamOutputStatisticsReport(
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) String teamName,
      @RequestParam(required = false) String processName,
      @RequestParam(required = false) String processType
   ) {
      String startDateStr = startDate.toString();
      String endDateStr = endDate.toString();
      log.info(
         "班组产量统计报表，请求参数 startDate:{},endDate:{},workshopId:{},productionLineId:{},teamName:{},processName:{},processType:{}",
         startDate,
         endDate,
         workshopId,
         productionLineId,
         teamName,
         processName,
         processType
      );
      return ResultBuilder.success(
         this.mesBuildingOutputReportService
            .teamOutputStatisticsReport(startDateStr, endDateStr, workshopId, productionLineId, teamName, processName, processType)
      );
   }

   @ApiOperation("班组产量统计详情报表")
   @GetMapping("/teamOutputStatisticsDetailsReport")
   public ResultVO teamOutputStatisticsDetailsReport(
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) String processType,
      @RequestParam(required = false) String teamName,
      @RequestParam(required = false) String processName
   ) {
      String startDateStr = startDate.toString();
      String endDateStr = endDate.toString();
      log.info(
         "班组产量统计详情报表，请求参数 startDate:{},endDate:{},workshopId:{},productionLineId:{},teamName:{},processName:{},processType:{}",
         startDate,
         endDate,
         workshopId,
         productionLineId,
         teamId,
         processName,
         processType,
         teamName,
         processName
      );
      return ResultBuilder.success(
         this.mesBuildingOutputReportService
            .teamOutputStatisticsDetailsReport(startDateStr, endDateStr, workshopId, productionLineId, teamId, processId, processType, teamName, processName)
      );
   }

   @ApiOperation("班组产量统计详情报表下载")
   @GetMapping("/teamOutputStatisticsDetailsReportDownload")
   public ResultVO teamOutputStatisticsDetailsReportDownload(
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) String processType,
      @RequestParam(required = false) String teamName,
      @RequestParam(required = false) String processName,
      @RequestParam(required = false) String workshopName,
      HttpServletResponse response
   ) {
      String startDateStr = startDate.toString();
      String endDateStr = endDate.toString();
      log.info(
         "班组产量统计详情报表，请求参数 startDate:{},endDate:{},workshopId:{},productionLineId:{},teamId:{},processId:{},processType:{}",
         startDate,
         endDate,
         workshopId,
         productionLineId,
         teamId,
         processId,
         processType,
         teamName,
         processName,
         workshopName
      );
      return ResultBuilder.success(
         this.mesBuildingOutputReportService
            .teamOutputStatisticsDetailsReportDownload(
               startDateStr, endDateStr, workshopId, productionLineId, teamId, processId, processType, teamName, processName, workshopName, response
            )
      );
   }

   @ApiOperation("车间制作产量统计月报")
   @GetMapping("/workshopProductionOutputStatisticsMonthlyReport")
   public ResultVO workshopProductionOutputStatisticsMonthlyReport(
      @RequestParam(required = false) String yearMonth,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) String structureType
   ) {
      log.info("车间制作产量统计月报，请求参数 yearMonth:{},workshopId:{},projectId:{},structureType:{}", yearMonth, workshopId, projectId, structureType);
      return ResultBuilder.success(
         this.mesBuildingOutputReportService.workshopProductionOutputStatisticsMonthlyReport(yearMonth, workshopId, projectId, structureType)
      );
   }

   @ApiOperation("车间制作产量统计月报下载")
   @GetMapping("/workshopProductionOutputStatisticsMonthlyReportDownload")
   public void workshopProductionOutputStatisticsMonthlyReportDownload(
      @RequestParam(required = false) String yearMonth,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) String workshopName,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) String structureType,
      HttpServletResponse response
   ) {
      log.info(
         "车间制作产量统计月报，请求参数 yearMonth:{},workshopId:{},workshopName{},projectId:{},structureType:{}",
         yearMonth,
         workshopId,
         workshopName,
         projectId,
         structureType
      );
      this.mesBuildingOutputReportService
         .workshopProductionOutputStatisticsMonthlyReportDownload(yearMonth, workshopId, workshopName, projectId, structureType, response);
   }
}
