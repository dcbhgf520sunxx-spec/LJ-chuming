package com.hzchum.scim.rest.controller.mes.building.record;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.record.PrintBiz;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintReportDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskArtifactPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskEnclosurePrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskPartPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProjectReturnRepairSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.ProjectReturnRepairQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-打印")
@RestController
@RequestMapping("/api/mes/building/print")
public class PrintController {
   private static final Logger log = LoggerFactory.getLogger(PrintController.class);
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private PrintBiz printBiz;
   @Autowired
   private MesBuildingPrintRecordService printRecordService;
   @Autowired
   private TechAuxiliaryMaterialService auxiliaryMaterialService;
   @Autowired
   private TechStandardPartService standardPartService;

   @ApiOperation("产品标签-构件列表")
   @GetMapping("artifact")
   @PreAuthorize("@permission.check('mes_label_artifact:get')")
   public ResultVO listArtifactPrint(@Valid TaskArtifactPrintDOParam param) {
      log.info("API 调用 ：产品标签-构件列表");
      return ResultBuilder.success(this.taskService.listArtifactPrint(param));
   }

   @ApiOperation(" 产品标签-零件直发件列表")
   @GetMapping("/part")
   public ResultVO listPartPrint(@Valid TaskPartPrintDOParam param) {
      log.info("API 调用 ： 产品标签-零件直发件列表");
      return ResultBuilder.success(this.taskService.listPartPrint(param));
   }

   @ApiOperation("产品标签-围护列表")
   @GetMapping("enclosure")
   public ResultVO listEnclosurePrint(@Valid TaskEnclosurePrintDOParam param) {
      log.info("API 调用 ：产品标签-围护列表");
      return ResultBuilder.success(this.taskService.listEnclosurePrint(param));
   }

   @ApiOperation("产品标签-配套件列表")
   @GetMapping("auxiliary-material")
   public ResultVO listTechStandardPartPrint(@Valid AuxiliaryMaterialPrintDTOParam param) {
      log.info("API 调用 ：产品标签-配套件列表");
      return ResultBuilder.success(this.standardPartService.listTechStandardPartPrint(param));
   }

   @ApiOperation("添加任务（构件、围护）打印记录")
   @PostMapping("/record/task")
   @PreAuthorize("(@permission.check('mes_label_artifact:print','mes_label_artifact:batchPrint') && {1,2}.contains(@mesBuildingTaskServiceImpl.getById(#param.taskId)?.taskTypeEnum)) || (@permission.check('enclosure_label:print','enclosure_label:batchPrint') && @mesBuildingTaskServiceImpl.getById(#param.taskId)?.taskTypeEnum == 4)")
   public ResultVO saveTaskRecord(@RequestBody @Valid PrintReportDTOParam param) {
      log.info("API 调用 ：添加任务（构件、围护）打印记录");
      return ResultBuilder.success(this.printBiz.savePrintRecord(PrintTypeEnum.TASK.getType(), param));
   }

   @ApiOperation(value = "添加包打印记录", notes = "添加包打印记录", nickname = "19")
   @PostMapping("/record/package")
   public ResultVO savePackageRecord(@RequestBody @Valid PrintReportDTOParam param) {
      log.info("API 调用 ：添加包打印记录");
      return ResultBuilder.success(this.printBiz.savePrintRecord(PrintTypeEnum.PACKAGE.getType(), param));
   }

   @ApiOperation("添加材料（配套件）打印记录")
   @PostMapping("/record/material")
   @PreAuthorize("@permission.check('mes_label_auxiliary_material:print','mes_label_auxiliary_material:batchPrint')")
   public ResultVO saveMaterialRecord(@RequestBody @Valid PrintReportDTOParam param) {
      log.info("API 调用 ：添加材料（配套件）打印记录");
      return ResultBuilder.success(this.printBiz.savePrintRecord(PrintTypeEnum.AUXILIARY_MATERIALS.getType(), param));
   }

   @ApiOperation("任务（构件、围护）打印记录列表")
   @GetMapping("/record/task/{taskId}")
   @PreAuthorize("(@permission.check('mes_label_artifact:record') && {1,2}.contains(@mesBuildingTaskServiceImpl.getById(#taskId)?.taskTypeEnum)) || (@permission.check('enclosure_label:record') && @mesBuildingTaskServiceImpl.getById(#taskId)?.taskTypeEnum == 4)")
   public ResultVO listTaskRecord(@PathVariable Long taskId) {
      log.info("API 调用 ：任务（构件、围护）打印记录列表");
      return ResultBuilder.success(this.printRecordService.listPrintRecord(taskId, PrintTypeEnum.TASK.getType()));
   }

   @ApiOperation("包打印记录列表")
   @GetMapping("/record/package/{packageId}")
   @PreAuthorize("@permission.check('mes_pack:printRecords')")
   public ResultVO listPackageRecord(@PathVariable Long packageId) {
      log.info("API 调用 ：包打印记录列表");
      return ResultBuilder.success(this.printRecordService.listPrintRecord(packageId, PrintTypeEnum.PACKAGE.getType()));
   }

   @ApiOperation("材料（辅材）打印记录列表")
   @GetMapping("/record/material/{materialId}")
   @PreAuthorize("@permission.check('mes_label_auxiliary_material:record')")
   public ResultVO listMaterialRecord(@PathVariable Long materialId) {
      log.info("API 调用 ：材料（辅材）打印记录列表");
      return ResultBuilder.success(this.printRecordService.listPrintRecord(materialId, PrintTypeEnum.AUXILIARY_MATERIALS.getType()));
   }

   @ApiOperation("返修构件-项目列表")
   @GetMapping("/returnArtifact/project/list")
   @PreAuthorize("@permission.check('mes_label_return_repair:get')")
   public ResultVO<PageVO<ProjectReturnRepairSummaryDTO>> listReturnProject(
      ProjectReturnRepairQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:标签打印-返修项目列表");
      return ResultBuilder.success(this.printBiz.listArtifactReturnProject(param, pageNumber, pageSize));
   }

   @ApiOperation("返修构件-列表")
   @GetMapping("/returnArtifact/list")
   @PreAuthorize("@permission.check('mes_label_return_repair:get')")
   public ResultVO listReturnProject(@RequestParam Long projectId) {
      log.info("Api调用:标签打印-返修项目列表");
      return ResultBuilder.success(new ListVO<>(this.printBiz.listReturnRepairArtifact(projectId)));
   }

   @ApiOperation("新增退货返修构件-打印")
   @PostMapping("/returnArtifact/print")
   @PreAuthorize("@permission.check('mes_label_return_repair:get')")
   public ResultVO saveReturnArtifactPrint(@RequestBody @Valid PrintReportDTOParam param) {
      log.info("API调用:标签打印-新增退货返修构件打印");
      return ResultBuilder.success(this.printBiz.savePrintRecord(PrintTypeEnum.RETURN_REPAIR.getType(), param));
   }

   @ApiOperation("退货返修构件-打印记录列表")
   @GetMapping("/returnArtifact/{warehouseId}")
   @PreAuthorize("@permission.check('mes_label_return_repair:get')")
   public ResultVO listReturnArtifactPrint(@PathVariable Long warehouseId) {
      log.info("API调用:退货返修构件-打印记录列表");
      return ResultBuilder.success(this.printRecordService.listPrintRecord(warehouseId, PrintTypeEnum.RETURN_REPAIR.getType()));
   }
}
