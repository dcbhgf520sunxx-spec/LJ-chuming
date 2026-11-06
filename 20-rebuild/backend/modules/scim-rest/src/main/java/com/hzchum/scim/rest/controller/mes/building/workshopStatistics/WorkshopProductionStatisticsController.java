package com.hzchum.scim.rest.controller.mes.building.workshopStatistics;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.workshopStatistics.WorkshopProductionStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshopStatistics.WorkshopProductionStatisticsQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES建钢-车间产量统计报表")
@RestController
@RequestMapping("/api/mes/building/workshop/production/statistics")
public class WorkshopProductionStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(WorkshopProductionStatisticsController.class);
   @Resource
   private WorkshopProductionStatisticsBiz workshopProductionStatisticsBiz;

   @ApiOperation("车间产量统计报表列表")
   @GetMapping("/list")
   public ResultVO listWorkshopProductionStatistics(@Valid WorkshopProductionStatisticsQueryParam param) {
      log.info("API调用：车间产量统计报表列表，入参：{}", param);
      return ResultBuilder.success(this.workshopProductionStatisticsBiz.listWorkshopProductionStatistics(param));
   }

   @ApiOperation("车间产量统计报表下载")
   @GetMapping("/export")
   public void exportWorkshopProductionStatistics(@Valid WorkshopProductionStatisticsQueryParam param, HttpServletResponse response) {
      log.info("API调用：车间产量统计报表下载，入参：{}", param);
      this.workshopProductionStatisticsBiz.exportWorkshopProductionStatistics(param, response);
   }
}
