package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.FreezeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryFreezeDetailsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UnfreezeDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-冻结管理")
@RestController
@RequestMapping("/api/wms/freeze")
public class FreezeController {
   private static final Logger log = LoggerFactory.getLogger(FreezeController.class);
   @Resource
   MaterialFreezeService materialFreezeService;

   @ApiOperation("查询冻结列表")
   @GetMapping("/raw-material")
   @PreAuthorize("@permission.check('wms_rawMat_freeze_list:get')")
   public ResultVO list(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询冻结列表");
      return ResultBuilder.success(this.materialFreezeService.freezePageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询冻结单据列表")
   @GetMapping("/raw-material-receipt")
   public ResultVO freezeRecordPageInfo(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询冻结单据列表");
      return ResultBuilder.success(this.materialFreezeService.freezeRecordPageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询冻结单据详情")
   @GetMapping("/raw-material-details")
   public ResultVO getFreezeDetails(
      QueryFreezeDetailsDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：查询冻结单据详情");
      return ResultBuilder.success(this.materialFreezeService.getFreezeDetails(param, pageNumber, pageSize));
   }

   @ApiOperation("查询解冻列表")
   @GetMapping("/raw-material/unfreeze")
   @PreAuthorize("@permission.check('wms_rawMat_unfreeze_list:get')")
   public ResultVO getUnfreeze(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询解冻列表");
      return ResultBuilder.success(this.materialFreezeService.unfreezePageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询冻结详情列表")
   @GetMapping("/raw-material/record")
   @PreAuthorize("@permission.check('wms_rawMat_freeze_list:get','wms_rawMat_material_freeze:detail')")
   public ResultVO getRecord(Long materialId) {
      log.info("API 调用 ：查询冻结详情列表");
      return ResultBuilder.success(this.materialFreezeService.getRecord(materialId));
   }

   @ApiOperation("解除冻结")
   @PutMapping("/raw-material/unfreeze")
   @PreAuthorize(
      "@permission.check('wms_rawMat_freeze_list:unfreeze_outbound','wms_rawMat_freeze_list:unfreeze_transfer','wms_rawMat_freeze_list:unfreeze_reject')"
   )
   public ResultVO setUnfreeze(@RequestBody UnfreezeDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：解除冻结");
      return ResultBuilder.success(this.materialFreezeService.setUnfreeze(param));
   }

   @ApiOperation("钢板手动冻结")
   @PutMapping("/raw-material/steelPlateManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:freeze','wms_matWarehouse_steel_self:freeze','wms_matWarehouse_steel_partyA:freeze')")
   public ResultVO steelPlateManualFreeze(@Valid @RequestBody FreezeDTOParam freezeDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 钢板手动冻结");
      return ResultBuilder.success(this.materialFreezeService.ManualFreeze(freezeDTOParam));
   }

   @ApiOperation("型材手动冻结")
   @PutMapping("/raw-material/sectionSteelManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:freeze','wms_matWarehouse_steel_self:freeze','wms_matWarehouse_steel_partyA:freeze')")
   public ResultVO sectionSteelManualFreeze(@Valid @RequestBody FreezeDTOParam freezeDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 型材手动冻结");
      return ResultBuilder.success(this.materialFreezeService.ManualFreeze(freezeDTOParam));
   }

   @ApiOperation("钢卷手动冻结")
   @PutMapping("/raw-material/steelCoilManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:freeze','wms_matWarehouse_steel_self:freeze','wms_matWarehouse_steel_partyA:freeze')")
   public ResultVO steelCoilManualFreeze(@Valid @RequestBody FreezeDTOParam freezeDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 钢卷手动冻结");
      return ResultBuilder.success(this.materialFreezeService.ManualFreeze(freezeDTOParam));
   }

   @ApiOperation("辅材手动冻结")
   @PutMapping("/raw-material/auxiliaryMaterialManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_auxMaterial:freeze','wms_matWarehouse_auxMaterial_self:freeze','wms_matWarehouse_auxMaterial_partyA:freeze')")
   public ResultVO auxiliaryMaterialManualFreeze(@Valid @RequestBody FreezeDTOParam freezeDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 辅材手动冻结");
      return ResultBuilder.success(this.materialFreezeService.ManualFreeze(freezeDTOParam));
   }

   @ApiOperation("办公用品手动冻结")
   @PutMapping("/raw-material/otherMaterialManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:freeze','wms_matWarehouse_other_self:freeze','wms_matWarehouse_other_partyA:freeze')")
   public ResultVO otherMaterialManualFreeze(@Valid @RequestBody FreezeDTOParam freezeDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 其它手动冻结");
      return ResultBuilder.success(this.materialFreezeService.ManualFreeze(freezeDTOParam));
   }

   @ApiOperation("气体手动冻结")
   @PutMapping("/raw-material/gesManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:freeze','wms_matWarehouse_gas_self:freeze','wms_matWarehouse_gas_partyA:freeze')")
   public ResultVO gesManualFreeze(@Valid @RequestBody FreezeDTOParam freezeDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 气体手动冻结");
      return ResultBuilder.success(this.materialFreezeService.ManualFreeze(freezeDTOParam));
   }

   @ApiOperation("钢板手动批量冻结")
   @PutMapping("/raw-material/steelPlateBatchManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:freeze','wms_matWarehouse_steel_self:freeze','wms_matWarehouse_steel_partyA:freeze')")
   public ResultVO steelPlateBatchManualFreeze(@Valid @RequestBody List<FreezeDTOParam> freezeDTOParams, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 钢板手动批量冻结");
      return ResultBuilder.success(this.materialFreezeService.BatchManualFreeze(freezeDTOParams));
   }

   @ApiOperation("型材手动批量冻结")
   @PutMapping("/raw-material/sectionSteelBatchManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:freeze','wms_matWarehouse_steel_self:freeze','wms_matWarehouse_steel_partyA:freeze')")
   public ResultVO sectionSteelBatchManualFreeze(@Valid @RequestBody List<FreezeDTOParam> freezeDTOParams, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 钢板手动批量冻结");
      return ResultBuilder.success(this.materialFreezeService.BatchManualFreeze(freezeDTOParams));
   }

   @ApiOperation("钢卷手动批量冻结")
   @PutMapping("/raw-material/steelCoilBatchManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:freeze','wms_matWarehouse_steel_self:freeze','wms_matWarehouse_steel_partyA:freeze')")
   public ResultVO steelCoilBatchManualFreeze(@Valid @RequestBody List<FreezeDTOParam> freezeDTOParams, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 钢卷手动批量冻结");
      return ResultBuilder.success(this.materialFreezeService.BatchManualFreeze(freezeDTOParams));
   }

   @ApiOperation("辅材手动批量冻结")
   @PutMapping("/raw-material/auxiliaryMaterialBatchManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_auxMaterial:freeze','wms_matWarehouse_auxMaterial_self:freeze','wms_matWarehouse_auxMaterial_partyA:freeze')")
   public ResultVO auxiliaryMaterialBatchManualFreeze(@Valid @RequestBody List<FreezeDTOParam> freezeDTOParams, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 辅材手动批量冻结");
      return ResultBuilder.success(this.materialFreezeService.BatchManualFreeze(freezeDTOParams));
   }

   @ApiOperation("办公用品手动批量冻结")
   @PutMapping("/raw-material/otherMaterialBatchManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:freeze','wms_matWarehouse_other_self:freeze','wms_matWarehouse_other_partyA:freeze')")
   public ResultVO otherMaterialBatchManualFreeze(@Valid @RequestBody List<FreezeDTOParam> freezeDTOParams, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 其它手动批量冻结");
      return ResultBuilder.success(this.materialFreezeService.BatchManualFreeze(freezeDTOParams));
   }

   @ApiOperation("气体手动批量冻结")
   @PutMapping("/raw-material/gesBatchManualFreeze")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:freeze','wms_matWarehouse_gas_self:freeze','wms_matWarehouse_gas_partyA:freeze')")
   public ResultVO gesBatchManualFreeze(@Valid @RequestBody List<FreezeDTOParam> freezeDTOParams, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ： 气体手动批量冻结");
      return ResultBuilder.success(this.materialFreezeService.BatchManualFreeze(freezeDTOParams));
   }
}
