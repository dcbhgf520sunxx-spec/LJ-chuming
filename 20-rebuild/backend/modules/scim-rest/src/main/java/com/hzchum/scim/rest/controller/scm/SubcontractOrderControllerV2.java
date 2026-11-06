package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderBiz;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderTempBiz;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectBranchCompanyDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderTempDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SaveSubcontractOrderDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderTempAuditDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

@Api(tags = "供应链管理-分包订单")
@RestController
@RequestMapping("/api/v2/scm/subcontract-order")
public class SubcontractOrderControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(SubcontractOrderControllerV2.class);
   @Resource
   private SubcontractOrderBiz subcontractOrderBiz;
   @Resource
   private SubcontractOrderTempBiz subcontractOrderTempBiz;

   @GetMapping("/getPage")
   @ApiOperation("供应链-分包分页接口")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", required = false),
            @ApiImplicitParam(name = "type", value = "状态", required = false),
            @ApiImplicitParam(name = "auditTypeEnum", value = "审批状态", required = false),
            @ApiImplicitParam(name = "serialNumber", value = "采购编码", required = false),
            @ApiImplicitParam(name = "projectName", value = "项目", required = false),
            @ApiImplicitParam(name = "supplierName", value = "供应商", required = false),
            @ApiImplicitParam(name = "projectManagerName", value = "项目经理", required = false),
            @ApiImplicitParam(name = "projectAttribute", value = "项目属性", required = true),
            @ApiImplicitParam(name = "userName", value = "创建人", required = false)
      }
   )
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO getPage(
      SubcontractOrderQueryDtoParamV2 param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 分包订单列表");
      return ResultBuilder.success(this.subcontractOrderBiz.getPage(param, pageNumber, pageSize));
   }

   @PostMapping("/saveSubcontractOrder")
   @ApiOperation("新增分包订单")
   @PreAuthorize("@permission.check('self_sub_supplier:add') || @permission.check('interior_sub_supplier:add')")
   public ResultVO saveSubcontractOrder(@RequestBody @Valid SaveSubcontractOrderDTOParam param) {
      log.info("Api调用: 新增分包订单");
      return ResultBuilder.success(this.subcontractOrderBiz.saveSubcontractOrder(param));
   }

   @PutMapping("/updateSubcontractOrder")
   @ApiOperation("修改-分包订单")
   @PreAuthorize("@permission.check('self_sub_supplier:edit') || @permission.check('interior_sub_supplier:edit')")
   public ResultVO updateSubcontractOrder(@RequestBody @Valid SaveSubcontractOrderDTOParam param) {
      log.info("Api调用:修改-分包订单");
      return ResultBuilder.success(this.subcontractOrderBiz.updateSubcontractOrder(param));
   }

   @GetMapping("/paymentList/{orderId}")
   @ApiOperation("获取分包订单付款列表")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<PageVO<SupplierPaymentDetailDto>> paymentList(
      @PathVariable Long orderId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 获取分包订单付款列表");
      return ResultBuilder.success(this.subcontractOrderBiz.getPaymentList(orderId, pageNumber, pageSize));
   }

   @GetMapping("/paymentList/{orderId}/print")
   @ApiOperation("分包订单付款列表-打印")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<PrintVO<List<SupplierPaymentDetailDto>>> paymentListPrint(@PathVariable Long orderId) {
      log.info("Api调用: 分包订单付款列表-打印");
      return ResultBuilder.success(this.subcontractOrderBiz.printPaymentList(orderId));
   }

   @GetMapping("/invoiceList/{orderId}")
   @ApiOperation("获取分包订单发票列表")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<PageVO<SupplierInvoiceDetailDto>> invoiceList(
      @PathVariable Long orderId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 获取分包订单发票列表");
      return ResultBuilder.success(this.subcontractOrderBiz.getInvoiceList(orderId, pageNumber, pageSize));
   }

   @GetMapping("/invoiceList/{orderId}/print")
   @ApiOperation("分包订单发票列表-打印")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<PrintVO<List<SupplierInvoiceDetailDto>>> invoiceListPrint(@PathVariable Long orderId) {
      log.info("Api调用: 分包订单发票列表-打印");
      return ResultBuilder.success(this.subcontractOrderBiz.printInvoiceList(orderId));
   }

   @GetMapping("/settleList/{orderId}")
   @ApiOperation("获取:分包订单-结算列表")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<ListVO<SupplierSettlementDTO>> settleList(
      @PathVariable Long orderId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 获取分包订单结算列表");
      return ResultBuilder.success(new ListVO<>(this.subcontractOrderBiz.listSubOrderSettle(orderId, false)));
   }

   @GetMapping("/settleList/{orderId}/print")
   @ApiOperation("获取:分包订单-结算列表-打印")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<PrintVO<List<SupplierSettlementDTO>>> settleListPrint(@PathVariable Long orderId) {
      log.info("Api调用: 获取分包订单结算列表-打印");
      return ResultBuilder.success(this.subcontractOrderBiz.printListSubOrderSettle(orderId, false));
   }

   @GetMapping("/preSettleList/{orderId}")
   @ApiOperation("获取:分包订单-预结算列表")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<ListVO<SupplierSettlementDTO>> preSettleList(
      @PathVariable Long orderId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 获取分包订单结算列表");
      return ResultBuilder.success(new ListVO<>(this.subcontractOrderBiz.listSubOrderSettle(orderId, true)));
   }

   @GetMapping("/preSettleList/{orderId}/print")
   @ApiOperation("获取:分包订单-预结算列表-打印")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO<PrintVO<List<SupplierSettlementDTO>>> preSettleListPrint(@PathVariable Long orderId) {
      log.info("Api调用: 获取分包订单结算列表-打印");
      return ResultBuilder.success(this.subcontractOrderBiz.printListSubOrderSettle(orderId, true));
   }

   @GetMapping("/subcontractOrder/{orderId}")
   @ApiOperation("获取分包订单详情")
   @PreAuthorize("@permission.check('self_sub_supplier:get') || @permission.check('interior_sub_supplier:get')")
   public ResultVO subcontractOrder(@PathVariable Long orderId) {
      log.info("Api调用: 获取分包订单详情");
      return ResultBuilder.success(this.subcontractOrderBiz.getSubcontractOrderDetail(orderId));
   }

   @DeleteMapping("/delSumSubcontractOrder")
   @ApiOperation("删除分包订单")
   @PreAuthorize("@permission.check('self_sub_supplier:del') || @permission.check('interior_sub_supplier:del')")
   public ResultVO delSubcontractOrder(@RequestBody List<Long> orderId) {
      log.info("Api调用: 删除分包订单");
      return ResultBuilder.success(this.subcontractOrderBiz.deleteSubcontractOrder(orderId));
   }

   @GetMapping("")
   @ApiOperation("获取项目经理列表")
   public ResultVO getProjectManagerList() {
      log.info("Api调用: 获取项目经理列表");
      return ResultBuilder.success(this.subcontractOrderBiz.getProjectManagerList());
   }

   @GetMapping("/getProjectList")
   @ApiOperation("获取项目列表")
   public ResultVO<List<ProjectBranchCompanyDTO>> getProjectList() {
      log.info("Api调用: 获取项目列表");
      return ResultBuilder.success(this.subcontractOrderBiz.getProjectList());
   }

   @ApiOperation("获取分包订单-审批数据")
   @GetMapping("/getTempOrderInfo/{tempId}")
   public ResultVO<SubcontractOrderTempDTO> getOrderTempInfo(@PathVariable Long tempId) {
      log.info("Api调用: 获取分包订单-审批数据");
      return ResultBuilder.success(this.subcontractOrderTempBiz.getTempById(tempId));
   }

   @ApiOperation("审批-分包订单")
   @PostMapping("/audit")
   public ResultVO<Boolean> auditOrder(@RequestBody @Valid SubcontractOrderTempAuditDtoParam param) {
      log.info("Api调用:审批-分包订单");
      return ResultBuilder.success(this.subcontractOrderTempBiz.auditSubOrderChange(param));
   }
}
