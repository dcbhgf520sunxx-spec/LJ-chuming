package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-库存使用报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/inventory-use")
public class InventoryUseStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(InventoryUseStatisticsController.class);
   @Resource
   InventoryUseStatisticsService inventoryUseStatisticsService;

   @ApiOperation("获取库存使用时间段信息")
   @GetMapping("/getTimeList")
   public ResultVO timeList() {
      log.info("API 调用 ：获取库存使用时间段信息");
      return ResultBuilder.success(this.inventoryUseStatisticsService.getTimeList());
   }

   @ApiOperation("库存使用分析统计报表查询")
   @GetMapping
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public ResultVO list(
      QueryInventoryUseStatisticsDTOParam dtoParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：库存使用分析统计报表查询");
      return ResultBuilder.success(this.inventoryUseStatisticsService.getInventoryUseStatistics(dtoParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("库存使用分析统计报表查询-新")
   @GetMapping("/new")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public ResultVO listNew(
      QueryInventoryUseStatisticsDTOParam dtoParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：库存使用分析统计报表查询-新");
      return ResultBuilder.success(this.inventoryUseStatisticsService.getInventoryUseStatisticsNew(dtoParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("库存使用手动结存")
   @PostMapping("/weighting")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:manualBalance')")
   public ResultVO weighting(@RequestParam(required = true, name = "endTime") LocalDateTime endTime, @RequestParam(required = false, name = "name") String name) {
      log.info("API 调用 ：库存使用手动结存");
      return ResultBuilder.success(this.inventoryUseStatisticsService.weighting(false, endTime, name));
   }

   @ApiOperation("根据统计ID查询库存使用记录信息")
   @GetMapping("/getUseRecord")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public ResultVO getUseRecordByStatisticsId(
      @RequestParam(required = true, name = "id") Long id, @RequestParam(required = false, name = "formType") Integer formType
   ) {
      log.info("API 调用 ：根据统计ID查询库存使用记录信息");
      return ResultBuilder.success(this.inventoryUseStatisticsService.getUseRecordByStatisticsId(id, formType));
   }

   @ApiOperation("根据统计ID集合查询库存使用记录信息-新")
   @GetMapping("/getUseRecord-new")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public ResultVO getUseRecordByStatisticsNew(
      @RequestParam(required = true, name = "ids") List<Long> ids, @RequestParam(required = false, name = "formType") Integer formType
   ) {
      log.info("API 调用 ：根据统计ID集合查询库存使用记录信息-新");
      return ResultBuilder.success(this.inventoryUseStatisticsService.getUseRecordByStatisticsNew(ids, formType));
   }

   @ApiOperation("钢板-型材-钢卷->统计量返回")
   @GetMapping("/getSteelCount")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public ResultVO getSteelCount(QueryInventoryUseStatisticsDTOParam dtoParam) {
      log.info("API 调用 ：钢板-型材-钢卷->统计量返回-新");
      return ResultBuilder.success(this.inventoryUseStatisticsService.getSteelCount(dtoParam));
   }
}
