package com.hzchum.scim.rest.controller.mes.building.wage_manage;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.biz.wage_manage.MesProductionWageBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.ReverseInferenceModeExportParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价管理-工价统计")
@RequestMapping("/api/mes/building/wage-manage/wage-statistics")
@RestController
public class MesWageStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(MesWageStatisticsController.class);
   @Autowired
   private MesProductionWageBiz productionWageBiz;

   @ApiOperation("年度汇总表")
   @GetMapping("year-summary-list")
   public ResultVO yearSummaryList(@RequestParam Integer year, @RequestParam Long projectId, @RequestParam(required = false) Long workshopId) {
      log.info("API 调用 ：工价统计-年度汇总表");
      return ResultBuilder.success(new ListVO<>(this.productionWageBiz.yearSummaryList(year, workshopId, projectId)));
   }

   @ApiOperation("月份汇总表")
   @GetMapping("month-summary-page")
   public ResultVO monthSummaryPage(
      @RequestParam Integer year,
      @RequestParam Integer month,
      @RequestParam Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(name = "sort[]", required = false) List<String> sort
   ) {
      log.info("API 调用 ：工价统计-年度汇总表");
      return ResultBuilder.success(this.productionWageBiz.monthSummaryPage(year, month, projectId, workshopId, pageNumber, pageSize, sort));
   }

   @ApiOperation("月份汇总表下载")
   @GetMapping("/month-summary/export")
   public void monthSummaryExport(
      @RequestParam Integer year,
      @RequestParam Integer month,
      @RequestParam Long projectId,
      @RequestParam(required = false) Long workshopId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ： 下载汇总表");
      this.productionWageBiz.monthSummaryExport(year, month, projectId, workshopId, response);
   }

   @ApiOperation("反推模式生产明细")
   @GetMapping("reverse-inference-mode-page")
   public ResultVO reverseInferenceModePage(
      @RequestParam Long workshopId,
      @RequestParam Long processId,
      @RequestParam String teamLeaderName,
      @RequestParam LocalDate startDate,
      @RequestParam LocalDate endDate,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(name = "sort[]", required = false) List<String> sort
   ) {
      log.info("API 调用 ：工价统计-反推模式生产明细");
      return ResultBuilder.success(
         this.productionWageBiz.reverseInferenceModePage(workshopId, processId, teamLeaderName, startDate, endDate, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("反推模式生产明细下载")
   @PostMapping("/reverse-inference-mode/export")
   public void reverseInferenceModeExport(@RequestBody @Validated ValidList<ReverseInferenceModeExportParam> paramList, HttpServletResponse response) {
      log.info("API 调用 ： 反推模式生产明细下载");
      this.productionWageBiz.reverseInferenceModeExport(paramList, response);
   }

   @ApiOperation("日期范围")
   @GetMapping("date-range")
   public ResultVO dateRange(@RequestParam Integer year, @RequestParam Integer month, @RequestParam Long projectId) {
      log.info("API 调用 ：工价统计-日期范围");
      return ResultBuilder.success(this.productionWageBiz.dateRange(year, month, projectId));
   }
}
