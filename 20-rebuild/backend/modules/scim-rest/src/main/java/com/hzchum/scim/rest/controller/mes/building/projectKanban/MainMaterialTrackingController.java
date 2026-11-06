package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MainMaterialTrackingBiz;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES项目看板-主材跟踪")
@RestController
@RequestMapping("/api/mes/building/kanban/tracking")
public class MainMaterialTrackingController {
   private static final Logger log = LoggerFactory.getLogger(MainMaterialTrackingController.class);
   @Autowired
   private SysSteelAnalysisBiz sysSteelAnalysisBiz;
   @Autowired
   private MainMaterialTrackingBiz mainMaterialTrackingBiz;

   @ApiOperation("主材跟踪汇总")
   @GetMapping("summary")
   public ResultVO summary(@RequestParam Long projectId) {
      log.info("API 调用 ：主材跟踪汇总");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.summary(projectId));
   }

   @ApiOperation("钢材使用用量对比")
   @GetMapping
   @PreAuthorize("@permission.check('mes_main_material_track:get')")
   public ResultVO analysis(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：钢材使用用量对比");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.analysis(projectId, null, pageNumber, pageSize));
   }

   @ApiOperation("打印:钢材使用用量对比")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('mes_main_material_track:print')")
   public ResultVO analysisPrint(@RequestParam Long projectId) {
      log.info("API 调用 ：打印:钢材使用用量对比");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.analysisPrint(projectId, null));
   }

   @ApiOperation("钢材库存量详情")
   @GetMapping("/inventory")
   @PreAuthorize("@permission.check('mes_main_material_track_stock:get')")
   public ResultVO inventoryDetails(
      @RequestParam Long projectId,
      @RequestParam String thickness,
      @RequestParam String material,
      @RequestParam Long configId,
      @RequestParam Long basicId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：钢材库存量详情");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.inventoryDetails(projectId, thickness, material, configId, basicId, pageNumber, pageSize));
   }

   @ApiOperation("打印:钢材库存量详情")
   @GetMapping("/inventory/print")
   @PreAuthorize("@permission.check('mes_main_material_track_stock:print')")
   public ResultVO inventoryDetailsPrint(
      @RequestParam Long projectId, @RequestParam String thickness, @RequestParam String material, @RequestParam Long configId, @RequestParam Long basicId
   ) {
      log.info("API 调用 ：打印:钢材库存量详情");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.inventoryDetailsPrint(projectId, thickness, material, configId, basicId));
   }

   @ApiOperation("钢材库领用详情")
   @GetMapping("/use")
   @PreAuthorize("@permission.check('mes_main_material_track_use_record:get')")
   public ResultVO useDetail(
      @RequestParam Long projectId,
      @RequestParam String thickness,
      @RequestParam String material,
      @RequestParam Long configId,
      @RequestParam Long basicId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：钢材库领用详情");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.useDetail(projectId, thickness, material, configId, basicId, pageNumber, pageSize));
   }

   @ApiOperation("打印:钢材库领用详情")
   @GetMapping("/use/print")
   @PreAuthorize("@permission.check('mes_main_material_track_use_record:print')")
   public ResultVO useDetailPrint(
      @RequestParam Long projectId, @RequestParam String thickness, @RequestParam String material, @RequestParam Long configId, @RequestParam Long basicId
   ) {
      log.info("API 调用 ：打印:钢材库领用详情");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.useDetailPrint(projectId, thickness, material, configId, basicId));
   }

   @ApiOperation("构件生产记录")
   @GetMapping("/artifact/record")
   public ResultVO artifactRecord(@RequestParam Long projectId, @RequestParam String year) {
      log.info("API 调用 ：钢材出库记录-构件生产记录");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.artifactRecord(projectId, year));
   }

   @ApiOperation("构件生产记录详情")
   @GetMapping("artifact/record/detail")
   public ResultVO artifactRecordDetail(
      @RequestParam Long projectId,
      @RequestParam String month,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：构件生产记录详情");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.artifactRecordDetail(projectId, month, pageNumber, pageSize));
   }

   @ApiOperation("构件生产记录详情打印")
   @GetMapping("artifact/record/detail/print")
   public ResultVO artifactRecordDetailPrint(@RequestParam Long projectId, @RequestParam String month) {
      log.info("API 调用 ：构件生产记录详情打印");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.artifactRecordDetailPrint(projectId, month));
   }

   @ApiOperation("钢材出库记录")
   @GetMapping("/plate/record")
   public ResultVO plateRecord(@RequestParam Long projectId, @RequestParam String year) {
      log.info("API 调用 ：钢材出库记录");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.plateRecord(projectId, year));
   }

   @ApiOperation("钢材生产记录详情")
   @GetMapping("plate/record/detail")
   public ResultVO plateRecordDetail(
      @RequestParam Long projectId,
      @RequestParam String month,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：钢材生产记录详情");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.artifactRecordDetail(projectId, month, pageNumber, pageSize));
   }

   @ApiOperation("钢材生产记录详情")
   @GetMapping("plate/record/detail/print")
   public ResultVO plateRecordDetail(@RequestParam Long projectId, @RequestParam String month) {
      log.info("API 调用 ：钢材生产记录详情");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.artifactRecordDetailPrint(projectId, month));
   }

   @ApiOperation("损耗统计")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "projectIds", value = "项目id", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "workShopIds", value = "车间id", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage")
   public ResultVO wastage(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) List<Long> projectIds,
      @RequestParam(required = false) List<Long> workShopId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：损耗统计");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.wastage(year, status, projectIds, workShopId, pageNumber, pageSize));
   }

   @ApiOperation("下载损耗统计")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "projectIds", value = "项目id", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "workShopIds", value = "车间id", dataType = "List<Long>", paramType = "query")
      }
   )
   @GetMapping("/wastage/export")
   public void wastage(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) List<Long> projectIds,
      @RequestParam(required = false) List<Long> workShopId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：损耗统计");
      this.mainMaterialTrackingBiz.wastageExport(year, status, projectIds, workShopId, response);
   }

   @ApiOperation("损耗统计汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "projectIds", value = "项目id", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "workShopIds", value = "车间id", dataType = "String", paramType = "query")
      }
   )
   @GetMapping("/wastageCollect")
   public ResultVO wastageCollect(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) String status,
      @RequestParam(required = false) List<Long> projectIds,
      @RequestParam(required = false) List<Long> workShopId
   ) {
      log.info("API 调用 ：损耗统计汇总");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.wastageCollect(year, status, projectIds, workShopId));
   }

   @ApiOperation("钢材领用明细")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "projectIds", value = "项目id", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "workShopIds", value = "车间id", dataType = "String", paramType = "query")
      }
   )
   @GetMapping("/steelReceive/record")
   public ResultVO artifactRecord(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) String status,
      @RequestParam(required = false) List<Long> projectIds,
      @RequestParam(required = false) List<Long> workShopId
   ) {
      log.info("API 调用 ：钢材领用明细");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.steelReceive(year, status, projectIds, workShopId));
   }

   @ApiOperation("钢材生产明细")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", dataType = "Integer", paramType = "query")
      }
   )
   @GetMapping("/steelProduction/record")
   public ResultVO plateRecord(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：钢材生产明细");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.steelProduction(year, startDate, endDate, projectId, workShopId, pageNumber, pageSize));
   }

   @ApiOperation("钢材生产明细生产总量统计（吨）")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query")
      }
   )
   @GetMapping("/steelProduction/recordTotalWeight")
   public ResultVO plateRecord(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId
   ) {
      log.info("API 调用 ：钢材生产明细生产总量统计（吨）");
      return ResultBuilder.success(this.mainMaterialTrackingBiz.recordTotalWeight(year, startDate, endDate, projectId, workShopId));
   }

   @ApiOperation("下载钢材生产明细")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query")
      }
   )
   @GetMapping("/steelProduction/export")
   public void plateRecord(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ： 下载 钢材生产明细");
      this.mainMaterialTrackingBiz.exportSteelProduction(year, startDate, endDate, projectId, workShopId, response);
   }
}
