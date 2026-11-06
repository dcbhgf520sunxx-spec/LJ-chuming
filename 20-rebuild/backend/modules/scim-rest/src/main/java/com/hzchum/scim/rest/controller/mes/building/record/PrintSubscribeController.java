package com.hzchum.scim.rest.controller.mes.building.record;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.record.PrintBiz;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintReportDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.WareSubscribeArtifactPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.WareSubscribePrintDTO;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.service.task.EnclosurePrintService;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-申购入库打印")
@RestController
@RequestMapping("/api/mes/building/subscribe/print")
public class PrintSubscribeController {
   private static final Logger log = LoggerFactory.getLogger(PrintSubscribeController.class);
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingPrintRecordService printRecordService;
   @Autowired
   private PrintBiz printBiz;
   @Autowired
   private EnclosurePrintService enclosurePrintService;

   @ApiOperation("产品标签-构件(外购)列表")
   @GetMapping("artifact")
   public ResultVO listArtifactPrint(@Valid WareSubscribeArtifactPrintDOParam param) {
      log.info("API 调用 ：产品标签-构件(外购)列表");
      return ResultBuilder.success(this.warehouseSummaryService.listArtifactPrint(param));
   }

   @ApiOperation("产品标签-围护(外购)列表")
   @GetMapping("enclosure")
   public ResultVO listEnclosurePrint(
      Long projectId,
      Long planId,
      Integer category,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      log.info("API 调用 ：产品标签-围护(外购)列表");
      return ResultBuilder.success(
         this.warehouseSummaryService.listEnclosurePrint(projectId, planId, category, name, serialNumber, specification, material, pageNumber, pageSize)
      );
   }

   @ApiOperation("添加构件(外购)打印记录")
   @PostMapping("/artifact/print")
   public ResultVO saveTaskRecord(@RequestBody @Valid PrintReportDTOParam param) {
      log.info("API 调用 ：添加构件(外购)打印记录");
      return ResultBuilder.success(this.printBiz.savePrintRecord(PrintTypeEnum.WAREHOUSE.getType(), param));
   }

   @ApiOperation("新增围护(外购)打印记录")
   @PostMapping("/enclosure/print")
   public ResultVO savePrint(@RequestBody WareSubscribePrintDTO printDTO) {
      log.info("API 调用 ：新增围护打印记录");
      return ResultBuilder.success(this.printBiz.savePrint(printDTO.getWarehouseId(), printDTO.getQuantity()));
   }

   @ApiOperation("构件(外购)打印记录列表")
   @GetMapping("/record/artifact/{warehouseId}")
   public ResultVO listTaskRecord(@PathVariable Long warehouseId) {
      log.info("API 调用 ：构件(外购)打印记录列表");
      return ResultBuilder.success(this.printRecordService.listPrintRecord(warehouseId, PrintTypeEnum.WAREHOUSE.getType()));
   }

   @ApiOperation("查询围护(外购)打印记录")
   @GetMapping("/record/enclosure/{warehouseId}")
   public ResultVO<List<EnclosurePrint>> getPrint(Long warehouseId) {
      log.info("API 调用 ：查询围护(外购)打印记录");
      return ResultBuilder.success(this.enclosurePrintService.getwarehousePrint(warehouseId));
   }

   @ApiOperation("产品标签-配套件列表")
   @GetMapping("auxiliary-material")
   public ResultVO listTechStandardPartPrint(@Valid AuxiliaryMaterialPrintDTOParam param) {
      log.info("API 调用 ：产品标签-配套件列表");
      return ResultBuilder.success(this.warehouseSummaryService.listTechStandardPartPrint(param));
   }

   @ApiOperation("添加配套件打印记录")
   @PostMapping("/auxiliary/print")
   public ResultVO saveAuxiliaryRecordPrint(@RequestBody @Valid PrintReportDTOParam param) {
      log.info("API 调用 ：添加配套件打印记录");
      return ResultBuilder.success(this.printBiz.savePrintRecord(PrintTypeEnum.WAREHOUSE.getType(), param));
   }

   @ApiOperation("配套件打印记录列表")
   @GetMapping("/record/auxiliary/{warehouseId}")
   public ResultVO listAuxiliaryRecord(@PathVariable Long warehouseId) {
      log.info("API 调用 ：配套件打印记录列表");
      return ResultBuilder.success(this.printRecordService.listPrintRecord(warehouseId, PrintTypeEnum.WAREHOUSE.getType()));
   }
}
