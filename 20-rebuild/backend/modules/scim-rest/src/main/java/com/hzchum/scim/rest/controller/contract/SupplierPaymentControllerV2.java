package com.hzchum.scim.rest.controller.contract;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import java.util.Objects;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierJointlyOwnedProjectDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchasePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentInsourcingAddDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderPaymentAddDtoParam;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.scm.core.api.biz.SupplierBiz;
import com.hzchum.scim.scm.core.api.enums.SupplierClassEnum;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPayableSummaryDTO;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-供应商付款")
@RestController
@RequestMapping("/api/v2/contract/payment")
public class SupplierPaymentControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(SupplierPaymentControllerV2.class);
   @Resource
   private ContractSupplierPaymentBiz supplierPaymentBiz;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierBiz supplierBiz;
   @Resource
   private SubcontractOrderService subcontractOrderService;

   @ApiOperation("分包台账--获取填报项目(内、合)")
   @GetMapping("/subcontract/getProjectLedger/{projectManagerId}")
   public ResultVO<ListVO<ProjectInfo>> getProjectLedger(@PathVariable Long projectManagerId) {
      log.info("Api调用: 分包台账--获取填报项目(内、合)");
      return ResultBuilder.success(this.subcontractOrderService.getProjectLedger(projectManagerId));
   }

   @ApiOperation("分包台账--获取填报供应商(内、合)")
   @GetMapping("/subcontract/getSupplier/{projectManagerId}/{projectId}")
   public ResultVO<List<SupplierInfo>> getSupplier(@PathVariable Long projectManagerId, @PathVariable Long projectId) {
      log.info("Api调用: 分包台账--获取填报供应商(内、合)");
      return ResultBuilder.success(this.subcontractOrderService.getSupplierInfo(projectManagerId, projectId));
   }

   @ApiOperation("分包台账--获取分包合同号(内、合)")
   @GetMapping("/subcontract/getContractNumber/{projectManagerId}/{projectId}/{supplierId}")
   public ResultVO getContractNumber(@PathVariable Long projectManagerId, @PathVariable Long projectId, @PathVariable Long supplierId) {
      log.info("Api调用: 获取分包合同号(内、合)");
      return ResultBuilder.success(this.subcontractOrderService.getContractNumber(projectManagerId, projectId, supplierId));
   }

   @ApiOperation("分包台账--获取付款详情数据(内、合)")
   @GetMapping("/subcontract/getPaymentDetail/{subcontractId}")
   public ResultVO getPaymentDetail(@PathVariable Long subcontractId) {
      log.info("Api调用: 分包台账--获取付款详情数据(内、合)");
      return ResultBuilder.success(this.supplierPaymentService.getSubcontractDetailById(subcontractId));
   }

   @ApiOperation("分包台账--发起分包合同付款审批(内、合)")
   @PostMapping("/subcontract/addPayment")
   @PreAuthorize("@permission.check('interior_sub_supplier:payment')")
   public ResultVO addPayment(@RequestBody @Valid PurchaseSupplierPaymentInsourcingAddDTOParam param) {
      SubcontractOrder order = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null && (Objects.equals(order.getProjectAttribute(), 2) || Objects.equals(order.getProjectAttribute(), 3)), "仅允许非自营分包订单");
      Preconditions.checkArgument(Objects.equals(order.getSupplierId(), param.getSupplierId()) && Objects.equals(order.getProjectId(), param.getProjectId()) && Objects.equals(order.getProjectManagerId(), param.getProjectManagerId()), "订单供应商、项目或项目经理不一致");
      log.info("Api调用: 分包台账--发起分包合同付款审批(内、合)");
      return ResultBuilder.success(this.supplierPaymentBiz.addPacketsPayment(param));
   }

   @ApiOperation("采购订单-根据项目经理获取项目")
   @GetMapping("/getProject")
   public ResultVO<List<SupplierJointlyOwnedProjectDto>> getProjectByManagerId(@RequestParam Long projectManagerId) {
      log.info("Api调用: 根据项目经理获取项目");
      return ResultBuilder.success(this.supplierPaymentBiz.getProjectByManagerId(projectManagerId));
   }

   @ApiOperation("采购订单-根据项目经理和项目id查询供应商")
   @GetMapping("/getSupplier")
   public ResultVO getSupplierByManagerIdAndProjectId(@RequestParam Long projectManagerId, @RequestParam Long projectId) {
      log.info("Api调用: 根据项目经理和项目id查询供应商");
      return ResultBuilder.success(this.supplierPaymentBiz.getSupplierByManagerIdAndProjectId(projectManagerId, projectId));
   }

   @ApiOperation("采购订单-获取采购合同号")
   @GetMapping("/getSupplierNumber")
   public ResultVO getSupplierNumber(@RequestParam Long projectManagerId, @RequestParam Long projectId, @RequestParam Long supplierId) {
      log.info("Api调用: 根据项目经理和项目id查询供应商");
      return ResultBuilder.success(this.supplierPaymentBiz.getSupplierNumber(projectManagerId, projectId, supplierId));
   }

   @ApiOperation("采购台账--付款申请(内包制)")
   @PostMapping("/addSupplierPayment")
   public ResultVO addSupplierPayment(@RequestBody @Valid PurchaseSupplierPaymentInsourcingAddDTOParam param) {
      log.info("Api调用: 新增采购订单付款");
      return ResultBuilder.success(this.supplierPaymentBiz.addOaSupplierPayment(param));
   }

   @ApiOperation("采购台账--付款详情(内包制)")
   @GetMapping("/paymentDetail")
   public ResultVO getSupplierPaymentDetail(Long projectId, Long supplierId) {
      log.info("Api调用: 采购订单付款详情(内包制)");
      return ResultBuilder.success(this.supplierPaymentService.getPaymentDetailById(projectId, supplierId));
   }

   @ApiOperation("采购台账--付款和开票记录（通用）")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理id", required = false, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", required = false, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "Integer", paramType = "query")
      }
   )
   @GetMapping("/PaymentAndInvoicingList")
   public ResultVO getSupplierPaymentList(
      Long orderId,
      Long supplierId,
      Long projectManagerId,
      Long projectId,
      Integer type,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用: 采购订单付款与开票记录(通用)");
      return ResultBuilder.success(this.supplierPaymentService.getDetailList(orderId, supplierId, projectManagerId, projectId, type, pageNumber, pageSize));
   }

   @ApiOperation("供应商订单付款列表V2")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "purchaseType", value = "1原材料采购订单 2制成品采购订单", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "basicClass", value = "物料分类", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "订单编号", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名字", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态 1已结算 0未结算", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/order")
   @PreAuthorize("@permission.check('contract_supplier_material:get')")
   public ResultVO<PageVO<SupplierPaymentRecordDTO>> listSupplierPayments(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Long projectId,
      Integer settlementStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 供应商订单付款列表V2");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .pageOrderPaymentsV2(
               purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, projectId, settlementStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("应付汇总-列表V2")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "supplierClassification", value = "127 采购供应商  1024 物流供应商", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名称", paramType = "query"),
            @ApiImplicitParam(name = "hasPay", value = " true有应付 false无应付", paramType = "query", dataType = "Boolean"),
            @ApiImplicitParam(name = "hasTax", value = "true有欠税 false无欠税", paramType = "query", dataType = "Boolean")
      }
   )
   @GetMapping("/payable/summary")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_payment:get')")
   public ResultVO<ListVO<SupplierPayableSummaryDTO>> listSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean hasPay, Boolean hasTax
   ) {
      log.info("Api调用: 应付汇总-列表V2");
      return ResultBuilder.success(this.supplierBiz.summaryPayableV2(supplierClassification, supplierName, startDate, endDate, hasPay, hasTax));
   }

   @ApiOperation("打印应付汇总-列表")
   @GetMapping("/payable/summary/print")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_payment:print')")
   public ResultVO printSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean hasPay, Boolean hasTax
   ) {
      log.info("Api调用: 打印应付汇总列表");
      return ResultBuilder.success(this.supplierBiz.printListSummaryPayableV2(supplierClassification, supplierName, startDate, endDate, hasPay, hasTax));
   }

   @ApiOperation("采购台账--获取供应商(自营)")
   @GetMapping("/getSupplierList")
   public ResultVO getPurchaseSupplier() {
      log.info("Api调用: 采购订单--获取采购供应商(自营)");
      List<Supplier> supplierList = this.supplierService
         .list()
         .stream()
         .filter(s -> SupplierClassEnum.checkPurchaseSupplier(s.getSupplierClassification()))
         .collect(Collectors.toList());
      Map<Long, String> map = supplierList.stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      return ResultBuilder.success(map);
   }

   @ApiOperation("采购台账--获取采购合同号(自营)-全部")
   @ApiImplicitParam(name = "")
   @GetMapping("/lists")
   public ResultVO getPurchaseOrderSnListAll(
      @RequestParam Long supplierId,
      @RequestParam(defaultValue = "false") Boolean boolSettleUse,
      @RequestParam(defaultValue = "false") Boolean boolPreSettleUse
   ) {
      log.info("Api调用: 获取采购合同号(自营)");
      return ResultBuilder.success(this.supplierPaymentService.getPaymentDetailList(supplierId, boolSettleUse, boolPreSettleUse));
   }

   @ApiOperation("采购台账--获取采购合同号下的详细信息(自营)")
   @GetMapping("/listDetails")
   public ResultVO getSupplierPaymentList(@RequestParam List<Long> orderIds) {
      log.info("Api调用: 获取采购合同号下的详细信息(自营)");
      return ResultBuilder.success(this.supplierPaymentService.getSupplierPaymentList(orderIds));
   }

   @ApiOperation("采购台账--付款申请(自营)")
   @PostMapping("/addSelf-owned")
   public ResultVO addSelfOwned(@RequestBody @Valid PurchasePaymentSaveParam param) {
      log.info("Api调用: 付款申请(自营)");
      return ResultBuilder.success(this.supplierPaymentBiz.addOaSelfOwned(param));
   }

   @ApiOperation("项目台账-支出/开票详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "orderId", value = "采购单id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "incomeExpendType", value = "收支明细(1:支出2发票)", required = true, dataType = "Integer")
      }
   )
   @GetMapping("/projectPaymentDetailList")
   public ResultVO<ProjectLedgerSupplierInvoiceDTO> projectPaymentDetail(
      @RequestParam Long projectId, @RequestParam Long supplierId, @RequestParam Long orderId, @RequestParam Integer incomeExpendType
   ) {
      log.info("API 调用 : 项目台账-支出/开票详情");
      return ResultBuilder.success(this.supplierPaymentService.projectPaymentDetailList(projectId, supplierId, orderId, incomeExpendType));
   }

   @ApiOperation("项目台账-支出/开票详情打印")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "orderId", value = "采购单id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "incomeExpendType", value = "收支明细(1:支出2发票)", required = true, dataType = "Integer")
      }
   )
   @GetMapping("/projectPaymentDetailList/print")
   public ResultVO print(@RequestParam Long projectId, @RequestParam Long supplierId, @RequestParam Long orderId, @RequestParam Integer incomeExpendType) {
      log.info("API 调用 : 项目台账-支出/开票详情打印");
      return ResultBuilder.success(this.supplierPaymentService.projectPaymentDetailListPrint(projectId, supplierId, orderId, incomeExpendType));
   }

   @ApiOperation("分包台账-获取供应商(自营)")
   @GetMapping("/getSupplierList/sub")
   public ResultVO getSubSupplier(Long projectId) {
      log.info("Api调用:分包订单-获取供应商(自营)");
      Set<Long> subSupplierIds = this.subcontractOrderService
         .list(Wrappers.lambdaQuery(SubcontractOrder.class).eq(projectId != null, SubcontractOrder::getProjectId, projectId))
         .stream()
         .map(SubcontractOrder::getSupplierId)
         .collect(Collectors.toSet());
      if (subSupplierIds.isEmpty()) {
         return ResultBuilder.success(Collections.emptyMap());
      }

      List<Supplier> supplierList = this.supplierService
         .listByIds(subSupplierIds)
         .stream()
         .filter(s -> SupplierClassEnum.checkSubSupplier(s.getSupplierClassification()))
         .collect(Collectors.toList());
      Map<Long, String> map = supplierList.stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      return ResultBuilder.success(map);
   }

   @ApiOperation("分包台账-获取分包合同号(自)")
   @GetMapping("/selfOwned/getSupplier/{supplierId}")
   public ResultVO<Map<Long, String>> getSubOrderSnList(
      @PathVariable Long supplierId, Long projectId, @RequestParam(defaultValue = "false") Boolean boolSettleUse
   ) {
      log.info("Api调用: 分包台账-获取分包合同号(自)");
      return ResultBuilder.success(this.supplierPaymentBiz.getSubcontractSupplierInfo(supplierId, projectId, boolSettleUse));
   }

   @ApiOperation("分包台账-获取支付、收票信息(自)")
   @GetMapping("/selfOwned/getPaymentDetail")
   public ResultVO getSelfPaymentDetail(@RequestParam List<Long> orderIds) {
      log.info("Api调用: 分包台账-根据采购合同号获取支付、收票信息(自)");
      return ResultBuilder.success(this.supplierPaymentBiz.getPaymentDetailById(orderIds));
   }

   @ApiOperation("分包台账-发起付款申请(自)")
   @PostMapping("/selfOwned/addSelfPayment")
   @PreAuthorize("@permission.check('self_sub_supplier:payment')")
   public ResultVO addSelfPayment(@RequestBody @Valid SubOrderPaymentAddDtoParam param) {
      for (com.hzchum.scim.contract.core.api.pojo.dto.supplier.saveSupplierPaymentDto row : param.getSupplierPayment()) {
         Preconditions.checkArgument(row != null && row.getSupplierPaymentId() != null, "订单不能为空");
         SubcontractOrder order = this.subcontractOrderService.getById(row.getSupplierPaymentId());
         Preconditions.checkArgument(order != null && Objects.equals(order.getProjectAttribute(), 1), "仅允许自营分包订单");
         Preconditions.checkArgument(Objects.equals(order.getSupplierId(), param.getSupplierId()), "供应商与订单不一致");
      }
      log.info("Api调用: 分包台账-发起付款申请(自)");
      return ResultBuilder.success(this.supplierPaymentBiz.addSelfOwnedSubcontractPayment(param));
   }
}
