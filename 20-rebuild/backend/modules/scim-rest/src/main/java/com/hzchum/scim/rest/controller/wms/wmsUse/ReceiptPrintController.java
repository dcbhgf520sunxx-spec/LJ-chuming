package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryByStr;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReceiptPrintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

@Api(tags = "wms-单据打印")
@RestController
@RequestMapping("/api/wms")
public class ReceiptPrintController {
   private static final Logger log = LoggerFactory.getLogger(ReceiptPrintController.class);
   @Resource
   ReceiptPrintService receiptPrintService;

   @ApiOperation("入库单据打印")
   @GetMapping("/inbound/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_receipt:get','wms_rawMat_inbound_review:get')")
   public ResultVO inbound(@PathVariable("id") Long id) {
      log.info("API 调用 ：入库单据打印");
      return ResultBuilder.success(this.receiptPrintService.inboundPrint(id));
   }

   @ApiOperation("入库单据打印状态更新")
   @GetMapping("/inbound/receipt/{id}/printState")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_receipt:get','wms_rawMat_inbound_review:get','wms_rawMat_inbound_review:detail')")
   public ResultVO inboundPrintState(@PathVariable("id") Long id) {
      log.info("API 调用 ：入库单据打印");
      return ResultBuilder.success(this.receiptPrintService.inboundPrintState(id));
   }

   @ApiOperation("出库单据打印")
   @GetMapping("/outbound/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_record:get','wms_rawMat_outbound_review:get','wms_rawMat_outbound_review_self:get','wms_rawMat_outbound_review_partyA:get','wms_rawMat_outbound_review:detail','wms_report_rawMat_outbound_receipt:get')")
   public ResultVO outbound(@PathVariable("id") Long id) {
      log.info("API 调用 ：出库单据打印");
      return ResultBuilder.success(this.receiptPrintService.outboundPrint(id));
   }

   @ApiOperation("退库单据打印")
   @GetMapping("/return/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_rawMat_return_review:get','wms_rawMat_return_review:detail','wms_report_rawMat_return_receipt:get')")
   public ResultVO returnList(@PathVariable("id") Long id) {
      log.info("API 调用 ：退库单据打印");
      return ResultBuilder.success(this.receiptPrintService.returnPrint(id));
   }

   @ApiOperation("退货单据打印")
   @GetMapping("/reject/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get','wms_rawMat_reject_review:get')")
   public ResultVO reject(@PathVariable("id") Long id) {
      log.info("API 调用 ：退货单据打印");
      return ResultBuilder.success(this.receiptPrintService.rejectPrint(id));
   }

   @ApiOperation("调拨单据打印")
   @GetMapping("/transfer/receipt/{id}/print")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:get','wms_rawMat_transfer_review:detail','wms_report_rawMat_transfer_receipt:get')")
   public ResultVO transfer(@PathVariable("id") Long id) {
      log.info("API 调用 ：调拨单据打印");
      return ResultBuilder.success(this.receiptPrintService.transferPrint(id));
   }

   @ApiOperation("红冲记录打印")
   @GetMapping("/supplement/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_supplement_details:print')")
   public ResultVO supplement(QueryDetailDTOParam param, @RequestParam(required = false, name = "sort") List<String> sort) {
      log.info("API 调用 ：红冲记录打印");
      return ResultBuilder.success(this.receiptPrintService.supplementPrint(param, sort));
   }

   @ApiOperation("移库单打印")
   @GetMapping("/move-material/{id}/print")
   @PreAuthorize("@permission.check('wms_rawMat_moving_inventory_record:get','wms_rawMat_moving_inventory_review:get','wms_rawMat_moving_inventory_review:detail','wms_rawMat_moving_inventory_self_record:get','wms_rawMat_moving_inventory_party_a_record:get')")
   public ResultVO moveMaterial(@PathVariable("id") Long id) {
      log.info("API 调用 ：移库单打印");
      return ResultBuilder.success(this.receiptPrintService.moveMaterialPrint(id));
   }

   @ApiOperation("移库单打印明细")
   @PostMapping("/move-material/details/print")
   @PreAuthorize("@permission.check('wms_rawMat_moving_inventory_record:get','wms_rawMat_moving_inventory_review:get','wms_rawMat_moving_inventory_review:detail','wms_rawMat_moving_inventory_self_record:get')")
   public ResultVO moveMaterialDetails(@RequestBody @Valid QueryByStr queryString) {
      log.info("API 调用 ：移库单打印明细");
      return ResultBuilder.success(this.receiptPrintService.moveMaterialDetails(queryString));
   }

   @ApiOperation("出库单据打印状态更新")
   @GetMapping("/outbound/receipt/{id}/printState")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_record:get','wms_rawMat_outbound_review:get','wms_rawMat_outbound_review_self:get','wms_rawMat_outbound_review_partyA:get','wms_rawMat_outbound_review:detail','wms_report_rawMat_outbound_receipt:get')")
   public ResultVO outboundPrintState(@PathVariable("id") Long id) {
      log.info("API 调用 ：出库单据打印状态更新");
      return ResultBuilder.success(this.receiptPrintService.outboundPrintState(id));
   }

   @ApiOperation("退货单据打印状态更新")
   @GetMapping("/reject/receipt/{id}/printState")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get','wms_rawMat_reject_review:get','wms_rawMat_reject_review:detail')")
   public ResultVO rejectPrintState(@PathVariable("id") Long id) {
      log.info("API 调用 ：退货单据打印状态更新");
      return ResultBuilder.success(this.receiptPrintService.rejectPrintState(id));
   }

   @ApiOperation("退库单据打印状态更新")
   @GetMapping("/return/receipt/{id}/printState")
   @PreAuthorize("@permission.check('wms_rawMat_return_review:get','wms_rawMat_return_review:detail','wms_report_rawMat_return_receipt:get')")
   public ResultVO returnPrint(@PathVariable("id") Long id) {
      log.info("API 调用 ：退库单据打印状态更新");
      return ResultBuilder.success(this.receiptPrintService.returnPrintState(id));
   }

   @ApiOperation("调拨单据打印状态更新")
   @GetMapping("/transfer/receipt/{id}/printState")
   @PreAuthorize("@permission.check('wms_rawMat_transfer_review:get','wms_rawMat_transfer_review:detail','wms_report_rawMat_transfer_receipt:get')")
   public ResultVO transferPrintState(@PathVariable("id") Long id) {
      log.info("API 调用 ：调拨单据打印状态更新");
      return ResultBuilder.success(this.receiptPrintService.transferPrintState(id));
   }
}
