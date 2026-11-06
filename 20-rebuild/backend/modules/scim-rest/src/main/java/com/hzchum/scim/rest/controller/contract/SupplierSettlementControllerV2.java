package com.hzchum.scim.rest.controller.contract;

import com.google.common.base.Preconditions;
import java.util.Objects;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierSettlementBiz;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderSettlementAddParam;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementAddDTOParam;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-供应商结算")
@RestController
@RequestMapping("/api/contract/supplier-settlement/v2")
public class SupplierSettlementControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(SupplierSettlementControllerV2.class);
   @Resource
   private ContractSupplierSettlementBiz supplierSettlementBiz;

   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private SubcontractOrderService subcontractOrderService;

   private void checkSettlementOrderPermission(Long orderId) {
      SubcontractOrder order = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(order != null && (Objects.equals(order.getProjectAttribute(), 1) || Objects.equals(order.getProjectAttribute(), 2) || Objects.equals(order.getProjectAttribute(), 3)), "分包订单不存在或项目属性缺失");
      String permission = Objects.equals(order.getProjectAttribute(), 1) ? "self_sub_supplier:payment" : "interior_sub_supplier:payment";
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null && (user.isAdmin() || (user.getPermissions() != null && user.getPermissions().contains(permission))), "无权限访问");
   }

   @PostMapping("/save-inner")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:pay_application')")
   public ResultVO saveInner(@RequestBody @Valid SupplierSettlementAddDTOParam param) {
      return ResultBuilder.success(this.supplierSettlementService.addOaSupplierSettlement(param));
   }

   @GetMapping("/get-inner")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:pay_application','scm_purchaseOrder_v2:invoice_entry')")
   public ResultVO getInner(@RequestParam(required = false) Long projectId, @RequestParam(required = false) Long projectManagerId,
      @RequestParam(required = false) Long supplierId, @RequestParam(required = false) String purchaseContractNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize) {
      if (projectId == null || projectManagerId == null || supplierId == null || purchaseContractNumber == null
         || purchaseContractNumber.trim().isEmpty() || pageNumber < 1 || pageSize < 1) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, "项目、供应商、项目经理、采购合同号和有效分页不能为空");
      }
      return ResultBuilder.success(this.supplierSettlementService.getSupplierSettlementInner(
         projectId, projectManagerId, supplierId, purchaseContractNumber, pageNumber, pageSize));
   }

   @ApiOperation("新增-新增采购订单-结算（自营）")
   @PostMapping("/selfEmployed")
   public ResultVO saveSelfEmployed(@RequestBody @Valid PurchaseSettlementSaveParam param) {
      log.info("Api调用: 新增采购订单结算(自营)");
      param.setBoolPreSettlement(false);
      return ResultBuilder.success(this.supplierSettlementBiz.saveOaSelfEmployed(param));
   }

   @ApiOperation("新增-新增采购订单-预结算（自营）")
   @PostMapping("/selfEmployed/preSettle")
   public ResultVO saveSelfPreSettle(@RequestBody @Valid PurchaseSettlementSaveParam param) {
      log.info("Api调用: 新增采购订单结算(自营)");
      param.setBoolPreSettlement(true);
      return ResultBuilder.success(this.supplierSettlementBiz.saveOaSelfEmployed(param));
   }

   @ApiOperation("原材料采购订单结算-回显(自营)")
   @ApiImplicitParams(@ApiImplicitParam(name = "orderId", value = "采购订单id", required = true, dataType = "Long", paramType = "query"))
   @GetMapping("/getSelfEmployed")
   public ResultVO getSupplierSettlement(@RequestParam Long orderId) {
      log.info("Api调用: 原材料采购订单结算-数据回显");
      return ResultBuilder.success(this.supplierSettlementBiz.getSupplierSettlement(orderId));
   }

   @ApiOperation("新增-分包结算")
   @PostMapping("/saveSubcontractOrder")
   @PreAuthorize("@permission.check('self_sub_supplier:payment') || @permission.check('interior_sub_supplier:payment')")
   public ResultVO saveSubcontractOrder(@RequestBody @Valid SubOrderSettlementAddParam param) {
      this.checkSettlementOrderPermission(param.getOrderId());
      log.info("Api调用: 新增分包合同结算");
      return ResultBuilder.success(this.supplierSettlementBiz.saveSubcontractOrder(param));
   }

   @ApiOperation("分包合同结算数据回显")
   @GetMapping("/getSubcontractOrder")
   public ResultVO getSubcontractOrder(@RequestParam Long orderId) {
      log.info("Api调用: 原材料采购订单结算-数据回显");
      return ResultBuilder.success(this.supplierSettlementBiz.getSubcontractOrder(orderId));
   }

   @ApiOperation("新增-分包预结算")
   @PostMapping("/saveSubcontractOrder/pre")
   @PreAuthorize("@permission.check('self_sub_supplier:payment') || @permission.check('interior_sub_supplier:payment')")
   public ResultVO saveSubcontractOrderPre(@RequestBody @Valid SubOrderSettlementAddParam param) {
      this.checkSettlementOrderPermission(param.getOrderId());
      log.info("Api调用: 新增:分包合同-预结算");
      return ResultBuilder.success(this.supplierSettlementBiz.saveSubcontractOrderPre(param));
   }
}
