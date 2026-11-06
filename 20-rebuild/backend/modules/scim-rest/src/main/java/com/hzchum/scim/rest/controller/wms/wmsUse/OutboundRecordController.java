package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-出库申请")
@RestController
@RequestMapping("/api/wms/outbound/application")
public class OutboundRecordController {
   private static final Logger log = LoggerFactory.getLogger(OutboundRecordController.class);
   @Resource
   OutboundService outboundService;

   @ApiOperation("根据条件分页查询以审核出库单列表")
   @GetMapping("/record/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_record:get')")
   public ResultVO list(
      QueryOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询以审核出库单列表");
      param.setType(2);
      return ResultBuilder.success(this.outboundService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取出库清单")
   @GetMapping("/record/raw-materials/{id}")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取出库清单");
      return ResultBuilder.success(this.outboundService.getOutboundById(id));
   }

   @ApiOperation("钢板申请出库")
   @PutMapping("/steel-plate")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO steelPlate(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢板申请出库");
      return ResultBuilder.success(this.outboundService.saveOutbound(param));
   }

   @ApiOperation("型钢申请出库")
   @PutMapping("/section-steel")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO sectionSteel(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：型钢申请出库");
      return ResultBuilder.success(this.outboundService.saveOutbound(param));
   }

   @ApiOperation("钢卷申请出库")
   @PutMapping("/steel-coil")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO steelCoil(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢卷申请出库");
      return ResultBuilder.success(this.outboundService.saveOutbound(param));
   }

   @ApiOperation("辅材申请出库")
   @PutMapping("/auxiliary-material")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_auxMaterial_self:outbound','wms_matWarehouse_auxMaterial_partyA:outbound')"
   )
   public ResultVO auxiliaryMaterial(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：辅材申请出库");
      return ResultBuilder.success(this.outboundService.saveOutbound(param));
   }

   @ApiOperation("其它申请出库")
   @PutMapping("/other-material")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:outbound','wms_matWarehouse_other_partyA:outbound','wms_matWarehouse_other_self:outbound')")
   public ResultVO otherMaterial(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：其它申请出库");
      return ResultBuilder.success(this.outboundService.saveOutbound(param));
   }

   @ApiOperation("气体申请出库")
   @PutMapping("/gas")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:outbound','wms_matWarehouse_gas_self:outbound','wms_matWarehouse_gas_partyA:outbound')")
   public ResultVO ges(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：气体申请出库");
      return ResultBuilder.success(this.outboundService.saveOutbound(param));
   }

   @ApiOperation("钢板批量出库")
   @PutMapping("/steel-plate/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO steelPlateBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢板批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutbound(param));
   }

   @ApiOperation("型材批量出库")
   @PutMapping("/section-steel/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO sectionSteelBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：型材批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutbound(param));
   }

   @ApiOperation("钢卷批量出库")
   @PutMapping("/steel-coil/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO steelCoilBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢卷批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutbound(param));
   }

   @ApiOperation("辅材批量出库")
   @PutMapping("/auxiliary-material/batch")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_auxMaterial_self:outbound','wms_matWarehouse_auxMaterial_partyA:outbound')"
   )
   public ResultVO auxiliaryMaterialBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：辅材批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutbound(param));
   }

   @ApiOperation("其它批量出库")
   @PutMapping("/other-material/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:outbound','wms_matWarehouse_other_self:outbound','wms_matWarehouse_other_partyA:outbound')")
   public ResultVO otherMaterialBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：其它批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutbound(param));
   }

   @ApiOperation("气体批量出库")
   @PutMapping("/gas/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:outbound','wms_matWarehouse_gas_self:outbound','wms_matWarehouse_gas_partyA:outbound')")
   public ResultVO gasBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：气体批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutbound(param));
   }

   @ApiOperation("查询已出库辅材和气体")
   @GetMapping("/use-classify")
   public ResultVO list(String year) {
      log.info("API 调用 ：查询已出库辅材和气体");
      return ResultBuilder.success(this.outboundService.getUseByYear(year));
   }

   @ApiOperation("手动冻结钢板申请出库")
   @PutMapping("/manuallyFreezeDirectSteelPlateOutbound")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO manuallyFreezeDirectSteelPlateOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：手动冻结申请出库");
      return ResultBuilder.success(this.outboundService.manuallyFreezeDirectOutbound(param));
   }

   @ApiOperation("手动冻结型钢申请出库")
   @PutMapping("/manuallyFreezeDirectSectionSteelOutbound")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO manuallyFreezeDirectSectionSteelOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：型钢申请出库");
      return ResultBuilder.success(this.outboundService.manuallyFreezeDirectOutbound(param));
   }

   @ApiOperation("手动冻结钢卷申请出库")
   @PutMapping("/manuallyFreezeDirectSteelCoilOutbound")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound')")
   public ResultVO manuallyFreezeDirectSteelCoilOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢卷申请出库");
      return ResultBuilder.success(this.outboundService.manuallyFreezeDirectOutbound(param));
   }

   @ApiOperation("手动冻结辅材申请出库")
   @PutMapping("/manuallyFreezeDirectAuxiliaryMaterialOutbound")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_auxMaterial_self:outbound','wms_matWarehouse_auxMaterial_partyA:outbound')"
   )
   public ResultVO manuallyFreezeDirectAuxiliaryMaterialOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：手动冻结申请出库");
      return ResultBuilder.success(this.outboundService.manuallyFreezeDirectOutbound(param));
   }

   @ApiOperation("手动冻结其它申请出库")
   @PutMapping("/manuallyFreezeDirectOtherMaterialOutbound")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:outbound','wms_matWarehouse_other_self:outbound','wms_matWarehouse_other_partyA:outbound')")
   public ResultVO manuallyFreezeDirectOtherMaterialOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：手动冻结申请出库");
      return ResultBuilder.success(this.outboundService.manuallyFreezeDirectOutbound(param));
   }

   @ApiOperation("手动冻结气体申请出库")
   @PutMapping("/manuallyFreezeDirectGasOutbound")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:outbound','wms_matWarehouse_gas_self:outbound','wms_matWarehouse_gas_partyA:outbound')")
   public ResultVO manuallyFreezeDirectGasOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：手动冻结申请出库");
      return ResultBuilder.success(this.outboundService.manuallyFreezeDirectOutbound(param));
   }
}
