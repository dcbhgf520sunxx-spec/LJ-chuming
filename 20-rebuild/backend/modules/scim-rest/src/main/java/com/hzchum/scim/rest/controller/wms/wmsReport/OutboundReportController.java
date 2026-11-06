package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
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

@Api(tags = "wms-出库报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/outbound")
public class OutboundReportController {
   private static final Logger log = LoggerFactory.getLogger(OutboundReportController.class);
   @Resource
   ReportService reportService;
   @Resource
   OutboundService outboundService;

   @ApiOperation("报表-查询出库明细")
   @GetMapping("/details")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_details:get')")
   public ResultVO detailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询出库库明细");
      param.setOutReviewStatus(2);
      return ResultBuilder.success(this.reportService.getOutboundDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询出库明细汇总")
   @GetMapping("/detailsCount")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_details:get')")
   public ResultVO detailListCount(QueryDetailDTOParam param) {
      log.info("API 调用 ：报表-查询出库库明细汇总");
      param.setOutReviewStatus(2);
      return ResultBuilder.success(this.reportService.getOutboundDetailCount(param));
   }

   @ApiOperation("报表-查询出库钢材核算量")
   @GetMapping("/details/mete")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_details:get')")
   public ResultVO detailList(QueryDetailDTOParam param) {
      log.info("API 调用 ：报表-查询出库钢材核算量");
      return ResultBuilder.success(this.reportService.getSteelOutboundMete(param));
   }

   @ApiOperation("报表-查询切割预料列表")
   @GetMapping("/cut-surplus")
   @PreAuthorize("@permission.check('wms_report_rawMat_cut_surplus_receipt:get')")
   public ResultVO cutSurplus(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) String cutTaskId,
      @RequestParam(required = false) List<LocalDateTime> endTime,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询切割预料列表");
      return ResultBuilder.success(this.reportService.getCutSurplus(projectId, cutTaskId, endTime, pageNumber, pageSize, sort));
   }

   @ApiOperation("出库单列表（体现实时金额）")
   @GetMapping("/receiptList")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_receipt:get')")
   public ResultVO list(
      QueryReportOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：出库单列表（体现实时金额）");
      return ResultBuilder.success(this.reportService.getOutbound(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("出库单详情（体现实时金额）")
   @GetMapping("/receiptDetailById/{id}")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_receipt:get','wms_rawMat_outbound_review:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：出库单详情（体现实时金额）");
      return ResultBuilder.success(this.outboundService.getOutboundDTO(id));
   }

   @ApiOperation("出库单打印（体现实时金额）")
   @GetMapping("/receiptDetailById/{id}/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_outbound_receipt:get','wms_rawMat_outbound_review:detail')")
   public ResultVO outboundPrint(@PathVariable("id") Long id) {
      log.info("API 调用 ：出库单打印");
      return ResultBuilder.success(this.outboundService.outboundPrint(id));
   }
}
