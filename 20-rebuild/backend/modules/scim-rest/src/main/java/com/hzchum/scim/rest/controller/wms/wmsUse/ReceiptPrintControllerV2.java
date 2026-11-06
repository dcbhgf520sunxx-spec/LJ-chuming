package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReceiptPrintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-单据打印")
@RestController
@RequestMapping("/api/v2/wms")
public class ReceiptPrintControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ReceiptPrintControllerV2.class);
   @Resource
   ReceiptPrintService receiptPrintService;

   @ApiOperation("制成品入库单据打印")
   @GetMapping("/inbound/manufactured/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_receipt_manuf:get')")
   public ResultVO inboundManufactured(@PathVariable("id") Long id) {
      log.info("API 调用 ：制成品入库单据打印");
      return ResultBuilder.success(this.receiptPrintService.inboundManufacturedPrint(id));
   }

   @ApiOperation("制成品出库单据打印")
   @GetMapping("/outbound/manufactured/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_rawMat_manuf_outbound_record:get','wms_rawMat_manuf_outbound_record:detail','wms_report_manuf_outbound_details:get')")
   public ResultVO outboundManufactured(@PathVariable("id") Long id) {
      log.info("API 调用 ：制成品出库单据打印");
      return ResultBuilder.success(this.receiptPrintService.outboundManufacturedPrint(id));
   }

   @ApiOperation("制成品退库单据打印")
   @GetMapping("/return/manufactured/receipt/{id}/print")
   public ResultVO returnManufactured(@PathVariable("id") Long id) {
      log.info("API 调用 ：制成品退库单据打印");
      return ResultBuilder.success(this.receiptPrintService.returnManufacturedPrint(id));
   }
}
