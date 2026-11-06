package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.business.core.api.biz.BusinessProjectTrackingBiz;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessProjectInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessReturnProductDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessShipListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceV2DTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-订单跟踪-v2")
@RestController
@RequestMapping("/api/project/tracking/v2")
public class ContractProjectTrackingControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectTrackingControllerV2.class);
   private final BusinessProjectTrackingBiz businessProjectTrackingBiz;
   private final BusinessBiz businessBiz;

   @ApiOperation("项目信息")
   @GetMapping
   @PreAuthorize("@permission.check('sale_unit_order_tracking:get')")
   public ResultVO<BusinessProjectInfoDTO> getProjectSaleInfo(@RequestParam Long projectId, @RequestHeader("financeBranchId") Long branchCompanyId) {
      log.info("Api调用:销售订单跟踪");
      BusinessProjectInfoDTO trackingProjectInfo = this.businessProjectTrackingBiz.getOrderTrackingProjectInfo(projectId, branchCompanyId);
      return ResultBuilder.success(trackingProjectInfo);
   }

   @ApiOperation("收款列表")
   @GetMapping("/collection")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:get')")
   public ResultVO<PageVO<ContractCollectionV2DTO>> collectionList(
      @RequestParam Long projectId,
      @RequestHeader("financeBranchId") Long branchCompanyId,
      Integer monthType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:销售订单-项目收款列表");
      return ResultBuilder.success(this.businessProjectTrackingBiz.projectCollectionList(projectId, branchCompanyId, monthType, pageNumber, pageSize));
   }

   @ApiOperation("收款列表-打印")
   @GetMapping("/collection/print")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:print')")
   public ResultVO<PrintVO<List<ContractCollectionV2DTO>>> collectionListPrint(
      @RequestParam Long projectId, @RequestHeader("financeBranchId") Long branchCompanyId, Integer monthType
   ) {
      log.info("Api调用:销售订单-项目收款列表-打印");
      return ResultBuilder.success(this.businessProjectTrackingBiz.projectCollectionListPrint(projectId, branchCompanyId, monthType));
   }

   @ApiOperation("开票列表")
   @GetMapping("/invoice")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:get')")
   public ResultVO<PageVO<ContractInvoiceV2DTO>> invoiceList(
      @RequestParam Long projectId,
      @RequestHeader("financeBranchId") Long branchCompanyId,
      Integer monthType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:销售订单-项目开票列表");
      return ResultBuilder.success(this.businessProjectTrackingBiz.projectInvoiceList(projectId, branchCompanyId, monthType, pageNumber, pageSize));
   }

   @ApiOperation("开票列表-打印")
   @GetMapping("/invoice/print")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:print')")
   public ResultVO<PrintVO<List<ContractInvoiceV2DTO>>> invoiceListPrint(
      @RequestParam Long projectId, @RequestHeader("financeBranchId") Long branchCompanyId, Integer monthType
   ) {
      log.info("Api调用:销售订单-项目开票列表-打印");
      return ResultBuilder.success(this.businessProjectTrackingBiz.projectInvoiceListPrint(projectId, branchCompanyId, monthType));
   }

   @ApiOperation("发运列表")
   @GetMapping("/ship")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:get')")
   public ResultVO<PageVO<ShipmentInfoDTO>> shipList(
      BusinessShipListQueryParam param,
      @RequestHeader("financeBranchId") Long branchCompanyId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:销售订单-项目发运列表");
      param.setBranchCompanyId(branchCompanyId);
      return ResultBuilder.success(this.businessProjectTrackingBiz.projectShipPageList(param, pageNumber, pageSize));
   }

   @ApiOperation("发运列表-打印")
   @GetMapping("/ship/print")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:print')")
   public ResultVO<PrintVO<List<ShipmentInfoDTO>>> shipListPrint(BusinessShipListQueryParam param, @RequestHeader("financeBranchId") Long branchCompanyId) {
      log.info("Api调用:销售订单-项目发运列表-打印");
      param.setBranchCompanyId(branchCompanyId);
      return ResultBuilder.success(this.businessProjectTrackingBiz.projectShipPageListPrint(param));
   }

   @ApiOperation("制成品-退货列表")
   @GetMapping("/return/list")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:get')")
   public ResultVO<ListVO<BusinessReturnProductDTO>> listReturnProduct(@RequestParam Long linkId) {
      log.info("APi调用:发运跟踪-产品退货列表");
      return ResultBuilder.success(new ListVO<>(this.businessBiz.listReturnProduct(linkId)));
   }

   @ApiOperation("制成品-退货列表-打印")
   @GetMapping("/return/list/print")
   @PreAuthorize("@permission.check('sale_unit_order_tracking:print')")
   public ResultVO<PrintVO<List<BusinessReturnProductDTO>>> printListReturnProduct(@RequestParam Long linkId) {
      log.info("APi调用:发运跟踪-产品退货列表-打印");
      return ResultBuilder.success(this.businessBiz.printListReturnProduct(linkId));
   }

   public ContractProjectTrackingControllerV2(final BusinessProjectTrackingBiz businessProjectTrackingBiz, final BusinessBiz businessBiz) {
      this.businessProjectTrackingBiz = businessProjectTrackingBiz;
      this.businessBiz = businessBiz;
   }
}
