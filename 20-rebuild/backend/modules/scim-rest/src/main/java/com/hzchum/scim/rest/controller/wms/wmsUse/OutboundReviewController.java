package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateOutboundDTOParam;
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

@Api(tags = "wms-出库审核")
@RestController
@RequestMapping("/api/wms/outbound/application")
public class OutboundReviewController {
   private static final Logger log = LoggerFactory.getLogger(OutboundReviewController.class);
   @Resource
   OutboundService outboundService;

   @ApiOperation("审核页面查询")
   @GetMapping("/review/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_review:get')")
   public ResultVO list(
      QueryOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：审核页面查询");
      param.setType(1);
      return ResultBuilder.success(this.outboundService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("获取未审核出库单ID集")
   @GetMapping("/review/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_review:get','wms_rawMat_outbound_review_partyA:review','wms_rawMat_outbound_review_self:review')")
   public ResultVO getIds(QueryOutboundDTOParam param) {
      log.info("API 调用 ：获取未审核出库单ID集");
      param.setType(1);
      return ResultBuilder.success(this.outboundService.getIds(param));
   }

   @ApiOperation("根据ID获取未出库清单")
   @GetMapping("/review/raw-materials/{id}")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取未出库清单");
      return ResultBuilder.success(this.outboundService.getOutboundById(id));
   }

   @ApiOperation("删除出库单")
   @PutMapping("/review/raw-materials/{id}/returned")
   public ResultVO returned(@PathVariable("id") Long id) {
      log.info("API 调用 ：删除出库单");
      return ResultBuilder.success(this.outboundService.returned(id));
   }

   @ApiOperation("根据ID删除对应的单条出库详情")
   @PutMapping("/review/raw-materials/material-del")
   @PreAuthorize(
      "@permission.check('wms_rawMat_outbound_review:review','wms_rawMat_outbound_review_self:review','wms_rawMat_outbound_review_partyA:review',"
         + "'wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound',"
         + "'wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_auxMaterial_self:outbound','wms_matWarehouse_auxMaterial_partyA:outbound',"
         + "'wms_matWarehouse_gas:outbound','wms_matWarehouse_gas_self:outbound','wms_matWarehouse_gas_partyA:outbound',"
         + "'wms_matWarehouse_other:outbound','wms_matWarehouse_other_self:outbound','wms_matWarehouse_other_partyA:outbound')"
   )
   public ResultVO delete(Long listId, Long materialId) {
      log.info("API 调用 ：根据ID删除对应的单条出库详情");
      return ResultBuilder.success(this.outboundService.delete(listId, materialId));
   }

   @ApiOperation("查询当前用户未审核的出库单")
   @GetMapping("/review/raw-materials/current-user")
   public ResultVO getByCurrentUser() {
      log.info("API 调用 ：查询当前用户未审核的出库单");
      return ResultBuilder.success(this.outboundService.getByCurrentUser());
   }

   @ApiOperation("查询当前用户未审核的出库单")
   @GetMapping("/review/raw-materials/current-user/detail-number")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_gas:outbound','wms_matWarehouse_other:outbound')"
   )
   public ResultVO getDetailNumber() {
      log.info("API 调用 ：查询当前用户未审核的出库单");
      return ResultBuilder.success(this.outboundService.getDetailNumber());
   }

   @ApiOperation("修改出库清单详情数据")
   @PutMapping("/review/raw-materials/material-update")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound',"
         + "'wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_auxMaterial_self:outbound','wms_matWarehouse_auxMaterial_partyA:outbound',"
         + "'wms_matWarehouse_gas:outbound','wms_matWarehouse_gas_self:outbound','wms_matWarehouse_gas_partyA:outbound',"
         + "'wms_matWarehouse_other:outbound','wms_matWarehouse_other_self:outbound','wms_matWarehouse_other_partyA:outbound')"
   )
   @SignerCheck(lockKey = "#param.id", message = "该单据正在编辑，请稍后再试")
   public ResultVO updateOutboundDetail(@Valid @RequestBody UpdateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改出库清单详情数据");
      return ResultBuilder.success(this.outboundService.updateOutboundDetail(param));
   }
}
