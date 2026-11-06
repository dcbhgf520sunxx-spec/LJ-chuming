package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReceiptDownloadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-明细下载")
@RestController
@RequestMapping("/api/wms/report/raw-materials")
public class ReceiptDownloadController {
   private static final Logger log = LoggerFactory.getLogger(ReceiptDownloadController.class);
   @Resource
   ReceiptDownloadService receiptDownloadService;

   @ApiOperation("入库明细下载")
   @GetMapping("/inbound/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_details:get')")
   public void inboundDownload(QueryReportInboundDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：入库明细下载");
      this.receiptDownloadService.inboundDownload(param, response);
   }

   @ApiOperation("入库和退货明细下载")
   @GetMapping("/inboundAndReject/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_details:get')")
   public void inboundAndRejectDownload(QueryReportInboundDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：入库明细下载");
      this.receiptDownloadService.inboundAndRejectDownload(param, response);
   }

   @ApiOperation("出库明细下载")
   @GetMapping("/outbound/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_details:get')")
   public void outboundDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：出库明细下载");
      this.receiptDownloadService.outboundDownload(param, response, 2);
   }

   @ApiOperation("出库和退库明细下载")
   @GetMapping("/outboundAndReturn/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_details:get')")
   public void outboundDownloadAndReturnDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：出库明细下载");
      this.receiptDownloadService.outboundDownloadAndReturnDownload(param, response, 2);
   }

   @ApiOperation("调拨明细下载")
   @GetMapping("/transfer/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_transfer_details:get')")
   public void transferDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：调拨明细下载");
      this.receiptDownloadService.transferDownload(param, response);
   }

   @ApiOperation("移库明细下载")
   @GetMapping("/moveMaterial/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_remove_details:get')")
   public void moveMaterialDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：移库明细下载");
      this.receiptDownloadService.moveMaterialDownload(param, response);
   }

   @ApiOperation("退货明细下载")
   @GetMapping("/reject/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get')")
   public void rejectDetailDownload(QueryRejectDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：退货明细下载");
      this.receiptDownloadService.rejectDetailDownload(param, response);
   }

   @ApiOperation("退库明细下载")
   @GetMapping("/return/details/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_return_details:get')")
   public void returnDetailDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：退库明细下载");
      this.receiptDownloadService.returnDetailDownload(param, response);
   }

   @ApiOperation("高新研发费下载")
   @GetMapping("/high-tech-rd-fee/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_highTechRDFee:get')")
   public void RDFeeDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：高新研发费下载");
      this.receiptDownloadService.RDFeeDownload(param, response);
   }

   @ApiOperation("收发存记录下载")
   @GetMapping("/send-and-receive-storage/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_sendAndReceiveStorage:get')")
   public void statisticsDownload(QueryStatisticsDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：收发存记录下载");
      this.receiptDownloadService.statisticsDownload(param, response);
   }

   @ApiOperation("收发存记录详情下载")
   @GetMapping("/send-and-receive-storage/detail/excel")
   public void statisticsDetailDownload(
      @RequestParam(required = false) List<Long> ids,
      Integer formType,
      LocalDateTime date,
      @RequestParam(required = false) List<Long> statIds,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：收发存记录详情下载");
      this.receiptDownloadService.statisticsDetailDownload(ids, formType, date, statIds, response);
   }

   @ApiOperation("库存明细下载")
   @GetMapping("/inventory/excel")
   @PreAuthorize("@permission.check('reportRawMaterialInventoryPM:download')")
   public void inventoryDetailExcel(
      @RequestParam(required = false) Integer basicClass,
      @RequestParam(required = false) List<Long> classifyId,
      @RequestParam(required = false) Integer orderSupplyType,
      @RequestParam(required = false) List<Long> workshopIds,
      @RequestParam(required = false) String specification,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：库存明细下载");
      this.receiptDownloadService.inventoryDetailExcel(basicClass, classifyId, orderSupplyType, workshopIds, specification, response);
   }

   @ApiOperation("库存物料下载")
   @GetMapping("/inventoryBegin/excel")
   @PreAuthorize("@inventoryExportAccess.read(#p0)")
   @SignerCheck(boolMethodAndClassName = true, timeout = 120L, message = "库存物料下载中,请稍后刷新页面重试")
   public void inventoryBeginExcel(
      @RequestParam List<Integer> basicClass,
      @RequestParam Boolean boolPartyA,
      @RequestParam(required = false) String specification,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：库存物料下载");
      this.receiptDownloadService.inventoryBeginExcel(basicClass, boolPartyA, specification, response);
   }

   @ApiOperation("进销存详情下载")
   @GetMapping("/psi/excel")
   public void inventoryDetailExcel(
      Integer basicClass,
      @RequestParam(name = "times") List<LocalDateTime> times,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) BigDecimal thickness,
      @RequestParam(required = false) Long classifyId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：进销存详情下载");
      this.receiptDownloadService.PSIExcel(basicClass, times, material, thickness, classifyId, response);
   }

   @ApiOperation("存货明细账记录下载")
   @GetMapping("/inventory-details/detail/excel")
   public void inventoryDetailsRecordExcel(
      @RequestParam(required = false) List<LocalDateTime> times, @RequestParam(required = false) String detailKey, HttpServletResponse response
   ) {
      log.info("API 调用 ：存货明细账记录下载");
      this.receiptDownloadService.inventoryDetailsRecordExcel(times, detailKey, response);
   }

   @ApiOperation("盘亏详情下载")
   @GetMapping("/deficitDetail/excel")
   @PreAuthorize("@permission.check('report_rawMat_inventory_loss:download')")
   public void deficitDetailExcel(QueryReportDeficitDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：盘亏详情下载");
      this.receiptDownloadService.deficitDetailExcel(param, response);
   }

   @ApiOperation("入库价格调整记录下载")
   @GetMapping("/record/raw-adjustDetail/excel")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_adjust_amount:get')")
   public void adjustDetailList(QueryReportAdjustDTOParam queryInboundDTOParam, HttpServletResponse response) {
      log.info("API 调用 ：入库价格调整记录下载");
      this.receiptDownloadService.adjustDetailListExcel(queryInboundDTOParam, response);
   }

   @ApiOperation("存货明细账记录下载")
   @GetMapping("/template/excel")
   public void templateExcel(Integer receiptType, Integer basicClass, HttpServletResponse response) {
      log.info("API 调用 ：存货明细账记录下载");
      this.receiptDownloadService.templateExcel(receiptType, basicClass, response);
   }
}
