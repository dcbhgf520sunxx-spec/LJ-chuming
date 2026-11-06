package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferBuyInDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferReviewDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

@Api(tags = "wms-调拨")
@RestController
@RequestMapping("/api/wms/transfer")
public class TransferController {
   private static final Logger log = LoggerFactory.getLogger(TransferController.class);
   @Resource
   TransferService transferService;

   @ApiOperation("获取调拨单")
   @GetMapping("/application/review/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:get')")
   public ResultVO list(
      QueryTransferDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取调拨单");
      return ResultBuilder.success(this.transferService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取调拨单信息")
   @GetMapping("/application/review/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:get','wms_rawMat_transfer_review:detail')")
   public ResultVO queryById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取调拨单信息");
      return ResultBuilder.success(this.transferService.queryById(id));
   }

   @ApiOperation("查询待审核调拨ids")
   @GetMapping("/application/review/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:get')")
   public ResultVO getIds(QueryTransferDTOParam param) {
      log.info("API 调用 ：查询待审核调拨ids");
      return ResultBuilder.success(this.transferService.getIds(param));
   }

   @ApiOperation("钢板调拨申请")
   @PutMapping("/application/steel-plate")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:transfer','wms_matWarehouse_steel_self:transfer','wms_matWarehouse_steel_partyA:transfer')")
   public ResultVO steelPlate(@Valid @RequestBody TransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢板调拨申请");
      return ResultBuilder.success(this.transferService.saveTransfer(param));
   }

   @ApiOperation("型钢调拨申请")
   @PutMapping("/application/section-steel")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:transfer','wms_matWarehouse_steel_self:transfer','wms_matWarehouse_steel_partyA:transfer')")
   public ResultVO sectionSteel(@Valid @RequestBody TransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：型钢调拨申请");
      return ResultBuilder.success(this.transferService.saveTransfer(param));
   }

   @ApiOperation("钢卷调拨申请")
   @PutMapping("/application/steel-coil")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:transfer','wms_matWarehouse_steel_self:transfer','wms_matWarehouse_steel_partyA:transfer')")
   public ResultVO steelCoil(@Valid @RequestBody TransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢卷调拨申请");
      return ResultBuilder.success(this.transferService.saveTransfer(param));
   }

   @ApiOperation("辅材调拨申请")
   @PutMapping("/application/auxiliary-material")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_auxMaterial:transfer','wms_matWarehouse_auxMaterial_self:transfer','wms_matWarehouse_auxMaterial_partyA:transfer')"
   )
   public ResultVO auxiliaryMaterial(@Valid @RequestBody TransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：辅材调拨申请");
      return ResultBuilder.success(this.transferService.saveTransfer(param));
   }

   @ApiOperation("其它调拨申请")
   @PutMapping("/application/other-material")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:transfer','wms_matWarehouse_other_self:transfer','wms_matWarehouse_other_partyA:transfer')")
   public ResultVO otherMaterial(@Valid @RequestBody TransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：其它调拨申请");
      return ResultBuilder.success(this.transferService.saveTransfer(param));
   }

   @ApiOperation("气体调拨申请")
   @PutMapping("/application/gas")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:transfer','wms_matWarehouse_gas_self:transfer','wms_matWarehouse_gas_partyA:transfer')")
   public ResultVO gas(@Valid @RequestBody TransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：气体调拨申请");
      return ResultBuilder.success(this.transferService.saveTransfer(param));
   }

   @ApiOperation("钢板批量调拨")
   @PutMapping("/application/steel-plate/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:transfer','wms_matWarehouse_steel_self:transfer','wms_matWarehouse_steel_partyA:transfer')")
   public ResultVO batchTransfer(@Valid @RequestBody BatchTransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢板批量调拨");
      return ResultBuilder.success(this.transferService.batchTransferApplication(param, BasicClassEnum.STEEL_PLATE.getType()));
   }

   @ApiOperation("型材批量调拨")
   @PutMapping("/application/section-steel/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:transfer','wms_matWarehouse_steel_self:transfer','wms_matWarehouse_steel_partyA:transfer')")
   public ResultVO sectionSteel(@Valid @RequestBody BatchTransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：型材批量调拨");
      return ResultBuilder.success(this.transferService.batchTransferApplication(param, BasicClassEnum.SECTION_STEEL.getType()));
   }

   @ApiOperation("钢卷批量调拨")
   @PutMapping("/application/steel-coil/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:transfer','wms_matWarehouse_steel_self:transfer','wms_matWarehouse_steel_partyA:transfer')")
   public ResultVO steelCoil(@Valid @RequestBody BatchTransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢卷批量调拨");
      return ResultBuilder.success(this.transferService.batchTransferApplication(param, BasicClassEnum.COLOR_ROLL.getType()));
   }

   @ApiOperation("辅材批量调拨")
   @PutMapping("/application/auxiliary-material/batch")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_auxMaterial:transfer','wms_matWarehouse_auxMaterial_self:transfer','wms_matWarehouse_auxMaterial_partyA:transfer')"
   )
   public ResultVO auxiliaryMaterial(@Valid @RequestBody BatchTransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：辅材批量调拨");
      return ResultBuilder.success(this.transferService.batchTransferApplication(param, BasicClassEnum.GENERAL_MATERIAL.getType()));
   }

   @ApiOperation("其他材料批量调拨申请")
   @PutMapping("/application/other-material/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:transfer','wms_matWarehouse_other_self:transfer','wms_matWarehouse_other_partyA:transfer')")
   public ResultVO otherMaterialBatchTransfer(@Valid @RequestBody BatchTransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }
      if (param.getTransferType() == null || param.getList() == null || param.getList().isEmpty()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, "调拨类型和明细不能为空");
      }
      return ResultBuilder.success(this.transferService.batchTransferApplication(param, BasicClassEnum.OTHER.getType()));
   }

   @ApiOperation("气体批量调拨")
   @PutMapping("/application/gas/batch")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:transfer','wms_matWarehouse_gas_self:transfer','wms_matWarehouse_gas_partyA:transfer')")
   public ResultVO gas(@Valid @RequestBody BatchTransferDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：气体批量调拨");
      return ResultBuilder.success(this.transferService.batchTransferApplication(param, BasicClassEnum.GAS.getType()));
   }

   @ApiOperation("审核通过")
   @PutMapping("/application/review/raw-materials/passed")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:review')")
   public ResultVO passed(@RequestBody TransferReviewDTOParam param) {
      log.info("API 调用 : 审核通过");
      return ResultBuilder.success(this.transferService.passed(param));
   }

   @ApiOperation("审核退回")
   @PutMapping("/application/review/raw-materials/returned")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:review')")
   public ResultVO returned(Long id, String approvalComments) {
      log.info("API 调用 : 审核退回");
      return ResultBuilder.success(this.transferService.returned(id, approvalComments));
   }

   @ApiOperation("甲供买入列表查询")
   @GetMapping("/party-a-buy-in")
   @PreAuthorize("@permission.check('wms_rawMat_partyABorrow_buyIn:get')")
   public ResultVO getPartyABuyIn(
      QueryTransferBuyInDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：甲供买入列表查询");
      return ResultBuilder.success(this.transferService.getPartyATransfer(param, pageNumber, pageSize, sort, 1));
   }

   @ApiOperation("归还甲方列表查询")
   @GetMapping("/return-to-party-a")
   @PreAuthorize("@permission.check('wms_rawMat_partyABorrow_return:get')")
   public ResultVO getReturnToPartyA(
      QueryTransferBuyInDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：归还甲方列表查询");
      return ResultBuilder.success(this.transferService.getPartyATransfer(param, pageNumber, pageSize, sort, 2));
   }

   @ApiOperation("归还甲方下载")
   @GetMapping("/return-to-party-a/excel")
   @PreAuthorize("@permission.check('wms_rawMat_partyABorrow_return:get')")
   public void excel(
      QueryTransferBuyInDTOParam param,
      HttpServletResponse response,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：归还甲方下载");
      this.transferService.returnExcel(param, TransferTypeEnum.RETURN_PARTY_A.getType(), response, pageNumber, pageSize, sort);
   }

   @ApiOperation("甲供买入记录下载")
   @GetMapping("/party-a-buy-in/excel")
   @PreAuthorize("@permission.check('wms_rawMat_partyABorrow_buyIn:get')")
   public void excel2(
      QueryTransferBuyInDTOParam param,
      HttpServletResponse response,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：甲供买入记录下载");
      this.transferService.returnExcel(param, TransferTypeEnum.BORROW_RETURN.getType(), response, pageNumber, pageSize, sort);
   }
}
