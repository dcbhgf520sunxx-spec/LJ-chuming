package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
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
@RequestMapping("/api/v2/wms/outbound/application")
public class OutboundRecordControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(OutboundRecordControllerV2.class);
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
      return ResultBuilder.success(this.outboundService.pageInfoV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取出库清单V2")
   @GetMapping("/record/raw-materials/{id}")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取出库清单V2");
      return ResultBuilder.success(this.outboundService.getOutboundByIdV2(id));
   }

   @ApiOperation("查询已出库辅材和气体V2")
   @GetMapping("/use-classify")
   public ResultVO list(String year) {
      log.info("API 调用 ：查询已出库辅材和气体V2");
      return ResultBuilder.success(this.outboundService.getUseByYear(year));
   }

   @ApiOperation("外协原料申请出库")
   @PutMapping("/outsourcing")
   @PreAuthorize("@stockOutboundAccess.single(#p0.materialId)")
   public ResultVO OutsourcingOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：外协原料申请出库");
      return ResultBuilder.success(this.outboundService.outsourcingDirectSubmitReview(param));
   }

   @ApiOperation("外协原料批量出库")
   @PutMapping("/OutsourcingOutboundBatch")
   @PreAuthorize("@stockOutboundAccess.batch(#p0)")
   public ResultVO OutsourcingOutboundBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：外协原料批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutsourcingSubmitReview(param));
   }

   @ApiOperation("废料申请出库")
   @PutMapping("/scraps")
   public ResultVO ScrapsOutbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：废料申请出库");
      return ResultBuilder.success(this.outboundService.outsourcingDirectSubmitReview(param));
   }

   @ApiOperation("废料批量出库")
   @PutMapping("/ScrapsOutboundBatch")
   public ResultVO ScrapsOutboundBatch(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：废料批量出库");
      return ResultBuilder.success(this.outboundService.BatchOutsourcingSubmitReview(param));
   }

   @ApiOperation("申请出库 -> 对外出售 -> 保存至出库清单")
   @PutMapping("/save/forSale")
   @PreAuthorize("@stockOutboundAccess.single(#p0.materialId)")
   public ResultVO saveForSale(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：申请出库 -> 对外出售 -> 保存至出库清单");
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.outboundService.saveForSaleOutbound(param));
   }

   @ApiOperation("申请出库 -> 对外出售 -> 提交审核")
   @PutMapping("/submit/forSale")
   public ResultVO submitForSale(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：申请出库 -> 对外出售 -> 提交审核");
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.outboundService.submitForSaleOutbound(param));
   }

   @ApiOperation("批量申请出库 -> 对外出售 -> 保存至出库清单")
   @PutMapping("/save/forSale/batch")
   @PreAuthorize("@stockOutboundAccess.batch(#p0)")
   public ResultVO bathSaveForSale(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量申请出库 -> 对外出售 -> 保存至出库清单");
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.outboundService.BatchSaveForSale(param));
   }

   @ApiOperation("批量申请出库 -> 对外出售 -> 提交审核")
   @PutMapping("/submit/forSale/batch")
   @PreAuthorize("@stockOutboundAccess.batch(#p0)")
   public ResultVO bathSubmitForSale(@Valid @RequestBody BatchOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量申请出库 -> 对外出售 -> 提交审核");
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.outboundService.BatchSubmitForSale(param));
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

   @ApiOperation("手动冻结 -> 申请出库 -> 对外出售 -> 保存至出库清单")
   @PutMapping("/save/manuallyFreezeSaveForSale")
   public ResultVO manuallyFreezeSaveForSale(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：手动冻结 -> 申请出库 -> 对外出售 -> 保存至出库清单");
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.outboundService.manuallyFreezeSaveForSaleOutbound(param));
   }

   @ApiOperation("手动冻结 -> 申请出库 -> 对外出售 -> 提交审核")
   @PutMapping("/submit/manuallyFreezeSubmitForSale")
   public ResultVO manuallyFreezeSubmitForSale(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：手动冻结 -> 申请出库 -> 对外出售 -> 提交审核");
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.outboundService.manuallyFreezeSubmitForSaleOutbound(param));
   }

   @ApiOperation("获取物料领用情况")
   @GetMapping("/materialUseAndDeepMete")
   public ResultVO getMaterialUseAndDeepMete(@RequestParam Long projectId, @RequestParam Long classifyId) {
      log.info("API 调用 ：获取物料领用情况");
      return ResultBuilder.success(this.outboundService.getMaterialUseAndDeepMete(projectId, classifyId));
   }
}
