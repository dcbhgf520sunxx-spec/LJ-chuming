package com.hzchum.scim.rest.controller.mes.building.warehouse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.AppShipTimeDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.AppWarehouseRecordDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseArtifactFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseEnclosureFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDetailDOParam;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES-入库记录")
@RestController
@RequestMapping("/api/app/mes/building/warehouse")
public class AppWarehouseController {
   private static final Logger log = LoggerFactory.getLogger(AppWarehouseController.class);
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private WarehouseBiz warehouseBiz;

   @ApiOperation("入库记录-库存汇总")
   @GetMapping("/summary")
   public ResultVO sumArtifactWarehouse(@RequestParam Integer productType) {
      log.info("API 调用 ：出入库看板-库存汇总");
      return ResultBuilder.success(this.warehouseSummaryService.sumMeteByCondition(null, null, null, productType, WarehouseTypeEnum.INTO.getType()));
   }

   @ApiOperation("入库记录-项目汇总")
   @GetMapping("/project/summary")
   public ResultVO projectSummary(@Valid AppShipTimeDOParam param) {
      log.info("API 调用 ：入库记录-项目汇总");
      return ResultBuilder.success(this.warehouseRecordService.sumGroupByProject(param));
   }

   @ApiOperation("入库记录-构件列表")
   @GetMapping("artifact")
   public ResultVO pageArtifact(AppWarehouseRecordDOParam param) {
      log.info("API 调用 ：入库记录-构件列表");
      return ResultBuilder.success(this.warehouseRecordService.listArtifactRecordDetail(param));
   }

   @ApiOperation("入库记录-围护列表")
   @GetMapping("enclosure")
   public ResultVO pageEnclosure(AppWarehouseRecordDOParam param) {
      log.info("API 调用 ：入库记录-围护列表");
      return ResultBuilder.success(this.warehouseRecordService.listEnclosureRecordDetail(param));
   }

   @ApiOperation("项目出入库报表-汇总")
   @GetMapping("/report/summary")
   public ResultVO sumArtifactWarehouse(Long projectId, Long monomerId) {
      log.info("API 调用 ：出入库看板-汇总");
      return ResultBuilder.success(this.warehouseBiz.sumAppMete(projectId, monomerId));
   }

   @ApiOperation("项目出入库报表-构件")
   @GetMapping("/report/artifact")
   public ResultVO artifactReport(WarehouseArtifactFindDOParam param) {
      log.info("API 调用 ：项目出入库报表-构件");
      return ResultBuilder.success(this.warehouseSummaryService.pageArtifact(param));
   }

   @ApiOperation("项目出入库报表-围护")
   @GetMapping("/report/enclosure")
   public ResultVO enclosureReport(WarehouseEnclosureFindDOParam param) {
      log.info("API 调用 ：出入库看板-围护");
      return ResultBuilder.success(this.warehouseSummaryService.pageEnclosure(param));
   }

   @ApiOperation("制成品入发存-分页")
   @GetMapping("/finish-product/page")
   @PreAuthorize("@permission.check('manufacturedInventory')")
   public ResultVO finishedWarehousePage(
      Long workShopId,
      LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer projectStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 制成品入发存-分页");
      return ResultBuilder.success(
         this.warehouseBiz
            .finishedWarehousePage(null, workShopId, dateTime, dateTimeList, productType, projectName, lumpSumSystemType, projectStatus, pageNumber, pageSize)
      );
   }

   @ApiOperation("制成品入发存列表-构件")
   @GetMapping("/report/finish-product/artifact")
   @PreAuthorize("@permission.check('manufacturedInventory')")
   public ResultVO finishArtifactReport(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 制成品入发存列表-构件");
      return ResultBuilder.success(this.warehouseRecordService.finishArtifactReport(param));
   }
}
