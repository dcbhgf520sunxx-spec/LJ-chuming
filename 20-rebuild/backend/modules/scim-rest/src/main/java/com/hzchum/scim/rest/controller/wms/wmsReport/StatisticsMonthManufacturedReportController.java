package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsMonthManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-制成品月收发存报表")
@RestController
@RequestMapping("/api/wms/manufacture/report/raw-materials")
public class StatisticsMonthManufacturedReportController {
   private static final Logger log = LoggerFactory.getLogger(StatisticsMonthManufacturedReportController.class);
   @Resource
   StatisticsMonthManufacturedService statisticsMonthManufacturedService;

   @ApiOperation("查询制成品收发存报表")
   @GetMapping("/statistics")
   public ResultVO statistics(QueryStatisticsMonthManufacturedDTOParam param) {
      log.info("API 调用 ：查询制成品收发存报表");
      return ResultBuilder.success(this.statisticsMonthManufacturedService.statistics(param));
   }

   @ApiOperation("查询制成品收发存报表")
   @GetMapping("/count")
   public ResultVO statisticsCount(QueryStatisticsMonthManufacturedDTOParam param) {
      log.info("API 调用 ：查询制成品收发存报表");
      return ResultBuilder.success(this.statisticsMonthManufacturedService.statisticsCount(param));
   }
}
