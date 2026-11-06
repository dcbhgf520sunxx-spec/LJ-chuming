package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.service.wmsReport.WarehouseDataDashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-仓库数据看板")
@RestController
@RequestMapping("/api/wms/report/data/dashboard")
public class WarehouseDataDashboardController {
   private static final Logger log = LoggerFactory.getLogger(WarehouseDataDashboardController.class);
   @Resource
   WarehouseDataDashboardService warehouseDataDashboardService;

   @ApiOperation("上月库存额")
   @GetMapping("/inventoryAmount")
   public ResultVO inventoryAmount(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 上月库存额");
      return ResultBuilder.success(this.warehouseDataDashboardService.inventoryAmount(factoryId, workshopId));
   }

   @ApiOperation("库存占比分析")
   @GetMapping("/inventoryRatio")
   public ResultVO inventoryRatio(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 库存占比分析");
      return ResultBuilder.success(this.warehouseDataDashboardService.inventoryRatio(factoryId, workshopId));
   }

   @ApiOperation("实时出库信息")
   @GetMapping("/realTime/outbound")
   public ResultVO realTimeOutbound(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 实时出库信息");
      return ResultBuilder.success(this.warehouseDataDashboardService.realTimeOutbound(factoryId, workshopId));
   }

   @ApiOperation("实时采购及入库信息")
   @GetMapping("/realTime/purchaseAndInbound")
   public ResultVO realTimePurchaseAndInbound(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 实时采购及入库信息");
      return ResultBuilder.success(this.warehouseDataDashboardService.realTimePurchaseAndInbound(factoryId, workshopId));
   }

   @ApiOperation("钢材库存周转率")
   @GetMapping("/steel/stockTurnover")
   public ResultVO steelStockTurnover(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 钢材库存周转率");
      return ResultBuilder.success(this.warehouseDataDashboardService.steelStockTurnover(factoryId, workshopId));
   }

   @ApiOperation("近15天出入库数据")
   @GetMapping("/inboundAndOutboundData")
   public ResultVO inboundAndOutboundData(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 近15天出入库数据");
      return ResultBuilder.success(this.warehouseDataDashboardService.inboundAndOutboundData(factoryId, workshopId));
   }

   @ApiOperation("项目钢材投料统计")
   @GetMapping("/projectSteelCount")
   public ResultVO projectSteelCount(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 项目钢材投料统计");
      return ResultBuilder.success(this.warehouseDataDashboardService.projectSteelCount(factoryId, workshopId));
   }

   @ApiOperation("即时消息提示")
   @GetMapping("/instantMessageHint")
   public ResultVO instantMessageHint(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 即时消息提示");
      return ResultBuilder.success(this.warehouseDataDashboardService.instantMessageHint(factoryId, workshopId));
   }

   @ApiOperation("实时库存额")
   @GetMapping("/month/realTime/inventoryAmount")
   public ResultVO monthRealTimeInventoryAmount(
      @RequestParam(name = "factoryId", required = false) Long factoryId, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 : 本月实时库存额");
      return ResultBuilder.success(this.warehouseDataDashboardService.monthRealTimeInventoryAmount(factoryId, workshopId));
   }
}
