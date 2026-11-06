package com.hzchum.scim.rest.controller.mes.building.report_work;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.biz.report_work.MesReportWorkApprovedBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkApprovedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkUnapprovedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesTeamWageSummaryQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "报工审核")
@RestController
@RequestMapping("/api/mes/building/report-work/report-work-approved")
public class MesReportWorkApprovedController {
   private static final Logger log = LoggerFactory.getLogger(MesReportWorkApprovedController.class);
   @Autowired
   private MesReportWorkApprovedBiz reportWorkApprovedBiz;

   @ApiOperation("统计")
   @GetMapping("statistics")
   public ResultVO statistics(@RequestParam Integer year) {
      log.info("API调用: 报工审核-统计");
      return ResultBuilder.success(this.reportWorkApprovedBiz.statistics(year));
   }

   @ApiOperation("未审核分页列表")
   @GetMapping("unapproved-page")
   public ResultVO unapprovedPage(
      MesReportWorkUnapprovedQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 报工审核-未审核列表");
      return ResultBuilder.success(this.reportWorkApprovedBiz.unapprovedPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("剔除")
   @PutMapping("elimination")
   public ResultVO elimination(@RequestBody @Validated ValidList<MesReportWorkApprovedParam> params) {
      log.info("API调用: 报工审核-剔除");
      return ResultBuilder.success(this.reportWorkApprovedBiz.elimination(params));
   }

   @ApiOperation("审核通过")
   @PostMapping("approved")
   public ResultVO approved(@RequestBody @Validated ValidList<MesReportWorkApprovedParam> params) {
      log.info("API调用: 报工审核-审核通过");
      return ResultBuilder.success(this.reportWorkApprovedBiz.approved(params));
   }

   @ApiOperation("班组工资汇总")
   @GetMapping("team-wage-summary")
   public ResultVO teamWageSummary(
      MesTeamWageSummaryQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 报工审核-班组工资汇总");
      return ResultBuilder.success(this.reportWorkApprovedBiz.teamWageSummaryPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("班组工资汇总打印")
   @GetMapping("team-wage-summary/print")
   public ResultVO teamWageSummaryPrint(MesTeamWageSummaryQuery query) {
      log.info("API调用: 报工审核-班组工资汇总打印");
      return ResultBuilder.success(this.reportWorkApprovedBiz.teamWageSummaryPrint(query));
   }

   @ApiOperation("班组工资汇总统计")
   @GetMapping("team-wage-summary/statistics")
   public ResultVO teamWageSummaryStatistics(MesTeamWageSummaryQuery query) {
      log.info("API调用: 报工审核-班组工资汇总统计");
      return ResultBuilder.success(this.reportWorkApprovedBiz.teamWageSummaryStatistics(query));
   }

   @ApiOperation("班组产量")
   @GetMapping("team-production")
   public ResultVO teamProduction(
      MesTeamWageSummaryQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 报工审核-班组产量");
      return ResultBuilder.success(this.reportWorkApprovedBiz.teamProductionPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("班组产量打印")
   @GetMapping("team-production/print")
   public ResultVO teamProductionPrint(MesTeamWageSummaryQuery query) {
      log.info("API调用: 报工审核-班组产量打印");
      return ResultBuilder.success(this.reportWorkApprovedBiz.teamProductionPrint(query));
   }
}
