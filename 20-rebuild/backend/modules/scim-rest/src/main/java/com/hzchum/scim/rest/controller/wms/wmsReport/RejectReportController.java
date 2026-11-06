package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
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

@Api(tags = "wms-退货报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/reject")
public class RejectReportController {
   private static final Logger log = LoggerFactory.getLogger(RejectReportController.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-查询退货单信息")
   @GetMapping("/receipt")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get')")
   public ResultVO detailList(
      QueryRejectDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询退货单信息");
      return ResultBuilder.success(this.reportService.getRejectList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询退货单信息汇总")
   @GetMapping("/receiptCount")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get')")
   public ResultVO detailListCount(QueryRejectDTOParam param) {
      log.info("API 调用 ：报表-查询退货单信息汇总");
      return ResultBuilder.success(this.reportService.getRejectListCount(param));
   }

   @ApiOperation("报表-查询退货单信息")
   @GetMapping("/receipt/{id}")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get','wms_rawMat_reject_review:detail')")
   public ResultVO getById(@PathVariable Long id) {
      log.info("API 调用 ：报表-查询退货单信息");
      return ResultBuilder.success(this.reportService.getRejectDetail(id));
   }

   @ApiOperation("报表-查询退货明细信息")
   @GetMapping("/receiptDetail")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get')")
   public ResultVO receiptDetailList(
      QueryRejectDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询退货单信息");
      return ResultBuilder.success(this.reportService.getRejectDetailList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询出库钢材核算量")
   @GetMapping("/receiptDetail/mete")
   @PreAuthorize("@permission.check('wms_report_rawMat_reject_details:get')")
   public ResultVO receiptDetailMete(QueryRejectDetailDTOParam param) {
      log.info("API 调用 ：报表-查询出库钢材核算量");
      return ResultBuilder.success(this.reportService.getReceiptDetailMete(param));
   }
}
