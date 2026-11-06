package com.hzchum.scim.rest.controller.mes.building.warehouse;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.ProjectContentNoEnum;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseArtifactFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseEnclosureFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.MesBuildingWarehouseRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES库存")
@RestController
@RequestMapping("/api/mes/building/warehouse")
public class MesBuildingWarehouseController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseController.class);
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private WarehouseBiz warehouseBiz;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;

   @ApiOperation("出入库看板-构件")
   @GetMapping("/artifact/page")
   public ResultVO pageArtifact(WarehouseArtifactFindDOParam param) {
      log.info("API 调用 ：出入库看板-构件");
      return ResultBuilder.success(this.warehouseSummaryService.pageArtifact(param));
   }

   @ApiOperation("出入库看板-打印")
   @GetMapping("/artifact/print")
   public ResultVO printArtifact(WarehouseArtifactFindDOParam param) {
      log.info("API 调用 ：出入库看板-打印");
      return ResultBuilder.success(this.warehouseSummaryService.printArtifact(param));
   }

   @ApiOperation("出入库看板-构件汇总")
   @GetMapping("/artifact/summary")
   public ResultVO sumArtifactWarehouse(@RequestParam Long monomerId, Long factoryId) {
      log.info("API 调用 ：出入库看板-构件汇总");
      return ResultBuilder.success(this.warehouseBiz.sumMete(monomerId, factoryId, ProductTypeEnum.ARTIFACT.getType()));
   }

   @ApiOperation("出入库看板-围护")
   @GetMapping("/enclosure/page")
   public ResultVO getWarehouseRecordListPage(WarehouseEnclosureFindDOParam param) {
      log.info("API 调用 ：出入库看板-围护");
      return ResultBuilder.success(this.warehouseSummaryService.pageEnclosure(param));
   }

   @ApiOperation("出入库看板-围护打印")
   @GetMapping("/enclosure/print")
   public ResultVO printWarehouseRecordListPage(WarehouseEnclosureFindDOParam param) {
      log.info("API 调用 ：出入库看板-围护打印");
      return ResultBuilder.success(this.warehouseSummaryService.printEnclosure(param));
   }

   @ApiOperation("出入库看板-围护汇总")
   @GetMapping("/enclosure/summary")
   public ResultVO sumEnclosureWarehouse(@RequestParam Long monomerId, Long factoryId) {
      log.info("API 调用 ：出入库看板-围护汇总");
      return ResultBuilder.success(this.warehouseBiz.sumMete(monomerId, factoryId, ProductTypeEnum.ENCLOSURE.getType()));
   }

   @ApiOperation("入发存报表")
   @GetMapping("/report")
   public ResultVO report(WarehouseReportDOParam param) {
      log.info("API 调用 ：入发存报表");
      return ResultBuilder.success(this.warehouseRecordService.listReport(param));
   }

   @ApiOperation("入发存报表-打印")
   @GetMapping("/report/print")
   public ResultVO printReport(WarehouseReportDOParam param) {
      log.info("API 调用 ：入发存报表-打印");
      return ResultBuilder.success(this.warehouseRecordService.printReport(param));
   }

   @ApiOperation("入发存报表汇总")
   @GetMapping("/report/summary")
   public ResultVO artifactEnclosureStatementSummary(WarehouseReportDOParam param) {
      log.info("Api 调用 : 入发存报表汇总");
      return ResultBuilder.success(this.warehouseRecordService.sumReport(param));
   }

   @ApiOperation("入发存列表-构件详情")
   @GetMapping("/report/artifact")
   public ResultVO artifactDetail(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 入发存列表-构件详情");
      return ResultBuilder.success(this.warehouseRecordService.listArtifactReportDetail(param));
   }

   @ApiOperation("入发存列表-围护详情")
   @GetMapping("/report/enclosure")
   public ResultVO enclosureStatementDetail(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 入发存列表-围护详情");
      return ResultBuilder.success(this.warehouseRecordService.listEnclosureReportDetail(param));
   }

   @ApiOperation("获取入库产品列表")
   @GetMapping("/product/list/page")
   public ResultVO<PageVO<ProductWarehouseDTO>> getProductList(
      @RequestParam(value = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(value = "productionLineName", required = false) String productionLineName,
      @RequestParam(value = "productName", required = false) String productName,
      @RequestParam(value = "serialNumber", required = false) String serialNumber,
      @RequestParam(value = "projectId", required = false) Long projectId,
      @RequestParam(value = "monomerId", required = false) Long monomerId,
      @RequestParam(value = "areaId", required = false) Long areaId,
      @RequestParam(value = "productType", required = false) Integer productType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api 调用 : 获取入库产品列表");
      return ResultBuilder.success(
         this.warehouseRecordService
            .getProductPage(dateTime, productionLineName, productName, serialNumber, projectId, monomerId, areaId, productType, pageNumber, pageSize)
      );
   }

   @ApiOperation("项目入库记录")
   @GetMapping("/list-record")
   public ResultVO<PageVO<MesBuildingWarehouseRecordDTO>> pageListWarehouseRecord(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 项目入库记录");
      return ResultBuilder.success(this.warehouseBiz.listWareHouseRecord(projectId, pageNumber, pageSize));
   }

   @ApiOperation("项目入库记录-打印")
   @GetMapping("/list-record/print")
   public ResultVO<PrintVO<List<Map<String, Object>>>> printListWarehouseRecord(@RequestParam Long projectId) {
      log.info("Api调用: 打印项目入库记录");
      return ResultBuilder.success(this.warehouseBiz.printInWareHouseRecord(projectId));
   }

   @ApiOperation("结构制成品-入发存汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型 构件 或 零件与组立", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query")
      }
   )
   @GetMapping("/finish-product/summary")
   @PreAuthorize("@permission.check('mes_product-send-receive-storage:get')")
   public ResultVO finishedWarehouseSummary(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("Api调用: 结构制成品-入发存汇总");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseSummary(projectId, dateTime, dateTimeList, workshopId, productType, projectName, null, projectStatus)
      );
   }

   @ApiOperation("围护制成品-入发存汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "category", value = "围护类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query")
      }
   )
   @GetMapping("/finish-product/enclosure/summary")
   public ResultVO finishedWarehouseEnclosureSummary(
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType
   ) {
      log.info("Api调用: 围护制成品-入发存汇总");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseEnclosureSummary(category, projectId, dateTime, workshopId, productType, projectName, null)
      );
   }

   @ApiOperation("围护制成品-入发存汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dictionaryId", value = "围护类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query")
      }
   )
   @GetMapping("/v2/finish-product/enclosure/summary")
   public ResultVO finishedWarehouseEnclosureSummary(
      @RequestParam(required = false) Long dictionaryId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType
   ) {
      log.info("Api调用: 围护制成品-入发存汇总");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseEnclosureSummaryV2(dictionaryId, projectId, dateTime, workshopId, productType, projectName, null)
      );
   }

   @ApiOperation("结构制成品入发存-分页")
   @GetMapping("/finish-product/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围(年月日)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型 构件 或 零件与组立", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('mes_product-send-receive-storage:get')")
   public ResultVO finishedWarehousePage(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer projectStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 结构制成品入发存-分页");
      return ResultBuilder.success(
         this.warehouseBiz
            .finishedWarehousePage(
               projectId, workshopId, dateTime, dateTimeList, productType, projectName, lumpSumSystemType, projectStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("围护制成品入发存-分页")
   @GetMapping("/finish-product/enclosure/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "category", value = "围护类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query")
      }
   )
   public ResultVO finishedWarehouseEnclosurePage(
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 围护制成品入发存-分页");
      return ResultBuilder.success(
         this.warehouseBiz
            .finishedWarehouseEnclosurePage(category, projectId, workshopId, dateTime, productType, projectName, lumpSumSystemType, pageNumber, pageSize)
      );
   }

   @ApiOperation("围护制成品入发存-分页")
   @GetMapping("/v2/finish-product/enclosure/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dictionaryId", value = "围护类型字典id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query")
      }
   )
   public ResultVO finishedWarehouseEnclosurePageV2(
      @RequestParam(required = false) Long dictionaryId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) String projectName,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 围护制成品入发存-分页");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseEnclosurePageV2(dictionaryId, projectId, workshopId, dateTime, productType, projectName, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印结构制成品入发存")
   @GetMapping("/finish-product/print")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "category", value = "围护类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('mes_product-send-receive-storage:print')")
   public ResultVO finishedWarehousePrint(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("Api调用: 打印结构制成品入发存");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehousePrint(projectId, workshopId, dateTime, dateTimeList, productType, projectName, lumpSumSystemType, projectStatus)
      );
   }

   @ApiOperation("打印围护制成品入发存")
   @GetMapping("/finish-product/enclosure/print")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "category", value = "围护类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query")
      }
   )
   public ResultVO finishedWarehouseEnclosurePrint(
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("Api调用: 打印围护制成品入发存");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseEnclosurePrint(category, projectId, workshopId, dateTime, productType, projectName, lumpSumSystemType)
      );
   }

   @ApiOperation("打印围护制成品入发存")
   @GetMapping("/v2/finish-product/enclosure/print")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dictionaryId", value = "围护类型字典id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "时间(年月)", paramType = "query"),
            @ApiImplicitParam(name = "workshopId", value = "车间id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "项目名称", paramType = "query")
      }
   )
   public ResultVO finishedWarehouseEnclosurePrintV2(
      @RequestParam(required = false) Long dictionaryId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType
   ) {
      log.info("Api调用: 打印围护制成品入发存");
      return ResultBuilder.success(this.warehouseBiz.finishedWarehouseEnclosurePrintV2(dictionaryId, projectId, workshopId, dateTime, productType, projectName));
   }

   @ApiOperation("结构制成品入发存列表-构件")
   @GetMapping("/report/finish-product/artifact")
   public ResultVO finishArtifactReport(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 结构制成品入发存列表-构件");
      return ResultBuilder.success(this.warehouseBiz.finishArtifactReport(param));
   }

   @ApiOperation("结构制成品入发存汇总-构件")
   @GetMapping("/report/finish-product/artifact/sum")
   public ResultVO finishArtifactReportSum(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 结构制成品入发存汇总-构件");
      return ResultBuilder.success(this.warehouseBiz.finishArtifactReportSum(param));
   }

   @ApiOperation("围护制成品入发存列表")
   @GetMapping("/report/finish-product/enclosure")
   public ResultVO finishEnclosureReport(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 围护制成品入发存列表");
      return ResultBuilder.success(this.warehouseBiz.finishEnclosureReport(param));
   }

   @ApiOperation("围护制成品入发存列表")
   @GetMapping("/v2/report/finish-product/enclosure")
   public ResultVO finishEnclosureReportV2(WarehouseReportDetailDOParam param) {
      log.info("Api 调用 : 围护制成品入发存列表");
      return ResultBuilder.success(this.warehouseBiz.finishEnclosureReportV2(param));
   }

   @ApiOperation("打印结构制成品入发存列表")
   @GetMapping("/print/finish-product/artifact")
   public ResultVO printFinishedWarehousePrint(WarehouseReportDetailDOParam param) {
      log.info("Api调用: 打印结构制成品入发存列表");
      return ResultBuilder.success(this.warehouseBiz.printFinishedWarehousePrint(param));
   }

   @ApiOperation("打印围护制成品入发存列表")
   @GetMapping("/print/finish-product/enclosure")
   public ResultVO printFinishedWarehouseEnclosurePrint(WarehouseReportDetailDOParam param) {
      log.info("Api调用: 打印围护制成品入发存列表");
      return ResultBuilder.success(this.warehouseBiz.printFinishedWarehouseEnclosurePrint(param));
   }

   @ApiOperation("结构制成品入发存详情")
   @GetMapping("/finish-product/detail")
   @PreAuthorize("@permission.check('mes_product-send-receive-storage:detail')")
   public ResultVO finishedWarehouseDetail(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList
   ) {
      log.info("Api调用: 结构制成品入发存详情");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseDetail(projectId, monomerId, areaId, serialNumber, workshopId, productType, dateTime, dateTimeList)
      );
   }

   @ApiOperation("围护制成品入发存详情")
   @GetMapping("/finish-product/detail/enclosure")
   public ResultVO finishedWarehouseEnclosureDetail(
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam Long projectId,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) LocalDateTime dateTime
   ) {
      log.info("Api调用: 围护制成品入发存详情");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseEnclosureDetail(category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime)
      );
   }

   @ApiOperation("结构制成品入发存详情-分页")
   @GetMapping("/finish-product/detail/page")
   @PreAuthorize("@permission.check('mes_product-send-receive-storage:detail')")
   public ResultVO finishedWarehouseDetailPage(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 结构制成品入发存详情-分页");
      return ResultBuilder.success(
         this.warehouseBiz
            .finishedWarehouseDetailPage(projectId, monomerId, areaId, serialNumber, workshopId, productType, dateTime, dateTimeList, pageNumber, pageSize)
      );
   }

   @ApiOperation("围护制成品入发存详情-分页")
   @GetMapping("/finish-product/detail/enclosure/page")
   public ResultVO finishedWarehouseEnclosureDetailPage(
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam Long projectId,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 围护制成品入发存详情-分页");
      return ResultBuilder.success(
         this.warehouseBiz
            .finishedWarehouseEnclosureDetailPage(category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印结构制成品入发存详情")
   @GetMapping("/finish-product/detail/print")
   @PreAuthorize("@permission.check('mes_product-send-receive-storage:detailPrint')")
   public ResultVO finishedWarehouseDetailPrint(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Integer weightStatus
   ) {
      log.info("Api调用: 打印结构制成品入发存详情");
      return ResultBuilder.success(
         this.warehouseBiz
            .finishedWarehouseDetailPrint(projectId, monomerId, areaId, serialNumber, workshopId, productType, dateTime, dateTimeList, weightStatus)
      );
   }

   @ApiOperation("打印围护制成品入发存详情")
   @GetMapping("/finish-product/detail/enclosure/print")
   public ResultVO finishedWarehouseDetailPrint(
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam Long projectId,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在") Integer productType,
      @RequestParam(required = false) LocalDateTime dateTime
   ) {
      log.info("Api调用: 打印围护制成品入发存详情");
      return ResultBuilder.success(
         this.warehouseBiz.finishedWarehouseEnclosureDetailPrint(category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime)
      );
   }
}
