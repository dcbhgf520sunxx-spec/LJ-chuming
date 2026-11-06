package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MoveMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMoveMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-移库主表")
@RestController
@RequestMapping("/api/wms/move_material")
public class MoveMaterialController {
   private static final Logger log = LoggerFactory.getLogger(MoveMaterialController.class);
   @Resource
   private MoveMaterialService moveMaterialService;

   @ApiOperation("获取移库单")
   @GetMapping("/application/review/raw-materials")
   @PreAuthorize(
      "@permission.check('wms_rawMat_moving_inventory_record:get','wms_rawMat_moving_inventory_review:get','wms_rawMat_moving_inventory_self_record:get','wms_rawMat_moving_inventory_party_a_record:get')"
   )
   public ResultVO list(
      QueryMoveMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取移库单");
      return ResultBuilder.success(this.moveMaterialService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取移库单详情")
   @GetMapping("/raw-materials/{id}")
   @PreAuthorize(
      "@permission.check('wms_rawMat_moving_inventory_record:get','wms_rawMat_moving_inventory_review:detail','wms_rawMat_moving_inventory_self_record:get','wms_rawMat_moving_inventory_party_a_record:get')"
   )
   public ResultVO queryById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取移库单详情");
      return ResultBuilder.success(this.moveMaterialService.queryById(id));
   }

   @ApiOperation("钢板移库申请->单个 or 批量")
   @PutMapping("/application/steel-plate")
   @PreAuthorize(
      "@permission.check('wms_moving_inventory_steel:movingInventory','wms_matWarehouse_steel_self:movingInventory','wms_matWarehouse_steel_partyA:movingInventory')"
   )
   public ResultVO steelPlate(@Valid @RequestBody MoveMaterialDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢板移库申请->单个 or 批量");
      return ResultBuilder.success(this.moveMaterialService.saveMoveMaterial(request));
   }

   @ApiOperation("型钢移库申请->单个 or 批量")
   @PutMapping("/application/section-steel")
   @PreAuthorize(
      "@permission.check('wms_moving_inventory_steel:movingInventory','wms_matWarehouse_steel_self:movingInventory','wms_matWarehouse_steel_partyA:movingInventory')"
   )
   public ResultVO sectionSteel(@Valid @RequestBody MoveMaterialDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：型钢移库申请->单个 or 批量");
      return ResultBuilder.success(this.moveMaterialService.saveMoveMaterial(request));
   }

   @ApiOperation("钢卷移库申请->单个 or 批量")
   @PutMapping("/application/steel-coil")
   @PreAuthorize(
      "@permission.check('wms_moving_inventory_steel:movingInventory','wms_matWarehouse_steel_self:movingInventory','wms_matWarehouse_steel_partyA:movingInventory')"
   )
   public ResultVO steelCoil(@Valid @RequestBody MoveMaterialDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢卷移库申请->单个 or 批量");
      return ResultBuilder.success(this.moveMaterialService.saveMoveMaterial(request));
   }

   @ApiOperation("辅材移库申请->单个 or 批量")
   @PutMapping("/application/auxiliary-material")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_auxMaterial:movingInventory','wms_matWarehouse_auxMaterial_self:movingInventory','wms_matWarehouse_auxMaterial_partyA:movingInventory')"
   )
   public ResultVO auxiliaryMaterial(@Valid @RequestBody MoveMaterialDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：辅材移库申请->单个 or 批量");
      return ResultBuilder.success(this.moveMaterialService.saveMoveMaterial(request));
   }

   @ApiOperation("其它移库申请->单个 or 批量")
   @PutMapping("/application/other-material")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_other:movingInventory','wms_matWarehouse_other_self:movingInventory','wms_matWarehouse_other_partyA:movingInventory')"
   )
   public ResultVO otherMaterial(@Valid @RequestBody MoveMaterialDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：其它移库申请->单个 or 批量");
      return ResultBuilder.success(this.moveMaterialService.saveMoveMaterial(request));
   }

   @ApiOperation("气体移库申请->单个 or 批量")
   @PutMapping("/application/gas")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_gas:movingInventory','wms_matWarehouse_gas_self:movingInventory','wms_matWarehouse_gas_partyA:movingInventory')"
   )
   public ResultVO gas(@Valid @RequestBody MoveMaterialDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：气体移库申请->单个 or 批量");
      return ResultBuilder.success(this.moveMaterialService.saveMoveMaterial(request));
   }

   @ApiOperation("查询待审核移库单ids")
   @GetMapping("/application/review/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_moving_inventory_review:get')")
   public ResultVO getIds(QueryMoveMaterialDTOParam param) {
      log.info("API 调用 ：查询待审核移库单ids");
      return ResultBuilder.success(this.moveMaterialService.getIds(param));
   }

   @ApiOperation("审核移库单")
   @PutMapping("/review")
   public ResultVO review(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核移库单");
      return ResultBuilder.success(this.moveMaterialService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销移库单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销移库单");
      return ResultBuilder.success(this.moveMaterialService.revocation(id));
   }
}
