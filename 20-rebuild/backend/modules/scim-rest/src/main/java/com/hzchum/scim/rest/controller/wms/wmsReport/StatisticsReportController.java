package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.MonthTimeRangeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-收发存报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/send-and-receive-storage")
public class StatisticsReportController {
   private static final Logger log = LoggerFactory.getLogger(StatisticsReportController.class);
   @Resource
   ReportService reportService;
   @Resource
   private BasicConfigService basicConfigService;

   @ApiOperation("收发存报表-查询收发存报表")
   @GetMapping
   @PreAuthorize("@permission.check('wms_report_rawMat_sendAndReceiveStorage:get')")
   public ResultVO detailList(QueryStatisticsDTOParam param) {
      log.info("API 调用 ：收发存报表-查询收发存报表");
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      StatisticsPageVO<StatisticsDTO> statistics;
      if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.MONTH.getType()) {
         statistics = this.reportService.getStatistics(param);
      } else {
         statistics = this.reportService.getStatisticsUser(param);
      }

      return ResultBuilder.success(statistics);
   }

   @ApiOperation("收发存报表-查询收发存报表详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('wms_report_rawMat_sendAndReceiveStorage:get')")
   public ResultVO detailListById(
      @RequestParam(required = false) List<Long> ids,
      @RequestParam(required = false) List<Long> statIds,
      Integer formType,
      @RequestParam(required = false) LocalDateTime date,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      Long wmsClosingTimeId
   ) {
      log.info("API 调用 ：收发存报表-查询收发存报表详情");
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      ListVO<StatisticsDetailDTO> statisticsDetail;
      if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.MONTH.getType()) {
         statisticsDetail = this.reportService.getStatisticsDetail(ids, statIds, formType, date);
      } else {
         statisticsDetail = this.reportService.getStatisticsDetailUser(ids, statIds, formType, date, wmsClosingTimeId, dateTimeList);
      }

      return ResultBuilder.success(statisticsDetail);
   }

   @ApiOperation("收发存报表-查询库存总量")
   @GetMapping("/inventory")
   @PreAuthorize("@permission.check('reportRawMaterialInventoryPM:get')")
   public ResultVO detailListById(
      Integer basicClass,
      @RequestParam(required = false) List<Long> classifyId,
      @RequestParam(required = false) Integer orderSupplyType,
      @RequestParam(required = false) List<Long> workshopIds,
      @RequestParam(required = false) String specification,
      @RequestParam(defaultValue = "10", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：收发存报表-查询库存总量");
      return ResultBuilder.success(
         this.reportService.getInventory(basicClass, classifyId, orderSupplyType, workshopIds, specification, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("收发存报表-查询库存钢材总核算量")
   @GetMapping("/inventory/mete")
   @PreAuthorize("@permission.check('reportRawMaterialInventoryPM:get')")
   public ResultVO getMete(
      Integer basicClass,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(required = false) List<Long> workshopIds,
      @RequestParam(required = false) String specification
   ) {
      log.info("API 调用 ：收发存报表-查询库存总量");
      return ResultBuilder.success(this.reportService.getInventoryMete(basicClass, classifyId, workshopIds, specification));
   }

   @ApiOperation("收发存报表-查询库存钢材总金额")
   @GetMapping("/inventory/amount")
   @PreAuthorize("@permission.check('reportRawMaterialInventoryPM:get')")
   public ResultVO getAmount() {
      log.info("API 调用 ：收发存报表-查询库存钢材总金额");
      return ResultBuilder.success(this.reportService.getInventoryAmount());
   }

   @ApiOperation("收发存报表-查询关账时间段")
   @GetMapping("/wmsClosingTime")
   public ResultVO getWmsClosingTime() {
      log.info("API 调用 ：收发存报表-查询关账时间段");
      return ResultBuilder.success(this.reportService.getWmsClosingTime());
   }

   @ApiOperation("收发存报表-设置关账时间")
   @PostMapping("/setWmsClosingTime")
   @PreAuthorize("@permission.check('wms_report_rawMat_sendAndReceiveStorage:setWmsClosingTime')")
   public ResultVO setWmsClosingTime(@RequestBody MonthTimeRangeDTOParam monthTimeRangeDTOParam) {
      log.info("API 调用 ：收发存报表-设置关账时间");
      return ResultBuilder.success(this.reportService.setWmsClosingTime(monthTimeRangeDTOParam));
   }
}
