package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-供应商结算")
@RestController
@RequestMapping("/api/contract/supplier-settlement")
public class SupplierSettlementController {
   private static final Logger log = LoggerFactory.getLogger(SupplierSettlementController.class);
   @Resource
   private SupplierSettlementService supplierSettlementService;

   @ApiOperation("结算记录列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "订单id", paramType = "query"),
            @ApiImplicitParam(name = "orderClass", value = "订单类别 1原材料订单 2制成品订单 4分包订单", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", paramType = "query")
      }
   )
   @GetMapping("")
   public ResultVO<PageVO<SupplierSettlementDTO>> listSupplierSettlement(
      Long orderId,
      @RequestParam(defaultValue = "1") Integer orderClass,
      Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询采购订单结算记录列表");
      return ResultBuilder.success(this.supplierSettlementService.listSupplierSettlement(orderId, orderClass, auditStatus, pageNumber, pageSize));
   }

   @ApiOperation("新增-原材料采购订单结算")
   @PostMapping("save")
   @PreAuthorize("@permission.check('supplier_material_payment:settle')")
   public ResultVO saveSupplierSettlement(@RequestBody @Valid SupplierSettlementSaveDTOParam param) {
      log.info("Api调用: 新增采购订单结算");
      return ResultBuilder.success(this.supplierSettlementService.saveSupplierSettlement(param));
   }

   @ApiOperation("修改-原材料采购订单结算")
   @PostMapping("update")
   public ResultVO updateSupplierSettlement(@RequestBody @Valid SupplierSettlementUpdateDTOParam param) {
      log.info("Api调用: 修改采购订单结算");
      return ResultBuilder.success(this.supplierSettlementService.updateSupplierSettlement(param));
   }

   @ApiOperation("删除结算")
   @ApiImplicitParam(name = "id", value = "结算记录id", paramType = "path", required = true)
   @DeleteMapping("/del/{id}")
   public ResultVO delSupplierSettlement(@PathVariable Long id) {
      log.info("Api调用: 删除采购订单结算记录");
      return ResultBuilder.success(this.supplierSettlementService.delSupplierSettlement(id));
   }

   @ApiOperation("审核-原材料订单结算")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "订单id", paramType = "query", required = true),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态 2通过 4驳回 ", paramType = "query", required = true)
      }
   )
   @PutMapping("/check")
   @PreAuthorize("@permission.check('contract_supplier_material:settleAudit')")
   public ResultVO checkSupplierSettlement(@RequestParam Long orderId, @RequestParam Integer auditStatus) {
      log.info("Api调用: 审核采购订单结算");
      return ResultBuilder.success(this.supplierSettlementService.checkSupplierSettlement(orderId, auditStatus));
   }
}
