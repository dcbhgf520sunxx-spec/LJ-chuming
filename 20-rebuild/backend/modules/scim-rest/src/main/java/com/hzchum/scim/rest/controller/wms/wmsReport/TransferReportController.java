package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-调拨报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/transfer")
public class TransferReportController {
   private static final Logger log = LoggerFactory.getLogger(TransferReportController.class);
   @Resource
   ReportService reportService;
   @Resource
   TransferService transferService;

   @ApiOperation("报表-查询调拨明细")
   @GetMapping("/details")
   @PreAuthorize("@permission.check('wms_report_rawMat_transfer_details:get')")
   public ResultVO detailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询调拨明细");
      return ResultBuilder.success(this.reportService.getTransferDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询调拨明细汇总")
   @GetMapping("/detailsCount")
   @PreAuthorize("@permission.check('wms_report_rawMat_transfer_details:get')")
   public ResultVO detailListCount(QueryDetailDTOParam param) {
      log.info("API 调用 ：报表-查询调拨明细汇总");
      return ResultBuilder.success(this.reportService.getTransferDetailCount(param));
   }

   @ApiOperation("调拨单列表(体现实时金额)")
   @GetMapping("receiptList")
   @PreAuthorize("@permission.check('wms_report_rawMat_transfer_receipt:get')")
   public ResultVO list(
      QueryTransferDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：调拨单列表(体现实时金额)");
      return ResultBuilder.success(this.transferService.pageTransferList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("调拨单详情(体现实时金额)")
   @GetMapping("/receiptDetailById/{id}")
   @PreAuthorize("@permission.check('wms_report_rawMat_transfer_receipt:get','wms_rawMat_transfer_review:detail')")
   public ResultVO queryById(@PathVariable("id") Long id) {
      log.info("API 调用 ：调拨单详情(体现实时金额)");
      return ResultBuilder.success(this.transferService.queryById2(id));
   }

   @ApiOperation("调拨单打印（体现实时金额）")
   @GetMapping("/receiptDetailById/{id}/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_transfer_receipt:get','wms_rawMat_transfer_review:detail')")
   public ResultVO transferPrint(@PathVariable("id") Long id) {
      log.info("API 调用 ：调拨单打印（体现实时金额）");
      return ResultBuilder.success(this.transferService.transferPrint(id));
   }
}
