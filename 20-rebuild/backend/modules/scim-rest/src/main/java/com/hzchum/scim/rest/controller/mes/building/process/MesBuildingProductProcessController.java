package com.hzchum.scim.rest.controller.mes.building.process;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProductProcessBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.AssembleConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.ProductProcessApplyAllDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.process.productProcess.post.ProductProcessApplyAllVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.process.productProcess.put.ProductProcessUpdateVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES总工序")
@RestController
@RequestMapping("/api/mes/building/productProcess")
public class MesBuildingProductProcessController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProductProcessController.class);
   @Autowired
   private MesBuildingProductProcessBiz productProcessBiz;

   @ApiOperation("列表-构件种类工序")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "classificationName", value = "构件种类", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "构件规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query"),
            @ApiImplicitParam(name = "sectionAndNameAndType", value = "类型和前缀", paramType = "query")
      }
   )
   @GetMapping("/artifact")
   @PreAuthorize("@permission.check('product_process_artifact:get')")
   public ResultVO artifactProcessPage(
      Integer productionLineTypeEnum,
      String classificationName,
      String specPrefix,
      @RequestParam Integer mesProductEnum,
      @RequestParam(required = false) String sectionAndNameAndType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:分页查询构件种工序类列表");
      return ResultBuilder.success(
         this.productProcessBiz
            .artifactProcessPage(productionLineTypeEnum, classificationName, specPrefix, mesProductEnum, sectionAndNameAndType, pageNumber, pageSize)
      );
   }

   @ApiOperation("列表-构件种类工序")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "classificationName", value = "构件种类", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "构件规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes产品分类", paramType = "query")
      }
   )
   @GetMapping("/v2/artifact")
   @PreAuthorize("@permission.check('product_process_artifact:get')")
   public ResultVO artifactProcessPage2(
      String classificationName,
      String specPrefix,
      Integer artifactType,
      @RequestParam Integer mesProductEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:分页查询构件种工序类列表");
      return ResultBuilder.success(
         this.productProcessBiz.artifactProcessPage2(classificationName, specPrefix, artifactType, mesProductEnum, pageNumber, pageSize)
      );
   }

   @ApiOperation("列表-构件类型与工序")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "classificationName", value = "构件种类", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "构件规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query")
      }
   )
   @GetMapping("/artifact/list")
   public ResultVO artifactProcessPage(Integer productionLineTypeEnum, String classificationName, String specPrefix, @RequestParam Integer mesProductEnum) {
      log.info("Api调用:查询构件类型与工序列表");
      return ResultBuilder.success(this.productProcessBiz.artifactProcessList(productionLineTypeEnum, classificationName, specPrefix, mesProductEnum));
   }

   @ApiOperation("种类关联工序列表")
   @GetMapping("/classPorcessLink")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "lineId", value = "产线id", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "种类id", paramType = "query"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "任务类型", paramType = "query")
      }
   )
   public ResultVO classConfigProcessLink(
      @NotNull(message = "产线不能为空") Long lineId, @NotNull(message = "种类不能为空") Long classId, @NotNull(message = "类型不能为空") Integer taskTypeEnum
   ) {
      log.info("Api调用:种类关联工序列表");
      return ResultBuilder.success(new ListVO<>(this.productProcessBiz.classConfigProcessLink(lineId, classId, taskTypeEnum)));
   }

   @ApiOperation("应用全部-种类列表")
   @GetMapping("/applyAllList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "lineId", value = "产线id", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "种类id", paramType = "query"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "任务类型", paramType = "query")
      }
   )
   public ResultVO applyAllClassList(
      @NotNull(message = "产线不能为空") Long lineId, @NotNull(message = "类型不能为空") Integer taskTypeEnum, @RequestParam Integer mesProductEnum
   ) {
      log.info("Api调用: 应用全部-种类列表");
      return ResultBuilder.success(new ListVO<>(this.productProcessBiz.applyAllClassList(lineId, taskTypeEnum, mesProductEnum)));
   }

   @ApiOperation("工序应用全部")
   @PostMapping("/applyAll")
   @PreAuthorize("@permission.check('product_process_artifact:edit','product_process_assemble:edit','product_process_machine_part:edit')")
   public ResultVO ApplyAll(@RequestBody @Valid ProductProcessApplyAllVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：工序应用全部");
      return ResultBuilder.success(this.productProcessBiz.ApplyAll(BeanUtil.copy(request, ProductProcessApplyAllDTOParam.class)));
   }

   @ApiOperation("组立配置工序分页列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "组立名称", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "组立规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query")
      }
   )
   @GetMapping("/assemble")
   @PreAuthorize("@permission.check('product_process_assemble:get')")
   public ResultVO<PageVO<AssembleConfigDTO>> assembleProcessPage(
      @RequestParam(required = false) Boolean boolSectionSteel,
      Integer productionLineTypeEnum,
      String name,
      String specPrefix,
      @RequestParam Integer mesProductEnum,
      @RequestParam(required = false) String sectionAndNameAndType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:组立配置分页列表");
      return ResultBuilder.success(
         this.productProcessBiz
            .assembleProcessPage(boolSectionSteel, productionLineTypeEnum, name, specPrefix, mesProductEnum, sectionAndNameAndType, pageNumber, pageSize)
      );
   }

   @ApiOperation("组立配置工序分页列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "组立名称", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "组立规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query")
      }
   )
   @GetMapping("/v2/assemble")
   @PreAuthorize("@permission.check('product_process_assemble:get')")
   public ResultVO<PageVO<AssembleConfigDTO>> assembleProcessPage2(
      @RequestParam(required = false) Boolean boolSectionSteel,
      Long lineId,
      String name,
      String specPrefix,
      @RequestParam Integer mesProductEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:组立配置分页列表");
      return ResultBuilder.success(this.productProcessBiz.assembleProcessPage2(lineId, name, specPrefix, mesProductEnum, pageNumber, pageSize));
   }

   @ApiOperation("查询组立类型与工序列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "组立名称", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "组立规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query")
      }
   )
   @GetMapping("/assemble/list")
   public ResultVO assembleProcessList(Integer productionLineTypeEnum, String name, String specPrefix, @RequestParam Integer mesProductEnum) {
      log.info("Api调用: 查询组立类型与工序列表");
      return ResultBuilder.success(this.productProcessBiz.assembleProcessList(productionLineTypeEnum, name, specPrefix, mesProductEnum));
   }

   @ApiOperation("零件配置工序分页列表")
   @GetMapping("/machine_part")
   @PreAuthorize("@permission.check('product_process_machine_part:get')")
   public ResultVO machinePartProcessList(
      @RequestParam(required = false) Integer productClassificationEnum,
      @RequestParam Integer mesProductEnum,
      @RequestParam(required = false) String sectionAndNameAndType
   ) {
      log.info("API 调用 ：零件配置工序分页列表");
      return ResultBuilder.success(
         new ListVO<>(this.productProcessBiz.machinePartProcessList(productClassificationEnum, mesProductEnum, sectionAndNameAndType))
      );
   }

   @ApiOperation("零件配置工序分页列表")
   @GetMapping("/v2/machine_part")
   @PreAuthorize("@permission.check('product_process_machine_part:get')")
   public ResultVO machinePartProcessList2(@RequestParam Integer mesProductEnum, Integer pageNumber, Integer pageSize) {
      log.info("API 调用 ：零件配置工序分页列表");
      return ResultBuilder.success(this.productProcessBiz.oldMachinePartProcessList(mesProductEnum, pageNumber, pageSize));
   }

   @ApiOperation("修改总工序")
   @PutMapping
   @PreAuthorize("@permission.check('product_process_artifact:edit','product_process_assemble:edit','product_process_machine_part:edit')")
   public ResultVO ProductProcessUpdate(@RequestBody @Valid ProductProcessUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改总工序");
      Preconditions.checkArgument(request.getTypeId() != null, "typeId不能为空");
      return ResultBuilder.success(this.productProcessBiz.updateProductProcess(BeanUtil.copy(request, MesBuildingProductProcessDTOParam.class)));
   }

   @ApiOperation("修改总工序")
   @PutMapping("/update2")
   @PreAuthorize("@permission.check('product_process_artifact:edit','product_process_assemble:edit','product_process_machine_part:edit')")
   public ResultVO ProductProcessUpdate(@RequestBody @Valid MesBuildingProductProcessDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改总工序");
      return ResultBuilder.success(this.productProcessBiz.updateProductProcess2(request));
   }

   @ApiOperation("获取零件制造工序关键字母列表")
   @GetMapping("/manufacture")
   public ResultVO manufactureParList(@RequestParam Integer mesProductEnum) {
      log.info("API 调用 ：获取零件制造工序关键字母列表");
      return ResultBuilder.success(new ListVO<>(this.productProcessBiz.manufactureParList(mesProductEnum)));
   }

   @ApiOperation("构件类型工序选择列表")
   @GetMapping("/artifact-type-process-select")
   public ResultVO artifactTypeProcessSelect(
      @ApiParam("构件分类") @RequestParam(required = false) Integer artifactClassification, @RequestParam Integer mesProductEnum
   ) {
      log.info("API 调用 ：构件类型工序选择列表");
      return ResultBuilder.success(new ListVO<>(this.productProcessBiz.artifactTypeProcessSelect(artifactClassification, mesProductEnum)));
   }

   @ApiOperation("部件类型工序选择列表")
   @GetMapping("/assemble-type-process-select")
   public ResultVO assembleTypeProcessSelect(@RequestParam Integer mesProductEnum) {
      log.info("API 调用 ：部件类型工序选择列表");
      return ResultBuilder.success(new ListVO<>(this.productProcessBiz.assembleTypeProcessSelect(mesProductEnum)));
   }

   @ApiOperation("零件类型工序选择列表")
   @GetMapping("/machine-part-type-process-select")
   public ResultVO machinePartTypeProcessSelect(
      @ApiParam("零件分类") @RequestParam(required = false) Integer machinePartClassification, @RequestParam Integer mesProductEnum
   ) {
      log.info("API 调用 ：零件类型工序选择列表");
      return ResultBuilder.success(new ListVO<>(this.productProcessBiz.machinePartTypeProcessSelect(machinePartClassification, mesProductEnum)));
   }
}
