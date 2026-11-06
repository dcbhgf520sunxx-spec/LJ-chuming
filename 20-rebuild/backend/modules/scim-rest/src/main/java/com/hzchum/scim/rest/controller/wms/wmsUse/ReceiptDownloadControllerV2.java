package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.enums.ExcelEnum;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDownloadParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReceiptDownloadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-明细下载")
@RestController
@RequestMapping("/api/v2/wms/report/raw-materials")
public class ReceiptDownloadControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ReceiptDownloadControllerV2.class);
   @Resource
   ReceiptDownloadService receiptDownloadService;

   @ApiOperation("excel下载")
   @GetMapping("/template/excel")
   public void templateExcel(Integer receiptType, Integer basicClass, HttpServletResponse response) {
      log.info("API 调用 ：excel下载");
      this.receiptDownloadService.templateExcelV2(receiptType, basicClass, response);
   }

   @ApiOperation("退货明细下载V2")
   @GetMapping("/reject/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get')")
   public void rejectDetailsDownload(QueryRejectDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：退货明细下载V2");
      this.receiptDownloadService.rejectDetailsDownload(param, response);
   }

   @ApiOperation("外协原料出库明细下载")
   @GetMapping("/outsourcingOutbound/details/excel")
   @PreAuthorize("@permission.check('outbound_details_outsource:get')")
   public void outsourcingOutboundDetailsDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：外协原料出库明细下载");
      this.receiptDownloadService.outsourcingOutboundDownload(param, response, 28);
   }

   @ApiOperation("对外出售明细下载")
   @GetMapping("/forSale/outbound/details/excel")
   @PreAuthorize("@permission.check('wms_report_self_purchased_warehouse_external_sales_details:get')")
   public void forSaleDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：对外出售明细下载");
      param.setOutReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      this.receiptDownloadService.forSaleDownload(param, response, ExcelEnum.FOR_SALE_OUTBOUND_EXCEL.getType());
   }

   @ApiOperation("对外出售价格差异明细下载")
   @GetMapping("/forSale/difference/outbound/details/excel")
   @PreAuthorize("@permission.check('wms_report_price_difference_for_external_sales_details:get')")
   public void forSaleDifferenceDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：对外出售价格差异明细下载");
      param.setOutReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      this.receiptDownloadService.forSaleDownload(param, response, ExcelEnum.FOR_SALE_DIFFERENCE_OUTBOUND_EXCEL.getType());
   }

   @ApiOperation("废料出库明细下载")
   @GetMapping("/scrapsOutbound/details/excel")
   @PreAuthorize("@permission.check('outbound_details_outsource:get')")
   public void scrapsOutboundDetailsDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：废料出库明细下载");
      this.receiptDownloadService.scrapsOutboundDownload(param, response, 31);
   }

   @ApiOperation("制成品入库明细下载")
   @GetMapping("/inbound/details/manufactured/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_details_manuf:get')")
   public void inboundManufacturedDownload(QueryInboundManufacturedDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：制成品入库明细下载");
      this.receiptDownloadService.inboundManufacturedDownload(param, response);
   }

   @ApiOperation("制成品出库明细下载")
   @GetMapping("/outbound/details/manufactured/excel")
   @PreAuthorize("@permission.check('wms_report_manuf_outbound_details:get')")
   public void inboundManufacturedDownload(QueryOutboundManufacturedDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：制成品出库明细下载");
      this.receiptDownloadService.outboundManufacturedDownload(param, response);
   }

   @ApiOperation("制成品退库明细下载")
   @GetMapping("/return/details/manufactured/excel")
   @PreAuthorize("@permission.check('wms_report_manuf_return_details:get')")
   public void inboundManufacturedDownload(QueryReturnManufacturedDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：制成品退库明细下载");
      this.receiptDownloadService.returnManufacturedDownload(param, response);
   }

   @ApiOperation("入库清单模板excel下载")
   @GetMapping("/inbound/template/excel")
   public void inboundTemplateExcel(
      @RequestParam("boolPartyA") Boolean boolPartyA, @RequestParam("basicClass") Integer basicClass, HttpServletResponse response
   ) {
      log.info("API 调用 ：入库清单模板excel下载");
      this.receiptDownloadService.inboundTemplateExcel(boolPartyA, basicClass, response);
   }

   @ApiOperation("期初入库清单模板excel下载")
   @GetMapping("/beginPeriodInbound/template/excel")
   public void beginPeriodInboundTemplateExcel(
      @RequestParam("boolPartyA") Boolean boolPartyA, @RequestParam("basicClass") Integer basicClass, HttpServletResponse response
   ) {
      log.info("API 调用 ：入库清单模板excel下载");
      this.receiptDownloadService.beginPeriodInboundTemplateExcel(boolPartyA, basicClass, response);
   }

   @ApiOperation("盘盈单打包下载")
   @GetMapping("/surplus/package")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_profit:get')")
   public void surplusBatchDownload(@Validated QueryDownloadParam param, HttpServletResponse response) {
      log.info("API 调用 ：盘盈单打包下载");
      this.receiptDownloadService.surplusBatchDownload(param, response);
   }

   @ApiOperation("盘盈单明细下载")
   @GetMapping("/surplus/details/excel")
   @PreAuthorize("@permission.check('report_rawMat_inventory_profit:download')")
   public void surplusDetailsDownload(QueryReportSurplusDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：盘盈单明细下载");
      this.receiptDownloadService.surplusDetailsDownload(param, response);
   }

   @ApiOperation("库存使用统计下载")
   @GetMapping("/inventory/statistics/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public void inventoryStatisticsDownload(QueryInventoryUseStatisticsDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：库存使用统计下载");
      this.receiptDownloadService.inventoryStatisticsDownload(param, response);
   }

   @ApiOperation("库存使用统计下载-新")
   @GetMapping("/inventory/statistics/excel-new")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public void inventoryStatisticsDownloadNew(QueryInventoryUseStatisticsDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：库存使用统计下载-新");
      this.receiptDownloadService.inventoryStatisticsDownloadNew(param, response);
   }

   @ApiOperation("库存使用记录下载")
   @GetMapping("/inventory/use/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public void statisticsDetailDownload(@RequestParam Long id, HttpServletResponse response) {
      log.info("API 调用 ：库存使用记录下载");
      this.receiptDownloadService.inventoryUseRecordDownload(id, response);
   }

   @ApiOperation("库存使用记录下载-新")
   @GetMapping("/inventory/use/excel-new")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:get')")
   public void statisticsDetailDownloadNew(@RequestParam("ids") List<Long> ids, HttpServletResponse response) {
      log.info("API 调用 ：库存使用记录下载-新");
      this.receiptDownloadService.inventoryUseRecordDownloadNew(ids, response);
   }

   @ApiOperation("采购明细下载入库导入使用")
   @GetMapping("/inbound/purchaseDetail")
   public void inboundPurchaseDetailDownload(@RequestParam("id") Long id, @RequestParam("basicClass") Integer basicClass, HttpServletResponse response) {
      log.info("API 调用 ：采购明细下载入库导入使用");
      this.receiptDownloadService.inboundPurchaseDetailDownload(id, basicClass, response);
   }

   @ApiOperation("发货单（直发工地采购详情打印）")
   @GetMapping("/purchaseOrderDetail/print")
   public ResultVO printList(@RequestParam Long orderId) {
      log.info("Api调用:发货单（直发工地采购详情打印）");
      return ResultBuilder.success(this.receiptDownloadService.printDeliveryPurchaseOrderDetailList(orderId));
   }

   @ApiOperation("盘盈导入清单模板excel下载")
   @GetMapping("/surplusImport/template/excel")
   public void surplusImportTemplateExcel(
      @RequestParam("boolPartyA") Boolean boolPartyA, @RequestParam("basicClass") Integer basicClass, HttpServletResponse response
   ) {
      log.info("API 调用 ：盘盈导入清单模板excel下载");
      this.receiptDownloadService.surplusImportTemplateExcel(boolPartyA, basicClass, response);
   }

   @ApiOperation("盘亏库存物料下载")
   @GetMapping("/loseInventory/download")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_loss:add')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 120L, message = "盘亏库存物料下载中,请稍后刷新页面重试")
   public void loseInventoryDownload(QueryByMaterialDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：盘亏库存物料下载");
      this.receiptDownloadService.loseInventoryDownload(param, response);
   }
}
